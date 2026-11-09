package koala.saline.mixins;

import net.minecraft.core.QuartPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Debug(export = true)
@Mixin(Aquifer.NoiseBasedAquifer.class)
public class AquiferMixin {
    
    @Final
    @Shadow
    private NoiseChunk noiseChunk;
    
    @Unique
    private DensityFunction test$continents;
    
    @Inject(method = "<init>", at = @At("RETURN"))
    public void constructor(NoiseChunk pNoiseChunk, ChunkPos pChunkPos, NoiseRouter pNoiseRouter, PositionalRandomFactory pPositionalRandomFactory, int pMinY, int pHeight, Aquifer.FluidPicker pGlobalFluidPicker, CallbackInfo ci) {
        test$continents = pNoiseRouter.continents();
    }
    
    /**
     * If position being computed is coastal or deeper (noise density function), then we want to replace the Aquifer fluid for close to or above surface.
     */
    @Inject(method = "computeFluid", at = @At(value = "RETURN"),
//  Note: the slice is to prevent replacing the last return as that one handles the underground aquifers. The
//    slice = @Slice(
//      from = @At("HEAD"),
//      to = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/Aquifer$NoiseBasedAquifer;computeSurfaceLevel(IIILnet/minecraft/world/level/levelgen/Aquifer$FluidStatus;IZ)I")
//    ),
    cancellable = true)
    public void changeComputedFluid(int pX, int pY, int pZ, CallbackInfoReturnable<Aquifer.FluidStatus> cir) {
        if (cir.getReturnValue().at(pY).is(Blocks.LAVA)) {
            return;
        }
        if (test$preliminaryContinentalValue(pX, pY, pZ) <= OverworldBiomeBuilder.NEAR_INLAND_START) { // OverworldBiomeBuilder.coastContinentalness max
            // Replace non-continental aquifers with salt-water. (replaces ocean water, and some connecting flooded caves)
            cir.setReturnValue(new Aquifer.FluidStatus(((Aquifer$FluidStatusAccessor) (Object) cir.getReturnValue()).getFluidLevel(), Blocks.CAKE.defaultBlockState()));
        }
    }
    
    @Unique
    private double test$preliminaryContinentalValue(int pX, int pY, int pZ) {
        int x = QuartPos.toBlock(QuartPos.fromBlock(pX));
        int y = QuartPos.toBlock(QuartPos.fromBlock(pY));
        int z = QuartPos.toBlock(QuartPos.fromBlock(pZ));
        
        return test$continents.compute(new DensityFunction.SinglePointContext(x, y, z));
    }
}

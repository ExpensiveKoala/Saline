package koala.saline.mixins;

import net.minecraft.world.level.levelgen.Aquifer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Aquifer.FluidStatus.class)
public interface Aquifer$FluidStatusAccessor {

    @Accessor("fluidLevel")
    int getFluidLevel();
}

package koala.saline.fluid;

import koala.saline.registry.SalineBlocks;
import koala.saline.registry.SalineFluids;
import koala.saline.registry.SalineItems;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public abstract class SaltWaterFluid extends BaseFlowingFluid {

    protected SaltWaterFluid(Properties properties) {
        super(properties);
    }

    @Override
    public Fluid getFlowing() {
        return SalineFluids.FLOWING_SALT_WATER.get();
    }

    @Override
    public Fluid getSource() {
        return SalineFluids.SALT_WATER.get();
    }

    @Override
    public Item getBucket() {
        return SalineItems.SALT_WATER_BUCKET;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState state) {
        return SalineBlocks.SALT_WATER.defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(state));
    }

    public static class Source extends SaltWaterFluid {
        protected Source(Properties properties) {
            super(properties);
        }

        @Override
        public int getAmount(FluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends SaltWaterFluid {

        protected Flowing(Properties properties) {
            super(properties);
        }

        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }
    }
}

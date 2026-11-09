package koala.saline.block;

import koala.saline.tags.SalineTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;

public class SaltBlock extends Block {
    public SaltBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        Direction direction = Direction.getRandom(random);
        BlockPos blockpos = pos.relative(direction);
        BlockState blockstate = level.getBlockState(blockpos);
        if (level.getFluidState(blockpos).is(FluidTags.WATER)) {
            if(blockstate.getBlock() instanceof LiquidBlockContainer liquidBlockContainer
                && liquidBlockContainer.canPlaceLiquid(null, level, blockpos, blockstate, SalineFluids.SALT_WATER)) {
                liquidBlockContainer.placeLiquid(level, blockpos, blockstate, SalineBlocks.SALT_WATER.getSource(false));
            } else if(blockstate.is(Blocks.WATER)) {
                level.setBlockAndUpdate(blockpos, SalineBlocks.SALT_WATER.defaultBlockState());
            }
        }
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (!entity.isSteppingCarefully() && entity.getType().is(SalineTags.GETS_HURT_BY_SALT)) {
            entity.hurt(level.damageSources().dryOut(), 1.0F);
        }
        super.stepOn(level, pos, state, entity);
    }
}

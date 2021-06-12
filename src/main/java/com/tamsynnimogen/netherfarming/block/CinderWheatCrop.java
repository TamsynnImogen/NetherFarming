package com.tamsynnimogen.netherfarming.block;

import com.tamsynnimogen.netherfarming.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class CinderWheatCrop extends CropsBlock
{
    public CinderWheatCrop(Properties builder)
    {
        super(builder);
    }

    @Override
    protected IItemProvider getSeedsItem()
    {
        return ModItems.CINDER_WHEAT_SEEDS.get();
    }

    @Override
    public boolean isValidPosition(BlockState stateIn, IWorldReader worldIn, BlockPos pos)
    {
        BlockState state = worldIn.getBlockState(pos.down());
        Block block = state.getBlock();

        if (block.equals(ModBlocks.TILLED_SOUL_SOIL.get()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
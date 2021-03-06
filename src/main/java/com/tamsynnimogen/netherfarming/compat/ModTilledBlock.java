package com.tamsynnimogen.netherfarming.compat;

import com.tamsynnimogen.netherfarming.block.ModBlocks;
import com.tamsynnimogen.netherfarming.block.ModFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.NetherVegetationFeature;
import net.minecraft.world.gen.feature.TwistingVineFeature;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.Random;

public class ModTilledBlock extends RotatedPillarBlock implements IGrowable {
    private final BlockState tilled;
    public ModTilledBlock(BlockState state, Properties properties) {
        super(properties);
        this.tilled = state;
    }

    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.up()).isAir();
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        BlockState blockstate = worldIn.getBlockState(pos);
        BlockPos blockpos = pos.up();
        if (blockstate.matchesBlock(ModBlocks.FERTILE_SOUL_SOIL.get())) {
            NetherVegetationFeature.func_236325_a_(worldIn, rand, blockpos, ModFeatures.Configs.SOUL_SOIL_VEGETATION_CONFIG, 3, 1);
        } else if (blockstate.matchesBlock(Blocks.SOUL_SOIL)) {
            NetherVegetationFeature.func_236325_a_(worldIn, rand, blockpos, ModFeatures.Configs.SOUL_SOIL_VEGETATION_CONFIG, 3, 1);
            if (rand.nextInt(8) == 0) {
                TwistingVineFeature.func_236423_a_(worldIn, rand, blockpos, 3, 1, 2);
            }
        }

    }

    @Override
    @Nullable
    public BlockState getToolModifiedState(BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack stack, ToolType toolType) {
        return toolType == ToolType.HOE ? tilled : null;
    }
}
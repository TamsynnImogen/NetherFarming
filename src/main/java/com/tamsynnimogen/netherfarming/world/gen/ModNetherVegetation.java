package com.tamsynnimogen.netherfarming.world.gen;

import com.tamsynnimogen.netherfarming.block.ModBlocks;
import com.tamsynnimogen.netherfarming.block.ModFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.NetherVegetationFeature;
import net.minecraft.world.gen.feature.TwistingVineFeature;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class ModNetherVegetation implements IGrowable {

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
            NetherVegetationFeature.func_236325_a_(worldIn, rand, blockpos, Features.Configs.NETHER_SPROUTS_CONFIG, 3, 1);
            if (rand.nextInt(8) == 0) {
                TwistingVineFeature.func_236423_a_(worldIn, rand, blockpos, 3, 1, 2);
            }
        }

    }
}

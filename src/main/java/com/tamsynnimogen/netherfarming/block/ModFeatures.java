package com.tamsynnimogen.netherfarming.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;

public class ModFeatures {

    public static final class Configs {
        public static final BlockStateProvidingFeatureConfig SOUL_SOIL_VEGETATION_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(ModFeatures.States.SOUL_ROOTS, 85).addWeightedBlockstate(ModFeatures.States.BLOODBARK_FUNGUS, 10).addWeightedBlockstate(ModFeatures.States.GLOWBERRY_CROP, 5));
    }

    public static final ConfiguredFeature<HugeFungusConfig, ?> BLOODBARK_FUNGUS_PLANTED = register(
            "bloodbark_fungi_planted", Feature.HUGE_FUNGUS.withConfiguration(ModHugeFungusConfig.BLOODBARK_FUNGUS_PLANTED));

    public static final class States {
        protected static final BlockState BLOODBARK_FUNGUS = ModBlocks.BLOODBARK_FUNGUS.get().getDefaultState();
        protected static final BlockState GLOWBERRY_CROP = ModBlocks.GLOWBERRY_CROP.get().getDefaultState();
        protected static final BlockState SOUL_ROOTS = ModBlocks.SOUL_ROOTS.get().getDefaultState();

    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }



}

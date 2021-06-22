package com.tamsynnimogen.netherfarming.block;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class ModHugeFungusConfig implements IFeatureConfig {
    public static final Codec<net.minecraft.world.gen.feature.HugeFungusConfig> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(BlockState.CODEC.fieldOf("valid_base_block").forGetter((config) -> {
            return config.validBaseBlock;
        }), BlockState.CODEC.fieldOf("stem_state").forGetter((config) -> {
            return config.stemState;
        }), BlockState.CODEC.fieldOf("hat_state").forGetter((config) -> {
            return config.hatState;
        }), BlockState.CODEC.fieldOf("decor_state").forGetter((config) -> {
            return config.decorState;
        }), Codec.BOOL.fieldOf("planted").orElse(false).forGetter((config) -> {
            return config.planted;
        })).apply(builder, net.minecraft.world.gen.feature.HugeFungusConfig::new);
    });
    public static final net.minecraft.world.gen.feature.HugeFungusConfig BLOODBARK_FUNGUS_PLANTED = new net.minecraft.world.gen.feature.HugeFungusConfig(Blocks.SOUL_SOIL.getDefaultState(), ModBlocks.BLOODBARK_LOG.get().getDefaultState(), ModBlocks.BLOODBARK_WART_BLOCK.get().getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);
    public static final net.minecraft.world.gen.feature.HugeFungusConfig BLOODBARK_FUNGUS;
    public final BlockState validBaseBlock;
    public final BlockState stemState;
    public final BlockState hatState;
    public final BlockState decorState;
    public final boolean planted;

    public ModHugeFungusConfig(BlockState validBaseBlock, BlockState stemState, BlockState hatState, BlockState decorState, boolean planted) {
        this.validBaseBlock = validBaseBlock;
        this.stemState = stemState;
        this.hatState = hatState;
        this.decorState = decorState;
        this.planted = planted;
    }

    static {
        BLOODBARK_FUNGUS = new net.minecraft.world.gen.feature.HugeFungusConfig(BLOODBARK_FUNGUS_PLANTED.validBaseBlock, BLOODBARK_FUNGUS_PLANTED.stemState, BLOODBARK_FUNGUS_PLANTED.hatState, BLOODBARK_FUNGUS_PLANTED.decorState, false);
    }
}


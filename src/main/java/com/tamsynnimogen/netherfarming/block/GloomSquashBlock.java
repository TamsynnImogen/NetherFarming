package com.tamsynnimogen.netherfarming.block;

import net.minecraft.block.*;

public class GloomSquashBlock extends ModStemGrownBlock {
    public GloomSquashBlock(AbstractBlock.Properties builder) {
        super(builder);
    }

    public ModStemBlock getStem() {
        return (ModStemBlock) ModBlocks.GLOOM_SQUASH_STEM.get();
    }

    public ModAttachedStemBlock getAttachedStem() {
        return (ModAttachedStemBlock)ModBlocks.ATTACHED_GLOOM_SQUASH_STEM.get();
    }
}
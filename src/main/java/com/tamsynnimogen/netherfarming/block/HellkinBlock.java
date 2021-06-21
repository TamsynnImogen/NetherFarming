package com.tamsynnimogen.netherfarming.block;

import net.minecraft.block.StemGrownBlock;

public class HellkinBlock extends ModStemGrownBlock {
    public HellkinBlock(Properties builder) {
        super(builder);
    }

    public ModStemBlock getStem() {
        return (ModStemBlock) ModBlocks.HELLKIN_STEM.get();
    }

    public ModAttachedStemBlock getAttachedStem() {
        return (ModAttachedStemBlock)ModBlocks.ATTACHED_HELLKIN_STEM.get();
    }
}

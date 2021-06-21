package com.tamsynnimogen.netherfarming.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AttachedStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.StemBlock;

public abstract class ModStemGrownBlock extends Block {
    public ModStemGrownBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    public abstract ModStemBlock getStem();

    public abstract ModAttachedStemBlock getAttachedStem();
}

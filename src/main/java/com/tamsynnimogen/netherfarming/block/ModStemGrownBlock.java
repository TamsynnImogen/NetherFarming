package com.tamsynnimogen.netherfarming.block;

import net.minecraft.block.*;

public abstract class ModStemGrownBlock extends StemGrownBlock {
    public ModStemGrownBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    public abstract ModStemBlock getStem();

    public abstract ModAttachedStemBlock getAttachedStem();
}

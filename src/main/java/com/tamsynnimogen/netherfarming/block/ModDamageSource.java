package com.tamsynnimogen.netherfarming.block;

import net.minecraft.util.DamageSource;

public class ModDamageSource extends DamageSource
{
    public static final ModDamageSource GLOWBERRY_BUSH = new ModDamageSource("GlowberryCrop");

    public ModDamageSource(String damageTypeIn) {
        super(damageTypeIn);
    }
}
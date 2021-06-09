package com.tamsynnimogen.netherfarming.item;

import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ModFood extends Foods
{
        public static final Food GLOWBERRY = (new Food.Builder()).hunger(2).saturation(0.1F).effect(() -> new EffectInstance(Effects.GLOWING, 300, 1), 0.5f).build();
        public static final Food CINDER_BREAD = (new Food.Builder()).hunger(2).saturation(0.1F).effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 300, 1), 0.5f).build();


}

package com.tamsynnimogen.netherfarming.item;

import com.tamsynnimogen.netherfarming.util.Config;
import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ModFood extends Foods
{
        public static final Food GLOWBERRY = (new Food.Builder()).hunger(1).saturation(0.1F).setAlwaysEdible().effect(() -> new EffectInstance(Effects.GLOWING, Config.GLOWBERRY_GLOW_DURATION.get(), 1), 0.5f).build();
        public static final Food CINDER_BREAD = (new Food.Builder()).hunger(3).saturation(0.3F).effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, Config.CINDERBREAD_RESISTANCE_DURATION.get(), 1), 0.5f).build();
        public static final Food HELLKIN_BLOOD_CURRY = (new Food.Builder()).hunger(5).saturation(0.6F).build();
        public static final Food COOKED_GLOOM_SQUASH = (new Food.Builder()).hunger(2).saturation(0.1F).build();

}
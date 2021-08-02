package com.tamsynnimogen.netherfarming.util;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.io.File;

public class Config
{

    public static ForgeConfigSpec SERVER_CONFIFG;
    public static ForgeConfigSpec CLIENT_CONFIFG;

    public static ForgeConfigSpec.IntValue GLOWBERRY_GLOW_DURATION;
    public static ForgeConfigSpec.IntValue CINDERBREAD_RESISTANCE_DURATION;
    public static ForgeConfigSpec.BooleanValue HELLKIN_CURRY_MODE;


    static {

        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        glowingDuration(SERVER_BUILDER, CLIENT_BUILDER);
        heatResistanceDuration(SERVER_BUILDER, CLIENT_BUILDER);
        //hellkinCurryMode(SERVER_BUILDER, CLIENT_BUILDER);

        SERVER_CONFIFG = SERVER_BUILDER.build();
        CLIENT_CONFIFG = CLIENT_BUILDER.build();

    }

    private static void glowingDuration(ForgeConfigSpec.Builder SERVER_BUILDER,
                                        ForgeConfigSpec.Builder CLIENT_BUILDER)
    {
        GLOWBERRY_GLOW_DURATION = CLIENT_BUILDER.comment("How long the Glowberry glowing lasts for (in ticks)")
                .defineInRange("glow_duration", 300, 100, Integer.MAX_VALUE);
    }
    private static void heatResistanceDuration(ForgeConfigSpec.Builder SERVER_BUILDER,
                                               ForgeConfigSpec.Builder CLIENT_BUILDER)
    {
        CINDERBREAD_RESISTANCE_DURATION = CLIENT_BUILDER.comment("How long the Cinderbread heat resistance lasts for (in ticks)")
                .defineInRange("resist_duration", 300, 100, Integer.MAX_VALUE);
    }
/*
    private static void hellkinCurryMode(ForgeConfigSpec.Builder SERVER_BUILDER,
                                               ForgeConfigSpec.Builder CLIENT_BUILDER)
    {
        HELLKIN_CURRY_MODE = CLIENT_BUILDER.comment("How long the Cinderbread heat resistance lasts for (in ticks)")
                .define("hellkinCurryMode", true);
    }
*/
    public static void loadConfigFile(ForgeConfigSpec config, String path)
    {
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path))
                .sync().autosave().writingMode(WritingMode.REPLACE).build();

        file.load();
        config.setConfig(file);
    }

}

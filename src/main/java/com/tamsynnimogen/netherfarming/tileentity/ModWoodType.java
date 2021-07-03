package com.tamsynnimogen.netherfarming.tileentity;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.block.WoodType;

import java.util.Set;
import java.util.stream.Stream;

public class ModWoodType extends WoodType {

    public static final WoodType BLOODBARK = new ModWoodType("bloodbark");

    protected ModWoodType(String name) {
        super(name);
    }
}
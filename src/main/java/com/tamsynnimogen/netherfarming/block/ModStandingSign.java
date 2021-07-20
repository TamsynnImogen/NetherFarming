package com.tamsynnimogen.netherfarming.block;

import com.tamsynnimogen.netherfarming.tileentity.ModSignTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class ModStandingSign extends StandingSignBlock {
    public ModStandingSign(Properties properties, WoodType type) {
        super(properties, type);
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ModSignTileEntity();
    }
}

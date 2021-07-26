package com.tamsynnimogen.netherfarming.tileentity;

import net.minecraft.tileentity.TileEntityType;

public class ModSignTileEntity extends net.minecraft.tileentity.SignTileEntity {
    public ModSignTileEntity() {
        super();
    }

    @Override
    public TileEntityType<?> getType() {
        return ModTileEntitites.SIGN_TILE_ENTITIES.get();
    }
}

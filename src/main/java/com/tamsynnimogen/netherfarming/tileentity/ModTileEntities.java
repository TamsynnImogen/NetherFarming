package com.tamsynnimogen.netherfarming.tileentity;

import com.tamsynnimogen.netherfarming.block.ModBlocks;
import com.tamsynnimogen.netherfarming.util.Registration;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModTileEntities
{

    public static final RegistryObject<TileEntityType<SignTileEntity>> SIGN
            = Registration.TILE_ENTITY_TYPES.register("sign", () -> TileEntityType.Builder.create(ModSignTileEntity::
            new, ModBlocks.BLOODBARK_SIGN, ModBlocks.BLOODBARK_WALL_SIGN));


    public static void register() { }
}

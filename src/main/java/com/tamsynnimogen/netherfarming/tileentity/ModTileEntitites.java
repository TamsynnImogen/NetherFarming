package com.tamsynnimogen.netherfarming.tileentity;

import com.tamsynnimogen.netherfarming.block.ModBlocks;
import com.tamsynnimogen.netherfarming.util.Registration;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModTileEntitites
{
    public static final RegistryObject<TileEntityType<ModSignTileEntity>> SIGN_TILE_ENTITIES
            = Registration.TILE_ENTITY_TYPES.register("sign", () -> TileEntityType.Builder.create(ModSignTileEntity::new,
                ModBlocks.BLOODBARK_SIGN.get(),
                ModBlocks.BLOODBARK_WALL_SIGN.get()
            ).build(null));

    public static void register() { }
}

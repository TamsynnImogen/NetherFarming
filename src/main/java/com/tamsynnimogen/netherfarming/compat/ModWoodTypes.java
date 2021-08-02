package com.tamsynnimogen.netherfarming.compat;

import com.tamsynnimogen.netherfarming.NetherFarming;
import com.tamsynnimogen.netherfarming.tileentity.ModTileEntitites;
import net.minecraft.block.WoodType;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(NetherFarming.MOD_ID)
public class ModWoodTypes extends WoodType {

    public static final String MOD_ID = "netherfarming";

    public static final WoodType BLOODBARK = WoodType.create(new ResourceLocation(MOD_ID, "signs").toString());

    protected ModWoodTypes(String nameIn) {
        super(nameIn);
    }

    private void clientSetup(final FMLClientSetupEvent event)
        {
            ClientRegistry.bindTileEntityRenderer(ModTileEntitites.SIGN_TILE_ENTITIES.get(), SignTileEntityRenderer::new);
            event.enqueueWork(() -> {
                Atlases.addWoodType(BLOODBARK);
            });
        }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> WoodType.register(BLOODBARK));
    }
}

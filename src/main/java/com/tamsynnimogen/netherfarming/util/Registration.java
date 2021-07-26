package com.tamsynnimogen.netherfarming.util;

import com.tamsynnimogen.netherfarming.NetherFarming;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration
{
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, NetherFarming.MOD_ID);

    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, NetherFarming.MOD_ID);

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, NetherFarming.MOD_ID);

    public static void register()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        TILE_ENTITY_TYPES.register(eventBus);
    }

}
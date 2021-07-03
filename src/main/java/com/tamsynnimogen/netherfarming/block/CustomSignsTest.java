package com.tamsynnimogen.netherfarming.block;

import com.tamsynnimogen.netherfarming.NetherFarming;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//@Mod(CustomSignsTest.MOD_ID)
public class CustomSignsTest
{/*
    public static final boolean ENABLE = true;
    public static final String MOD_ID = "netherfarming";

    public static final WoodType BLOODBARK = WoodType.create(new ResourceLocation(MOD_ID, "bloodbark").toString());

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final RegistryObject<CustomStandingSignBlock> BLOODBARK_STANDING_SIGN = BLOCKS.register("bloodbark_sign", () -> new CustomStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), CustomSignsTest.BLOODBARK));
    public static final RegistryObject<CustomWallSignBlock> BLOODBARK_WALL_SIGN = BLOCKS.register("bloodbark_wall_sign", () -> new CustomWallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), CustomSignsTest.BLOODBARK));

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final RegistryObject<SignItem> BLOODBARK_SIGN = ITEMS.register("bloodbark_sign", () -> new SignItem((new Item.Properties()).maxStackSize(16).group(NetherFarming.CREATIVETAB), BLOODBARK_STANDING_SIGN.get(), BLOODBARK_WALL_SIGN.get()));

    private static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MOD_ID);
    public static final RegistryObject<TileEntityType<CustomSignTileEntity>> CUSTOM_SIGN = TILE_ENTITIES.register("bloodbark_sign", () -> TileEntityType.Builder.create(CustomSignTileEntity::new, BLOODBARK_WALL_SIGN.get(), BLOODBARK_STANDING_SIGN.get()).build(null));

    public CustomSignsTest()
    {
        if (ENABLE)
        {
            final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
            BLOCKS.register(eventBus);
            ITEMS.register(eventBus);
            TILE_ENTITIES.register(eventBus);

            eventBus.addListener(this::clientSetup);
            eventBus.addListener(this::commonSetup);
        }
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        ClientRegistry.bindTileEntityRenderer(CUSTOM_SIGN.get(), SignTileEntityRenderer::new);
        event.enqueueWork(() -> {
           Atlases.addWoodType(BLOODBARK);
        });
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> WoodType.register(BLOODBARK));
    }

    public static class CustomStandingSignBlock extends StandingSignBlock
    {

        public CustomStandingSignBlock(Properties propertiesIn, WoodType woodTypeIn)
        {
            super(propertiesIn, woodTypeIn);
        }

        @Override
        public boolean hasTileEntity(BlockState stateIn)
        {
            return true;
        }

        //@Override
        public TileEntity newBlockEntity(IBlockReader worldIn)
        {
            return new CustomSignTileEntity();
        }
    }

    public static class CustomWallSignBlock extends WallSignBlock
    {

        public CustomWallSignBlock(Properties propertiesIn, WoodType woodTypeIn)
        {
            super(propertiesIn, woodTypeIn);
        }

        @Override
        public boolean hasTileEntity(BlockState stateIn)
        {
            return true;
        }

        //@Override
        public TileEntity newBlockEntity(IBlockReader worldIn)
        {
            return new CustomSignTileEntity();
        }
    }

    public static class CustomSignTileEntity extends SignTileEntity
    {
        @Override
        public TileEntityType<CustomSignTileEntity> getType()
        {
            return CUSTOM_SIGN.get();
        }
    }
    */
}

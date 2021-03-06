package com.tamsynnimogen.netherfarming;

import com.tamsynnimogen.netherfarming.block.ModBlocks;
import com.tamsynnimogen.netherfarming.events.ModEvents;
import com.tamsynnimogen.netherfarming.item.ModItems;
import com.tamsynnimogen.netherfarming.tileentity.ModTileEntitites;
import com.tamsynnimogen.netherfarming.util.Config;
import com.tamsynnimogen.netherfarming.util.Registration;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.WoodType;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(NetherFarming.MOD_ID)
public class NetherFarming
{
    public static final String MOD_ID = "netherfarming";

    public static final ItemGroup CREATIVETAB = new ItemGroup("creativeTab")
    {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.NETHER_FARMING_ICON.get());
        }
    };

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public NetherFarming() {

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIFG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIFG);

        Registration.register();
        ModItems.register();
        ModBlocks.register();

        ModTileEntitites.register();

        // register mod events
        MinecraftForge.EVENT_BUS.register(new ModEvents());

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        Config.loadConfigFile(Config.CLIENT_CONFIFG, FMLPaths.CONFIGDIR.get().resolve("netherfarming-client.toml").toString());
        Config.loadConfigFile(Config.SERVER_CONFIFG, FMLPaths.CONFIGDIR.get().resolve("netherfarming-server.toml").toString());

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static final WoodType BLOODBARK = WoodType.create(new ResourceLocation(MOD_ID, "bloodbark").toString());

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        event.enqueueWork(() -> {
            ComposterBlock.CHANCES.put(ModItems.CINDER_WHEAT.get(), 0.32f);
            ComposterBlock.CHANCES.put(ModItems.CINDER_WHEAT_DOUGH.get(), 0.32f);
            ComposterBlock.CHANCES.put(ModItems.GLOWBERRY.get(), 0.32f);
            ComposterBlock.CHANCES.put(ModItems.SOUL_ROOTS.get(), 0.32f);
            ComposterBlock.CHANCES.put(ModItems.CINDER_BREAD.get(), 0.32f);
            ComposterBlock.CHANCES.put(ModItems.CINDER_HAY_BLOCK.get(), 0.32f);
            ComposterBlock.CHANCES.put(ModItems.CINDER_WHEAT_SEEDS.get(), 0.32f);
            ComposterBlock.CHANCES.put(ModItems.GLOOM_SQUASH_SEEDS.get(), 0.32f);
            ComposterBlock.CHANCES.put(ModItems.HELLKIN_SEEDS.get(), 0.32f);
            ComposterBlock.CHANCES.put(ModItems.HELLKIN_BLOOD_CURRY.get(), 0.32f);
            ComposterBlock.CHANCES.put(ModItems.COOKED_GLOOM_SQUASH.get(), 0.32f);
            ComposterBlock.CHANCES.put(ModBlocks.BLOODBARK_FUNGUS.get().asItem(), 0.32f);
            ComposterBlock.CHANCES.put(ModBlocks.GLOOM_SQUASH.get().asItem(), 0.32f);
            ComposterBlock.CHANCES.put(ModBlocks.HELLKIN.get().asItem(), 0.32f);
            WoodType.register(BLOODBARK);
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
        RenderTypeLookup.setRenderLayer(ModBlocks.CINDER_WHEAT_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GLOWBERRY_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLOODBARK_FUNGUS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLOODBARK_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLOODBARK_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.ATTACHED_GLOOM_SQUASH_STEM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.ATTACHED_HELLKIN_STEM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GLOOM_SQUASH_STEM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.HELLKIN_STEM.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOUL_ROOTS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_SOUL_ROOTS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.POTTED_BLOODBARK_FUNGUS.get(), RenderType.getCutout());

        event.enqueueWork(() -> {
            ClientRegistry.bindTileEntityRenderer(ModTileEntitites.SIGN_TILE_ENTITIES.get(), SignTileEntityRenderer::new);
            Atlases.addWoodType(BLOODBARK);
        });
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}

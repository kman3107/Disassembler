package io.github.kman3107.disassembler;

import io.github.kman3107.disassembler.init.BlockInit;
import io.github.kman3107.disassembler.init.ContainerInit;
import io.github.kman3107.disassembler.init.ItemInit;
import io.github.kman3107.disassembler.init.TileInit;
import io.github.kman3107.disassembler.objects.blocks.DisassemblerScreen;
import io.github.kman3107.disassembler.setup.ClientProxy;
import io.github.kman3107.disassembler.setup.IProxy;
import io.github.kman3107.disassembler.setup.ServerProxy;
import io.github.kman3107.disassembler.world.gen.OreGen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("disassembler")
@Mod.EventBusSubscriber(modid = io.github.kman3107.disassembler.Disassembler.MOD_ID, bus = Bus.MOD)
public class Disassembler
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "disassembler";
    public static final IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
    public static Disassembler instance;

    public Disassembler() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        BlockInit.BLOCKS.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        TileInit.TILES.register(modEventBus);
        ContainerInit.CONTAINERS.register(modEventBus);

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(DisassemblerItemGroup.instance);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });

        LOGGER.debug("Registered BlockItems!");
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

        ScreenManager.registerFactory(ContainerInit.DISASSEMBLER_CONTAINER.get(), DisassemblerScreen::new);
    }

    @SubscribeEvent
    public static void onServerStarting(FMLServerStartingEvent event) {

    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
        OreGen.generateOre();
    }

    public static class DisassemblerItemGroup extends ItemGroup {
        public static final DisassemblerItemGroup instance = new DisassemblerItemGroup(ItemGroup.GROUPS.length, "disassemblertab");

        private DisassemblerItemGroup(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.DISASSEMBLER.get());
        }
    }
}

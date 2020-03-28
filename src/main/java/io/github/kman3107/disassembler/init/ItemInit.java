package io.github.kman3107.disassembler.init;

import io.github.kman3107.disassembler.Disassembler;
import io.github.kman3107.disassembler.objects.items.DisassemblyBook;
import io.github.kman3107.disassembler.objects.items.Dismite;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Disassembler.MOD_ID);

    public static final RegistryObject<DisassemblyBook> DISASSEMBLY_BOOK = ITEMS.register("disassembly_book", () -> new DisassemblyBook(new DisassemblyBook.Properties().group(io.github.kman3107.disassembler.Disassembler.DisassemblerItemGroup.instance)));

    public static final RegistryObject<Dismite> DISMITE = ITEMS.register("dismite", Dismite::new);
}

package io.github.kman3107.disassembler.objects.items;

import io.github.kman3107.disassembler.Disassembler;
import net.minecraft.item.Item;

public class Dismite extends Item {

    public Dismite() {
        super(new Properties().group(Disassembler.DisassemblerItemGroup.instance));
    }
}

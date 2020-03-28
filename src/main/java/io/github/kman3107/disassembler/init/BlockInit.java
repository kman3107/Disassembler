package io.github.kman3107.disassembler.init;

import io.github.kman3107.disassembler.Disassembler;
import io.github.kman3107.disassembler.objects.blocks.DismiteOre;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Disassembler.MOD_ID);

    public static final RegistryObject<io.github.kman3107.disassembler.objects.blocks.Disassembler> DISASSEMBLER = BLOCKS.register("disassembler", io.github.kman3107.disassembler.objects.blocks.Disassembler::new);

    public static final RegistryObject<DismiteOre> DISMITE_ORE = BLOCKS.register("dismite_ore", DismiteOre::new);
}

package io.github.kman3107.disassembler.init;

import io.github.kman3107.disassembler.Disassembler;
import io.github.kman3107.disassembler.objects.blocks.DisassemblerTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileInit {

    public static final DeferredRegister<TileEntityType<?>> TILES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Disassembler.MOD_ID);

    public static final RegistryObject<TileEntityType<DisassemblerTile>> DISASSEMBLER_TILE = TILES.register("disassembler", () -> TileEntityType.Builder.create(DisassemblerTile::new, BlockInit.DISASSEMBLER.get()).build(null));
}

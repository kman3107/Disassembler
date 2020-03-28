package io.github.kman3107.disassembler.init;

import io.github.kman3107.disassembler.Disassembler;
import io.github.kman3107.disassembler.objects.blocks.DisassemblerContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerInit {

    public static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, io.github.kman3107.disassembler.Disassembler.MOD_ID);

    public static final RegistryObject<ContainerType<DisassemblerContainer>> DISASSEMBLER_CONTAINER = CONTAINERS.register("disassembler", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        return new DisassemblerContainer(windowId, Disassembler.proxy.getClientWorld(), pos, inv, io.github.kman3107.disassembler.Disassembler.proxy.getClientPlayer());
    }));
}

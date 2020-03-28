package io.github.kman3107.disassembler.objects.blocks;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DismiteOre extends OreBlock {

    public DismiteOre() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(2f)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE));
    }
}

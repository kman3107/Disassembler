package io.github.kman3107.disassembler.world.gen;

import io.github.kman3107.disassembler.init.BlockInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {

    public static void generateOre() {
//        for (Biome biome : ForgeRegistries.BIOMES) {
//            if (biome == Biomes.PLAINS || biome == Biomes.JUNGLE || biome == Biomes.DESERT) {
//                ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 11, 10, 25));
//                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
//                        .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.DISMIT_ORE.get()
//                                .getDefaultState(), 7)).withPlacement(customConfig));
//            }
//        }

        for (Biome biome : ForgeRegistries.BIOMES) {
            ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(5, 11, 10, 25));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.DISMITE_ORE.get()
                            .getDefaultState(), 7)).withPlacement(customConfig));
        }
    }
}

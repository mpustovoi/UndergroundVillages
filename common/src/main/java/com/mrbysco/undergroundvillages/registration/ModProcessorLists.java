package com.mrbysco.undergroundvillages.registration;

import com.google.common.collect.ImmutableList;
import com.mrbysco.undergroundvillages.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.AlwaysTrueTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProcessorRule;
import net.minecraft.world.level.levelgen.structure.templatesystem.RandomBlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;

public class ModProcessorLists {
	public static final ResourceKey<StructureProcessorList> STREET_CAVE = ResourceKey.create(Registries.PROCESSOR_LIST, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "street_cave"));

	public static void bootstrap(BootstrapContext<StructureProcessorList> context) {
		register(context, STREET_CAVE, ImmutableList.of(new RuleProcessor(ImmutableList.of(new ProcessorRule(new BlockMatchTest(Blocks.CALCITE),
				new BlockMatchTest(Blocks.WATER), Blocks.OAK_PLANKS.defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.CALCITE, 0.1F),
				AlwaysTrueTest.INSTANCE, Blocks.GRASS_BLOCK.defaultBlockState()), new ProcessorRule(new BlockMatchTest(Blocks.GRASS_BLOCK),
				new BlockMatchTest(Blocks.WATER), Blocks.WATER.defaultBlockState()), new ProcessorRule(new BlockMatchTest(Blocks.DIRT),
				new BlockMatchTest(Blocks.WATER), Blocks.WATER.defaultBlockState())))));
	}

	private static void register(BootstrapContext<StructureProcessorList> BootstrapContext,
								 ResourceKey<StructureProcessorList> processorListResourceKey,
								 List<StructureProcessor> structureProcessorList) {
		BootstrapContext.register(processorListResourceKey, new StructureProcessorList(structureProcessorList));
	}
}

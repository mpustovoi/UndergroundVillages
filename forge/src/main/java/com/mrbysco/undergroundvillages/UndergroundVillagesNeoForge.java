package com.mrbysco.undergroundvillages;

import com.mrbysco.undergroundvillages.config.UndergroundConfigForge;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(Constants.MOD_ID)
public class UndergroundVillagesNeoForge {

	public UndergroundVillagesNeoForge(ModContainer container) {
		CommonClass.init();

		container.registerConfig(ModConfig.Type.COMMON, UndergroundConfigForge.commonSpec);
	}
}
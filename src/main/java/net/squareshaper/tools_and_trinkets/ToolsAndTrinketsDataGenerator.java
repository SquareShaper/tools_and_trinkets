package net.squareshaper.tools_and_trinkets;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.squareshaper.tools_and_trinkets.datagen.ModModelProvider;
import net.squareshaper.tools_and_trinkets.datagen.ModRecipeProvider;

public class ToolsAndTrinketsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}

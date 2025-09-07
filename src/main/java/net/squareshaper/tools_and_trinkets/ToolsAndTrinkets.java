package net.squareshaper.tools_and_trinkets;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.squareshaper.tools_and_trinkets.registry.ModEffects;
import net.squareshaper.tools_and_trinkets.registry.ModEntities;
import net.squareshaper.tools_and_trinkets.registry.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToolsAndTrinkets implements ModInitializer {
	public static final String MOD_ID = "tools_and_trinkets";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Identifier id(String name) {
		return Identifier.of(MOD_ID, name);
	}

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModEntities.registerModEntities();
		ModEffects.registerModEffects();
	}
}
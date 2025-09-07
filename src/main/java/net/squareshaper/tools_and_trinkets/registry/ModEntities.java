package net.squareshaper.tools_and_trinkets.registry;

import net.squareshaper.tools_and_trinkets.ToolsAndTrinkets;

public class ModEntities {
//    public static final EntityType<AquaeusBubbleEntity> AQUAEUS_BUBBLE = Registry.register(Registries.ENTITY_TYPE, WeaponRandomizerChallenge.id("aquaeus_bubble"),
//            EntityType.Builder.create(AquaeusBubbleEntity::new, SpawnGroup.MISC)
//                    .dimensions(0.1f,0.1f).build());

    public static void registerModEntities() {
        ToolsAndTrinkets.LOGGER.info("Registering Mod Entities for " + ToolsAndTrinkets.MOD_ID + "...");
    }
}

package net.squareshaper.tools_and_trinkets.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.squareshaper.tools_and_trinkets.ToolsAndTrinkets;

public class ModEffects {
//    public static final RegistryEntry<StatusEffect> DROWNING = registerEffect("drowning", new DrowningEffect(StatusEffectCategory.HARMFUL, 0x001a34));

    private static RegistryEntry<StatusEffect> registerEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, ToolsAndTrinkets.id(name), statusEffect);
    }

    public static void registerModEffects() {
        ToolsAndTrinkets.LOGGER.info("Registering Mod Effects for " + ToolsAndTrinkets.MOD_ID + "...");
    }
}

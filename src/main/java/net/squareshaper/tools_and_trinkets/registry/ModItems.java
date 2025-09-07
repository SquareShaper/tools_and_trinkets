package net.squareshaper.tools_and_trinkets.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.squareshaper.tools_and_trinkets.ToolsAndTrinkets;
import net.squareshaper.tools_and_trinkets.item.StabilizedPearlItem;

public class ModItems {
//    public static final Item AQUAEUS_TOME = registerItem("aquaeus_tome", new AquaeusTomeItem(new Item.Settings().maxDamage(AquaeusTomeItem.specialCooldown).maxCount(1)));

    public static final Item FENDORINE_SHARD = registerItem("fendorine_shard", new Item(new Item.Settings()));
    public static final Item FENDORINE_PEARL = registerItem("fendorine_pearl", new StabilizedPearlItem(new Item.Settings().maxCount(1)));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, ToolsAndTrinkets.id(name), item);
    }

    public static void registerModItems() {
        ToolsAndTrinkets.LOGGER.info("Registering Mod Items for " + ToolsAndTrinkets.MOD_ID + "...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.AMETHYST_SHARD, FENDORINE_SHARD);
        });
    }


}

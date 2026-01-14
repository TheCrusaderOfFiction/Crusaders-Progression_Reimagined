package net.wolfygames7237.crusadersprogressionreimagined.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.wolfygames7237.crusadersprogressionreimagined.CrusadersProgressionReimagined;
import net.wolfygames7237.crusadersprogressionreimagined.Item.ModItem;
import net.wolfygames7237.crusadersprogressionreimagined.loot.AddItemModifier;
import net.wolfygames7237.crusadersprogressionreimagined.loot.RequireToolModifier;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, CrusadersProgressionReimagined.MOD_ID);
    }


    @Override
    protected void start() {

        add("fiber_from_grass", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("minecraft", "blocks/grass")).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build()}, ModItem.FIBER.get()));
        add("rock_from_grass", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("minecraft", "blocks/grass")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build()}, ModItem.ROCK.get()));

        add("require_axe_for_all_logs", new RequireToolModifier(new LootItemCondition[] {
                // "Any" condition: This ensures the modifier always fires,
                // allowing our Java logic to do the heavy lifting safely.
                LootItemRandomChanceCondition.randomChance(1.0f).build()
        }));
    }
}

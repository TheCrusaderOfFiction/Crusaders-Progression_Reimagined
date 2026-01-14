package net.wolfygames7237.crusadersprogressionreimagined.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wolfygames7237.crusadersprogressionreimagined.CrusadersProgressionReimagined;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CrusadersProgressionReimagined.MOD_ID);

    public static final RegistryObject<RecipeSerializer<ForgeRecipe>> FORGE_SERIALIZER =
            SERIALIZERS.register("forge", () -> ForgeRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}

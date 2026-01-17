package net.wolfygames7237.crusadersprogressionreimagined.loot;

import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.wolfygames7237.crusadersprogressionreimagined.CrusadersProgressionReimagined;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, CrusadersProgressionReimagined.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM =
            LOOT_MODIFIER_SERIALIZERS.register("add_item", AddItemModifier.CODEC);

    public static final RegistryObject<Codec<RequireToolModifier>> REQUIRE_TOOL =
            LOOT_MODIFIER_SERIALIZERS.register("require_axe", () -> RequireToolModifier.CODEC.get());


    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }
}

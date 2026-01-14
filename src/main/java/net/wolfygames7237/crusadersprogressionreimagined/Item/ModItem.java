package net.wolfygames7237.crusadersprogressionreimagined.Item;

import net.minecraft.world.item.*;
import net.wolfygames7237.crusadersprogressionreimagined.CrusadersProgressionReimagined;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItem {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CrusadersProgressionReimagined.MOD_ID);

    public static final RegistryObject<Item> COPPER_HAMMER = ITEMS.register( "copper_hammer",
            () ->new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register( "iron_hammer",
            () ->new Item(new Item.Properties()));

    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register( "copper_sword",
            () ->new SwordItem(ModToolTiers.COPPER, 5, 2, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register( "copper_pickaxe",
            () ->new PickaxeItem(ModToolTiers.COPPER, 3, 1, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register( "copper_axe",
            () ->new AxeItem(ModToolTiers.COPPER, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register( "copper_shovel",
            () ->new ShovelItem(ModToolTiers.COPPER, 3, 1, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_HOE = ITEMS.register( "copper_hoe",
            () ->new HoeItem(ModToolTiers.COPPER, 0, 2, new Item.Properties()));


    public static final RegistryObject<Item> IRON_SWORD_BLADE = ITEMS.register( "iron_sword_blade",
            () ->new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_HOE_BLADE = ITEMS.register( "iron_hoe_blade",
            () ->new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_SHOVEL_BLADE = ITEMS.register( "iron_shovel_blade",
            () ->new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_AXE_HEAD = ITEMS.register( "iron_axe_head",
            () ->new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_PICKAXE_HEAD = ITEMS.register( "iron_pickaxe_head",
            () ->new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_SWORD_BLADE = ITEMS.register( "diamond_sword_blade",
            () ->new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_HOE_BLADE = ITEMS.register( "diamond_hoe_blade",
            () ->new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SHOVEL_BLADE = ITEMS.register( "diamond_shovel_blade",
            () ->new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_AXE_HEAD = ITEMS.register( "diamond_axe_head",
            () ->new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_PICKAXE_HEAD = ITEMS.register( "diamond_pickaxe_head",
            () ->new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROCK = ITEMS.register( "rock",
            () ->new Item(new Item.Properties()));

    public static final RegistryObject<Item> ROCK_HATCHET = ITEMS.register( "rock_hatchet",
            () ->new AxeItem(Tiers.WOOD,1,1, new Item.Properties()));
    public static final RegistryObject<Item> FIBER = ITEMS.register( "fiber",
            () ->new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

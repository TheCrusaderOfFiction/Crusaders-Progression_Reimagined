package net.wolfygames7237.crusadersprogressionreimagined.Item;

import net.wolfygames7237.crusadersprogressionreimagined.CrusadersProgressionReimagined;
import net.wolfygames7237.crusadersprogressionreimagined.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CrusadersProgressionReimagined.MOD_ID);

    public static final RegistryObject<CreativeModeTab> Crusaders_progress = CREATIVE_MODE_TABS.register("crusaders_progress",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.FORGE.get()))
                    .title(Component.translatable("creativetab.crusader_progress"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.FORGE.get());

                        output.accept(ModItem.COPPER_HAMMER.get());
                        output.accept(ModItem.IRON_HAMMER.get());

                        output.accept(ModItem.COPPER_SWORD.get());
                        output.accept(ModItem.COPPER_PICKAXE.get());
                        output.accept(ModItem.COPPER_AXE.get());
                        output.accept(ModItem.COPPER_SHOVEL.get());
                        output.accept(ModItem.COPPER_HOE.get());

                        output.accept(ModItem.IRON_SWORD_BLADE.get());
                        output.accept(ModItem.IRON_AXE_HEAD.get());
                        output.accept(ModItem.IRON_PICKAXE_HEAD.get());
                        output.accept(ModItem.IRON_SHOVEL_BLADE.get());
                        output.accept(ModItem.IRON_HOE_BLADE.get());

                        output.accept(ModItem.DIAMOND_SWORD_BLADE.get());
                        output.accept(ModItem.DIAMOND_AXE_HEAD.get());
                        output.accept(ModItem.DIAMOND_PICKAXE_HEAD.get());
                        output.accept(ModItem.DIAMOND_SHOVEL_BLADE.get());
                        output.accept(ModItem.DIAMOND_HOE_BLADE.get());

                        output.accept(ModItem.ROCK_HATCHET.get());
                        output.accept(ModItem.ROCK.get());

                        output.accept(ModItem.FIBER.get());
                        output.accept(ModBlocks.CHARGED_COAL_BLOCK.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

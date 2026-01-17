package net.wolfygames7237.crusadersprogressionreimagined.compat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.wolfygames7237.crusadersprogressionreimagined.CrusadersImaginedConfig;

public class DynamicTreesCompat {

    @SubscribeEvent
    public void onBreak(BlockEvent.BreakEvent event) {
        // 🔒 Respect config (cached value, SAFE)
        if (!CrusadersImaginedConfig.isAxeRequired()) {
            return;
        }

        Block block = event.getState().getBlock();
        ResourceLocation blockId = ForgeRegistries.BLOCKS.getKey(block);

        if (blockId == null) {
            return;
        }

        String namespace = blockId.getNamespace();
        String path = blockId.getPath();

        // ✅ Dynamic Trees namespaces always start with "dt" or are "dynamictrees"
        boolean isDynamicTrees =
                namespace.equals("dynamictrees") || namespace.startsWith("dt");

        if (!isDynamicTrees) {
            return;
        }

        // Only affect branch blocks
        if (!path.contains("branch")) {
            return;
        }

        // Cancel if not using an axe
        if (!(event.getPlayer().getMainHandItem().getItem() instanceof AxeItem)) {
            event.setCanceled(true);
        }
    }

}

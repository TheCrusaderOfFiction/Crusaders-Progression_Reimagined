package net.wolfygames7237.crusadersprogressionreimagined;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(
        modid = CrusadersProgressionReimagined.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class CrusadersImaginedConfig {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Raw config value (DO NOT .get() outside this class)
    private static final ForgeConfigSpec.BooleanValue REQUIRE_AXE_FOR_LOGS;

    // Cached value (SAFE to use anywhere)
    public static boolean requireAxeForLogs = true;

    static {
        BUILDER.push("General");

        REQUIRE_AXE_FOR_LOGS = BUILDER
                .comment("Require an axe to get log drops")
                .define("requireAxeForLogs", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    /* ==============================
       CONFIG EVENTS
       ============================== */

    @SubscribeEvent
    public static void onConfigLoad(final ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == SPEC) {
            bake();
        }
    }

    @SubscribeEvent
    public static void onConfigReload(final ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() == SPEC) {
            bake();
        }
    }

    /* ==============================
       INTERNAL
       ============================== */

    private static void bake() {
        requireAxeForLogs = REQUIRE_AXE_FOR_LOGS.get();
    }

    /* ==============================
       PUBLIC API
       ============================== */

    public static boolean isAxeRequired() {
        return requireAxeForLogs;
    }
}

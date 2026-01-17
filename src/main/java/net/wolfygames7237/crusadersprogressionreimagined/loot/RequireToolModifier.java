package net.wolfygames7237.crusadersprogressionreimagined.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.wolfygames7237.crusadersprogressionreimagined.CrusadersImaginedConfig;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class RequireToolModifier extends LootModifier {

    public static final Supplier<Codec<RequireToolModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, RequireToolModifier::new))
    );
    public RequireToolModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }



    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(
            ObjectArrayList<ItemStack> generatedLoot,
            LootContext context
    ) {
        if (!CrusadersImaginedConfig.isAxeRequired()) {
            return generatedLoot;
        }

        BlockState state = context.getParamOrNull(LootContextParams.BLOCK_STATE);
        ItemStack tool = context.getParamOrNull(LootContextParams.TOOL);

        if (state != null && state.is(BlockTags.LOGS)) {
            if (tool == null || !(tool.getItem() instanceof AxeItem)) {
                return new ObjectArrayList<>();
            }
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}

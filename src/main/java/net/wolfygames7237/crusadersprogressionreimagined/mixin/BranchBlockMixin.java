package net.wolfygames7237.crusadersprogressionreimagined.mixin;

import com.ferreusveritas.dynamictrees.block.branch.BranchBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.wolfygames7237.crusadersprogressionreimagined.CrusadersImaginedConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BranchBlock.class)
public abstract class BranchBlockMixin {

    @Inject(
            method = "playerWillDestroy",
            at = @At("HEAD"),
            cancellable = true
    )
    private void cancelBreakIfNoAxe(Level world, BlockPos pos, BlockState state, Player player, CallbackInfo ci) {

        // Config toggle
        if (!CrusadersImaginedConfig.isAxeRequired()) return;

        // Creative mode bypass
        if (player.isCreative()) return;

        // Check if player is holding an axe in either hand
        if (!(player.getMainHandItem().getItem() instanceof AxeItem) &&
                !(player.getOffhandItem().getItem() instanceof AxeItem)) {

            // Cancel block break
            ci.cancel();

            // Send feedback
            player.sendSystemMessage(Component.literal("§cYou must use an axe to break this branch!"));
        }
    }
}

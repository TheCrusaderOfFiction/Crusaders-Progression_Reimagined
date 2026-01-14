package net.wolfygames7237.crusadersprogressionreimagined.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.wolfygames7237.crusadersprogressionreimagined.blocks.ModBlocks;
import net.wolfygames7237.crusadersprogressionreimagined.CrusadersProgressionReimagined;
import net.wolfygames7237.crusadersprogressionreimagined.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CrusadersProgressionReimagined.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Blocks.BEDROCK
                        );

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.LOGS);
        this.tag(ModTags.Blocks.NEEDS_WOOD_TOOL);

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .remove(BlockTags.IRON_ORES);

        this.tag(ModTags.Blocks.NEEDS_COPPER_TOOL)
                .addTag(BlockTags.IRON_ORES);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.FORGE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);




    }
}

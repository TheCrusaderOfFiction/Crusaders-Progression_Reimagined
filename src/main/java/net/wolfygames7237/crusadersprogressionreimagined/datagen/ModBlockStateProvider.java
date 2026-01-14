package net.wolfygames7237.crusadersprogressionreimagined.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.wolfygames7237.crusadersprogressionreimagined.CrusadersProgressionReimagined;
import net.wolfygames7237.crusadersprogressionreimagined.blocks.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CrusadersProgressionReimagined.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.CHARGED_COAL_BLOCK);

        horizontalBlock(ModBlocks.FORGE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/forge")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

package net.derex.tutorialmod.block;

import net.derex.tutorialmod.TutorialMod;
import net.derex.tutorialmod.block.custom.CopperConverter;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks
{
    public static final Block COPPER_CONVERTER = registerBlock("copper_converter",
            new CopperConverter(FabricBlockSettings.of(Material.METAL).strength(2f)),
            ItemGroup.DECORATIONS);

    private static Block registerBlock(String name, Block block, ItemGroup group)
    {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup group)
    {
        return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings().group(group)));

    }
    public static void registerModBlocks()
    {
        TutorialMod.LOGGER.info("Registering blocks for "+TutorialMod.MOD_ID);
    }
}

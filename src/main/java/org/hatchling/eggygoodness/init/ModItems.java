package org.hatchling.eggygoodness.init;

import cpw.mods.fml.common.registry.GameRegistry;
import org.hatchling.eggygoodness.item.*;
import org.hatchling.eggygoodness.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
    public static final ItemFoodEggyGoodness eggSandwich = new ItemEggSandwich();
    public static final ItemFoodEggyGoodness friedDoubleYolkEgg = new ItemFriedDoubleYolkEgg();
    public static final ItemFoodEggyGoodness friedEgg = new ItemFriedEgg();
    public static final ItemFoodEggyGoodness hardBoiledEgg = new ItemHardBoiledEgg();
    public static final ItemFoodEggyGoodness rawDoubleYolkEgg = new ItemRawDoubleYolkEgg();
    public static final ItemFoodEggyGoodness rawEgg = new ItemRawEgg();
    public static final ItemFoodBowl rawScrambledEgg = new ItemRawScrambledEgg();
    public static final ItemFoodBowl scrambledEgg = new ItemScrambledEgg();
    public static final ItemFoodEggyGoodness softBoiledEgg = new ItemSoftBoiledEgg();
    public static final ItemEggyGoodness unpeeledHardBoiledEgg = new ItemUnpeeledHardBoiledEgg();
    public static final ItemEggyGoodness unpeeledSoftBoiledEgg = new ItemUnpeeledSoftBoiledEgg();
    public static final ItemEggyGoodness diamondGoldenEgg = new ItemDiamondGoldenEgg();
    public static final ItemEggyGoodness emeraldGoldenEgg = new ItemEmeraldGoldenEgg();

    public static void init()
    {
        GameRegistry.registerItem(eggSandwich, "eggSandwich");
        GameRegistry.registerItem(friedDoubleYolkEgg, "friedDoubleYolkEgg");
        GameRegistry.registerItem(friedEgg, "friedEgg");
        GameRegistry.registerItem(hardBoiledEgg, "hardBoiledEgg");
        GameRegistry.registerItem(rawDoubleYolkEgg, "rawDoubleYolkEgg");
        GameRegistry.registerItem(rawEgg, "rawEgg");
        GameRegistry.registerItem(rawScrambledEgg, "rawScrambledEgg");
        GameRegistry.registerItem(scrambledEgg, "scrambledEgg");
        GameRegistry.registerItem(softBoiledEgg, "softBoiledEgg");
        GameRegistry.registerItem(unpeeledHardBoiledEgg, "unpeeledHardBoiledEgg");
        GameRegistry.registerItem(unpeeledSoftBoiledEgg, "unpeeledSoftBoiledEgg");
        GameRegistry.registerItem(diamondGoldenEgg, "diamondGoldenEgg");
        GameRegistry.registerItem(emeraldGoldenEgg, "emeraldGoldenEgg");
    }
}

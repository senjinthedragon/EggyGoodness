package org.hatchling.eggygoodness.init;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.item.crafting.CraftingManager;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import org.hatchling.eggygoodness.reference.Reference;
import org.hatchling.eggygoodness.utility.RecipeFinder;

public class Recipes
{
    public static void init()
    {
        // Oredictionary Registrations
//TODO Figure out / balance gold dust to nugget conversion
        OreDictionary.registerOre("nuggetGold", ModItems.goldDust);
        OreDictionary.registerOre("dustGold", ModItems.goldDust);

        // Smelting Recipes
        GameRegistry.addSmelting(ModItems.rawEgg, new ItemStack(ModItems.friedEgg), 0.1f);
        GameRegistry.addSmelting(ModItems.rawDoubleYolkEgg, new ItemStack(ModItems.friedDoubleYolkEgg), 0.1f);
        GameRegistry.addSmelting(Items.egg, new ItemStack(ModItems.unpeeledSoftBoiledEgg), 0.1f);
        GameRegistry.addSmelting(ModItems.goldenEgg, new ItemStack(ModItems.unpeeledSoftBoiledGoldenEgg), 0.1f);
        GameRegistry.addSmelting(ModItems.diamondGoldenEgg, new ItemStack(ModItems.unpeeledSoftBoiledDiamondGoldenEgg), 0.1f);
        GameRegistry.addSmelting(ModItems.emeraldGoldenEgg, new ItemStack(ModItems.unpeeledSoftBoiledEmeraldGoldenEgg), 0.1f);
        GameRegistry.addSmelting(ModItems.unpeeledSoftBoiledEgg, new ItemStack(ModItems.unpeeledHardBoiledEgg), 0.1f);
        GameRegistry.addSmelting(ModItems.unpeeledSoftBoiledGoldenEgg, new ItemStack(ModItems.unpeeledHardBoiledGoldenEgg), 0.1f);
        GameRegistry.addSmelting(ModItems.unpeeledSoftBoiledDiamondGoldenEgg, new ItemStack(ModItems.unpeeledHardBoiledDiamondGoldenEgg), 0.1f);
        GameRegistry.addSmelting(ModItems.unpeeledSoftBoiledEmeraldGoldenEgg, new ItemStack(ModItems.unpeeledHardBoiledEmeraldGoldenEgg), 0.1f);
        GameRegistry.addSmelting(ModItems.rawScrambledEgg, new ItemStack(ModItems.scrambledEgg), 0.1f);
        GameRegistry.addSmelting(ModItems.goldDust, new ItemStack(Items.gold_nugget), 0.1f);

        // Shapeless Recipes
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.rawScrambledEgg), new ItemStack(ModItems.rawEgg), new ItemStack(Items.bowl));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.rawScrambledEgg), new ItemStack(ModItems.rawDoubleYolkEgg), new ItemStack(Items.bowl));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.eggSandwich), new ItemStack(ModItems.hardBoiledEgg), new ItemStack(Items.bread));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.gold_ingot), "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold", "nuggetGold"));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.eggnog), new ItemStack(Items.milk_bucket), new ItemStack(Items.sugar), new ItemStack(ModItems.rawEgg));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.eggnog), new ItemStack(Items.milk_bucket), new ItemStack(Items.sugar), new ItemStack(ModItems.rawDoubleYolkEgg));

        // Shaped Recipes
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.diamondGoldenEgg), "ABA", "BCB", "ABA", 'A', "ingotGold", 'B', "gemDiamond", 'C', new ItemStack(Items.egg)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.diamondGoldenEgg), "BAB", "ACA", "BAB", 'A', "ingotGold", 'B', "gemDiamond", 'C', new ItemStack(Items.egg)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.emeraldGoldenEgg), "ABA", "BCB", "ABA", 'A', "ingotGold", 'B', "gemEmerald", 'C', new ItemStack(Items.egg)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.emeraldGoldenEgg), "BAB", "ACA", "BAB", 'A', "ingotGold", 'B', "gemEmerald", 'C', new ItemStack(Items.egg)));

        if(Reference.CONFIG_OVERWRITE_VANILLA_RECIPES) {
            // Remove and replace vanilla cake recipe to include our raw egg
            removeRecipe(Items.cake);
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.cake), "AAA", "BEB", "CCC", 'A', new ItemStack(Items.milk_bucket), 'B', new ItemStack(Items.sugar), 'C', "cropWheat", 'E', new ItemStack(ModItems.rawEgg)));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.cake), "AAA", "BEB", "CCC", 'A', new ItemStack(Items.milk_bucket), 'B', new ItemStack(Items.sugar), 'C', "cropWheat", 'E', new ItemStack(ModItems.rawDoubleYolkEgg)));

            // Remove and replace vanilla pumpkin pie recipe to include our raw egg
            removeRecipe(Items.pumpkin_pie);
            GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_pie), new ItemStack(Blocks.pumpkin), new ItemStack(Items.sugar), new ItemStack(ModItems.rawEgg));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_pie), new ItemStack(Blocks.pumpkin), new ItemStack(Items.sugar), new ItemStack(ModItems.rawDoubleYolkEgg));
        }
        else
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.cake), "AAA", "BEB", "CCC", 'A', new ItemStack(Items.milk_bucket), 'B', new ItemStack(Items.sugar), 'C', "cropWheat", 'E', new ItemStack(ModItems.goldenEgg)));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.cake), "AAA", "BEB", "CCC", 'A', new ItemStack(Items.milk_bucket), 'B', new ItemStack(Items.sugar), 'C', "cropWheat", 'E', new ItemStack(ModItems.diamondGoldenEgg)));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.cake), "AAA", "BEB", "CCC", 'A', new ItemStack(Items.milk_bucket), 'B', new ItemStack(Items.sugar), 'C', "cropWheat", 'E', new ItemStack(ModItems.emeraldGoldenEgg)));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_pie), new ItemStack(Blocks.pumpkin), new ItemStack(Items.sugar), new ItemStack(ModItems.goldenEgg));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_pie), new ItemStack(Blocks.pumpkin), new ItemStack(Items.sugar), new ItemStack(ModItems.diamondGoldenEgg));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_pie), new ItemStack(Blocks.pumpkin), new ItemStack(Items.sugar), new ItemStack(ModItems.emeraldGoldenEgg));
        }
    }

    public static void removeRecipe(Item item)
    {
//TODO Does this need to be looped?
        CraftingManager.getInstance().getRecipeList().remove(RecipeFinder.find(item));
    }
}

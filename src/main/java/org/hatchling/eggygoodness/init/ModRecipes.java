package org.hatchling.eggygoodness.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import org.hatchling.eggygoodness.reference.Reference;
import org.hatchling.eggygoodness.utility.RecipeFinder;

public class ModRecipes
{
    public static void init()
    {
        // Smelting Recipes
        GameRegistry.addSmelting(ModItems.rawEgg, new ItemStack(ModItems.friedEgg), 0.1f);
        GameRegistry.addSmelting(ModItems.rawDoubleYolkEgg, new ItemStack(ModItems.friedDoubleYolkEgg), 0.1f);
        GameRegistry.addSmelting(Items.egg, new ItemStack(ModItems.unpeeledSoftBoiledEgg), 0.1f);
        GameRegistry.addSmelting(ModItems.unpeeledSoftBoiledEgg, new ItemStack(ModItems.unpeeledHardBoiledEgg), 0.1f);
        GameRegistry.addSmelting(ModItems.rawScrambledEgg, new ItemStack(ModItems.scrambledEgg), 0.1f);

        // Shapeless Recipes
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.rawScrambledEgg), new ItemStack(ModItems.rawEgg), new ItemStack(Items.bowl));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.rawScrambledEgg), new ItemStack(ModItems.rawDoubleYolkEgg), new ItemStack(Items.bowl));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.eggSandwich), new ItemStack(ModItems.hardBoiledEgg), new ItemStack(Items.bread));

        // Shaped Recipes
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.diamondGoldenEgg), "ABA", "BCB", "ABA", 'A', Items.gold_ingot, 'B', Items.diamond, 'C', Items.egg);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.diamondGoldenEgg), "BAB", "ACA", "BAB", 'A', Items.gold_ingot, 'B', Items.diamond, 'C', Items.egg);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.emeraldGoldenEgg), "ABA", "BCB", "ABA", 'A', Items.gold_ingot, 'B', Items.emerald, 'C', Items.egg);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.emeraldGoldenEgg), "BAB", "ACA", "BAB", 'A', Items.gold_ingot, 'B', Items.emerald, 'C', Items.egg);

        if(Reference.CONFIG_OVERWRITE_VANILLA_RECIPES) {
            // Remove and replace vanilla cake recipe to include our raw egg
            removeRecipe(Items.cake);
            GameRegistry.addShapedRecipe(new ItemStack(Items.cake), "AAA", "BEB", "CCC", 'A', Items.milk_bucket, 'B', Items.sugar, 'C', Items.wheat, 'E', ModItems.rawEgg);
            GameRegistry.addShapedRecipe(new ItemStack(Items.cake), "AAA", "BEB", "CCC", 'A', Items.milk_bucket, 'B', Items.sugar, 'C', Items.wheat, 'E', ModItems.rawDoubleYolkEgg);

            // Remove and replace vanilla pumpkin pie recipe to include our raw egg
            removeRecipe(Items.pumpkin_pie);
            GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_pie), Blocks.pumpkin, Items.sugar, ModItems.rawEgg);
            GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_pie), Blocks.pumpkin, Items.sugar, ModItems.rawDoubleYolkEgg);
        }
    }

    public static void removeRecipe(Item item)
    {
        CraftingManager.getInstance().getRecipeList().remove(RecipeFinder.find(item));
    }
}

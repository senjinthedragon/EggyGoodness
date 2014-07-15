package org.hatchling.eggygoodness.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import org.hatchling.eggygoodness.utility.RecipeFinder;

public class ModRecipes
{
    public static void init()
    {
        GameRegistry.addSmelting(ModItems.rawEgg, new ItemStack(ModItems.friedEgg), 0.1f);
        GameRegistry.addSmelting(Items.egg, new ItemStack(ModItems.unpeeledSoftBoiledEgg), 0.1f);
        GameRegistry.addSmelting(ModItems.unpeeledSoftBoiledEgg, new ItemStack(ModItems.unpeeledHardBoiledEgg), 0.1f);
        GameRegistry.addSmelting(ModItems.rawScrambledEgg, new ItemStack(ModItems.scrambledEgg), 0.1f);

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.rawScrambledEgg), new ItemStack(ModItems.rawEgg), new ItemStack(Items.bowl));

        CraftingManager.getInstance().getRecipeList().remove(RecipeFinder.find(Items.cake));
        GameRegistry.addShapedRecipe(new ItemStack(Items.cake, 1), "AAA", "BEB", "CCC", 'A', Items.milk_bucket, 'B', Items.sugar, 'C', Items.wheat, 'E', ModItems.rawEgg);

        CraftingManager.getInstance().getRecipeList().remove(RecipeFinder.find(Items.pumpkin_pie));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.pumpkin_pie), Blocks.pumpkin, Items.sugar, ModItems.rawEgg);
    }
}

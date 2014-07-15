package org.hatchling.eggygoodness.utility;

import net.minecraft.item.Item;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class RecipeFinder {
    public static int find(Item item)
    {
        IRecipe recipe = null;

        for(int i = 0; i < CraftingManager.getInstance().getRecipeList().size(); i++)
        {
            recipe = (IRecipe) CraftingManager.getInstance().getRecipeList().get(i);
            if(recipe != null && recipe.getRecipeOutput() != null && recipe.getRecipeOutput().getItem() == item)
            {
                return i;
            }
        }
        return 0;
    }
}

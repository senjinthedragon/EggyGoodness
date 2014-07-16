package org.hatchling.eggygoodness.utility;

import net.minecraft.item.Item;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.ListIterator;

public class RecipeFinder {
    // Looks through the registered recipe list for the first recipe that has 'item' as crafting-result and returns the position in the recipe array or 0 when not found.
    public static int find(Item item)
    {
        IRecipe recipe = null;
        ListIterator it = CraftingManager.getInstance().getRecipeList().listIterator(0);

        while(it.hasNext())
        {
            recipe = (IRecipe) it.next();
            if(recipe.getRecipeOutput() != null && recipe.getRecipeOutput().getItem() == item)
            {
                return it.previousIndex();
            }
        }
        return 0;
    }
}

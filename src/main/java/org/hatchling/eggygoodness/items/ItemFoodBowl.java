package org.hatchling.eggygoodness.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFoodBowl extends ItemFood
{
    public ItemFoodBowl(int p_i45330_1_)
    {
        super(p_i45330_1_, true);
    }

    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        if(!p_77654_3_.inventory.addItemStackToInventory(new ItemStack(Items.bowl))) p_77654_3_.entityDropItem(new ItemStack(Items.bowl), p_77654_3_.getEyeHeight());
        return super.onEaten(p_77654_1_, p_77654_2_, p_77654_3_);
    }
}

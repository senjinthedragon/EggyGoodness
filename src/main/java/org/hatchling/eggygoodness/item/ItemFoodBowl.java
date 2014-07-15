package org.hatchling.eggygoodness.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFoodBowl extends ItemFoodEggyGoodness
{
    public ItemFoodBowl(int healAmount, float saturationModifier, boolean isWolfsFavouriteMeat)
    {
        super(healAmount, saturationModifier, isWolfsFavouriteMeat);
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        if(!p_77654_3_.inventory.addItemStackToInventory(new ItemStack(Items.bowl))) p_77654_3_.entityDropItem(new ItemStack(Items.bowl), p_77654_3_.getEyeHeight());
        return super.onEaten(p_77654_1_, p_77654_2_, p_77654_3_);
    }
}

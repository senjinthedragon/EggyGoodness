package org.hatchling.eggygoodness.item;

import net.minecraft.world.World;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

public class ItemFoodBowl extends ItemFoodEggyGoodness
{
    public ItemFoodBowl(int healAmount, float saturationModifier, boolean isWolfsFavouriteMeat)
    {
        super(healAmount, saturationModifier, isWolfsFavouriteMeat);
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
    {
        if(!player.inventory.addItemStackToInventory(new ItemStack(Items.bowl)))
        {
            if(!world.isRemote) player.entityDropItem(new ItemStack(Items.bowl), player.getEyeHeight());
        }
        return super.onEaten(itemStack, world, player);
    }
}

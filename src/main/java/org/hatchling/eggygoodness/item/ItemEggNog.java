package org.hatchling.eggygoodness.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEggnog extends ItemFoodEggyGoodness
{
    public ItemEggnog()
    {
        super(3, 0.6F, true);
        this.setUnlocalizedName("eggnog");
    }

    @Override
    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player)
    {
        if(!player.inventory.addItemStackToInventory(new ItemStack(Items.bucket)))
        {
            if(!world.isRemote) player.entityDropItem(new ItemStack(Items.bucket), player.getEyeHeight());
        }
        return super.onEaten(itemStack, world, player);
    }
}

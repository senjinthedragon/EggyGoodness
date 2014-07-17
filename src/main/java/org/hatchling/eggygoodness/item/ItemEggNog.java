package org.hatchling.eggygoodness.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemEggnog extends ItemFoodEggyGoodness
{
    public ItemEggnog()
    {
        super(4, 0.3F, true);
        this.setUnlocalizedName("eggnog");
    }

    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player)
    {
        player.addPotionEffect(new PotionEffect(Potion.confusion.id, 300, 1));

        super.onFoodEaten(itemStack, world, player);
    }
}

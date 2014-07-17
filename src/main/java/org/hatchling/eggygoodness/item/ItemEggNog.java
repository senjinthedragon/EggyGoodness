package org.hatchling.eggygoodness.item;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

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

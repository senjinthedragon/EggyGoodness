package org.hatchling.eggygoodness.item;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemRawEgg extends ItemFoodEggyGoodness
{
    public ItemRawEgg()
    {
        super(1, 0.1F, true);
        this.setUnlocalizedName("rawEgg");
    }

    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player)
    {
        player.addPotionEffect(new PotionEffect(Potion.poison.id, 80, 1));

        super.onFoodEaten(itemStack, world, player);
    }
}

package org.hatchling.eggygoodness.item;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemRawDoubleYolkEgg extends ItemFoodEggyGoodness
{
    public ItemRawDoubleYolkEgg()
    {
        super(2, 0.4F, true);
        this.setUnlocalizedName("rawDoubleYolkEgg");
    }

    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player)
    {
        player.addPotionEffect(new PotionEffect(Potion.poison.id, 80, 1));

        super.onFoodEaten(itemStack, world, player);
    }
}

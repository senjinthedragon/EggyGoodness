package org.hatchling.eggygoodness.item;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemRawScrambledEgg extends ItemFoodBowl
{
    public ItemRawScrambledEgg()
    {
        super(3, 0.1F, true);
        this.setUnlocalizedName("rawScrambledEgg");
    }

    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player)
    {
        player.addPotionEffect(new PotionEffect(Potion.poison.id, 80, 1));

        super.onFoodEaten(itemStack, world, player);
    }
}

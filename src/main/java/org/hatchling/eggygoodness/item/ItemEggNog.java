package org.hatchling.eggygoodness.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEggnog extends ItemFoodEggyGoodness
{
    public ItemEggnog()
    {
        super(4, 0.3F, true);
        this.setUnlocalizedName("eggnog");
    }
}

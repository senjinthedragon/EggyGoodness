package org.hatchling.eggygoodness.item;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import org.hatchling.eggygoodness.entity.EntityGoldenEgg;

public class ItemGoldenEgg extends ItemEggyGoodness
{
    public ItemGoldenEgg()
    {
        super();
        this.setUnlocalizedName("goldenEgg");
        this.setMaxStackSize(16);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        if (!p_77659_3_.capabilities.isCreativeMode)
        {
            --p_77659_1_.stackSize;
        }

        p_77659_2_.playSoundAtEntity(p_77659_3_, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!p_77659_2_.isRemote)
        {
            p_77659_2_.spawnEntityInWorld(new EntityGoldenEgg(p_77659_2_, p_77659_3_));
        }

        return p_77659_1_;
    }
}

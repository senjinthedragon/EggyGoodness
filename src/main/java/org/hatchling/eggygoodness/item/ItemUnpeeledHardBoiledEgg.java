package org.hatchling.eggygoodness.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class ItemUnpeeledHardBoiledEgg extends ItemEggyGoodness
{
    public ItemUnpeeledHardBoiledEgg()
    {
        super();
        this.setUnlocalizedName("unpeeledHardBoiledEgg");
        this.setMaxStackSize(16);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("egg");
    }
}

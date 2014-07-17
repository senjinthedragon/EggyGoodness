package org.hatchling.eggygoodness.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemUnpeeledSoftBoiledEgg extends ItemEggyGoodness
{
    public ItemUnpeeledSoftBoiledEgg()
    {
        super();
        this.setUnlocalizedName("unpeeledSoftBoiledEgg");
        this.setMaxStackSize(16);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon("egg");
    }
}

package org.hatchling.eggygoodness.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;

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

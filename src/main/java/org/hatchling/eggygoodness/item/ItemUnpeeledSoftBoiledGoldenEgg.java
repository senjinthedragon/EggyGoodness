package org.hatchling.eggygoodness.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import org.hatchling.eggygoodness.reference.Reference;

public class ItemUnpeeledSoftBoiledGoldenEgg extends ItemEggyGoodness
{
    public ItemUnpeeledSoftBoiledGoldenEgg()
    {
        super();
        this.setUnlocalizedName("unpeeledSoftBoiledGoldenEgg");
        this.setMaxStackSize(16);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "goldenEgg");
    }
}

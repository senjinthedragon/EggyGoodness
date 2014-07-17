package org.hatchling.eggygoodness.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import org.hatchling.eggygoodness.reference.Reference;

public class ItemUnpeeledHardBoiledGoldenEgg extends ItemEggyGoodness
{
    public ItemUnpeeledHardBoiledGoldenEgg()
    {
        super();
        this.setUnlocalizedName("unpeeledHardBoiledGoldenEgg");
        this.setMaxStackSize(16);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "goldenEgg");
    }
}

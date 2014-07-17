package org.hatchling.eggygoodness.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import org.hatchling.eggygoodness.reference.Reference;

public class ItemUnpeeledHardBoiledDiamondGoldenEgg extends ItemEggyGoodness
{
    public ItemUnpeeledHardBoiledDiamondGoldenEgg()
    {
        super();
        this.setUnlocalizedName("unpeeledHardBoiledDiamondGoldenEgg");
        this.setMaxStackSize(16);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "diamondGoldenEgg");
    }
}

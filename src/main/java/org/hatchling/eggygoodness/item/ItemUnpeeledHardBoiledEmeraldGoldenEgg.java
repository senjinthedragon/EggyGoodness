package org.hatchling.eggygoodness.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.hatchling.eggygoodness.reference.Reference;

public class ItemUnpeeledHardBoiledEmeraldGoldenEgg extends ItemEggyGoodness
{
    public ItemUnpeeledHardBoiledEmeraldGoldenEgg()
    {
        super();
        this.setUnlocalizedName("unpeeledHardBoiledEmeraldGoldenEgg");
        this.setMaxStackSize(16);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "emeraldGoldenEgg");
    }
}

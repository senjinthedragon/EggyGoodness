package org.hatchling.eggygoodness.item;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.hatchling.eggygoodness.reference.Reference;
import org.hatchling.eggygoodness.creativetab.CreativeTabEggyGoodness;

public class ItemFoodEggyGoodness extends ItemFood
{
    public ItemFoodEggyGoodness(int healAmount, float saturationModifier, boolean isWolfsFavouriteMeat)
    {
        super(healAmount, saturationModifier, isWolfsFavouriteMeat);
        this.setCreativeTab(CreativeTabEggyGoodness.EggyGoodness_TAB);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}

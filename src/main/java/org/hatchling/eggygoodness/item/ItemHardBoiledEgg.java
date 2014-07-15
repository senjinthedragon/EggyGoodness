package org.hatchling.eggygoodness.item;

public class ItemHardBoiledEgg extends ItemFoodEggyGoodness
{
    public ItemHardBoiledEgg()
    {
        super(5, 0.6f, true);
        this.setUnlocalizedName("hardBoiledEgg");
        this.setMaxStackSize(16);
    }
}

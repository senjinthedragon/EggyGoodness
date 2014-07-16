package org.hatchling.eggygoodness.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import org.hatchling.eggygoodness.init.ModItems;
import org.hatchling.eggygoodness.reference.Reference;

public class CreativeTabEggyGoodness
{
    public static final CreativeTabs EggyGoodness_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.friedEgg;
        }
    };
}

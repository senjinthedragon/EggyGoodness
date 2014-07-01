package org.hatchling.eggygoodness.reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class Reference
{
    public static final String MOD_ID = "EggyGoodness";
    public static final String MOD_NAME = "Eggy Goodness";
    public static final String VERSION = "1.7.10-1.1";
    public static final String SERVER_PROXY_CLASS = "org.hatchling.eggygoodness.proxy.ServerProxy";
    public static final String CLIENT_PROXY_CLASS = "org.hatchling.eggygoodness.proxy.ClientProxy";

    public static ItemFood rawEgg;
    public static ItemFood bakedEgg;
    public static Item unpeeledSoftBoiledEgg;
    public static ItemFood softBoiledEgg;
    public static Item unpeeledHardBoiledEgg;
    public static ItemFood hardBoiledEgg;
    public static ItemFood rawScrambledEgg;
    public static ItemFood scrambledEgg;
}

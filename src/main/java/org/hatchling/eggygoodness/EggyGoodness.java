package org.hatchling.eggygoodness;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import org.hatchling.eggygoodness.proxy.IProxy;
import org.hatchling.eggygoodness.reference.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class EggyGoodness
{
    @Mod.Instance(Reference.MOD_ID)
    public static EggyGoodness instance;

    @SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    public static ItemFood bakedEgg;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        bakedEgg = (ItemFood) new ItemFood(4, 0.3f, false).setUnlocalizedName("bakedEgg").setTextureName("eggygoodness:bakedEgg");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.registerItem(bakedEgg, "eggygoodness_bakedEgg");
        FurnaceRecipes.smelting().func_151396_a(Items.egg, new ItemStack(bakedEgg), 0.1f);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}

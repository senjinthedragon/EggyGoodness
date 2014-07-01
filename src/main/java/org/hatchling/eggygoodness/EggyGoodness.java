package org.hatchling.eggygoodness;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import org.hatchling.eggygoodness.eventhook.EventHookContainer;
import org.hatchling.eggygoodness.proxy.IProxy;
import org.hatchling.eggygoodness.reference.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class EggyGoodness
{
    @Mod.Instance(Reference.MOD_ID)
    public static EggyGoodness instance;

    @SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        Reference.bakedEgg = (ItemFood) new ItemFood(4, 0.3f, false).setUnlocalizedName("bakedEgg").setTextureName("eggygoodness:bakedEgg");
        Reference.rawEgg = (ItemFood) new ItemFood(3, 0.2f, false).setUnlocalizedName("rawEgg").setTextureName("eggygoodness:rawEgg");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.registerItem(Reference.bakedEgg, "eggygoodness_bakedEgg");
        GameRegistry.registerItem(Reference.rawEgg, "eggygoodness_rawEgg");
        FurnaceRecipes.smelting().func_151396_a(Reference.rawEgg, new ItemStack(Reference.bakedEgg), 0.1f);
        MinecraftForge.EVENT_BUS.register(new EventHookContainer());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}

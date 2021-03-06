package org.hatchling.eggygoodness;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import org.hatchling.eggygoodness.handler.UpdateHandler;
import org.hatchling.eggygoodness.reference.Reference;
import org.hatchling.eggygoodness.proxy.IProxy;
import org.hatchling.eggygoodness.init.ModEntity;
import org.hatchling.eggygoodness.init.ModItems;
import org.hatchling.eggygoodness.init.Recipes;
import org.hatchling.eggygoodness.handler.ConfigurationHandler;
import org.hatchling.eggygoodness.eventhook.EventHookContainer;
import org.hatchling.eggygoodness.utility.LogHelper;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class EggyGoodness
{
    @Mod.Instance(Reference.MOD_ID)
    public static EggyGoodness instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        FMLCommonHandler.instance().bus().register(new UpdateHandler());
        ModItems.init();
        proxy.registerRenderThings();
        LogHelper.info("Pre Initialization Complete!");
    }
//TODO Figure out if I want initialization log messages or not. What do other mods do?
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Recipes.init();
        ModEntity.init(instance);
        MinecraftForge.EVENT_BUS.register(new EventHookContainer());
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete!");

//        for (String oreName : OreDictionary.getOreNames())
//        {
//            LogHelper.info(oreName);
//        }
    }
}

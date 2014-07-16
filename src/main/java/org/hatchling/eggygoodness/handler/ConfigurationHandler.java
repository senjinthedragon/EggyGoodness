package org.hatchling.eggygoodness.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import org.hatchling.eggygoodness.reference.Reference;
import java.io.File;

public class ConfigurationHandler {
    public static Configuration configuration;

    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        Reference.CONFIG_OVERWRITE_VANILLA_RECIPES = configuration.getBoolean("overwriteVanillaRecipes", Configuration.CATEGORY_GENERAL, true, "Replace the vanilla Cake and Pumpkin Pie recipes with versions that use Raw Egg");

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
}

package org.hatchling.eggygoodness;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
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
        Reference.rawEgg = (ItemFood) new ItemFood(3, 0.2f, false).setUnlocalizedName("rawEgg").setTextureName("eggygoodness:rawEgg");
        Reference.bakedEgg = (ItemFood) new ItemFood(4, 0.3f, false).setUnlocalizedName("bakedEgg").setTextureName("eggygoodness:bakedEgg");
        Reference.unpeeledSoftBoiledEgg = (Item) new Item().setUnlocalizedName("unpeeledSoftBoiledEgg").setTextureName("egg").setCreativeTab(CreativeTabs.tabFood);
        Reference.softBoiledEgg = (ItemFood) new ItemFood(4, 0.3f, false).setUnlocalizedName("softBoiledEgg").setTextureName("eggygoodness:boiledEgg");
        Reference.unpeeledHardBoiledEgg = (Item) new Item().setUnlocalizedName("unpeeledHardBoiledEgg").setTextureName("egg").setCreativeTab(CreativeTabs.tabFood);
        Reference.hardBoiledEgg = (ItemFood) new ItemFood(4, 0.3f, false).setUnlocalizedName("hardBoiledEgg").setTextureName("eggygoodness:boiledEgg");
        Reference.rawScrambledEgg = (ItemFood) new ItemFood(3, 0.2f, false).setUnlocalizedName("rawScrambledEgg").setTextureName("eggygoodness:rawScrambledEgg");
        Reference.scrambledEgg = (ItemFood) new ItemFood(4, 0.3f, false).setUnlocalizedName("scrambledEgg").setTextureName("eggygoodness:scrambledEgg");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.registerItem(Reference.rawEgg, "eggygoodness_rawEgg");
        GameRegistry.registerItem(Reference.bakedEgg, "eggygoodness_bakedEgg");
        GameRegistry.registerItem(Reference.unpeeledSoftBoiledEgg, "eggygoodness_unpeeledSoftBoiledEgg");
        GameRegistry.registerItem(Reference.softBoiledEgg, "eggygoodness_softBoiledEgg");
        GameRegistry.registerItem(Reference.unpeeledHardBoiledEgg, "eggygoodness_unpeeledHardBoiledEgg");
        GameRegistry.registerItem(Reference.hardBoiledEgg, "eggygoodness_hardBoiledEgg");
        GameRegistry.registerItem(Reference.rawScrambledEgg, "eggygoodness_rawScrambledEgg");
        GameRegistry.registerItem(Reference.scrambledEgg, "eggygoodness_scrambledEgg");

        FurnaceRecipes.smelting().func_151396_a(Reference.rawEgg, new ItemStack(Reference.bakedEgg), 0.1f);
        FurnaceRecipes.smelting().func_151396_a(Items.egg, new ItemStack(Reference.unpeeledSoftBoiledEgg), 0.1f);
        FurnaceRecipes.smelting().func_151396_a(Reference.unpeeledSoftBoiledEgg, new ItemStack(Reference.unpeeledHardBoiledEgg), 0.1f);
        FurnaceRecipes.smelting().func_151396_a(Reference.rawScrambledEgg, new ItemStack(Reference.scrambledEgg), 0.1f);

        GameRegistry.addShapelessRecipe(new ItemStack(Reference.rawScrambledEgg), new ItemStack(Reference.rawEgg), new ItemStack(Items.bowl));

        MinecraftForge.EVENT_BUS.register(new EventHookContainer());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}

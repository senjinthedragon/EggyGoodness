package org.hatchling.eggygoodness.eventhook;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.hatchling.eggygoodness.init.ModItems;
import org.hatchling.eggygoodness.entity.EntityGoldenChicken;
import org.hatchling.eggygoodness.reference.Reference;

import java.util.Random;

public class EventHookContainer
{
    @SubscribeEvent
    public void playerInteractEvent(PlayerInteractEvent event)
    {
        EntityPlayer player = event.entityPlayer;

        if(event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK)
        {
            if(player.getCurrentEquippedItem() != null && (player.getCurrentEquippedItem().getItem() == Items.egg || player.getCurrentEquippedItem().getItem() == ModItems.unpeeledSoftBoiledEgg || player.getCurrentEquippedItem().getItem() == ModItems.unpeeledHardBoiledEgg))
            {
                ItemStack returnStack = null;
                String soundFX = "";
                ItemStack boneMeal = new ItemStack(Items.dye);
                boneMeal.setItemDamage(15);

                if(player.getCurrentEquippedItem().getItem() == Items.egg)
                {
                    Random rand = new Random();

                    if(rand.nextInt(20) == 0)
                    {
                        returnStack = new ItemStack(ModItems.rawDoubleYolkEgg);
                    }
                    else
                    {
                        returnStack = new ItemStack(ModItems.rawEgg);
                        soundFX = "egg_crack";
                    }
                }
                else if(player.getCurrentEquippedItem().getItem() == ModItems.unpeeledSoftBoiledEgg)
                {
                    returnStack = new ItemStack(ModItems.softBoiledEgg);
                    soundFX = "egg_peel";
                }
                else if(player.getCurrentEquippedItem().getItem() == ModItems.unpeeledHardBoiledEgg)
                {
                    returnStack = new ItemStack(ModItems.hardBoiledEgg);
                    soundFX = "egg_peel";
                }

                if(--player.getCurrentEquippedItem().stackSize == 0)
                {
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                }

                player.getEntityWorld().playSoundEffect(player.posX + 0.5D, player.posY + 0.5D, player.posZ + 0.5D, Reference.MOD_ID.toLowerCase() + ":" + soundFX, 1.0F, player.getEntityWorld().rand.nextFloat() * 0.1F + 0.9F);
                if(!player.inventory.addItemStackToInventory(boneMeal))
                {
                    if(!player.getEntityWorld().isRemote) player.entityDropItem(boneMeal, player.getEyeHeight());
                }
                if(!player.inventory.addItemStackToInventory(returnStack))
                {
                    if(!player.getEntityWorld().isRemote) player.entityDropItem(returnStack, player.getEyeHeight());
                }
                event.setCanceled(true);
            }
            else if(player.getCurrentEquippedItem() != null && (player.getCurrentEquippedItem().getItem() == ModItems.goldenEgg || player.getCurrentEquippedItem().getItem() == ModItems.unpeeledSoftBoiledGoldenEgg || player.getCurrentEquippedItem().getItem() == ModItems.unpeeledHardBoiledGoldenEgg || player.getCurrentEquippedItem().getItem() == ModItems.diamondGoldenEgg || player.getCurrentEquippedItem().getItem() == ModItems.unpeeledSoftBoiledDiamondGoldenEgg || player.getCurrentEquippedItem().getItem() == ModItems.unpeeledHardBoiledDiamondGoldenEgg || player.getCurrentEquippedItem().getItem() == ModItems.emeraldGoldenEgg || player.getCurrentEquippedItem().getItem() == ModItems.unpeeledSoftBoiledEmeraldGoldenEgg || player.getCurrentEquippedItem().getItem() == ModItems.unpeeledHardBoiledEmeraldGoldenEgg))
            {
                ItemStack returnStack = null;
                String soundFX = "";
                ItemStack goldDust = new ItemStack(ModItems.goldDust);

                if(player.getCurrentEquippedItem().getItem() == ModItems.goldenEgg || player.getCurrentEquippedItem().getItem() == ModItems.diamondGoldenEgg || player.getCurrentEquippedItem().getItem() == ModItems.emeraldGoldenEgg)
                {
                    Random rand = new Random();

                    if(rand.nextInt(20) == 0)
                    {
                        returnStack = new ItemStack(ModItems.rawDoubleYolkEgg);
                    }
                    else
                    {
                        returnStack = new ItemStack(ModItems.rawEgg);
                        soundFX = "egg_crack";
                    }
                }
                else if(player.getCurrentEquippedItem().getItem() == ModItems.unpeeledSoftBoiledEgg || player.getCurrentEquippedItem().getItem() == ModItems.unpeeledSoftBoiledDiamondGoldenEgg || player.getCurrentEquippedItem().getItem() == ModItems.unpeeledSoftBoiledEmeraldGoldenEgg)
                {
                    returnStack = new ItemStack(ModItems.softBoiledEgg);
                    soundFX = "egg_peel";
                }
                else if(player.getCurrentEquippedItem().getItem() == ModItems.unpeeledHardBoiledEgg || player.getCurrentEquippedItem().getItem() == ModItems.unpeeledHardBoiledDiamondGoldenEgg || player.getCurrentEquippedItem().getItem() == ModItems.unpeeledHardBoiledEmeraldGoldenEgg)
                {
                    returnStack = new ItemStack(ModItems.hardBoiledEgg);
                    soundFX = "egg_peel";
                }

                if(--player.getCurrentEquippedItem().stackSize == 0)
                {
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                }

                player.getEntityWorld().playSoundEffect(player.posX + 0.5D, player.posY + 0.5D, player.posZ + 0.5D, Reference.MOD_ID.toLowerCase() + ":" + soundFX, 1.0F, player.getEntityWorld().rand.nextFloat() * 0.1F + 0.9F);
                if(!player.inventory.addItemStackToInventory(goldDust))
                {
                    if(!player.getEntityWorld().isRemote) player.entityDropItem(goldDust, player.getEyeHeight());
                }
                if(!player.inventory.addItemStackToInventory(returnStack))
                {
                    if(!player.getEntityWorld().isRemote) player.entityDropItem(returnStack, player.getEyeHeight());
                }
                event.setCanceled(true);
            }
        }
    }
}

package org.hatchling.eggygoodness.eventhook;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.hatchling.eggygoodness.reference.Reference;

public class EventHookContainer
{
/*
    @SubscribeEvent
    public void itemToss(ItemTossEvent event)
    {
        if(event.entityItem.getEntityItem().getItem() == Items.egg) {
            ItemStack boneMeal = new ItemStack(Items.dye, event.entityItem.getEntityItem().stackSize);
            boneMeal.setItemDamage(15);
            event.player.entityDropItem(boneMeal, event.player.getEyeHeight() + 0.5f);
            event.setCanceled(true);
        }
    }
*/
    @SubscribeEvent
    public void playerInteractEvent(PlayerInteractEvent event)
    {
        EntityPlayer player = event.entityPlayer;

        if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Items.egg)
        {
            if(event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK)
            {
                ItemStack boneMeal = new ItemStack(Items.dye);
                boneMeal.setItemDamage(15);
                ItemStack rawEgg = new ItemStack(Reference.rawEgg);

                if(--player.getCurrentEquippedItem().stackSize == 0)
                {
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                }
                player.getEntityWorld().playSoundEffect(player.posX + 0.5D, player.posY + 0.5D, player.posZ + 0.5D, "eggygoodness:egg_crack", 1.0F, player.getEntityWorld().rand.nextFloat() * 0.1F + 0.9F);
                if(!player.inventory.addItemStackToInventory(boneMeal)) player.entityDropItem(boneMeal, player.getEyeHeight());
                if(!player.inventory.addItemStackToInventory(rawEgg)) player.entityDropItem(rawEgg, player.getEyeHeight());
                event.setCanceled(true);
            }
        }
        else if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Reference.unpeeledSoftBoiledEgg)
        {
            if(event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK)
            {
                ItemStack boneMeal = new ItemStack(Items.dye);
                boneMeal.setItemDamage(15);
                ItemStack softBoiledEgg = new ItemStack(Reference.softBoiledEgg);

                if(--player.getCurrentEquippedItem().stackSize == 0)
                {
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                }
                player.getEntityWorld().playSoundEffect(player.posX + 0.5D, player.posY + 0.5D, player.posZ + 0.5D, "eggygoodness:egg_peel", 1.0F, player.getEntityWorld().rand.nextFloat() * 0.1F + 0.9F);
                if(!player.inventory.addItemStackToInventory(boneMeal)) player.entityDropItem(boneMeal, player.getEyeHeight());
                if(!player.inventory.addItemStackToInventory(softBoiledEgg)) player.entityDropItem(softBoiledEgg, player.getEyeHeight());
                event.setCanceled(true);
            }
        }
        else if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Reference.unpeeledHardBoiledEgg)
        {
            if(event.action == PlayerInteractEvent.Action.LEFT_CLICK_BLOCK)
            {
                ItemStack boneMeal = new ItemStack(Items.dye);
                boneMeal.setItemDamage(15);
                ItemStack hardBoiledEgg = new ItemStack(Reference.hardBoiledEgg);

                if(--player.getCurrentEquippedItem().stackSize == 0)
                {
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                }
                player.getEntityWorld().playSoundEffect(player.posX + 0.5D, player.posY + 0.5D, player.posZ + 0.5D, "eggygoodness:egg_peel", 1.0F, player.getEntityWorld().rand.nextFloat() * 0.1F + 0.9F);
                if(!player.inventory.addItemStackToInventory(boneMeal)) player.entityDropItem(boneMeal, player.getEyeHeight());
                if(!player.inventory.addItemStackToInventory(hardBoiledEgg)) player.entityDropItem(hardBoiledEgg, player.getEyeHeight());
                event.setCanceled(true);
            }
        }
    }
}

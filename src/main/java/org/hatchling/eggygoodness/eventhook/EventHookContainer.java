package org.hatchling.eggygoodness.eventhook;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.hatchling.eggygoodness.init.ModItems;

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
                    returnStack = new ItemStack(ModItems.rawEgg);
                    soundFX = "eggygoodness:egg_crack";
                }
                else if(player.getCurrentEquippedItem().getItem() == ModItems.unpeeledSoftBoiledEgg)
                {
                    returnStack = new ItemStack(ModItems.softBoiledEgg);
                    soundFX = "eggygoodness:egg_peel";
                }
                else if(player.getCurrentEquippedItem().getItem() == ModItems.unpeeledHardBoiledEgg)
                {
                    returnStack = new ItemStack(ModItems.hardBoiledEgg);
                    soundFX = "eggygoodness:egg_peel";
                }

                if(--player.getCurrentEquippedItem().stackSize == 0)
                {
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                }

                player.getEntityWorld().playSoundEffect(player.posX + 0.5D, player.posY + 0.5D, player.posZ + 0.5D, soundFX, 1.0F, player.getEntityWorld().rand.nextFloat() * 0.1F + 0.9F);
                if(!player.inventory.addItemStackToInventory(boneMeal)) player.entityDropItem(boneMeal, player.getEyeHeight());
                if(!player.inventory.addItemStackToInventory(returnStack)) player.entityDropItem(returnStack, player.getEyeHeight());
                event.setCanceled(true);
            }
        }
    }
}

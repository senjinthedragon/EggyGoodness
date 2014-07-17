package org.hatchling.eggygoodness.eventhook;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import org.hatchling.eggygoodness.init.ModItems;
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
            if(player.getCurrentEquippedItem() != null)
            {
                Item currentEquippedItem = player.getCurrentEquippedItem().getItem();

                if (currentEquippedItem == Items.egg || currentEquippedItem == ModItems.unpeeledSoftBoiledEgg || currentEquippedItem == ModItems.unpeeledHardBoiledEgg || currentEquippedItem == ModItems.goldenEgg || currentEquippedItem == ModItems.unpeeledSoftBoiledGoldenEgg || currentEquippedItem == ModItems.unpeeledHardBoiledGoldenEgg || currentEquippedItem == ModItems.diamondGoldenEgg || currentEquippedItem == ModItems.unpeeledSoftBoiledDiamondGoldenEgg || currentEquippedItem == ModItems.unpeeledHardBoiledDiamondGoldenEgg || currentEquippedItem == ModItems.emeraldGoldenEgg || currentEquippedItem == ModItems.unpeeledSoftBoiledEmeraldGoldenEgg || currentEquippedItem == ModItems.unpeeledHardBoiledEmeraldGoldenEgg)
                {
                    ItemStack returnStack = null;
                    ItemStack extrasStack = null;
                    String soundFX = "";

                    if (currentEquippedItem == Items.egg || currentEquippedItem == ModItems.goldenEgg || currentEquippedItem == ModItems.diamondGoldenEgg || currentEquippedItem == ModItems.emeraldGoldenEgg)
                    {
                        Random rand = new Random();
                        soundFX = "egg_crack";

                        if(rand.nextInt(20) == 0)
                        {
                            returnStack = new ItemStack(ModItems.rawDoubleYolkEgg);
                        }
                        else
                        {
                            returnStack = new ItemStack(ModItems.rawEgg);
                        }
                    }
                    else
                    {
                        soundFX = "egg_peel";

                        if(currentEquippedItem == ModItems.unpeeledSoftBoiledEgg || currentEquippedItem == ModItems.unpeeledSoftBoiledGoldenEgg || currentEquippedItem == ModItems.unpeeledSoftBoiledDiamondGoldenEgg || currentEquippedItem == ModItems.unpeeledSoftBoiledEmeraldGoldenEgg)
                        {
                            returnStack = new ItemStack(ModItems.softBoiledEgg);
                        }
                        else
                        {
                            returnStack = new ItemStack(ModItems.hardBoiledEgg);
                        }
                    }

                    if (currentEquippedItem == Items.egg || currentEquippedItem == ModItems.unpeeledSoftBoiledEgg || currentEquippedItem == ModItems.unpeeledHardBoiledEgg)
                    {
                        extrasStack = new ItemStack(Items.dye);
                        extrasStack.setItemDamage(15);
                    }
                    else
                    {
                        extrasStack = new ItemStack(ModItems.goldDust);
                    }

                    if(--player.getCurrentEquippedItem().stackSize == 0)
                    {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }

                    if(!player.inventory.addItemStackToInventory(returnStack))
                    {
                        if(!player.getEntityWorld().isRemote) player.entityDropItem(returnStack, player.getEyeHeight());
                    }

                    if(!player.inventory.addItemStackToInventory(extrasStack))
                    {
                        if(!player.getEntityWorld().isRemote) player.entityDropItem(extrasStack, player.getEyeHeight());
                    }

                    player.getEntityWorld().playSoundEffect(player.posX + 0.5D, player.posY + 0.5D, player.posZ + 0.5D, Reference.MOD_ID.toLowerCase() + ":" + soundFX, 1.0F, player.getEntityWorld().rand.nextFloat() * 0.1F + 0.9F);

                    event.setCanceled(true);
                }
            }
        }
    }
}

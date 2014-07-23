package org.hatchling.eggygoodness.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.util.ChatComponentText;
import org.hatchling.eggygoodness.utility.LogHelper;

public class UpdateHandler {
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
    {
        String message = "EggyGoodness - Test Message";
        if(!event.player.getEntityWorld().isRemote) {
            event.player.addChatMessage(new ChatComponentText(message));
        }
        LogHelper.info(message);
    }
}

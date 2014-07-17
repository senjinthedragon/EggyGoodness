package org.hatchling.eggygoodness.proxy;

import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.entity.RenderSnowball;
import cpw.mods.fml.client.registry.RenderingRegistry;
import org.hatchling.eggygoodness.init.ModItems;
import org.hatchling.eggygoodness.entity.EntityGoldenEgg;
import org.hatchling.eggygoodness.entity.EntityDiamondGoldenEgg;
import org.hatchling.eggygoodness.entity.EntityEmeraldGoldenEgg;
import org.hatchling.eggygoodness.entity.EntityGoldenChicken;
import org.hatchling.eggygoodness.render.RenderGoldenChicken;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerRenderThings()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityGoldenChicken.class, new RenderGoldenChicken(new ModelChicken(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGoldenEgg.class, new RenderSnowball(ModItems.goldenEgg));
        RenderingRegistry.registerEntityRenderingHandler(EntityDiamondGoldenEgg.class, new RenderSnowball(ModItems.diamondGoldenEgg));
        RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldGoldenEgg.class, new RenderSnowball(ModItems.emeraldGoldenEgg));
    }
}

package org.hatchling.eggygoodness.init;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import org.hatchling.eggygoodness.EggyGoodness;
import org.hatchling.eggygoodness.entity.EntityDiamondGoldenEgg;
import org.hatchling.eggygoodness.entity.EntityEmeraldGoldenEgg;
import org.hatchling.eggygoodness.entity.EntityGoldenChicken;
import org.hatchling.eggygoodness.entity.EntityGoldenEgg;
import org.hatchling.eggygoodness.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModEntity {
    public static void init(EggyGoodness instance)
    {
        EntityRegistry.registerModEntity(EntityGoldenChicken.class, "goldenChicken", 0, instance, 80, 1, true);
        EntityRegistry.registerModEntity(EntityGoldenEgg.class, "goldenEgg", 1, instance, 64, 10, true);
        EntityRegistry.registerModEntity(EntityDiamondGoldenEgg.class, "diamondGoldenEgg", 2, instance, 64, 10, true);
        EntityRegistry.registerModEntity(EntityEmeraldGoldenEgg.class, "emeraldGoldenEgg", 3, instance, 64, 10, true);
    }
}

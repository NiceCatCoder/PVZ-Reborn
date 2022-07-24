package com.xstudio.pvzreborn;

import com.xstudio.pvzreborn.block.BlockManager;
import com.xstudio.pvzreborn.entity.EntityManager;
import com.xstudio.pvzreborn.item.ItemManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PVZReborn.MOD_ID)
public class PVZReborn {
    public static final String MOD_ID = "pvzreborn";

    public PVZReborn() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemManager.init(bus);
        BlockManager.init(bus);
        EntityManager.init(bus);
    }
}

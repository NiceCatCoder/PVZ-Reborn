package com.xstudio.pvzreborn;

import com.xstudio.pvzreborn.item.ManagerItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PVZReborn.MOD_ID)
public class PVZReborn {
    public static final String MOD_ID = "pvzreborn";

    public PVZReborn() throws Exception {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ManagerItem.init(bus);
//        ManagerBlock.init(bus);
//        ManagerEntity.init(bus);
    }
    
}

package com.xstudio.pvzreborn.item;

import com.xstudio.pvzreborn.PVZReborn;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;

public class ItemManager {
    
    public static final HashMap<Class<? extends Item>, RegistryObject<Item>> ITEMS = new HashMap<>();
    private static final DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, PVZReborn.MOD_ID);

    public static void init(IEventBus bus) {
        ITEM_REGISTER.register(bus);
    }
}

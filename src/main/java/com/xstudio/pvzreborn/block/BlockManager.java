package com.xstudio.pvzreborn.block;

import com.xstudio.pvzreborn.PVZReborn;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;

public class BlockManager {
    public static final HashMap<Class<? extends Block>, RegistryObject<Block>> BLOCKS = new HashMap<>();
    public static final HashMap<Class<? extends Block>, RegistryObject<Item>> BLOCK_ITEMS = new HashMap<>();
    private static final DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, PVZReborn.MOD_ID);
    private static final DeferredRegister<Item> BLOCK_ITEM_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, PVZReborn.MOD_ID);

    public static void init(IEventBus bus) {
        BLOCK_REGISTER.register(bus);
    }
}

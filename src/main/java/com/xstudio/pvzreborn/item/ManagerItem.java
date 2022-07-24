package com.xstudio.pvzreborn.item;

import com.xstudio.pvzreborn.PVZReborn;
import com.xstudio.pvzreborn.utils.Utils;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.function.Supplier;

public class ManagerItem {

    public static final HashMap<String, RegistryObject<Item>> ITEMS = new HashMap<>();
    private static final DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, PVZReborn.MOD_ID);

    /**
     * @author Bread_NiceCat
     */
    public static void init(IEventBus bus) {
        ITEM_REGISTER.register(bus);
        //以下注册物品

        String[] commonItemList = {"overloaded_redstone"};
        for (String name : commonItemList) {
            registryItem(name, () -> new CommonItem() {
            });
        }
    }

    /**
     * @author Bread_NiceCat
     */
    public static void registryItem(String name, Supplier<? extends Item> sup) {
        ITEMS.put(name, ITEM_REGISTER.register(Utils.prefixPoint(name), sup));
    }

}

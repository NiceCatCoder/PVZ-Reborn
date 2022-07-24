package com.xstudio.pvzreborn.item;

import com.xstudio.pvzreborn.PVZReborn;
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

        String[] commonItemList = {
                "dark_knight_sword", "uncontrollable_nether_star", "supercritical_fire", "eighteenth_state_ice", "ancient_eye",
                "overloaded_redstone", "redstone_arm", "bedrock_dust", "huge_pea", "creeper_gland", "sharp_ender_crystal_fragment",
                "entity_light", "iron_golem_sculpture_fragment", "compact_thallium_sulfate"
        };
        for (String name : commonItemList) {
            registryItem(name, () -> new CommonItem() {
            });
        }
    }

    /**
     * @author Bread_NiceCat
     */
    public static void registryItem(String name, Supplier<? extends Item> sup) {
        ITEMS.put(name, ITEM_REGISTER.register(name, sup));
    }

}

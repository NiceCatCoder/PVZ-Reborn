package com.xstudio.pvzreborn.item;

import com.xstudio.pvzreborn.PVZReborn;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ManagerItem {

    public static final Map<String, RegistryObject<? extends Item>> ITEMS = new HashMap<>();
    private static final DeferredRegister<Item> ITEM_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, PVZReborn.MOD_ID);
    private static final String[] commonItemList = {
            "dark_knight_sword", "uncontrollable_nether_star", "supercritical_fire", "eighteenth_state_ice", "ancient_eye",
            "overloaded_redstone", "redstone_arm", "huge_pea", "bedrock_dust", "creeper_gland", "sharp_ender_crystal_fragment",
            "entity_light", "iron_golem_sculpture_fragment", "compact_thallium_sulfate", "empty_test_tube"
    };

    /**
     * @author Bread_NiceCat
     */
    public static void init(IEventBus bus) {
        // Registering item
        ITEM_REGISTER.register(bus);
        Arrays.stream(commonItemList).forEach(name -> registryItem(name, ItemBase::new));
        ITEM_REGISTER.register(ItemTestTube.NAME, ItemTestTube::new);
    }

    /**
     * @author Bread_NiceCat
     */
    public static void registryItem(String name, Supplier<? extends Item> sup) {
        ITEMS.put(name, ITEM_REGISTER.register(name, sup));
    }

    /**
     * @author superhelo
     */
    public static Item getItem(String name) {
        return ITEMS.get(name).get();
    }

}

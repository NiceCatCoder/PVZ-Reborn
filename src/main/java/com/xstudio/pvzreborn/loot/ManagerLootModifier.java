package com.xstudio.pvzreborn.loot;

import com.xstudio.pvzreborn.PVZReborn;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries.Keys;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ManagerLootModifier {

    public static final Map<String, RegistryObject<GlobalLootModifierSerializer<?>>> SERIALIZERS = new HashMap<>();
    private static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister.create(Keys.LOOT_MODIFIER_SERIALIZERS, PVZReborn.MOD_ID);

    public static void init(IEventBus bus) {
        GLM.register(bus);
        registerModifier(WitherLootModifier.NAME, WitherLootModifier.Serializer::new);
    }

    private static void registerModifier(String name, Supplier<? extends GlobalLootModifierSerializer<?>> supplier) {
        SERIALIZERS.put(name, GLM.register(name, supplier));
    }

    @SuppressWarnings("unchecked")
    public static <T extends IGlobalLootModifier> GlobalLootModifierSerializer<T> getSerializer(String name) {
        return (GlobalLootModifierSerializer<T>) SERIALIZERS.get(name).get();
    }

}

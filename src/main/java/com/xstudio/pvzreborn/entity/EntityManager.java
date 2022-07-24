package com.xstudio.pvzreborn.entity;

import com.xstudio.pvzreborn.PVZReborn;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;

public class EntityManager {
    public static final HashMap<Class<? extends Entity>, RegistryObject<EntityType<? extends Entity>>> ENTITIES = new HashMap<>();
    private static final DeferredRegister<EntityType<?>> ENTITY_REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, PVZReborn.MOD_ID);

    public static void init(IEventBus bus) {
        ENTITY_REGISTER.register(bus);
    }
}

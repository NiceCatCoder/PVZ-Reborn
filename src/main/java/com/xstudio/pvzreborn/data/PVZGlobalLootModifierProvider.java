package com.xstudio.pvzreborn.data;

import com.xstudio.pvzreborn.PVZReborn;
import com.xstudio.pvzreborn.loot.ManagerLootModifier;
import com.xstudio.pvzreborn.loot.WitherLootModifier;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class PVZGlobalLootModifierProvider extends GlobalLootModifierProvider {

    public PVZGlobalLootModifierProvider(DataGenerator gen) {
        super(gen, PVZReborn.MOD_ID);
    }

    @Override
    protected void start() {
        add(WitherLootModifier.NAME, new WitherLootModifier(
            new LootItemCondition[]{
                    LootTableIdCondition.builder(new ResourceLocation("entities/wither")).build(),
                    LocationCheck.checkLocation(LocationPredicate.Builder.location().setDimension(Level.NETHER)).build()
            }
        ));

    }

    private <T extends IGlobalLootModifier> void add(String name, T instance) {
        add(name, ManagerLootModifier.getSerializer(name), instance);
    }

}

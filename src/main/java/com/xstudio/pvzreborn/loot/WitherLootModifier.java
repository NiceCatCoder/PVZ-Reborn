package com.xstudio.pvzreborn.loot;

import com.google.gson.JsonObject;
import com.xstudio.pvzreborn.item.ManagerItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WitherLootModifier extends LootModifier {

    public static final String NAME = "wither_loot_modifier";

    public WitherLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @NotNull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        generatedLoot.add(new ItemStack(ManagerItem.getItem("uncontrollable_nether_star")));
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<WitherLootModifier> {

        @Override
        public WitherLootModifier read(ResourceLocation location, JsonObject object, LootItemCondition[] lootCondition) {
            return new WitherLootModifier(lootCondition);
        }

        @Override
        public JsonObject write(WitherLootModifier instance) {
            return makeConditions(instance.conditions);
        }

    }

}

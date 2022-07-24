package com.xstudio.pvzreborn.data;

import com.xstudio.pvzreborn.item.ManagerItem;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class PVZRecipeProvider extends RecipeProvider {

    public PVZRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ManagerItem.getItem("ancient_eye"))
            .requires(Items.GLASS_BOTTLE)
            .requires(Items.ENDER_EYE)
            .requires(Items.BLAZE_POWDER)
            .requires(Items.DRAGON_BREATH)
            .requires(Items.CHORUS_FRUIT)
            .requires(Items.TWISTING_VINES)
            .unlockedBy("has_ender_eye", has(Items.ENDER_EYE))
            .save(consumer);;

        ShapelessRecipeBuilder.shapeless(ManagerItem.getItem("redstone_arm"))
            .requires(Items.PISTON)
            .requires(Items.PISTON)
            .requires(Items.SLIME_BLOCK)
            .requires(Items.ARMOR_STAND)
            .requires(Items.STICK)
            .requires(Items.IRON_BLOCK)
            .unlockedBy("has_piston", has(Items.PISTON))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(ManagerItem.getItem("sharp_ender_crystal_fragment"), 32)
            .requires(Items.END_CRYSTAL, 8)
            .requires(Items.DIAMOND)
            .unlockedBy("has_end_crystal", has(Items.END_CRYSTAL))
            .save(consumer);

        ShapelessRecipeBuilder.shapeless(ManagerItem.getItem("huge_pea"), 4)
            .requires(Items.CAULDRON)
            .requires(Items.GRASS)
            .requires(Items.SLIME_BLOCK)
            .requires(Items.DISPENSER)
            .unlockedBy("has_glass", has(Items.GRASS))
            .save(consumer);
    }

}

package com.xstudio.pvzreborn.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Utils {
    private Utils() {
    }

    public static void createItemEntity(Level level, BlockPos pos, ItemStack stack) {
        level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), stack));
    }

    public static void createItemEntity(Level level, Vec3 pos, ItemStack stack) {
        level.addFreshEntity(new ItemEntity(level, pos.x, pos.y, pos.z, stack));
    }

}

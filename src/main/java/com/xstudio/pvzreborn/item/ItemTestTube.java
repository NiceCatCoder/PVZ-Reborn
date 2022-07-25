package com.xstudio.pvzreborn.item;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;

import java.awt.*;

public class ItemTestTube extends ItemBase implements ItemColor {
    public static final String NAME = "test_tube";

    public ItemTestTube() {
    }


    @Override
    public int getColor(ItemStack pStack, int pTintIndex) {
        if (pTintIndex == 1) {
            return Color.GREEN.getRGB();//debug
        } else {
            return 0;
        }
    }
}

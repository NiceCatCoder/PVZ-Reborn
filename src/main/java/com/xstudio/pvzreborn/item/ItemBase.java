package com.xstudio.pvzreborn.item;

import com.xstudio.pvzreborn.group.PVZRebornTab;
import net.minecraft.world.item.Item;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Properties().tab(PVZRebornTab.getInstance()));
    }

}

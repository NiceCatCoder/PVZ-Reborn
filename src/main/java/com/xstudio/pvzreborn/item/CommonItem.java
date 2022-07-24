package com.xstudio.pvzreborn.item;

import com.xstudio.pvzreborn.group.PVZRebornTab;
import net.minecraft.world.item.Item;

public abstract class CommonItem extends Item {

    public CommonItem() {
        super(new Properties().tab(PVZRebornTab.getInstance()));
    }

}

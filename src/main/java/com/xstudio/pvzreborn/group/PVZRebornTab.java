package com.xstudio.pvzreborn.group;

import com.xstudio.pvzreborn.PVZReborn;
import com.xstudio.pvzreborn.item.ManagerItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class PVZRebornTab extends CreativeModeTab {
    private static final PVZRebornTab INSTANCE = new PVZRebornTab();

    private PVZRebornTab() {
        super(PVZReborn.MOD_ID);
    }

    public static PVZRebornTab getInstance() {
        return INSTANCE;
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ManagerItem.ITEMS.get("overloaded_redstone").get());
    }

}

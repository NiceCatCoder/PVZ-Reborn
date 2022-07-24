package com.xstudio.pvzreborn.utils;

import com.xstudio.pvzreborn.PVZReborn;

public class Utils {
    private Utils() {
    }

    /**
     * 在字符串前带modid.
     * xxx -> modid.xxx
     *
     * @author Bread_NiceCat
     */
    public static String prefixPoint(String name) {
        return PVZReborn.MOD_ID + "." + name;
    }
}

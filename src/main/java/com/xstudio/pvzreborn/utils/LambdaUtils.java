package com.xstudio.pvzreborn.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LambdaUtils {
    private static final Logger LOGGER = LogManager.getLogger();

    private LambdaUtils() {
    }

    /**
     * 解决Lambda异常不输出问题
     *
     * @return 将参数返回便于抛出
     * @author Bread_NiceCat
     */
    public static RuntimeException reportException(Throwable t) {
        LOGGER.error(t);
        return new RuntimeException("Exception in Lambda", t);
    }

}

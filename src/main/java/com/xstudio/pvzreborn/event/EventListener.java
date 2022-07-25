package com.xstudio.pvzreborn.event;

import com.xstudio.pvzreborn.item.ManagerItem;
import com.xstudio.pvzreborn.utils.Utils;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import java.util.Arrays;

@EventBusSubscriber
public class EventListener {

    static final String[] colorItems = {"test_tube"};

    @SubscribeEvent
    public static void onCreeperExplosion(ExplosionEvent.Detonate event) {
        Explosion explosion = event.getExplosion();
        Vec3 pos = explosion.getPosition();
        Level level = event.getWorld();

        if (!level.isClientSide) {
            if (explosion.getSourceMob() instanceof Creeper creeper && creeper.isIgnited()) {
                Utils.createItemEntity(level, pos, new ItemStack(ManagerItem.getItem("creeper_gland")));
            }

            if (level.getBlockState(new BlockPos(pos).below()).is(Blocks.BEDROCK)) {
                Utils.createItemEntity(level, pos, new ItemStack(ManagerItem.getItem("bedrock_dust"), 2));
            }
        }

    }

    /**
     * @author Bread_NiceCat
     */
    @SubscribeEvent
    public static void onColorHandle(ColorHandlerEvent.Item event) {
        ItemColors itemColors = event.getItemColors();
        Arrays.stream(colorItems).forEach(name -> {
            Item item = ManagerItem.getItem(name);
            if (item instanceof ItemColor itemColor)
                itemColors.register(itemColor, item);
        });
    }

}

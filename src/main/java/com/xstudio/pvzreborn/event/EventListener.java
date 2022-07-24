package com.xstudio.pvzreborn.event;

import com.xstudio.pvzreborn.item.ManagerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class EventListener {

    @SubscribeEvent
    public static void onExplosion(ExplosionEvent.Detonate event) {
        Level level = event.getWorld();
        BlockPos pos = new BlockPos(event.getExplosion().getPosition());

        if (!level.isClientSide && level.getBlockState(pos.below()).is(Blocks.BEDROCK)) {
            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ManagerItem.getItem("bedrock_dust"))));
        }
    }

}

package com.xstudio.pvzreborn.event;

import com.xstudio.pvzreborn.item.ManagerItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class EventListener {

    @SubscribeEvent
    public static void onCreeperExplosion(ExplosionEvent.Detonate event) {
        Explosion explosion = event.getExplosion();
        LivingEntity entity = explosion.getSourceMob();

        if (entity instanceof Creeper creeper && creeper.isIgnited()) {
            Level level = creeper.level;
            Vec3 pos = explosion.getPosition();
            if (!level.isClientSide) {
                level.addFreshEntity(new ItemEntity(level, pos.x, pos.y, pos.z, new ItemStack(ManagerItem.getItem("creeper_gland"))));
            }
        }
    }

}

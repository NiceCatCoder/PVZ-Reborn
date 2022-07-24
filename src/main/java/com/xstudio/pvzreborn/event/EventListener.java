package com.xstudio.pvzreborn.event;

import com.xstudio.pvzreborn.item.ManagerItem;
import com.xstudio.pvzreborn.utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class EventListener {

    @SubscribeEvent
    public static void onCreeperExplosion(ExplosionEvent.Detonate event) {
        Level level = event.getWorld();

        if (!level.isClientSide) {
            Explosion explosion = event.getExplosion();
            LivingEntity entity = explosion.getSourceMob();
            Vec3 pos = explosion.getPosition();

            if (entity instanceof Creeper creeper && creeper.isIgnited()) {
                Utils.createItemEntity(level, pos, new ItemStack(ManagerItem.getItem("creeper_gland")));
            }
            if (level.getBlockState(new BlockPos(pos).below()).is(Blocks.BEDROCK)) {
                Utils.createItemEntity(level, pos, new ItemStack(ManagerItem.getItem("bedrock_dust"), 2));
            }
        }
    }

}

package com.xiaoyu.iwanttodieathome;

import com.xiaoyu.iwanttodieathome.util.CooldownManager;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = IWantToDieAtHome.MOD_ID)
public class PlayerDeathHandler {

    @SubscribeEvent
    public static void onPlayerDamage(LivingDamageEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) {
            return;
        }

        if (player.getHealth() <= event.getAmount()) {
            if (CooldownManager.hasUsedTeleport(player)) {
                return;
            }

            Vec3 spawnPos = getPlayerSpawnPosition(player);

            // event.setCanceled(true);

            teleportPlayerToSpawn(player, spawnPos);

            player.setHealth(1.0F);

            CooldownManager.markTeleportUsed(player);
        }
    }

    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) {
            return;
        }

        CooldownManager.resetTeleportUsage(player);
    }

    private static Vec3 getPlayerSpawnPosition(ServerPlayer player) {
        if (player.getRespawnPosition() != null) {
            return Vec3.atBottomCenterOf(player.getRespawnPosition());
        }
        return Vec3.atBottomCenterOf(player.serverLevel().getSharedSpawnPos());
    }

    private static void teleportPlayerToSpawn(ServerPlayer player, Vec3 spawnPos) {
        player.teleportTo(
                spawnPos.x,
                spawnPos.y,
                spawnPos.z);
    }

}

package com.xiaoyu.iwanttodieathome.util;

import net.minecraft.server.level.ServerPlayer;

import java.util.*;

public class CooldownManager {
    private static final Set<UUID> usedTeleport = new HashSet<>();

    public static boolean hasUsedTeleport(ServerPlayer player) {
        return usedTeleport.contains(player.getUUID());
    }

    public static void markTeleportUsed(ServerPlayer player) {
        usedTeleport.add(player.getUUID());
    }

    public static void resetTeleportUsage(ServerPlayer player) {
        usedTeleport.remove(player.getUUID());
    }

} 

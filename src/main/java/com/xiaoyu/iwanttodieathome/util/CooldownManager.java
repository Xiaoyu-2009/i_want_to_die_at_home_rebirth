package com.xiaoyu.iwanttodieathome.util;

import net.minecraft.server.level.ServerPlayer;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * 管理玩家的传送功能使用状态
 * 每个玩家只能使用一次传送功能，直到死亡后才会重置
 */
public class CooldownManager {
    // 存储已经使用过传送功能的玩家UUID
    private static final Set<UUID> usedTeleport = new HashSet<>();
    
    /**
     * 检查玩家是否已经使用过传送功能
     * @param player 要检查的玩家
     * @return 如果玩家已使用过返回true，否则返回false
     */
    public static boolean hasUsedTeleport(ServerPlayer player) {
        return usedTeleport.contains(player.getUUID());
    }
    
    /**
     * 标记玩家已使用传送功能
     * @param player 要标记的玩家
     */
    public static void markTeleportUsed(ServerPlayer player) {
        usedTeleport.add(player.getUUID());
    }
    
    /**
     * 重置玩家的传送使用状态
     * 当玩家死亡时调用此方法
     * @param player 要重置的玩家
     */
    public static void resetTeleportUsage(ServerPlayer player) {
        usedTeleport.remove(player.getUUID());
    }
} 
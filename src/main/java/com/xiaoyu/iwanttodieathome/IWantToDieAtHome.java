package com.xiaoyu.iwanttodieathome;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(IWantToDieAtHome.MOD_ID)
public class IWantToDieAtHome {
    public static final String MOD_ID = "i_want_to_die_at_home_rebirth";
    public static final String MOD_NAME = "I Want To Die At Home";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public IWantToDieAtHome() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // 注册事件监听器
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation makeResourceLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
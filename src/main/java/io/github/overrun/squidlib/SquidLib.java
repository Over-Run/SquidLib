package io.github.overrun.squidlib;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author squid233
 * @since 2020/10/09
 */
@Mod(modid = SquidLib.MODID, name = SquidLib.NAME, version = SquidLib.VERSION)
public class SquidLib {
    public static final String MODID = "squidlib";
    public static final String NAME = "SquidLib";
    public static final String VERSION = "1.0.0";

    @Mod.Instance
    private static SquidLib instance;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("Pre Initializing...");
        logger.info("Current state: " + event.getModState());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("SquidLib has initialized!");
        logger.info("Version: " + VERSION);
        logger.info("Current state: " + event.getModState());
    }

    public static SquidLib getInstance() {
        return instance;
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = LogManager.getLogger();
        }
        return logger;
    }
}

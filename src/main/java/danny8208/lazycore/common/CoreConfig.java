package danny8208.lazycore.common;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class CoreConfig {
    public static boolean enableBronzeIngot = true;

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
        }   catch (Exception e1) {
            LazyCore.logger.log(Level.ERROR, "Problem with loading config file");
        } finally {
            if(cfg.hasChanged()) {
                cfg.load();
            }
        }
    }

    private static void enableItems(Configuration cfg) {}
}

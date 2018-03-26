package com.rafacost3d.bbs_mod.init;

import com.rafacost3d.bbs_mod.BBSMod;
import com.rafacost3d.bbs_mod.proxy.CommonProxy;
import com.rafacost3d.bbs_mod.util.Reference;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

@net.minecraftforge.common.config.Config(modid= Reference.MODID)
public class ConfigInit {
    private static final String CATEGORY_GENERAL = "general";

    public static String breweryname = "Your Brewery";
    public static boolean metric = true;

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
        } catch (Exception e1) {
            BBSMod.logger.log(Level.ERROR, "Problem loading BBSMod config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.addCustomCategoryComment(CATEGORY_GENERAL,"Selected below the Unit System you prefer. Metric (true) or US/Imperial (false)");
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL,"Selected below the Unit System you prefer. Metric (true) or US/Imperial (false)");
        metric = cfg.getBoolean("metric", Configuration.CATEGORY_GENERAL, true,"Set Metric (true) or US/Imperial (false)");
        breweryname = cfg.getString("breweryname", CATEGORY_GENERAL, breweryname, "Set your Brewery Name here");
    }
}

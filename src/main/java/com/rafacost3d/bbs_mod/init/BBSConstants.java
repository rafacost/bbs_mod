package com.rafacost3d.bbs_mod.init;

import com.rafacost3d.bbs_mod.BBSMod;

public class BBSConstants {
    public static String DEGREE = null;
    public static Integer ROOM_TEMP = null;
    public static Integer WATER_BOILING = null;
    public static Double HOPS_WEIGHT = null;
    public static Double PELLETS_WEIGHT = null;
    public static Double LME_WEIGHT = null;
    public static String UNIT_WEIGHT = null;
    public static String KUNIT_WEIGHT = null;
    public static String UNIT_LIQUID = null;
    public static String KUNIT_LIQUID = null;
    public static Double BP_MAX_LIQUID = null;
    public static Double BP_MIN_LIQUID = null;

    public static void preint(){
        if(BBSConfig.metric) {
            BBSMod.logger.info("Loading Metric Defaults");
            DEGREE = " \u2103";
            ROOM_TEMP = 20;
            WATER_BOILING = 100;
            HOPS_WEIGHT = 0.44296875;
            PELLETS_WEIGHT = 0.8859375;
            LME_WEIGHT = 1.5;
            UNIT_WEIGHT = " g";
            KUNIT_WEIGHT = " kg";
            UNIT_LIQUID = " ml";
            KUNIT_LIQUID = " L";
            BP_MAX_LIQUID = 18.9;
            BP_MIN_LIQUID = 3.79;
        } else {
            BBSMod.logger.info("Loading US/Imperial Defaults");
            DEGREE = " \u2109";
            ROOM_TEMP = 68;
            WATER_BOILING = 212;
            HOPS_WEIGHT = 0.015625;
            PELLETS_WEIGHT = 0.03125;
            LME_WEIGHT = 3.3;
            UNIT_WEIGHT = " oz";
            KUNIT_WEIGHT = " lb";
            UNIT_LIQUID = " fl.oz";
            KUNIT_LIQUID = " GL";
            BP_MAX_LIQUID = 5.0;
            BP_MIN_LIQUID = 1.0;
        }
    }
}

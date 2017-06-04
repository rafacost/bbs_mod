package com.rafacost3d.bbs_mod.blocks.crops;

import com.rafacost3d.bbs_mod.BBSMod;

import java.util.HashMap;


public class CropsModelList {

    private final HashMap<Integer, String> registrations = new HashMap<Integer, String>();

    private final String rootDirectory;

    public CropsModelList(String resourceRoot) {
        //if (resourceRoot.charAt(resourceRoot.length() - 1) != '/') {
        //    throw new RuntimeException("Resource root path must be relative! (end with '/')");
        //}
        this.rootDirectory = getResourcePath(resourceRoot);
    }

    public CropsModelList add(int meta, String path) {
        this.registrations.put(meta, this.rootDirectory != null ? this.rootDirectory + path : getResourcePath(path));
        return this;
    }

    HashMap<Integer, String> getRegistrations() {
        return this.registrations;
    }

    private static String getResourcePath(String resource) {
        return (BBSMod.MODID + ":") + resource;
    }



}

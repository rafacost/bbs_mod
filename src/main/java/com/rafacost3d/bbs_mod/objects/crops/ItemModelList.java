package com.rafacost3d.bbs_mod.objects.crops;

import com.rafacost3d.bbs_mod.util.Reference;
import java.util.HashMap;

public class ItemModelList {
    private final HashMap<Integer, String> registrations = new HashMap<Integer, String>();

    private final String rootDirectory;

    public ItemModelList(String resourceRoot) {
        this.rootDirectory = getResourcePath(resourceRoot);
    }

    public ItemModelList add(int meta, String path) {
        this.registrations.put(meta, this.rootDirectory != null ? this.rootDirectory + path : getResourcePath(path));

        return this;
    }

    HashMap<Integer, String> getRegistrations() {
        return this.registrations;
    }

    private static String getResourcePath(String resource) {
        return (Reference.MODID + ":") + resource;
    }
}

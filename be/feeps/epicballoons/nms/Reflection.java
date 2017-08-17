package be.feeps.epicballoons.nms;

import be.feeps.epicballoons.Main;

/**
 * Created by Feeps on 16/08/2017
 */

public final class Reflection {
    public static Class<?> getClass(PackageType type, String name){
        Class <?> clazz = null;
        try{
            clazz = Class.forName(type.getPath() + "." + Main.instance.version + "." + name);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return clazz;
    }

    public enum PackageType{
        NMS("net.minecraft.server"),
        OBC("org.bukkit.craftbukkit"),
        BFB("be.feeps.epicballoons.nms");
        private String path;

        PackageType(String path){
            this.path = path;
        }

        public String getPath() {
            return this.path;
        }
    }
}

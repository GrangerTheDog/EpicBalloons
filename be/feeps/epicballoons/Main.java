package be.feeps.epicballoons;

import be.feeps.epicballoons.balloons.EpicBalloons;
import be.feeps.epicballoons.commands.EpicCommands;
import be.feeps.epicballoons.config.LangConfig;
import be.feeps.epicballoons.events.EpicEvents;
import be.feeps.epicballoons.nms.Reflection;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Feeps on 16/08/2017
 */

public class Main extends JavaPlugin{
    public static Main instance;
    public String version;

    @Override
    public void onEnable() {
        instance = this;
        this.version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];

        new LangConfig();
        this.registerEntities();
        this.getCommand("balloons").setExecutor(new EpicCommands());
        Bukkit.getPluginManager().registerEvents(new EpicEvents(), this);
    }

    @Override
    public void onDisable() {
        EpicBalloons.epicBalloonsMap.values().forEach(EpicBalloons::remove);
    }

    private void registerEntities(){
        try{
            Reflection.getClass(Reflection.PackageType.BFB, "Registry").newInstance();
        }catch (IllegalAccessException |InstantiationException e){
            e.printStackTrace();
        }
    }
}

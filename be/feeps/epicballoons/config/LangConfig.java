package be.feeps.epicballoons.config;

import be.feeps.epicballoons.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Created by Feeps on 16/08/2017
 */

public class LangConfig {
    private File locationFile;
    private YamlConfiguration locationFileData;

    public LangConfig(){
        this.locationFile = new File(Main.instance.getDataFolder(), "lang.yml");
        this.locationFileData = new YamlConfiguration();

        this.reloadData();

        for(Msg msg : Msg.values()){
            if(!this.locationFileData.contains(msg.getPath())){
                this.locationFileData.set(msg.getPath(), msg.getValue());
            }
        }

        Msg.setFile(this.locationFileData);
        saveData();
    }

    public void setData(String path, Object value) {
        this.locationFileData.set(path, value);
    }

    public Object getData(String path) {
        return this.locationFileData.get(path);
    }

    public boolean containsData(String path) {
        return this.locationFileData.contains(path);
    }

    public void saveData() {
        try {
            this.locationFileData.save(locationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadData() {
        try {
            locationFileData.load(this.locationFile);
        }catch (IOException e){
        } catch (InvalidConfigurationException e){

            Bukkit.getServer().getConsoleSender().sendMessage("[EpicPets]" + ChatColor.RED + " Error: Failed to load the lang.yml file.");
            try {
                Path path = Paths.get(Main.instance.getDataFolder() + File.separator + "old_lang_"+ UUID.randomUUID().toString().substring(0, 4) + ".yml");
                Files.copy(this.locationFile.toPath(), path);
            }catch (IOException e2){}
        }
    }

    public FileConfiguration getData() {
        return this.locationFileData;
    }

    public enum Msg {
        Prefix("messages.prefix","&6EpicBalloons &7| "),
        MessagesSpawn("message.spawn", "&aYou have spawn your balloon"),
        MessagesRemove("message.remove", "&cYour ballon has been removed"),
        MessagesNoPermission("message.noPermission", "&cYou don't have the permission"),
        InventoryName("inventory.name", "&8EpicBalloons"),
        InventoryLoreNoPermission("inventory.lore.hasPermission", "&cYou don't have the permission"),
        InventoryLoreHasPermission("inventory.lore.noPermission", "&aYou have the permission"),
        InventoryItemSlime("inventory.items.slime", "&aSlime"),
        InventoryItemNetherWarts("inventory.items.netherwarts", "&cNether Warts"),
        InventoryItemSponge("inventory.items.sponge", "&eSponge"),
        InventoryItemCactus("inventory.items.cactus", "&2Cactus"),
        InventoryItemGlass("inventory.items.glass", "&fGlass"),
        InventoryItemLeaves("inventory.items.leaves", "&aLeaves"),
        InventoryItemTNT("inventory.items.tnt", "&cT&fN&cT"),
        InventoryItemGlobe("inventory.items.globe", "&bGlobe"),
        InventoryItemBlackBalloon("inventory.items.blackballoon", "&0Black Balloon"),
        InventoryItemWhiteBalloon("inventory.items.whiteballoon", "&fWhite Balloon"),
        InventoryItemIllusion("inventory.items.illusion", "&dIllusion"),
        InventoryItemBeachBall("inventory.items.beachball", "&eBeachBall"),
        InventoryItemPokeBall("inventory.items.pokeball", "&cPokeBall"),
        InventoryItemRubiksCube("inventory.items.rubikscube", "&fRubiksCube"),
        InventoryItemGlobe2("inventory.items.globe2", "&eGlobe"),
        InventoryItemEye("inventory.items.eye", "&cEye"),
        InventoryItemTarget("inventory.items.target", "&fTarget"),
        InventoryItemGreenOre("inventory.items.greenore", "&2Green Ore"),
        InventoryItemFireCharge("inventory.items.firecharge", "&cFireCharge"),
        InventoryItemCocoaPod("inventory.items.cocoapod", "&6Cocoa Pod"),
        InventoryItemNetherPortal("inventory.items.netherportal", "&5Nether Portal"),
        InventoryItemRemoveBalloon("inventory.items.removeballoon", "&cRemove your balloon");

        private String path;
        private String value;
        private static YamlConfiguration LANG;

        Msg(String path, String value){
            this.path = path;
            this.value = value;
        }

        public String getPath(){
            return this.path;
        }

        public String getValue(){
            return this.value;
        }

        public static void setFile(YamlConfiguration config) {
            LANG = config;
        }

        @Override
        public String toString() {
            return ChatColor.translateAlternateColorCodes('&', LANG.getString(this.path, value));
        }

        public String toPrefix(){
            return ChatColor.translateAlternateColorCodes('&', LANG.getString(Prefix.getPath(), Prefix.getValue()) + LANG.getString(this.path, this.value));
        }
    }
}

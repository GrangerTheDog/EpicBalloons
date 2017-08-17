package be.feeps.epicballoons.balloons;

import be.feeps.epicballoons.config.LangConfig;
import be.feeps.epicballoons.utils.ItemsUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Feeps on 16/08/2017
 */

public enum EpicHeads {
    Slime(       10, LangConfig.Msg.InventoryItemSlime.toString(),       "slime", new ItemStack(Material.SLIME_BLOCK)),
    NetherWarts( 11, LangConfig.Msg.InventoryItemNetherWarts.toString(), "netherwarts", new ItemStack(Material.QUARTZ_ORE)),
    Sponge(      12, LangConfig.Msg.InventoryItemSponge.toString(),      "sponge", new ItemStack(Material.SPONGE)),
    Cactus(      13, LangConfig.Msg.InventoryItemCactus.toString(),      "cactus", new ItemStack(Material.CACTUS)),
    Glass(       14, LangConfig.Msg.InventoryItemGlass.toString(),       "glass", new ItemStack(Material.GLASS)),
    Leaves(      15, LangConfig.Msg.InventoryItemLeaves.toString(),      "leaves", new ItemStack(Material.LEAVES)),
    TNT(         16, LangConfig.Msg.InventoryItemTNT.toString(),         "tnt", new ItemStack(Material.TNT)),
    Globe(       19, LangConfig.Msg.InventoryItemGlobe.toString(),       "globe", ItemsUtils.getCustomSkull("YjFkZDRmZTRhNDI5YWJkNjY1ZGZkYjNlMjEzMjFkNmVmYTZhNmI1ZTdiOTU2ZGI5YzVkNTljOWVmYWIyNSJ9fX0")),
    BlackBalloon(20, LangConfig.Msg.InventoryItemBlackBalloon.toString(),"blackballoon", ItemsUtils.getCustomSkull("OTk2NzU0ZDMzMDQzNTM0NWFhZTNhOWYwNjNjZmNhNDJhZmIyOGI3YzVjNGJiOWYyOTRlZDI1MjdkOTYxIn19fQ")),
    WhiteBalloon(21, LangConfig.Msg.InventoryItemWhiteBalloon.toString(),"whiteballoon", ItemsUtils.getCustomSkull("Yjc4NTUxNjY5ODRhNzI1YmVjZmFjMWVhYjVjZmJkY2JlZTdlNDI2NDY2ZGRjM2JlZTRjNzFjZmQ3MmNiNTg4OCJ9fX0")),
    Illusion(    22, LangConfig.Msg.InventoryItemIllusion.toString(),    "illusion", ItemsUtils.getCustomSkull("YjQ2MmRkZmE1NTNjZTc4NjgzYmU0NzdiOGQ4NjU0ZjNkZmMzYWEyOTY5ODA4NDc4Yzk4N2FiODhjMzc2YTAifX19")),
    Beachball(   23, LangConfig.Msg.InventoryItemBeachBall.toString(),   "beachball", ItemsUtils.getCustomSkull("NWE1YWIwNWVhMjU0YzMyZTNjNDhmM2ZkY2Y5ZmQ5ZDc3ZDNjYmEwNGU2YjVlYzJlNjhiM2NiZGNmYWMzZmQifX19")),
    Pokeball(    24, LangConfig.Msg.InventoryItemPokeBall.toString(),    "pokeball", ItemsUtils.getCustomSkull("ZDQzZDRiN2FjMjRhMWQ2NTBkZGY3M2JkMTQwZjQ5ZmMxMmQyNzM2ZmMxNGE4ZGMyNWMwZjNmMjlkODVmOGYifX19")),
    RubiksCube(  25, LangConfig.Msg.InventoryItemRubiksCube.toString(),  "rubikscube", ItemsUtils.getCustomSkull("OGYxYTI3N2JlYjllNGZhYTZlN2UzNTZjNzQ3ODZlOTY2MTU1NzM2YTY4NThiZjViYjVhZDI5ZGY1YmFiNjFhMSJ9fX0")),
    Globe2(      28, LangConfig.Msg.InventoryItemGlobe2.toString(),      "globe2", ItemsUtils.getCustomSkull("NGQ0OGU3NWZmNTVjYjU3NTMzYzdiOTA0YmU4ODdhMzc0OTI1ZjkzODMyZjdhZTE2Yjc5MjM5ODdlOTcwIn19fQ")),
    Eye(         29, LangConfig.Msg.InventoryItemEye.toString(),         "eye", ItemsUtils.getCustomSkull("MmNlZjg3NzcyYWZkODViNDY4ZjRjN2ZiOTU3MWUzMTQzNWVmNzY1YWQ0MTNmZTQ2MDI2MjE1MDQyM2UyMDIxIn19fQ")),
    Target(      30, LangConfig.Msg.InventoryItemTarget.toString(),      "target", ItemsUtils.getCustomSkull("ODZmY2FlZmExOTY2OWQ4YmUwMmNmNWJhOWE3ZjJjZjZkMjdlNjM2NDEwNDk2ZmZjZmE2MmIwM2RjZWI5ZDM3OCJ9fX0")),
    GreenOre(    31, LangConfig.Msg.InventoryItemGreenOre.toString(),    "greenore", ItemsUtils.getCustomSkull("ZGM2YmFjZDM2ZWQ2MGY1MzMxMzhlNzU5YzQyNTk0NjIyMmI3OGVkYTZiNjE2MjE2ZjZkY2MwOGU5MGQzM2UifX19")),
    Firecharge(  32, LangConfig.Msg.InventoryItemFireCharge.toString(),  "firecharge", ItemsUtils.getCustomSkull("OWMyZTlkODM5NWNhY2Q5OTIyODY5YzE1MzczY2Y3Y2IxNmRhMGE1Y2U1ZjNjNjMyYjE5Y2ViMzkyOWM5YTExIn19fQ")),
    CocoaPod(    33, LangConfig.Msg.InventoryItemCocoaPod.toString(),    "cocoapod", ItemsUtils.getCustomSkull("NTA4M2VjMmIwMWRjMGZlZTc5YWEzMjE4OGQ5NDI5YWNjNjhlY2Y3MTQwOGRjYTA0YWFhYjUzYWQ4YmVhMCJ9fX0")),
    NetherPortal(34, LangConfig.Msg.InventoryItemNetherPortal.toString(),"netherportal", ItemsUtils.getCustomSkull("YjBiZmMyNTc3ZjZlMjZjNmM2ZjczNjVjMmM0MDc2YmNjZWU2NTMxMjQ5ODkzODJjZTkzYmNhNGZjOWUzOWIifX19"));

    private int slot;
    private String name;
    private String permission;
    private ItemStack item;

    EpicHeads(int slot, String name, String permission, ItemStack item){
        this.item = item;
        this.name = name;
        this.permission = permission;
        this.slot = slot;
    }

    public ItemStack getItem() {
        return this.item;
    }

    public String getName() {
        return this.name;
    }

    public String getPermission() {
        return "epicballoons." + this.permission;
    }

    public int getSlot() {
        return this.slot;
    }
}

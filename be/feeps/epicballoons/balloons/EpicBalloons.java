package be.feeps.epicballoons.balloons;

import be.feeps.epicballoons.config.LangConfig;
import be.feeps.epicballoons.nms.Reflection;
import be.feeps.epicballoons.utils.Sounds;
import org.bukkit.Effect;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Feeps on 16/08/2017
 */

public class EpicBalloons {
    public static Map<Player, EpicBalloons> epicBalloonsMap = new HashMap<>();
    private Player player;
    private ItemStack item;
    private Slime slime;
    private ArmorStand armorStand;

    public EpicBalloons(Player player, ItemStack item){
        this.player = player;
        this.item = item;
        if(epicBalloonsMap.containsKey(this.player))
            epicBalloonsMap.get(this.player).remove();

        epicBalloonsMap.put(player, this);
    }

    public void spawn(){
        try{
            Object world = player.getWorld().getClass().getMethod("getHandle").invoke(player.getWorld()); //Get the handle of the world

            Object balloon = Reflection.getClass(Reflection.PackageType.BFB, "NMSBalloons")                                     //
                    .getConstructor(Reflection.getClass(Reflection.PackageType.NMS, "World"), Player.class, ItemStack.class)     // Create a new instance of a balloon
                    .newInstance(world, this.player, this.item);                                                                  //

            world.getClass().getMethod("addEntity", Reflection.getClass(Reflection.PackageType.NMS, "Entity"), CreatureSpawnEvent.SpawnReason.class) //Add entity on the world
                    .invoke(world, balloon, CreatureSpawnEvent.SpawnReason.CUSTOM);

            this.slime = (Slime) balloon.getClass().getMethod("getSlime").invoke(balloon);              //Get the slime from the NMSBalloons class
            this.armorStand = (ArmorStand) balloon.getClass().getMethod("getContents").invoke(balloon); //Get the armorstand from the NMSBalloons class
            this.player.sendMessage(LangConfig.Msg.MessagesSpawn.toPrefix());
        }catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e){
            e.printStackTrace();
        }
    }

    public void remove(){
        this.slime.remove();
        this.player.getWorld().playSound(this.armorStand.getLocation().clone().add(0, 2, 0), Sounds.CHICKEN_EGG_POP.bukkitSound(), 1, 2);
        this.player.spigot().playEffect(this.armorStand.getLocation().clone().add(0, 2, 0), Effect.CLOUD, 0, 0, 0f, 0f, 0f, 0.1f, 10, 32);
        this.armorStand.remove();
        epicBalloonsMap.remove(this.player, this);
        this.player.sendMessage(LangConfig.Msg.MessagesRemove.toPrefix());
    }

    public void setItem(ItemStack item){
        this.armorStand.setHelmet(item);
    }
}

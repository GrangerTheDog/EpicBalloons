package be.feeps.epicballoons.events;

import be.feeps.epicballoons.balloons.EpicBalloons;
import be.feeps.epicballoons.inventories.EpicInventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Feeps on 16/08/2017
 */

public class EpicEvents implements Listener{
    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if(EpicBalloons.epicBalloonsMap.containsKey(player))
            EpicBalloons.epicBalloonsMap.get(player).remove();
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if (event.getInventory() == null) return;
        if (event.getCurrentItem() == null) return;
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();
        if(!EpicInventory.epicInventoryMap.containsKey(player)) return;
        if(event.getInventory() == EpicInventory.epicInventoryMap.get(player).getInventory()) return;
        if (event.getCurrentItem().getType() == Material.AIR) return;

        EpicInventory.epicInventoryMap.get(player).onClick(event);
    }
}

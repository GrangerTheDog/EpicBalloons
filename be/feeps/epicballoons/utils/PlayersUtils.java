package be.feeps.epicballoons.utils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Feeps on 17/08/2017
 */
public class PlayersUtils {
    private static List<Entity> currentlyMoving = new ArrayList();
    private static final HashMap<Entity, Location> lastLocation = new HashMap();

    public static void checkEntity(Entity entity) {
        Location currentloc = entity.getLocation();
        Location lastLoc = lastLocation.get(entity);

        lastLocation.putIfAbsent(entity, currentloc);
        lastLoc = lastLocation.get(entity);

        lastLocation.put(entity, entity.getLocation());
        if ((lastLoc.getX() != currentloc.getX()) || (lastLoc.getY() != currentloc.getY()) || (lastLoc.getZ() != currentloc.getZ())) {
            if (!currentlyMoving.contains(entity)) {
                currentlyMoving.add(entity);
            }
        }
        else if (currentlyMoving.contains(entity)) {
            currentlyMoving.remove(entity);
        }
    }

    public static boolean isMoving(Entity entity) {
        if (currentlyMoving.contains(entity)) {
            return true;
        }
        return false;
    }
}

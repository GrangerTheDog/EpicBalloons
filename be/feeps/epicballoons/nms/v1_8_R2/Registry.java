package be.feeps.epicballoons.nms.v1_8_R2;

import net.minecraft.server.v1_8_R2.EntityTypes;
import org.bukkit.entity.EntityType;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Feeps on 17/08/2017
 */
public class Registry {
    public Registry(){
        try {
            ArrayList array = new ArrayList();
            Field[] field;
            int j = (field = EntityTypes.class.getDeclaredFields()).length;

            for(int i = 0; i < j; i++) {
                Field f = field[i];
                if(f.getType().getSimpleName().equals(Map.class.getSimpleName())) {
                    f.setAccessible(true);
                    array.add(f.get(null));
                }
            }

            if(((Map)array.get(2)).containsKey((int) EntityType.SLIME.getTypeId())) {
                ((Map)array.get(0)).remove("EpicBalloons");
                ((Map)array.get(2)).remove((int) EntityType.SLIME.getTypeId());
            }

            Method m = EntityTypes.class.getDeclaredMethod("a", Class.class, String.class, Integer.TYPE);
            m.setAccessible(true);
            m.invoke(null, NMSBalloons.class, "EpicBalloons", (int) EntityType.SLIME.getTypeId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

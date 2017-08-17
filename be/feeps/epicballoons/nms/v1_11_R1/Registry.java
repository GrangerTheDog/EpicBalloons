package be.feeps.epicballoons.nms.v1_11_R1;

import net.minecraft.server.v1_11_R1.EntityTypes;
import net.minecraft.server.v1_11_R1.MinecraftKey;
import org.bukkit.entity.EntityType;

/**
 * Created by Feeps on 17/08/2017
 */
public class Registry {
    public Registry(){
        EntityTypes.b.a(EntityType.SLIME.getTypeId(), new MinecraftKey("EpicBalloons"), NMSBalloons.class);
    }
}

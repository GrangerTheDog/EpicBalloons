package be.feeps.epicballoons.nms.v1_8_R2;

import be.feeps.epicballoons.utils.MathUtils;
import net.minecraft.server.v1_8_R2.DamageSource;
import net.minecraft.server.v1_8_R2.EntitySlime;
import net.minecraft.server.v1_8_R2.World;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Feeps on 17/08/2017
 */
public class NMSBalloons extends EntitySlime {
    private Player player;
    private ArmorStand contents;
    private Location currentLoc;

    public NMSBalloons(World world, Player player, ItemStack item){
        super(world);
        this.player = player;
        this.updatePosition();
        this.contents = (ArmorStand) player.getWorld().spawnEntity(this.currentLoc.clone().subtract(0, 1, 0), EntityType.ARMOR_STAND);

        ((Slime)this.getBukkitEntity()).setSize(-1);
        ((Slime)this.getBukkitEntity()).setLeashHolder(this.player);
        this.setInvisible(true);
        this.setLocation(this.currentLoc.getX(), this.currentLoc.getY(), this.currentLoc.getZ(), this.currentLoc.getYaw(), this.currentLoc.getPitch());
        this.contents.setVisible(false);
        this.contents.setCustomNameVisible(false);
        this.contents.setGravity(false);
        this.contents.setHelmet(item);
    }

    @Override
    public boolean isInvulnerable(DamageSource damagesource) {
        return true;
    }

    @Override
    public void t_(){ //The update method
        this.updatePosition();
        setLocation(this.currentLoc.getX(), this.currentLoc.getY(), this.currentLoc.getZ(), this.currentLoc.getYaw(), this.currentLoc.getPitch());

        this.contents.teleport(this.getBukkitEntity().getLocation().clone().subtract(0, 1, 0));

        ((Slime)this.getBukkitEntity()).setLeashHolder(this.player);
    }

    private boolean status = true;
    private boolean yaw = true;
    private int i = 0;
    private void updatePosition(){
        this.currentLoc = this.player.getLocation();
        this.currentLoc.setPitch(-50f - MathUtils.random(0f, 5f));

        if(i == 90)
            yaw = false;
        else if (i == 0)
            yaw = true;

        if (yaw)
            i--;
        else
            i++;

        this.currentLoc.setYaw(i);
        this.currentLoc.add(
                this.currentLoc.getDirection().multiply(-1.3D).getX(),
                2.3D + (status ? 0.1D : 0D),
                this.currentLoc.getDirection().multiply(-1.8D).getZ());

        status = !status;
    }

    public ArmorStand getContents(){
        return this.contents;
    }

    public Slime getSlime(){
        return (Slime) this.getBukkitEntity();
    }
}
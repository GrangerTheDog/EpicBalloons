package be.feeps.epicballoons.commands;

import be.feeps.epicballoons.inventories.EpicInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Feeps on 16/08/2017
 */

public class EpicCommands implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            new EpicInventory((Player)commandSender).openInv();
            return true;
        }else{
            this.sendBalloon();
            return true;
        }
    }

    private void sendBalloon(){
        System.out.print(",,,,,,,,,,,,,,HHHHHH,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,HHHHHHHHHHH,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,HHHHHHHHHHHHHHH,,,,,,,,,,,,,,,");
        System.out.print(",,,,HHH,,,HHHHHHHHHHHH,,,,,,,,,,,,,,");
        System.out.print(",,,HH,,,,HHHHHHHHHHHHHH,,,,,,,,,,,,,");
        System.out.print(",HH,,,,HHHHHHHHHHHHHHHHH,,,,,,,,,,,,");
        System.out.print(",HH,,,,HHHHHHHHHHHHHHHHH,,,,,,,,,,,,");
        System.out.print("HHH,,,HHHHHHHHHHHHHHHHH,,,,,,,,,,,,,");
        System.out.print("HHH,,,HHHHHHHHHHHHHHHHH,,,,,,,,,,,,,");
        System.out.print("HHH,,,HHHHHHHHHHHHHHHHH,,,,,,,,,,,,,");
        System.out.print(",HHHHHHHHHHHHHHHHHHHHH,,,,,,,,,,,,,,");
        System.out.print(",,HHHHHHHHHHHHHHHHHHHH,,,,,,,,,,,,,,");
        System.out.print(",,,HHHHHHHHHHHHHHHHHH,,,,,,,,,,,,,,,");
        System.out.print(",,,,,HHHHHHHHHHHHHHHH,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,HHHHHHHHHHHHH,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,HHHHHHHHH,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,EpicBalloons by Feeps,,,,,,,");
    }
}

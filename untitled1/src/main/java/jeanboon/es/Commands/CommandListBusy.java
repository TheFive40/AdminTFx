package jeanboon.es.Commands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;

public class CommandListBusy implements CommandExecutor {
    HashMap<String, String> staffs_ocupados = CommandBusy.getOcupados();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(staffs_ocupados.isEmpty()){
            sender.sendMessage(ChatColor.DARK_RED + "No hay staffs ocupados");
            return true;
        }else{
            sender.sendMessage(ChatColor.WHITE+ "----------------------------------------------------");
            for(String staffs : staffs_ocupados.keySet()){
                sender.sendMessage(ChatColor.RED + staffs + " " + staffs_ocupados.get(staffs));
            }
            sender.sendMessage(ChatColor.WHITE+ "----------------------------------------------------");
            return true;
        }
    }
}

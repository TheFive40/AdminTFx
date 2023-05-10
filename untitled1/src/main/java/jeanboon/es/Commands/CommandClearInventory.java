package jeanboon.es.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandClearInventory implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            player.getInventory().clear();
            sender.sendMessage(ChatColor.GREEN + "Tu inventario ha sido restablecido");
            return true;
        }else{
            sender.sendMessage(ChatColor.RED + " No puedes usar este comando desde la consola ");
            return true;
        }
    }
}

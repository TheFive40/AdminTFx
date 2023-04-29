package jeanboon.es.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandVanish implements CommandExecutor {
    boolean isInvisible = false;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(!isInvisible){player.setInvisible(true);player.sendMessage(ChatColor.GREEN + "Invisibilidad activada");isInvisible = true;return true;}else{
            player.setInvisible(false);player.sendMessage(ChatColor.RED + "Invisibilidad desactivada");isInvisible = false;return true;}
        }
        return false;
    }
}

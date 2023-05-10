package jeanboon.es.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class CommandLastConnection implements CommandExecutor {
    Plugin plugin = null;

    public CommandLastConnection(Plugin plugin){this.plugin = plugin;}

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player && args.length > 0)
        {
           sender.sendMessage(ChatColor.GREEN  + args[0] + " Ultima vez activo " + plugin.getServer().getPlayer(args[0]).getLastLogin());
           return true;
        }else{
            sender.sendMessage(ChatColor.RED + "Faltan argumentos. Use: /seen <jugador>");
            return true;
        }

    }
}

package jeanboon.es.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class CommandSuicide implements CommandExecutor {

    Plugin plugin = null;

    public CommandSuicide(Plugin plugin)
    {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            player.setHealth(0);
            plugin.getServer().broadcastMessage(ChatColor.RED + sender.getName() + " se ha quitado la vida D:");
            return true;
        }else{
            sender.sendMessage(ChatColor.RED + "Faltan argumentos. Use: /suicide");
            return true;
        }
    }
}

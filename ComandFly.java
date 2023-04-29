package jeanboon.es.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ComandFly implements CommandExecutor {
    Plugin p = null;
    boolean isFly = false;

    public ComandFly(Plugin p) {
        this.p = p;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player && args.length == 0 && !isFly){
            Player p = (Player) sender;
            p.setAllowFlight(true);
            p.setFlying(true);
            isFly = true;
            p.sendMessage(ChatColor.GREEN + "Modo de vuelo activado");
            return true;
        }
        if(isFly){
            Player p = (Player) sender;
            p.setFlying(false);
            p.sendMessage(ChatColor.RED + "Modo vuelo desactivado");
            p.setAllowFlight(false);
            isFly = false;
            return true;
        }
        if (args.length > 0) {
            sender.sendMessage(ChatColor.RED + "Faltan argumentos. Uso: /fly ");
            return true;
        }

        return false;
    }
}

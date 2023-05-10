package jeanboon.es.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class CommandGravity implements CommandExecutor {
    Plugin plugin = null;
    public CommandGravity(Plugin plugin){this.plugin=plugin;}
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if(args.length>0 && sender instanceof Player && args[0].equalsIgnoreCase("yes")){
            for(Player player : plugin.getServer().getOnlinePlayers()){
                player.setGravity(false);
                player.sendMessage(ChatColor.GREEN + "Modalidad de gravedad 0 activada");
            }
            return true;
        }else if (args.length>0 && sender instanceof  Player && args[0].equalsIgnoreCase("no")){
            for(Player player : plugin.getServer().getOnlinePlayers()){
                player.setGravity(true);
                player.sendMessage(ChatColor.RED + "Modalidad de gravedad 0 desactivada");
            }
            return true;
        }else{
            sender.sendMessage(ChatColor.RED +"Faltan argumentos. Use: /gravity <yes or no>");
            return true;
        }
    }
}

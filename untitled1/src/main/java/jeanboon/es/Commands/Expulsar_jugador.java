package jeanboon.es.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
public class Expulsar_jugador implements CommandExecutor {

    Plugin plugin = null;

    public Expulsar_jugador(Plugin p){
        this.plugin = p;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        try{

            if(sender instanceof Player && args.length>0 && args.length<=2){
                if(plugin.getServer().getPlayer(args[0]) != null){
                    plugin.getServer().getPlayer(args[0]).kickPlayer(args[1]);
                    plugin.getServer().broadcastMessage(ChatColor.GREEN + player.getName() + ChatColor.WHITE + " ha kickeado del servidor al jugador " + ChatColor.GREEN + args[0] + ChatColor.WHITE + " por " + ChatColor.GREEN + args[1]);
                    return true;
                }else{
                    player.sendMessage(ChatColor.DARK_RED + "Error jugador no encontrado");
                    return true;
                }
            }else if(sender instanceof ConsoleCommandSender && args.length>0 && args.length<=2){
                if(plugin.getServer().getPlayer(args[0]) != null){
                    plugin.getServer().getPlayer(args[0]).kickPlayer(args[1]);
                    plugin.getServer().broadcastMessage(ChatColor.GREEN + player.getName() + ChatColor.WHITE + " ha kickeado del servidor al jugador " + ChatColor.GREEN + args[0] + ChatColor.WHITE + " por " + ChatColor.GREEN + args[1]);
                    return true;
                }else{
                    player.sendMessage(ChatColor.DARK_RED + "Error jugador no encontrado");
                    return true;
                }
            }
            return false;
        }catch(NullPointerException e ){
            return false;
        }

    }
}

package jeanboon.es.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class CommandClear implements CommandExecutor {
    Plugin p = null;

    public CommandClear(Plugin p){
        this.p = p;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(args.length>0){
            if(args[0].equalsIgnoreCase("chat") && sender instanceof Player){
                Player jugador = (Player) sender;
                for(int i = 0;i<100;i++){
                    p.getServer().broadcastMessage("");
                }
                jugador.sendMessage(ChatColor.GREEN + "El chat ha sido limpiado");
                return true;
            }else if(args[0].equalsIgnoreCase("lag")){
                for(Entity entidad : p.getServer().getWorld("world").getEntities())
                {
                    entidad.remove();
                }
                sender.sendMessage(ChatColor.GREEN + "Items del suelo eliminados satisfactoriamente");

            }else if (args[0].equalsIgnoreCase("players")){
              for(Player onlinePlayers :p.getServer().getOnlinePlayers() ) {onlinePlayers.setHealth(0);}
              return true;
            }
        }else{
            sender.sendMessage(ChatColor.RED + "Faltan argumentos. Use /chat <token>");
            return true;
        }

        return false;
    }
}

package jeanboon.es.Commands;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class CommandTpall implements CommandExecutor {
    private Plugin p = null;
    public CommandTpall(Plugin p ){this.p = p;}
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if(args.length>0){
            sender.sendMessage(ChatColor.RED + "Faltan argumentos. Use: /tpall");
            return true;
        }else if (args.length<=0 && sender instanceof Player){
            Player player = (Player) sender;
            Location loc = player.getLocation();
            sender.sendMessage(ChatColor.GREEN + "Teletransportando jugadores a tu posicion actual...");
            for(Player p : p.getServer().getOnlinePlayers()){p.teleport(loc);}
            return true;
        }
        return false;
    }
}

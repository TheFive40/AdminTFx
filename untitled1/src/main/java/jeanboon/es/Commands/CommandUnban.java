package jeanboon.es.Commands;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class CommandUnban implements CommandExecutor {
    Plugin plugin = null;

    public CommandUnban(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if(args.length == 1){
            plugin.getServer().broadcastMessage(ChatColor.WHITE + "El jugador " + ChatColor.GREEN +args[0] + ChatColor.WHITE + " ha sido desbaneado por " +
                    ChatColor.GREEN + sender.getName());
            plugin.getServer().getBanList(BanList.Type.NAME).pardon(args[0]);
            return true;
        }else{
            sender.sendMessage(ChatColor.RED + "Faltan argumentos. Use: /unban <usuario>");
            return true;
        }
    }
}

package jeanboon.es.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandFood implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(args.length>0){sender.sendMessage(ChatColor.RED + "Faltan argumentos. Use: /food");return true;}

        else if (args.length == 0 && sender instanceof Player){
            Player player = (Player) sender;
            player.setFoodLevel(20);
            sender.sendMessage(ChatColor.GREEN + "Tu barra de comida ha sido restablecida");
            return true;
        }
        return false;
    }
}

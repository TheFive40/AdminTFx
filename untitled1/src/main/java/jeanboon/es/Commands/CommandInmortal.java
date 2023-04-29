package jeanboon.es.Commands;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandInmortal implements CommandExecutor {
    boolean isGod = false;
    private int sat = 0;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(args.length>0){sender.sendMessage(ChatColor.RED +"Faltan argumentos. Use: /dios" );}
        else if (args.length <=0 && sender instanceof Player && !isGod){
            Player player = (Player) sender;
        sender.sendMessage(ChatColor.GOLD + "Modo dios activado");
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(1000);
        player.setHealthScale(1000);
        sat = player.getSaturatedRegenRate();
        player.setSaturatedRegenRate(300);
        isGod = true;
        return true;
        }else if (args.length<=0 && sender instanceof Player && isGod){
            Player player = (Player) sender;
            player.setHealthScale(20);
            player.setSaturatedRegenRate(sat);
            sat = 0;
            isGod = false;
            sender.sendMessage(ChatColor.GOLD + "Modo dios desactivado");
        return true;
        }
        return false;
    }
}

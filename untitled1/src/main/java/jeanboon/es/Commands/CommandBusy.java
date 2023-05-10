package jeanboon.es.Commands;

import net.kyori.adventure.sound.Sound;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;

public class CommandBusy implements CommandExecutor {
    Plugin plugin = null;
    public CommandBusy(Plugin plugin){
        this.plugin = plugin;
    }

    public static HashMap<String, String> getOcupados() {
        return ocupados;
    }

    public static void setOcupados(HashMap<String, String> staffs_ocupados) {
        ocupados = staffs_ocupados;
    }

    private static HashMap<String, String> ocupados = new HashMap<>();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(args.length>0 && !ocupados.containsKey(sender.getName())){
            StringBuilder razon = new StringBuilder();
            for(int i = 0;i<args.length;i++){razon.append(" ");razon.append(args[i]);}
            ocupados.put(sender.getName(), String.valueOf(razon));
            sender.sendMessage(ChatColor.WHITE+ "----------------------------------------------------");
            plugin.getServer().broadcastMessage("");
            plugin.getServer().broadcastMessage(ChatColor.RED + "El staff " + sender.getName() + " está ocupado evita ser molesto ");
            plugin.getServer().broadcastMessage("");
            plugin.getServer().broadcastMessage(ChatColor.RED + "Motivo " + razon);
            plugin.getServer().broadcastMessage("");
            sender.sendMessage(ChatColor.WHITE+ "----------------------------------------------------");
            for(Player player : plugin.getServer().getOnlinePlayers()){
                player.playSound(player.getLocation(), "block.anvil.land", 1.0f, 1.0f);
            }
            setOcupados(ocupados);
            return true;
        }else if (args.length>0 && ocupados.containsKey(sender.getName())){
            sender.sendMessage(ChatColor.WHITE+ "----------------------------------------------------");
            plugin.getServer().broadcastMessage("");
            plugin.getServer().broadcastMessage(ChatColor.GREEN + "El staff " + sender.getName() + " ya no esta ocupado ");
            plugin.getServer().broadcastMessage("");
            sender.sendMessage(ChatColor.WHITE+ "----------------------------------------------------");
            for(Player player : plugin.getServer().getOnlinePlayers()){
                player.playSound(player.getLocation(), "block.anvil.land", 1.0f, 1.0f);
            }
            ocupados.remove(sender.getName());
            return true;
        }else{
            sender.sendMessage(ChatColor.RED + "Faltan argumentos. Use: /ocupado <Razon>");
            return true;
        }
    }
}

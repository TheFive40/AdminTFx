package jeanboon.es.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import thefive.es.Events.JumpingPlayer;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandFreeze implements CommandExecutor {
    Plugin plugin = null;
    boolean isFreeze = false;
    float velocity = 1F;
    Player player = null;

    HashMap<String, String> congelados = new HashMap();
    public CommandFreeze(Plugin plugin){
        this.plugin = plugin;
        JumpingPlayer event = new JumpingPlayer(plugin);
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(args.length>0 && sender instanceof Player){
            player = plugin.getServer().getPlayer(args[0]);
            if(!isFreeze){
                isFreeze = true;
                congelados.put(args[0], "yes");
                player.setWalkSpeed(0F);
                player.setFlySpeed(0);
                sender.sendMessage(ChatColor.GREEN + "El jugador " + args[0] + " Ha sido congelado");
                player.sendMessage(ChatColor.GREEN + "¡Has sido congelado!");
                JumpingPlayer.setPlayer(player);
                JumpingPlayer.setFreeze(isFreeze);
                JumpingPlayer.setCongelados(congelados);
                return true;

            }else{
                congelados.remove(args[0]);
                player.setWalkSpeed(0.5F);
                player.setFlySpeed(1F);
                sender.sendMessage(ChatColor.GREEN + "El jugador " + args[0] + " ha sido descongelado");
                player.sendMessage(ChatColor.GREEN + "¡Has sido descongelado!");
                isFreeze = false;
                JumpingPlayer.setFreeze(isFreeze);
                JumpingPlayer.setPlayer(player);
                JumpingPlayer.setCongelados(congelados);
                return true;
            }
        }else{
            sender.sendMessage(ChatColor.GRAY + "Descripcion: Este comando te permite congelar a un usuario especificando su nombre");
            sender.sendMessage(ChatColor.RED + "Faltan argumentos. Use: /congelar <usuario>");
            return true;
        }
    }
}

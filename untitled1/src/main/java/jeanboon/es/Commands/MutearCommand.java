package jeanboon.es.Commands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

public class MutearCommand implements CommandExecutor, Listener {
    private HashMap<UUID, Long> mutedPlayers = null;
    public MutearCommand(Plugin p, HashMap<UUID, Long> mutedPlayers){
        this.mutedPlayers = mutedPlayers;
        mutedPlayers = this.mutedPlayers;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (cmd.getName().equalsIgnoreCase("mute")) {
            if (args.length < 2) {
                sender.sendMessage(ChatColor.RED + "Use: /mute <jugador> <tiempo en minutos>");
                return true;
            }

            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage(ChatColor.RED + "Jugador no encontrado");
                return true;
            }

            long time = Long.parseLong(args[1]);
            long endTime = System.currentTimeMillis() + (time * 60000);

            mutedPlayers.put(target.getUniqueId(), endTime);
            target.sendMessage(ChatColor.RED + "Has sido silenciado por " + time + " Minutos por " + sender.getName());
            sender.sendMessage(ChatColor.GREEN + "Jugador " + target.getName() + " ha sido silenciado por " + time + " minutos");

            return true;
        }

        return false;
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (mutedPlayers.containsKey(player.getUniqueId())) {
            long endTime = mutedPlayers.get(player.getUniqueId());

            if (System.currentTimeMillis() >= endTime) {
                mutedPlayers.remove(player.getUniqueId());
                player.sendMessage(ChatColor.GREEN + "You have been unmuted");
                return;
            }

            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "¡Estás silenciado y no puedes enviar mensajes! " + endTime + " Tiempo restante");
        }
    }
    }




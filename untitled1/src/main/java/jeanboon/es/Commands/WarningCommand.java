package jeanboon.es.Commands;
import org.bukkit.BanList;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import java.util.Date;
import java.util.HashMap;

import static org.bukkit.ChatColor.*;

public class WarningCommand implements CommandExecutor {
    Plugin p = null;
    int num_sanciones = 0;
    HashMap<String, Integer> ListWarn = null;
    OfflinePlayer offlinePlayer = null;

    public WarningCommand(Plugin p, HashMap<String, Integer> ListWarn) {
        this.p = p;
        this.ListWarn = ListWarn;
        ListWarn = this.ListWarn;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player pl = (Player) commandSender;
        Player player = null;
        if (strings.length < 2) {
            pl.sendMessage(ChatColor.RED + "Faltan argumentos. Use /warn <usuario> <motivo>");
            return true;
        } else {
            player = this.p.getServer().getPlayer(strings[0]);
            if(player == null && !ListWarn.containsKey(strings[0])){
                offlinePlayer =
                        p.getServer().getOfflinePlayer(strings[0]);
                ListWarn
                        .put(offlinePlayer.getName(), 1);
                num_sanciones = 1;
                pl.getServer().broadcastMessage(WHITE +"El jugador " + GREEN + offlinePlayer.getName() + WHITE +
                        " ha sido advertido por " + GREEN + pl.getName() + WHITE + " por " + GREEN + strings[1]);
                return true;
            }

            else if (player == null && ListWarn.containsKey(strings[0]) && num_sanciones < 3){
                ListWarn
                        .put(offlinePlayer.getName(), num_sanciones++);
                pl.getServer().broadcastMessage(WHITE +"El jugador " + GREEN + offlinePlayer.getName() + WHITE +
                        " ha sido advertido por " + GREEN + pl.getName() + WHITE + " por " + GREEN + strings[1]);
                return true;
            }else if (player == null && ListWarn.containsKey(strings[0]) && num_sanciones == 3){
                Date date = new Date();
                date.setHours(24);
                offlinePlayer.banPlayer(RED + strings[1], date, DARK_RED + "Console");
                num_sanciones = 0;
                ListWarn.remove(strings[0]);
                pl.getServer().broadcastMessage(WHITE +"El jugador " + GREEN + offlinePlayer.getName() + WHITE +
                        " ha sido advertido por " + GREEN + pl.getName() + WHITE + " por " + GREEN + strings[1]);

                p.getServer().broadcastMessage(WHITE + "El jugador " + GREEN + offlinePlayer.getName() + WHITE
                        + " ha sido baneado por " + GREEN + "Console " + WHITE + " por " + GREEN + " Alcanzar las 4 advertencias");
                return true;
            }
        }
            if (strings.length == 2 && !ListWarn.containsKey(player.getName())) {
                ListWarn
                        .put(player.getName(), 1);
                pl.getServer().broadcastMessage(WHITE +"El jugador " + GREEN + player.getName() + WHITE +
                        " ha sido advertido por " + GREEN + pl.getName() + WHITE + " por " + GREEN + strings[1]);
                return true;
            }
            if (strings.length == 2 && ListWarn.containsKey(player.getName())&& ListWarn.get(player.getName())<3) {
                int sancion = ListWarn.get(player.getName());
                ListWarn
                        .put(player.getName(), (sancion+1));
                pl.getServer().broadcastMessage(WHITE +"El jugador " + GREEN + player.getName() + WHITE +
                        " ha sido advertido por " + GREEN + pl.getName() + WHITE + " por " + GREEN + strings[1]);
                return true;
            }
            if (ListWarn.get(player.getName())==3) {
                Date expires = new Date();
                expires.setHours(24);
                p.getServer().broadcastMessage(WHITE +"El jugador " +GREEN+ player.getName() + WHITE + " ha sido expulsado por " + GREEN
                        + "Alcanzar las 4 advertencias " + WHITE + "por " + GREEN + " Console" );
                player.kick();
                p.getServer().getBanList(BanList.Type.NAME)
                        .addBan(player.getName(), "Has alcanzado las 4 Advertencias", expires, "Console");
                p.getServer().broadcastMessage(WHITE + "El jugador " + GREEN + player.getName() + WHITE
                        + " ha sido baneado por " + GREEN + "Console " + WHITE + " por " + GREEN + " Alcanzar las 4 advertencias");
                ListWarn.remove(player.getName());
                return true;
            }
        return false;
    }
}
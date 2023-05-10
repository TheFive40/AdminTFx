package jeanboon.es.Commands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
public class CommandStaff implements CommandExecutor, Listener {
    boolean isStaff = false;
    Plugin plugin = null;
    public CommandStaff(Plugin p){
        this.plugin = p;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp() && !isStaff) {
                player.sendMessage(ChatColor.LIGHT_PURPLE + "Chat staff activado");
                isStaff = true;
                return true;
            } else if (player.isOp() && isStaff) {
                isStaff = false;
                player.sendMessage(ChatColor.RED + "Chat staff desactivado");
                return true;
            }
        }else{
            sender.sendMessage(ChatColor.RED + "Faltan argumentos. Use: /staff");
            return true;
        }
        return false;
    }
@EventHandler
    public void chatStaff (PlayerChatEvent e){
    Player player = e.getPlayer();
    if(isStaff){
            for(Player player1 : plugin.getServer().getOnlinePlayers()){
                if(player1.isOp()){
                    player1.sendMessage(ChatColor.LIGHT_PURPLE + "[CHAT-STAFF] " + player.getName() + ChatColor.LIGHT_PURPLE + " " + e.getMessage());
                }
            }
        e.setCancelled(true);
    }
}
}

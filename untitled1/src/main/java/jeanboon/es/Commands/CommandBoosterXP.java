package jeanboon.es.Commands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import thefive.es.Events.BoosterXP;

public class CommandBoosterXP implements CommandExecutor {
    private long time = 0;
   private static long endTime = 0;
    Plugin plugin = null;
    static boolean isOnly = false;
    private static int xp = 0;

    private static boolean isExpired = true;
    public CommandBoosterXP(Plugin p){
        this.plugin = p;
        BoosterXP booster = new BoosterXP(plugin);
    }

    public void setEndTime(long endTime){
        this.endTime = endTime;
    }
    public static long getEndTime(){
        return endTime;
    }

    public static void setIsOnly(boolean isOnly2){
        isOnly = isOnly2;
    }
    public static boolean getIsOnly(){
        return isOnly;
    }

    public static void setXP(int amount){
        xp = amount;
    }
    public static int getXP(){
        return xp;
    }
    public static void setExpired(boolean Expired){
        isExpired = Expired;
    }
    public static boolean isExpired(){
        return isExpired;
    }

    public static void setTime(long tiempo){endTime = tiempo;}
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(args.length>0){
            if(!isOnly){
                time = Long.parseLong(args[1]);
                endTime = System.currentTimeMillis() + (time*60000);
                setEndTime(endTime);
                setIsOnly(true);
                setXP(Integer.parseInt(args[0]));
                CommandBoosterXP.setExpired(true);
                plugin.getServer().broadcastMessage(ChatColor.RED + "-------------------------------------------------");
                plugin.getServer().broadcastMessage("");
                plugin.getServer().broadcastMessage(ChatColor.DARK_RED + "BOOSTER ACTIVADO POR: " + sender.getName());
                plugin.getServer().broadcastMessage("");
                plugin.getServer().broadcastMessage(ChatColor.DARK_RED + "BOOSTER GLOBAL ACTIVADO");
                plugin.getServer().broadcastMessage("");
                plugin.getServer().broadcastMessage(ChatColor.RED + "-------------------------------------------------");

                return true;
            }else{
                sender.sendMessage(ChatColor.GREEN + "Ya hay un booster Activado");
                return true;
            }

        }else{
            sender.sendMessage(ChatColor.RED + "Faltan argumentos. Use: /booster <XP> <Tiempo en minutos>");
            return true;
        }
    }
}

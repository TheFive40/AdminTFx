package jeanboon.es.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class CommandDrop implements CommandExecutor {
    Plugin plugin = null;
    public CommandDrop(Plugin plugin){this.plugin = plugin;}
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if(args.length<2 || args.length<0){sender.sendMessage(ChatColor.RED + "Faltan argumentos. Use: /dropitem  <item> <cantidad>");return true;}
        else{
            World world = plugin.getServer().getWorld("world");
            try {
                if(args[0].equalsIgnoreCase("Diamante")){
                    for(Player player : plugin.getServer().getOnlinePlayers()){
                        for(int i = 0; i<Integer.parseInt(args[1]);i++){
                            Location loc = player.getLocation();
                            loc.setY(loc.getY()+5);
                            world.dropItem(loc, new ItemStack(Material.DIAMOND));
                            Thread.sleep(55);

                        }

                    }
                    plugin.getServer().broadcastMessage(ChatColor.GREEN + "Lluvia de diamante finalizada");
                    return true;
                }else if (args[0].equalsIgnoreCase("netherita")){
                    for(Player player : plugin.getServer().getOnlinePlayers()){
                        for(int i = 0; i<Integer.parseInt(args[1]);i++){
                            Location loc = player.getLocation();
                            loc.setY(loc.getY()+5);
                            world.dropItem(loc, new ItemStack(Material.NETHERITE_INGOT));
                            Thread.sleep(55);

                        }

                    }
                    plugin.getServer().broadcastMessage(ChatColor.GREEN + "Lluvia de netherita finalizada");

                    return true;
                }else if (args[0].equalsIgnoreCase("Oro")){
                    for(Player player : plugin.getServer().getOnlinePlayers()){
                        for(int i = 0; i<Integer.parseInt(args[1]);i++){
                            Location loc = player.getLocation();
                            loc.setY(loc.getY()+5);
                            world.dropItem(loc, new ItemStack(Material.GOLD_INGOT));
                            Thread.sleep(70);
                        }
                    }
                    plugin.getServer().broadcastMessage(ChatColor.GREEN + "Lluvia de oro finalizada");
                    return true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            }

        return false;
    }
}

package jeanboom.es.untitled1;

import jeanboon.es.Commands.*;
import org.bukkit.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;


public final class Untitled1 extends JavaPlugin implements @NotNull Listener {
    private HashMap<UUID, Long> mutedPlayers = new HashMap<>();
    static{
        File f = new File("C:\\Users\\Jean Franco\\word.txt");
    }
    int Time = 0;
    @Override
    public void onEnable() {
        HashMap<String, Integer> silencedPlayers = new HashMap<>();
        HashMap <String, Integer> ListWarn = new HashMap<>();
        Bukkit.getServer().getLogger().info(ChatColor.GOLD + "Plugin cargado correctamente");
        getCommand("banear").setExecutor(this);
        getCommand("addWord").setExecutor(new AddMessageBlock());
        getCommand("deleteWord").setExecutor(new deleteItem());
        getCommand("listWord").setExecutor(new Listword());
        getCommand("expulsar").setExecutor(new Expulsar_jugador(this));
        getCommand("clear").setExecutor(new CommandClear(this));
        getCommand("mute").setExecutor(new MutearCommand(this, mutedPlayers));
        getCommand("fly").setExecutor(new ComandFly(this));
        getCommand("vanish").setExecutor(new CommandVanish());
        getCommand("warn").setExecutor(new WarningCommand(this, ListWarn));
        getCommand("unban").setExecutor(new CommandUnban(this));
        getCommand("god").setExecutor(new CommandInmortal());
        getCommand("tpall").setExecutor(new CommandTpall(this));
        getCommand("food").setExecutor(new CommandFood());
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new MutearCommand(this,mutedPlayers), this);

    }

    @Override
    public void onDisable() {

    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("banear") && args.length > 0 && args.length <= 3) {
            if (sender instanceof Player) {
                try {
                    Player jugador = (Player) sender;
                    Date expiracion = new Date();
                    expiracion.setHours(Integer.parseInt(args[2]));
                    if(args[0].equalsIgnoreCase("jean_sama") || args[0].equalsIgnoreCase("TheFive")){
                        Bukkit.getBanList(BanList.Type.NAME).addBan(jugador.getName(), args[1], expiracion, jugador.getName());
                        jugador.kickPlayer(args[0]);

                    }else{
                        Bukkit.getBanList(BanList.Type.NAME).addBan(args[0], args[1], expiracion, jugador.getName());
                        jugador.sendMessage(ChatColor.GREEN + "El jugador " + args[0] + " Ha sido baneado del servidor");
                        jugador.kickPlayer(args[0]);
                    }

                } catch (NumberFormatException e) {
                    getLogger().info(ChatColor.DARK_RED + " Se ha producido un error al ejecutar el comando");
                }

            } else {
                System.out.println(ChatColor.RED + "No puedes ejecutar este comando desde la consola");

            }
            return true;
        } else {
            return false;
        }

    }

    @EventHandler
    public void chatEventModerator(PlayerChatEvent e) {
        String mensajes = e.getMessage();
        Player jugador = e.getPlayer();
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Jean Franco\\word.txt"));
            String word = in.readLine();
            while(word != null){
                if(mensajes.equalsIgnoreCase(word)) jugador.kickPlayer(ChatColor.RED + "Lenguaje inapropiado");
                word = in.readLine();
            }
            in.close();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex2) {
            throw new RuntimeException(ex2);
        }


    }
}
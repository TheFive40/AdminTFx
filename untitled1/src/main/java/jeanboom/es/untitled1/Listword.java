package jeanboom.es.untitled1;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
public class Listword implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        try {
            if (command.getName().equalsIgnoreCase("listWord")) {
                FileReader reader = new FileReader("C:\\Users\\Jean Franco\\word.txt");
                Player jugador = (Player) commandSender;
                BufferedReader in = new BufferedReader(reader);
                jugador.sendMessage(ChatColor.RED + "-----------------------------");
                String palabra = in.readLine();
                while(palabra != null)
                {
                    jugador.sendMessage(ChatColor.DARK_GREEN + "Palabra " +  ChatColor.GOLD + palabra);
                    palabra = in.readLine();
                }
                jugador.sendMessage(ChatColor.RED + "-----------------------------");
                in.close();
                return true;
            } else {
                System.out.println("No puedes  usar este comando desde la consola");
                return false;
            }


        }catch(Exception e ){
            e.printStackTrace();
            return false;
        }
    }
}

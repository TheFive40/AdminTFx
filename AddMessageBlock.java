package jeanboom.es.untitled1;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class AddMessageBlock implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (commandSender instanceof Player) {
            Player jugador = (Player) commandSender;
            jugador.sendMessage(ChatColor.GREEN + "La palabra " + ChatColor.GOLD + args[0] + " " + ChatColor.GREEN + " Ha sido añadida a la lista");
            try {
                FileWriter out = new FileWriter("C:\\Users\\Jean Franco\\word.txt", true);
                PrintWriter linea = new PrintWriter(out);
                linea.println(args[0]);
                out.close();
                return true;
            } catch (IOException e) {
                jugador.sendMessage(ChatColor.RED + "Ha ocurrido un error");
            }

        } else {
            Player jugador = (Player) commandSender;
            jugador.sendMessage(ChatColor.RED + "ERROR EN LOS ARGUMENTOS DEL COMANDO");
            return false;

        }
        return false;
    }
}

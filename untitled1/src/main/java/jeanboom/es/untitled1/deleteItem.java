package jeanboom.es.untitled1;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class deleteItem implements CommandExecutor {
    static List<String> lista = new ArrayList<String>();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player jugador = (Player) sender;
            jugador.sendMessage(ChatColor.GREEN + "La palabra " + ChatColor.DARK_RED + args[0]  + ChatColor.GREEN + " fue eliminada");
            File arch = new File(System.getProperty("user.dir") + File.separator + "word2.txt");
            File arch_original = new File(System.getProperty("user.dir") + File.separator + "word.txt");
            try {
                FileWriter escribir = new FileWriter(System.getProperty("user.dir") + File.separator + "word2.txt", true);
                PrintWriter out = new PrintWriter(escribir);
                BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator + "word.txt"));
                String palabra = reader.readLine();
                while(palabra != null){
                    if(!palabra.equalsIgnoreCase(args[0])){
                        out.println(palabra);
                    }
                    palabra = reader.readLine();
                }
                out.close();
                escribir.close();
                reader.close();
                jugador.sendMessage("" + arch_original.delete());
                arch.renameTo(new File(System.getProperty("user.dir") + File.separator + "word.txt"));
                arch.delete();

                return true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return false;

        }


    }



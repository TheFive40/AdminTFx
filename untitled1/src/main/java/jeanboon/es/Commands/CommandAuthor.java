package jeanboon.es.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandAuthor implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage(ChatColor.WHITE+ "----------------------------------------------------");
        sender.sendMessage(ChatColor.DARK_RED + "Este plugin fue creado y desarrollado por jean_sama y/o TheFive");
        sender.sendMessage("");
        sender.sendMessage(ChatColor.YELLOW + "Contacto: ");
        sender.sendMessage("");
        sender.sendMessage(ChatColor.DARK_PURPLE + "Discord: TheFive#3047");
        sender.sendMessage("");
        sender.sendMessage(ChatColor.RED + "Correo: jeanf2805@gmail.com");
        sender.sendMessage(ChatColor.WHITE+ "----------------------------------------------------");
        return true;

    }
}

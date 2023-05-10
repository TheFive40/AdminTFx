package thefive.es.Events;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import it.unimi.dsi.fastutil.Hash;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;

public class JumpingPlayer implements Listener {
    Plugin plugin = null;

    public Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player jugador) {
        player = jugador;
    }

    public  static boolean getFreeze() {
        return isFreeze;
    }



    public static void setFreeze(boolean freeze) {
        isFreeze = freeze;
    }

    public static HashMap<String,String> getCongelados() {
        return congelados;
    }

    public static void setCongelados(HashMap<String, String> congelados2) {
        congelados = congelados2;
    }

    static Player player = null;

    static HashMap<String, String> congelados = new HashMap();
    static boolean isFreeze = false;
    public JumpingPlayer(Plugin plugin){
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void isJumpPlayer(PlayerJumpEvent e ){
        if(isFreeze && getPlayer() != null && getCongelados().containsKey(e.getPlayer().getName())){
            e.setCancelled(true);
        }

    }
}

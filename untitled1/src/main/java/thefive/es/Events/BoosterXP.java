package thefive.es.Events;
import jeanboon.es.Commands.CommandBoosterXP;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.Plugin;

public class BoosterXP implements Listener {
    Plugin p = null;
    public BoosterXP(Plugin p){
        this.p = p;
        p.getServer().getPluginManager().registerEvents(this, p);
    }


    @EventHandler
    public void killEntity(EntityDeathEvent e){
        if(CommandBoosterXP.getIsOnly()){
            if(System.currentTimeMillis()>= CommandBoosterXP.getEndTime()){
                p.getServer().broadcastMessage(ChatColor.GREEN + "BOOSTER EXPIRADO");
                CommandBoosterXP.setIsOnly(false);
                CommandBoosterXP.setExpired(true);
                CommandBoosterXP.setTime(0);
            }else{
                LivingEntity entidad = (LivingEntity) e.getEntity();
                Player player = entidad.getKiller();
                player.sendMessage(ChatColor.GREEN + "+" + CommandBoosterXP.getXP() + " Experiencia (Booster Global)" );
                player.giveExp(CommandBoosterXP.getXP());

            }
        }

    }
}

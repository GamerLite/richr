package Gl.main.rich;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;


import java.util.logging.Logger;
public class PluginRich extends JavaPlugin {
	private Scoreboard board;
	private Objective objective;
	Logger log = getLogger();
	
	public void onEnable(){
		log.info("RichOn");
		board = Bukkit.getScoreboardManager() .getNewScoreboard();
		objective = board.registerNewObjective("Rich", "name");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	}
		public void onPlayerJoin(PlayerJoinEvent event) {
		    Player player = event.getPlayer(); 
		    PlayerInventory inventory = player.getInventory(); 
		    ItemStack diamondstack = new ItemStack(Material.DIAMOND, 64);
		    ItemStack emeraldstack = new ItemStack(Material.EMERALD, 64);
		    if (inventory.contains(diamondstack)) { 
		        inventory.addItem(diamondstack);
		        player.sendMessage(ChatColor.GOLD + "Поздравляем у вас 64 алмаза!");
		       
		    }
		    if (inventory.contains(emeraldstack)) { 
		        inventory.addItem(emeraldstack);
		        player.sendMessage(ChatColor.GREEN + "Поздравляем у вас 64 емеральда!");
		       
		    }
		    ScoreboardManager manager = Bukkit.getScoreboardManager();
		    Scoreboard board = manager.getNewScoreboard();
		     
		    Objective objective = board.registerNewObjective("showhealth", "health");
		    objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
		    objective.setDisplayName("/ 20");
		     
		    for(Player online : Bukkit.getOnlinePlayers()){
		      online.setScoreboard(board);
		      online.setHealth(online.getHealth()); //Update their health
		    }
	}

	public void onDisable(){
		log.info("RichOff");
	}
}
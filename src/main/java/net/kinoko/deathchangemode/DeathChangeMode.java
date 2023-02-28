package net.kinoko.deathchangemode;

import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathChangeMode extends JavaPlugin implements Listener {
    private GameMode DeathChangeMode;

    @Override
    public void onEnable() {
        loadConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        player.setGameMode(DeathChangeMode);
    }

    private void loadConfig() {
        FileConfiguration config = getConfig();
        config.addDefault("death-change-mode", "SURVIVAL");
        DeathChangeMode = GameMode.valueOf(config.getString("death-change-mode"));
        saveConfig();
    }
}

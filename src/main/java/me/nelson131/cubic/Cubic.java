package me.nelson131.cubic;

import github.scarsz.discordsrv.DiscordSRV;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Cubic extends JavaPlugin {


    public static Plugin plugin = Cubic.getPlugin();
    Logger logger = getLogger();
    FileConfiguration config = getConfig();

    private static Plugin getPlugin(){
        return plugin;
    }
    @Override
    public void onEnable() {
        saveDefaultConfig();
        plugin = this;
        logger.info("enabled cubic");
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
    }

    @Override
    public void onDisable() {

    }
}

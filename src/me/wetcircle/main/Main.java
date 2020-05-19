package me.wetcircle.main;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.wetcircle.commands.Me;

public class Main extends JavaPlugin implements Listener {

	private FileConfiguration config = this.getConfig(); ////
	public List<String> disabledCommands = config.getStringList("disabled-commands");

	@Override
	public void onEnable() {
		System.out.println("hi");
		Bukkit.getPluginManager().registerEvents(this, this);
		System.out.println(config.getCurrentPath());
		if (!config.contains("config")) {
			System.out.println("hi");
			List<String> defaultCommands = Arrays.asList("me", "do");
			config.set("config.messageDisplayTime", 10);
			config.set("config.sendChatMessage", false);
			config.set("config.disabledCommands", defaultCommands);
			this.saveConfig();
		}
	}

	@Override
	public void onDisable() {
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommand(PlayerCommandPreprocessEvent event) {
		String message = event.getMessage().replaceFirst("/", "");
		String[] splitMessage = message.split(" ");
		Main main = new Main();
		Me me = new Me();
		System.out.println("hi");
		System.out.println(splitMessage);
		for (String msg : main.disabledCommands)
			if (splitMessage[0].equalsIgnoreCase(msg)) {
				System.out.println("hi3");
				if (msg.equalsIgnoreCase("me")) {
					System.out.println("hi4");
					me.meCommand("me", event.getPlayer());
				} else if (msg.equalsIgnoreCase("do")) {
					me.meCommand("do", event.getPlayer());
				}

			}

	}

}

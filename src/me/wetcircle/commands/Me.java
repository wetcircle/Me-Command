package me.wetcircle.commands;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import me.wetcircle.main.Main;

public class Me {

	/*
	 * /me takes a look there
	 * 
	 */

	public void meCommand(String arg, Player player) {
		Main main = new Main();
		int messageDisplayTime = main.getConfig().getInt("config.messageDisplayTime");
		for (int i = 0; i <= messageDisplayTime; i++) {
			System.out.println("hi5");
			if (arg.equalsIgnoreCase("me")) {
				player.getLocation().add(new Vector(1,2,3));
			} else if (arg.equalsIgnoreCase("do")) {

			} else {
				return;
			}
		}
		
	}

}

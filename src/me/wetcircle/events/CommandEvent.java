package me.wetcircle.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class CommandEvent implements Listener {

		@EventHandler
	public void playerMove(PlayerMoveEvent event){
		System.out.println('h');
	}

}

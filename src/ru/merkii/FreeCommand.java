package ru.merkii;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class FreeCommand extends JavaPlugin {
	private static FreeCommand instance;
	public void onEnable() {
		saveDefaultConfig();
	}
	public static FreeCommand getInstance() {
		return FreeCommand.instance;
	}
	public static String color() {
		return ChatColor.translateAlternateColorCodes('&', "§");
	}
}
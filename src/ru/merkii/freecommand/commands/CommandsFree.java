package ru.merkii.freecommand.commands;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import commonlib.com.minnymin.command.Command;
import commonlib.com.minnymin.command.CommandArgs;
import ru.merkii.FreeCommand;

public class CommandsFree {
	@Command(name = "free")
	public void free(CommandArgs args) {
		Player p = args.getPlayer();
		int sec = p.getStatistic(Statistic.PLAY_ONE_TICK) / 20;
		if(sec < FreeCommand.getInstance().getConfig().getInt("Options.CooldownSec")) {
			List<String> command = FreeCommand.getInstance().getConfig().getStringList("Options.Commands");
			for(String commands:command) {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), commands.replaceAll("%player%", p.getName()));
			}
		} else {
			p.sendMessage(FreeCommand.getInstance().getConfig().getString("Options.ErrorCooldown").replaceAll("&", "§").replaceAll("%player%", p.getName()));
		}
	}
}
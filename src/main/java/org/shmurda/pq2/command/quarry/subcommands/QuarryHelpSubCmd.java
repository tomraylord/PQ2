package org.shmurda.pq2.command.quarry.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.shmurda.pq2.util.SubCmd;

import java.util.List;

public class QuarryHelpSubCmd implements SubCmd {

    @Override
    public void execute(CommandSender sender, List<String> args) {
        sender.sendMessage(ChatColor.GRAY + " === " + ChatColor.WHITE + "Showing help for " + ChatColor.YELLOW + "/quarry" + ChatColor.GRAY + " === ",
                ChatColor.GREEN + "quarry assemble " + ChatColor.YELLOW + "<tier> " + ChatColor.WHITE + "Assembles a quarry on the block you are looking at",
                ChatColor.GREEN + "quarry disassemble " + ChatColor.YELLOW + "<id> " + ChatColor.WHITE + "Disassembles the quarry with that id",
                ChatColor.GREEN + "quarry list " + ChatColor.WHITE + "Lists all quarries that you own",
                ChatColor.GREEN + "quarry start " + ChatColor.YELLOW + "<id> " + ChatColor.WHITE + "Starts the quarry with that id",
                ChatColor.GREEN + "quarry stop " + ChatColor.YELLOW + "<id> " + ChatColor.WHITE + "Stops the quarry with that id",
                ChatColor.GREEN + "quarry help ");
    }

    @Override
    public String getPermission() {
        return null;
    }

    @Override
    public boolean allowConsole() {
        return true;
    }

    @Override
    public boolean runAsynchronously() {
        return false;
    }
}

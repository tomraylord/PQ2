package org.shmurda.pq2.command.quarry;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.shmurda.pq2.PQMain;
import org.shmurda.pq2.command.quarry.subcommands.QuarryHelpSubCmd;
import org.shmurda.pq2.util.SubCmd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuarryCommand extends Command {

    private final PQMain main;
    private final Map<String, SubCmd> subcommandMap;

    public QuarryCommand(PQMain main) {
        super("quarry");

        this.main = main;

        subcommandMap = new HashMap<>();
        subcommandMap.put("help", new QuarryHelpSubCmd());
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        boolean console = !(sender instanceof Player);

        if (!subcommandMap.containsKey(label)) {
            label = "help";
        }

        List<String> arguments = Arrays.stream(args).toList();
        SubCmd subCmd = subcommandMap.get(label);

        if (!subCmd.allowConsole() && console) {
            sender.sendMessage(ChatColor.RED + "You cannot do this.");
            return true;
        }

        if (subCmd.getPermission() != null) {
            if (!sender.hasPermission(subCmd.getPermission())) {
                sender.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
                return true;
            }
        }

        if (subCmd.runAsynchronously()) {
            main.getServer().getScheduler().runTask(main, () -> subCmd.execute(sender, arguments));
        } else {
            subCmd.execute(sender, arguments);
        }

        return true;
    }
}

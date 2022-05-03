package org.shmurda.pq2.util;

import org.bukkit.command.CommandSender;

import java.util.List;

public interface SubCmd {

    void execute(CommandSender sender, List<String> args);

    String getPermission();

    boolean allowConsole();
    
    boolean runAsynchronously();

}

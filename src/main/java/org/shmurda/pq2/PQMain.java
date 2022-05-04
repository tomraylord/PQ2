package org.shmurda.pq2;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.shmurda.pq2.command.quarry.QuarryCommand;
import org.shmurda.pq2.user.UserHandler;
import org.shmurda.pq2.util.CommandUtil;

import java.util.List;
import java.util.Optional;

@Getter
public final class PQMain extends JavaPlugin {

    private static Optional<PQMain> instance;

    private UserHandler userHandler;

    public PQMain() {
        instance = Optional.of(this);
    }

    public static PQMain get() {
        return instance.orElseThrow(() -> new IllegalStateException("PQMain is null. WTF?"));
    }

    @Override
    public void onEnable() {
        info(ChatColor.GREEN + "Registering Config (1/3)");
        saveDefaultConfig();

        info(ChatColor.GREEN + "Registering Commands (2/3)");
        CommandUtil.registerCmds(
                new QuarryCommand(this)
        );

        info(ChatColor.GREEN + "Loading User Handler (3/3)");
        userHandler = new UserHandler(this);

        info(ChatColor.GREEN + "Done.");
    }

    @Override
    public void onDisable() { }

    public void info(String message) {
        Bukkit.getConsoleSender().sendMessage("[PablosQuarry2] " + message);
    }
}

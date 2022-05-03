package org.shmurda.pq2;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.shmurda.pq2.user.UserHandler;

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
        saveDefaultConfig();

        userHandler = new UserHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

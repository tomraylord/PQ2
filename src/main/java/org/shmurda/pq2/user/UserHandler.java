package org.shmurda.pq2.user;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.shmurda.pq2.PQMain;

import java.util.HashMap;
import java.util.UUID;

public class UserHandler implements Listener {

    public static final HashMap<UUID, User> users = new HashMap<>();

    public UserHandler(PQMain plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void djhfglsdkjhfglkjsdh(PlayerJoinEvent event) {
        User user = new User(event.getPlayer());
        users.put(event.getPlayer().getUniqueId(), user);
    }

    @EventHandler
    public void Ilovelean420blazeit69(PlayerQuitEvent event) {
      users.remove(event.getPlayer().getUniqueId());
    }

    public static User getByUUID(UUID uuid) {
        return users.getOrDefault(uuid, null);
    }

}

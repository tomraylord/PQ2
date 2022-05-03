package org.shmurda.pq2.user;

import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public class User {

    private final Player parent;
    private boolean loaded;

    public User(Player player) {
        parent = player;
        loaded = false;
    }

    public void load() {
        loaded = true;
    }

    public void save() {

    }

}

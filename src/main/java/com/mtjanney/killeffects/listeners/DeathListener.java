package com.mtjanney.killeffects.listeners;

import com.mtjanney.killeffects.KillEffects;
import com.mtjanney.killeffects.database.SQLite;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.util.UUID;

public class DeathListener implements Listener {

    @EventHandler
    public void onJoin(AsyncPlayerPreLoginEvent event) {
        UUID uuid = event.getUniqueId();
        SQLite sqLite = KillEffects.getSqLite();

        if (!sqLite.playerExists(uuid)) {
            sqLite.addPlayer(uuid);
        }
    }

    @EventHandler
    public void onKill(PlayerDeathEvent event) {
        Player playerKilled = event.getPlayer();

        if (playerKilled.getKiller() != null) { // Player was killed by another player
            Player killer = playerKilled.getKiller();

            System.out.println(KillEffects.getSqLite().getPlayerEffect(killer.getUniqueId()));
        }
    }
}

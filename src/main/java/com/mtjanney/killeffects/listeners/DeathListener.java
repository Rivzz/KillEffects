package com.mtjanney.killeffects.listeners;

import com.mtjanney.killeffects.KillEffects;
import com.mtjanney.killeffects.database.SQLite;
import com.mtjanney.killeffects.effects.FireworkType;
import org.bukkit.Color;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FireworkExplodeEvent;
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
        Player playerKilled = event.getEntity();

        if (playerKilled.getKiller() != null) { // Player was killed by another player
            Player killer = playerKilled.getKiller();
            int effectID = KillEffects.getSqLite().getPlayerEffect(killer.getUniqueId());

            if (effectID == 0) {
                new FireworkType().display(playerKilled.getLocation().add(0, 1, 0), Color.RED);
            } else {
                // Todo: Check other methods without unique modifiers
            }
        }
    }

    @EventHandler
    public void onFireworkDamage(FireworkExplodeEvent event) {
        Firework firework = event.getEntity();

        if (firework.getFireworkMeta().getDisplayName().equals("delete")) {
            event.setCancelled(true);
        }
    }
}

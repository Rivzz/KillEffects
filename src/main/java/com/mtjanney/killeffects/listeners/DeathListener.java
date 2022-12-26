package com.mtjanney.killeffects.listeners;

import com.mtjanney.killeffects.KillEffects;
import com.mtjanney.killeffects.database.SQLite;
import com.mtjanney.killeffects.effects.FireworkType;
import com.mtjanney.killeffects.effects.ParticleType;
import com.mtjanney.killeffects.effects.utilities.Execution;
import org.bukkit.Color;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.FireworkExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.util.UUID;

public class DeathListener extends Execution implements Listener {

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

            if (KillEffects.getSqLite().playerExists(killer.getUniqueId())) {
                int effectID = KillEffects.getSqLite().getPlayerEffect(killer.getUniqueId());

                if (effectID == 0) {
                    new FireworkType().display(playerKilled.getLocation().add(0, 1, 0), Color.RED);
                } else {
                    new ParticleType().display(playerKilled.getLocation(), convert(effectID));
                }
            }
        }
    }

    @EventHandler
    public void onKillEntity(EntityDeathEvent event) {
        if (event.getEntity().getType().equals(EntityType.PAINTING)
                || event.getEntity().getType().equals(EntityType.FIREWORK)
                || event.getEntity().getType().equals(EntityType.AREA_EFFECT_CLOUD)
                || event.getEntity().getType().equals(EntityType.ARMOR_STAND)
                || event.getEntity().getType().equals(EntityType.DRAGON_FIREBALL)
                || event.getEntity().getType().equals(EntityType.DROPPED_ITEM)
                || event.getEntity().getType().equals(EntityType.ITEM_FRAME)
                || event.getEntity().getType().equals(EntityType.LEASH_HITCH)
                || event.getEntity().getType().equals(EntityType.LIGHTNING)
                || event.getEntity().getType().equals(EntityType.EVOKER_FANGS)
                || event.getEntity().getType().equals(EntityType.EXPERIENCE_ORB)
                || event.getEntity().getType().equals(EntityType.EGG)
                || event.getEntity().getType().equals(EntityType.ENDER_CRYSTAL)
                || event.getEntity().getType().equals(EntityType.ENDER_PEARL)
                || event.getEntity().getType().equals(EntityType.FALLING_BLOCK)
                || event.getEntity().getType().equals(EntityType.FIREBALL)
                || event.getEntity().getType().equals(EntityType.SMALL_FIREBALL)
                || event.getEntity().getType().equals(EntityType.LLAMA_SPIT)
                || event.getEntity().getType().equals(EntityType.MARKER)
                || event.getEntity().getType().equals(EntityType.FISHING_HOOK)
                || event.getEntity().getType().equals(EntityType.PRIMED_TNT)
                || event.getEntity().getType().equals(EntityType.PLAYER)
                || event.getEntity().getType().equals(EntityType.SHULKER_BULLET)
                || event.getEntity().getType().equals(EntityType.SNOWBALL)
                || event.getEntity().getType().equals(EntityType.ARROW)
                || event.getEntity().getType().equals(EntityType.SPECTRAL_ARROW)
                || event.getEntity().getType().equals(EntityType.SPLASH_POTION)
                || event.getEntity().getType().equals(EntityType.THROWN_EXP_BOTTLE)
                || event.getEntity().getType().equals(EntityType.TRIDENT)
                || event.getEntity().getType().equals(EntityType.WITHER_SKULL)
                || event.getEntity().getType().equals(EntityType.MINECART)
                || event.getEntity().getType().equals(EntityType.MINECART_COMMAND)
                || event.getEntity().getType().equals(EntityType.MINECART_CHEST)
                || event.getEntity().getType().equals(EntityType.MINECART_FURNACE)
                || event.getEntity().getType().equals(EntityType.MINECART_HOPPER)
                || event.getEntity().getType().equals(EntityType.MINECART_MOB_SPAWNER)
                || event.getEntity().getType().equals(EntityType.MINECART_TNT)) {
            return;
        }

        if (event.getEntity().getKiller() != null) {
            Player killer = event.getEntity().getKiller();

            if (KillEffects.getSqLite().playerExists(killer.getUniqueId())) {
                int effectID = KillEffects.getSqLite().getPlayerEffect(killer.getUniqueId());

                if (effectID == 0) {
                    new FireworkType().display(event.getEntity().getLocation().add(0, 1, 0), Color.RED);
                } else {
                    new ParticleType().display(event.getEntity().getLocation(), convert(effectID));
                }
            }
        }
    }

    @EventHandler
    public void onFireworkDamage(FireworkExplodeEvent event) {
        Firework firework = event.getEntity();

        // TODO: This is still broken, check nearby entities and if it contains a player then remove damage?
//        if (firework.getFireworkMeta().getDisplayName().equals("delete")) {
//            event.setCancelled(true);
//        }
    }
}

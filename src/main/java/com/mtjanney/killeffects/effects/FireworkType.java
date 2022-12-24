package com.mtjanney.killeffects.effects;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworkType implements EffectExecution {

    @Override
    public void display(Location location, Color color) {
        Firework firework = (Firework) location.getWorld().spawnEntity(location, EntityType.FIREWORK);
        FireworkMeta meta = firework.getFireworkMeta();

        meta.setPower(2);
        meta.addEffect(FireworkEffect.builder().withColor(color).flicker(true).build());

        firework.setFireworkMeta(meta);
        firework.detonate();
    }
}

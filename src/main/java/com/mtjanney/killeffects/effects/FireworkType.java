package com.mtjanney.killeffects.effects;

import com.mtjanney.killeffects.effects.utilities.Execution;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworkType extends Execution {

    @Override
    public void display(Location location, Color color) {
        Firework firework = (Firework) location.getWorld().spawnEntity(location, EntityType.FIREWORK);
        FireworkMeta meta = firework.getFireworkMeta();

        meta.setDisplayName("delete");
        meta.setPower(2);
        meta.addEffect(FireworkEffect.builder().withColor(color).flicker(false).build());

        firework.setFireworkMeta(meta);
        firework.setOp(true);
        firework.detonate();
    }
}

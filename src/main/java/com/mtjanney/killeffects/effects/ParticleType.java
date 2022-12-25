package com.mtjanney.killeffects.effects;

import com.destroystokyo.paper.ParticleBuilder;
import com.mtjanney.killeffects.effects.utilities.EffectType;
import com.mtjanney.killeffects.effects.utilities.Execution;
import org.bukkit.Location;
import org.bukkit.Particle;

public class ParticleType extends Execution {
    @Override
    public void display(Location location, EffectType effectType) {
        location = location.add(0, 1, 0);

        switch (effectType) {
            case BUBBLE_POP: {
                new ParticleBuilder(Particle.BUBBLE_POP)
                        .count(10)
                        .location(location)
                        .receivers(10)
                        .spawn();
                break;
            }
        }
    }
}

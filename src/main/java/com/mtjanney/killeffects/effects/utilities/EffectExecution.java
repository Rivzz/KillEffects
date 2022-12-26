package com.mtjanney.killeffects.effects.utilities;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;

public interface EffectExecution {
    void display(Location location, EffectType effectType);
    void display(Location location, Color color);
    void generate(Location location, Particle particle, boolean directional);
    EffectType convert(int effectID);
}

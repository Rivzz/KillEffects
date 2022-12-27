package com.mtjanney.killeffects.effects.utilities;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;

public interface EffectExecution {
    void display(Location location, Effects effectType);
    void display(Location location, Color color);
    void display(Location location, Sounds soundType);
    void generate(Location location, Particle particle, boolean repeat);
    void generate(Location location, Sound sound);
    Effects convertEffect(int effectID);
    Sounds convertSound(int soundID);
}

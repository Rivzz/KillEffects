package com.mtjanney.killeffects.effects.utilities;

import org.bukkit.Color;
import org.bukkit.Location;

public interface EffectExecution {
    void display(Location location, EffectType effectType);
    void display(Location location, Color color);
}

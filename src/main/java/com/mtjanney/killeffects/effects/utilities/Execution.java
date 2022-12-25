package com.mtjanney.killeffects.effects.utilities;

import org.bukkit.Color;
import org.bukkit.Location;

public abstract class Execution implements EffectExecution {
    @Override
    public void display(Location location, EffectType effectType) {}

    @Override
    public void display(Location location, Color color) {}
}

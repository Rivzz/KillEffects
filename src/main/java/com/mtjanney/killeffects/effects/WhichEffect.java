package com.mtjanney.killeffects.effects;

import org.bukkit.Color;
import org.bukkit.Location;

public class WhichEffect {

    public void ConstructFirework(Location location) { // 0001
        new FireworkType().display(location, Color.RED);
    }
}

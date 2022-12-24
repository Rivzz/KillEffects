package com.mtjanney.killeffects;

import com.mtjanney.killeffects.database.SQLite;
import com.mtjanney.killeffects.listeners.DeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class KillEffects extends JavaPlugin {
    private static SQLite sqLite;

    @Override
    public void onLoad() {
        sqLite = new SQLite("database", this);
        sqLite.create();
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
    }

    @Override
    public void onDisable() {

    }

    public static SQLite getSqLite() {
        return sqLite;
    }
}
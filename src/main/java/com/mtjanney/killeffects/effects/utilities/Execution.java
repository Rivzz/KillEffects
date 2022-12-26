package com.mtjanney.killeffects.effects.utilities;

import com.mtjanney.killeffects.KillEffects;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Execution implements EffectExecution {
    @Override
    public void display(Location location, EffectType effectType) {}

    @Override
    public void display(Location location, Color color) {}

    @Override
    public void generate(Location location, Particle particle, boolean repeat) {
        if (repeat) {
            new BukkitRunnable() {

                int cycles = 0;

                @Override
                public void run() {
                    for (int i = 0; i < 25; i++) {
                        double x = ThreadLocalRandom.current().nextDouble(-1, 1);
                        double y = ThreadLocalRandom.current().nextDouble(-1, 1);
                        double z = ThreadLocalRandom.current().nextDouble(-1, 1);

                        Location clone = location.clone().add(x, y, z);

                        location.getWorld().spawnParticle(particle, clone, 0, 0, 0, 0);
                    }

                    if (cycles == 2) {
                        cancel();
                    }

                    cycles++;
                }
            }.runTaskTimerAsynchronously(KillEffects.getInstance(), 0L, 5L);
        } else {
            new BukkitRunnable() {

                @Override
                public void run() {
                    for (int i = 0; i < 25; i++) {
                        double x = ThreadLocalRandom.current().nextDouble(-1, 1);
                        double y = ThreadLocalRandom.current().nextDouble(-1, 1);
                        double z = ThreadLocalRandom.current().nextDouble(-1, 1);

                        Location clone = location.clone().add(x, y, z);

                        location.getWorld().spawnParticle(particle, clone, 0, 0, 0, 0);
                    }
                }
            }.runTaskAsynchronously(KillEffects.getInstance());
        }
    }

    @Override
    public EffectType convert(int effectID) {
        switch (effectID) {
            case 1: {
                return EffectType.BUBBLE_POP;
            }
            case 2: {
                return EffectType.CAMPFIRE;
            }
            case 3: {
                return EffectType.CLOUD;
            }
            case 4: {
                return EffectType.CRIT;
            }
            case 5: {
                return EffectType.CRIT_MAGIC;
            }
            case 6: {
                return EffectType.DRAGON_BREATH;
            }
            case 7: {
                return EffectType.DRIP_LAVA;
            }
            case 8: {
                return EffectType.DRIP_WATER;
            }
            case 9: {
                return EffectType.ELECTRIC_SPARK;
            }
            case 10: {
                return EffectType.ENCHANTMENT_TABLE;
            }
            case 11: {
                return EffectType.END_ROD;
            }
            case 12: {
                return EffectType.EXPLOSION_LARGE;
            }
            case 13: {
                return EffectType.FALLING_HONEY;
            }
            case 14: {
                return EffectType.FIREWORKS_SPARK;
            }
            case 15: {
                return EffectType.FLAME;
            }
            case 16: {
                return EffectType.HEART;
            }
            case 17: {
                return EffectType.NOTE;
            }
            case 18: {
                return EffectType.PORTAL;
            }
            case 19: {
                return EffectType.SNOWFLAKE;
            }
            case 20: {
                return EffectType.SOUL_FIRE_FLAME;
            }
            case 21: {
                return EffectType.TOTEM;
            }
            case 22: {
                return EffectType.VILLAGER_ANGRY;
            }
            case 23: {
                return EffectType.VILLAGER_HAPPY;
            }
            default: {
                return EffectType.NULL;
            }
        }
    }
}

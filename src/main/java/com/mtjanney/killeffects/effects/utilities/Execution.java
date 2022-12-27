package com.mtjanney.killeffects.effects.utilities;

import com.mtjanney.killeffects.KillEffects;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Execution implements EffectExecution {
    @Override
    public void display(Location location, Effects effectType) {}

    @Override
    public void display(Location location, Sounds soundType) {}

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
    public void generate(Location location, Sound sound) {
        new BukkitRunnable() {

            @Override
            public void run() {
                System.out.println("This sound is " + sound);
                location.getWorld().playSound(location, sound, 2F, 1F);
            }
        }.runTaskAsynchronously(KillEffects.getInstance());
    }

    @Override
    public Sounds convertSound(int soundID) {
        switch (soundID) {
            case 1: {
                return Sounds.BLOCK_ANVIL_LAND;
            }
            case 2: {
                return Sounds.BLOCK_BELL_USE;
            }
            case 3: {
                return Sounds.BLOCK_CHAIN_BREAK;
            }
            case 4: {
                return Sounds.BLOCK_CHEST_OPEN;
            }
            case 5: {
                return Sounds.BLOCK_CONDUIT_DEACTIVATE;
            }
            case 6: {
                return Sounds.BLOCK_ENCHANTMENT_TABLE_USE;
            }
            case 7: {
                return Sounds.BLOCK_END_PORTAL_SPAWN;
            }
            case 8: {
                return Sounds.BLOCK_GLASS_BREAK;
            }
            case 9: {
                return Sounds.BLOCK_LAVA_EXTINGUISH;
            }
            case 10: {
                return Sounds.BLOCK_SCULK_CATALYST_BREAK;
            }
            default: {
                return Sounds.NULL;
            }
        }
    }

    @Override
    public Effects convertEffect(int effectID) {
        switch (effectID) {
            case 1: {
                return Effects.BUBBLE_POP;
            }
            case 2: {
                return Effects.CAMPFIRE;
            }
            case 3: {
                return Effects.CLOUD;
            }
            case 4: {
                return Effects.CRIT;
            }
            case 5: {
                return Effects.CRIT_MAGIC;
            }
            case 6: {
                return Effects.DRAGON_BREATH;
            }
            case 7: {
                return Effects.DRIP_LAVA;
            }
            case 8: {
                return Effects.DRIP_WATER;
            }
            case 9: {
                return Effects.ELECTRIC_SPARK;
            }
            case 10: {
                return Effects.ENCHANTMENT_TABLE;
            }
            case 11: {
                return Effects.END_ROD;
            }
            case 12: {
                return Effects.EXPLOSION_LARGE;
            }
            case 13: {
                return Effects.FALLING_HONEY;
            }
            case 14: {
                return Effects.FALLING_OBSIDIAN_TEAR;
            }
            case 15: {
                return Effects.FIREWORKS_SPARK;
            }
            case 16: {
                return Effects.FLAME;
            }
            case 17: {
                return Effects.GLOW_SQUID_INK;
            }
            case 18: {
                return Effects.HEART;
            }
            case 19: {
                return Effects.NOTE;
            }
            case 20: {
                return Effects.PORTAL;
            }
            case 21: {
                return Effects.SNOWFLAKE;
            }
            case 22: {
                return Effects.SOUL_FIRE_FLAME;
            }
            case 23: {
                return Effects.TOTEM;
            }
            case 24: {
                return Effects.VILLAGER_ANGRY;
            }
            case 25: {
                return Effects.VILLAGER_HAPPY;
            }
            default: {
                return Effects.NULL;
            }
        }
    }
}

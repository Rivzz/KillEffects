package com.mtjanney.killeffects.effects;

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
                generate(location, Particle.BUBBLE_POP, true);
                break;
            }
            case CAMPFIRE: {
                generate(location, Particle.CAMPFIRE_SIGNAL_SMOKE, false);
                break;
            }
            case CLOUD: {
                generate(location, Particle.CLOUD, false);
                break;
            }
            case CRIT: {
                generate(location, Particle.CRIT, true);
                break;
            }
            case CRIT_MAGIC: {
                generate(location, Particle.CRIT_MAGIC, true);
                break;
            }
            case DRAGON_BREATH: {
                generate(location, Particle.DRAGON_BREATH, false);
                break;
            }
            case DRIP_LAVA: {
                generate(location, Particle.DRIP_LAVA, false);
                break;
            }
            case DRIP_WATER: {
                generate(location, Particle.DRIP_WATER, false);
                break;
            }
            case ELECTRIC_SPARK: {
                generate(location, Particle.ELECTRIC_SPARK, true);
                break;
            }
            case ENCHANTMENT_TABLE: {
                generate(location, Particle.ENCHANTMENT_TABLE, true);
                break;
            }
            case END_ROD: {
                generate(location, Particle.END_ROD, false);
                break;
            }
            case EXPLOSION_LARGE: {
                generate(location, Particle.EXPLOSION_LARGE, false);
                break;
            }
            case FALLING_HONEY: {
                generate(location, Particle.FALLING_HONEY, false);
                break;
            }
            case FIREWORKS_SPARK: {
                generate(location, Particle.FIREWORKS_SPARK, true);
                break;
            }
            case FLAME: {
                generate(location, Particle.FLAME, true);
                break;
            }
            case HEART: {
                generate(location, Particle.HEART, true);
                break;
            }
            case NOTE: {
                generate(location, Particle.NOTE, true);
                break;
            }
            case PORTAL: {
                generate(location, Particle.PORTAL, true);
                break;
            }
            case SNOWFLAKE: {
                generate(location, Particle.SNOWFLAKE, true);
                break;
            }
            case SOUL_FIRE_FLAME: {
                generate(location, Particle.SOUL_FIRE_FLAME, true);
                break;
            }
            case TOTEM: {
                generate(location, Particle.TOTEM, false);
                break;
            }
            case VILLAGER_ANGRY: {
                generate(location, Particle.VILLAGER_ANGRY, true);
                break;
            }
            case VILLAGER_HAPPY: {
                generate(location, Particle.VILLAGER_HAPPY, false);
                break;
            }
        }
    }
}

package com.mtjanney.killeffects.effects;

import com.mtjanney.killeffects.effects.utilities.Execution;
import com.mtjanney.killeffects.effects.utilities.Sounds;
import org.bukkit.Location;
import org.bukkit.Sound;

public class SoundType extends Execution {

    @Override
    public void display(Location location, Sounds soundType) {
        location = location.add(0, 1, 0);

        switch (soundType) {
            case BLOCK_ANVIL_LAND: {
                generate(location, Sound.BLOCK_ANVIL_LAND);
                break;
            }
            case BLOCK_BELL_USE: {
                generate(location, Sound.BLOCK_BELL_USE);
                break;
            }
            case BLOCK_CHAIN_BREAK: {
                generate(location, Sound.BLOCK_CHAIN_BREAK);
                break;
            }
            case BLOCK_CHEST_OPEN: {
                generate(location, Sound.BLOCK_CHEST_OPEN);
                break;
            }
            case BLOCK_CONDUIT_DEACTIVATE: {
                generate(location, Sound.BLOCK_CONDUIT_DEACTIVATE);
                break;
            }
            case BLOCK_ENCHANTMENT_TABLE_USE: {
                generate(location, Sound.BLOCK_ENCHANTMENT_TABLE_USE);
                break;
            }
            case BLOCK_END_PORTAL_SPAWN: {
                generate(location, Sound.BLOCK_END_PORTAL_SPAWN);
                break;
            }
            case BLOCK_GLASS_BREAK: {
                generate(location, Sound.BLOCK_GLASS_BREAK);
                break;
            }
            case BLOCK_LAVA_EXTINGUISH: {
                generate(location, Sound.BLOCK_LAVA_EXTINGUISH);
                break;
            }
            case BLOCK_SCULK_CATALYST_BREAK: {
                generate(location, Sound.BLOCK_SCULK_CATALYST_BREAK);
                break;
            }
            default: {
                // Nothing (no sound active)
            }
        }
    }
}

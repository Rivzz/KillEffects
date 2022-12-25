package com.mtjanney.killeffects.commands;

import com.mtjanney.killeffects.KillEffects;
import com.mtjanney.killeffects.effects.FireworkType;
import com.mtjanney.killeffects.effects.ParticleType;
import com.mtjanney.killeffects.effects.utilities.EffectType;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Command_KillEffects implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!command.getName().equalsIgnoreCase("killeffects") || !(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            // TODO: Display help message
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("firework")) {
                new FireworkType().display(player.getLocation().add(0, 1, 0), Color.RED);
            } else if (args[0].equalsIgnoreCase("swap")) {
                if (KillEffects.getSqLite().playerExists(player.getUniqueId())) {
                    if (KillEffects.getSqLite().getPlayerEffect(player.getUniqueId()) == 0) {
                        KillEffects.getSqLite().changePlayerEffect(player.getUniqueId(), 1);
                        System.out.println("Changed player's effectID=1");
                    } else {
                        System.out.println("Changed player's effectID=0");
                        KillEffects.getSqLite().changePlayerEffect(player.getUniqueId(), 0);
                    }
                }
            } else if (args[0].equalsIgnoreCase("particle")) {
                new ParticleType().display(player.getLocation(), EffectType.BUBBLE_POP);
            }
        } else {
            // TODO: Display a help message
        }

        return false;
    }
}

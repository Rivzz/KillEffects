package com.mtjanney.killeffects.commands;

import com.mtjanney.killeffects.KillEffects;
import com.mtjanney.killeffects.effects.FireworkType;
import com.mtjanney.killeffects.effects.ParticleType;
import com.mtjanney.killeffects.effects.utilities.EffectType;
import com.mtjanney.killeffects.effects.utilities.Execution;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Command_KillEffects extends Execution implements CommandExecutor {
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
            } else if (args[0].equalsIgnoreCase("particle")) {
                if (!KillEffects.getSqLite().playerExists(player.getUniqueId())) {
                    return false;
                }

                int effectID = KillEffects.getSqLite().getPlayerEffect(player.getUniqueId());

                if (effectID == 0) {
                    new FireworkType().display(player.getLocation().add(0, 1, 0), Color.RED);
                } else {
                    new ParticleType().display(player.getLocation(), convert(effectID));
                }
            }
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("set")) {
                int num = Integer.parseInt(args[1]);

                if (!KillEffects.getSqLite().playerExists(player.getUniqueId())) {
                    return false;
                }

                KillEffects.getSqLite().changePlayerEffect(player.getUniqueId(), num);
                System.out.println("Changed " + player.getUniqueId() + "'s effectID=" + num);
            }
        } else {
            // TODO: Display a help message
        }

        return false;
    }
}

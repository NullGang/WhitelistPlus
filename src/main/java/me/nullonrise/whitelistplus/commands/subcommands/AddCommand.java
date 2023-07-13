package me.nullonrise.whitelistplus.commands.subcommands;

import me.nullonrise.whitelistplus.WhitelistPlus;
import me.nullonrise.whitelistplus.commands.SubCommand;
import me.nullonrise.whitelistplus.utils.MessagesConfig;
import me.nullonrise.whitelistplus.utils.MsgManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class AddCommand extends SubCommand {
    private String name = "add";
    private String description = "add a player into the list.";
    private String syntax = "/wlp add <player>";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getSyntax() {
        return syntax;
    }

    @Override
    public void perform(Player player, String[] args) {
        if (player.hasPermission("whitelistplus.add")) {
            if (args.length > 1) {
                Player target = Bukkit.getPlayerExact(args[1]);
               if(WhitelistPlus.get().whitelised.contains(target.getName().toLowerCase())) {
                   player.sendMessage(MsgManager.Colored(MessagesConfig.get().getString("Messages.Prefix") + " " + MessagesConfig.get().getString("Messages.Error") + "Player is in the whitelist already"));
               }
                WhitelistPlus.get().whitelised.add(target.getName().toLowerCase());
                WhitelistPlus.get().getConfig().set("List", (Object) WhitelistPlus.get().whitelised);
                WhitelistPlus.get().getConfig().set("UseAsBlacklist", WhitelistPlus.get().useAsBlacklist);
                WhitelistPlus.get().getConfig().set("Enabled", WhitelistPlus.get().enabled);
                WhitelistPlus.get().saveConfig();
                player.sendMessage(MsgManager.Colored(MessagesConfig.get().getString("Messages.Prefix") + " " + MessagesConfig.get().getString("Messages.PlayerAdded")));
            } else {
                player.sendMessage(MsgManager.Colored(MessagesConfig.get().getString("Messages.Prefix") + " " + MessagesConfig.get().getString("Messages.Error") + "Player was not provided"));
            }
        }
    }
}

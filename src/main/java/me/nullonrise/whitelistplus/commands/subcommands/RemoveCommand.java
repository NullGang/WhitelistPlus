package me.nullonrise.whitelistplus.commands.subcommands;

import me.nullonrise.whitelistplus.WhitelistPlus;
import me.nullonrise.whitelistplus.commands.SubCommand;
import me.nullonrise.whitelistplus.utils.MessagesConfig;
import me.nullonrise.whitelistplus.utils.MsgManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

public class RemoveCommand extends SubCommand {
    private String name = "remove";
    private String description = "Remove a player off the list.";
    private String syntax = "/wlp remove <player>";

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
        if (player.hasPermission("whitelistplus.remove")) {
            if (args.length > 1) {
                Player target = Bukkit.getPlayerExact(args[1]);
                if(WhitelistPlus.get().whitelised.contains(target.getName().toLowerCase())) {
                    WhitelistPlus.get().whitelised.remove(target.getName().toLowerCase());
                    final FileConfiguration config = WhitelistPlus.get().getConfig();
                    config.set("List", (Object) WhitelistPlus.get().whitelised);
                    config.set("UseAsBlacklist", WhitelistPlus.get().useAsBlacklist);
                    config.set("Enabled", WhitelistPlus.get().enabled);
                    WhitelistPlus.get().saveConfig();
                    player.sendMessage(MsgManager.Colored(MessagesConfig.get().getString("Messages.Prefix") + " " + MessagesConfig.get().getString("Messages.PlayerRemoved")));
                } else {
                    player.sendMessage(MsgManager.Colored(MessagesConfig.get().getString("Messages.Prefix") + " " + MessagesConfig.get().getString("Messages.Error") + "Player is not in the list."));
                }
            } else {
                player.sendMessage(MsgManager.Colored(MessagesConfig.get().getString("Messages.Prefix") + " " + MessagesConfig.get().getString("Messages.Error") + "Player was not provided"));
            }
        }
    }
}

package me.nullonrise.whitelistplus.commands.subcommands;

import me.nullonrise.whitelistplus.WhitelistPlus;
import me.nullonrise.whitelistplus.commands.SubCommand;
import me.nullonrise.whitelistplus.utils.MessagesConfig;
import me.nullonrise.whitelistplus.utils.MsgManager;
import org.bukkit.entity.Player;
public class ReloadCommand extends SubCommand {
    private String name = "reload";
    private String description = "Reload the plugin config file.";
    private String syntax = "/wlp reload";

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
        if (args.length == 1) {
            WhitelistPlus.get().reloadConfig();
            MessagesConfig.reload();
            player.sendMessage(MsgManager.Colored(MessagesConfig.get().getString("Messages.Prefix") + " " + MessagesConfig.get().getString("Messages.Reload")));
        }
    }
}

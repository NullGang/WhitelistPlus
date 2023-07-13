package me.nullonrise.whitelistplus.commands.subcommands;

import me.nullonrise.whitelistplus.WhitelistPlus;
import me.nullonrise.whitelistplus.commands.SubCommand;
import me.nullonrise.whitelistplus.utils.MessagesConfig;
import me.nullonrise.whitelistplus.utils.MsgManager;
import org.bukkit.entity.Player;

public class EnableCommand extends SubCommand {
    private String name = "enable";
    private String description = "Enable the list.";
    private String syntax = "/wlp enable";

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
        if (player.hasPermission("whitelistplus.enable")) {
            if (args.length == 1) {
                WhitelistPlus.get().enabled = true;
                WhitelistPlus.get().getConfig().set("List", (Object) WhitelistPlus.get().whitelised);
                WhitelistPlus.get().getConfig().set("UseAsBlacklist", WhitelistPlus.get().useAsBlacklist);
                WhitelistPlus.get().getConfig().set("Enabled", WhitelistPlus.get().enabled);
                WhitelistPlus.get().saveConfig();
                player.sendMessage(MsgManager.Colored(MessagesConfig.get().getString("Messages.Prefix") + " " + MessagesConfig.get().getString("Messages.Enable")));
            }
        }
    }
}

package me.nullonrise.whitelistplus.commands.subcommands;

import me.nullonrise.whitelistplus.WhitelistPlus;
import me.nullonrise.whitelistplus.commands.SubCommand;
import me.nullonrise.whitelistplus.utils.MessagesConfig;
import me.nullonrise.whitelistplus.utils.MsgManager;
import org.bukkit.entity.Player;

public class BlackListCommand extends SubCommand {
    private String name = "type";
    private String description = "Set the whitelist type.";
    private String syntax = "/wlp type <type>";

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
        if (args.length > 1) {
            if (args[1].toLowerCase() == "blacklist") {
                WhitelistPlus.get().useAsBlacklist = true;
                WhitelistPlus.get().getConfig().set("List", (Object) WhitelistPlus.get().whitelised);
                WhitelistPlus.get().getConfig().set("UseAsBlacklist", WhitelistPlus.get().useAsBlacklist);
                WhitelistPlus.get().getConfig().set("Enabled", WhitelistPlus.get().enabled);
                WhitelistPlus.get().saveConfig();
                player.sendMessage(MsgManager.Colored(MessagesConfig.get().getString("Messages.Prefix") + " " + MessagesConfig.get().getString("Messages.BLOn")));
            }
            if (args[1].toLowerCase() == "whitelist") {
                WhitelistPlus.get().useAsBlacklist = false;
                WhitelistPlus.get().getConfig().set("List", (Object) WhitelistPlus.get().whitelised);
                WhitelistPlus.get().getConfig().set("UseAsBlacklist", WhitelistPlus.get().useAsBlacklist);
                WhitelistPlus.get().getConfig().set("Enabled", WhitelistPlus.get().enabled);
                WhitelistPlus.get().saveConfig();
                player.sendMessage(MsgManager.Colored(MessagesConfig.get().getString("Messages.Prefix") + " " + MessagesConfig.get().getString("Messages.WLOn")));
            }
            if (args[1].toLowerCase() != "whitelist" && args[1].toLowerCase() != "blacklist") {
                player.sendMessage(MsgManager.Colored(MessagesConfig.get().getString("Messages.Prefix") + " " + MessagesConfig.get().getString("Messages.Error") + "No type was provided. Use whitelist or blacklist."));
            }
        } else {
            player.sendMessage(MsgManager.Colored(MessagesConfig.get().getString("Messages.Prefix") + " " + MessagesConfig.get().getString("Messages.Error") + "No type was provided. Use whitelist or blacklist"));
        }
    }
}

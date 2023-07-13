package me.nullonrise.whitelistplus.commands.subcommands;

import me.nullonrise.whitelistplus.WhitelistPlus;
import me.nullonrise.whitelistplus.commands.SubCommand;
import me.nullonrise.whitelistplus.utils.MsgManager;
import org.bukkit.entity.Player;

public class ListCommand extends SubCommand {
    private String name = "list";
    private String description = "Show the players list.";
    private String syntax = "/wlp list";

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
            String names = "";
            for(final String str : WhitelistPlus.get().getConfig().getStringList("List")) {
                names = String.valueOf(names) + str + "&e&l, &7";
            }
            player.sendMessage(MsgManager.Colored("&e&lWhitelisted: &7" + names));
        }
    }
}

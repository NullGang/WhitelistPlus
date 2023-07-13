package me.nullonrise.whitelistplus.commands;

import me.nullonrise.whitelistplus.commands.subcommands.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor {
    private ArrayList<SubCommand> subcommands = new ArrayList<>();

    public CommandManager(){
        subcommands.add(new ReloadCommand());
        subcommands.add(new AddCommand());
        subcommands.add(new RemoveCommand());
        subcommands.add(new EnableCommand());
        subcommands.add(new DisableCommand());
        subcommands.add(new BlackListCommand());
        subcommands.add(new ListCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if (args.length > 0){
                for (int i = 0; i < getSubcommands().size(); i++){
                    if (args[0].equalsIgnoreCase(getSubcommands().get(i).getName())){
                        getSubcommands().get(i).perform(p, args);
                    }
                }
            }else if(args.length == 0){
                p.sendMessage("--------------------------------");
                p.sendMessage("§8§l[§f§lWhitelist§e§l+§8§l]");
                p.sendMessage(" ");
                for (int i = 0; i < getSubcommands().size(); i++){
                    p.sendMessage(getSubcommands().get(i).getSyntax() + " - " + getSubcommands().get(i).getDescription());
                }
                p.sendMessage(" ");
                p.sendMessage("§8§l[§f§lWhitelist§e§l+§8§l]");
                p.sendMessage("--------------------------------");
            }

        }


        return true;
    }

    public ArrayList<SubCommand> getSubcommands(){
        return subcommands;
    }

}

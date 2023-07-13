package me.nullonrise.whitelistplus;

import me.nullonrise.whitelistplus.commands.CommandManager;
import me.nullonrise.whitelistplus.commands.completer.CommandCompleter;
import me.nullonrise.whitelistplus.events.Join;
import me.nullonrise.whitelistplus.utils.MessagesConfig;
import me.nullonrise.whitelistplus.utils.MsgManager;
import org.bukkit.plugin.java.JavaPlugin;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;

public final class WhitelistPlus extends JavaPlugin {

    private static WhitelistPlus plugin;
    public ArrayList<String> whitelised = new ArrayList<>();
    public Boolean enabled = true;
    public Boolean useAsBlacklist = false;

    public static WhitelistPlus get() {
        return plugin;
    }
    @Override
    public void onEnable() {
        plugin = this;
        for(String names : getConfig().getStringList("List")) {
            if(!whitelised.contains(names)) {
                whitelised.add(names);
            }
        }
        getServer().getPluginManager().registerEvents(new Join(), this);
        getCommand("wlplus").setExecutor(new CommandManager());
        getCommand("wlplus").setTabCompleter(new CommandCompleter());
        getServer().getConsoleSender().sendMessage(MsgManager.Colored("&8&l[&f&lWHITELIST&e&l+&8&l] &ePlugin has started"));
        MessagesConfig.setup();
        MessagesConfig.get().createSection("Messages");
        MessagesConfig.get().addDefault("Messages.Prefix", "&8&l[&f&lWHITELIST&e&l+&8&l]");
        MessagesConfig.get().addDefault("Messages.NotListed", "&4You are not whitelisted or you are in the blacklist of this server.");
        MessagesConfig.get().addDefault("Messages.PlayerAdded", "&eSuccessfully added player into the list.");
        MessagesConfig.get().addDefault("Messages.PlayerRemove", "&eSuccessfully removed player off the list.");
        MessagesConfig.get().addDefault("Messages.Enable", "&eSuccessfully enabled the list.");
        MessagesConfig.get().addDefault("Messages.Disable", "&eSuccesfully disabled the whitelist.");
        MessagesConfig.get().addDefault("Messages.BLOn", "&eSuccesfully disabled the list.");
        MessagesConfig.get().addDefault("Messages.WLOn", "&eSuccessfully enabled the blacklist.");
        MessagesConfig.get().addDefault("Messages.Reload", "&eReloaded correctly.");
        MessagesConfig.get().addDefault("Messages.Error", "&4Error: ");
        MessagesConfig.get().options().copyDefaults(true);
        MessagesConfig.save();
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(MsgManager.Colored("&8&l[&f&lWHITELIST&e&l+&8&l] &eGoodbye!"));
    }
}

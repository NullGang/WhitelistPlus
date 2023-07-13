package me.nullonrise.whitelistplus.utils;

import org.bukkit.ChatColor;

public class MsgManager {
    public static String Colored(String text) {
        String result = ChatColor.translateAlternateColorCodes('&', text);
        return result;
    }
}

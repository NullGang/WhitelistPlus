package me.nullonrise.whitelistplus.events;

import me.nullonrise.whitelistplus.WhitelistPlus;
import me.nullonrise.whitelistplus.utils.MessagesConfig;
import me.nullonrise.whitelistplus.utils.MsgManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {
    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
      if(WhitelistPlus.get().getConfig().getBoolean("Enabled")) {
          if(WhitelistPlus.get().getConfig().getBoolean("UseAsBlacklist")) {
              if(WhitelistPlus.get().getConfig().getStringList("List").contains(player.getName().toLowerCase())) {
                  player.kickPlayer(MsgManager.Colored(MessagesConfig.get().getString("Messages.Prefix") + " " + MessagesConfig.get().getString("Messages.NotListed")));
              }
          } else {
              if(!WhitelistPlus.get().getConfig().getStringList("List").contains(player.getName().toLowerCase())) {
                  player.kickPlayer(MsgManager.Colored(MessagesConfig.get().getString("Messages.Prefix") +" " + MessagesConfig.get().getString("Messages.NotListed")));
              }
          }
      }
    }
}

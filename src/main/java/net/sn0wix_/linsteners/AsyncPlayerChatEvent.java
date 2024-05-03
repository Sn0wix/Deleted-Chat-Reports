package net.sn0wix_.linsteners;

import net.sn0wix_.DeletedChatReports;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class AsyncPlayerChatEvent implements Listener {
    private final DeletedChatReports main;
    private final String playerChatDisplayName;

    public AsyncPlayerChatEvent(DeletedChatReports main) {
        this.main = main;
        playerChatDisplayName = main.getConfig().getString("playerChatDisplayName");
    }

    @EventHandler
    public void asyncChatEvent(org.bukkit.event.player.AsyncPlayerChatEvent event){
        event.setCancelled(true);

        String message = event.getMessage();

        String playerChatName = playerChatDisplayName.replace("$PLAYERNAME$", event.getPlayer().getDisplayName());

        main.getServer().getOnlinePlayers().forEach(player -> player.sendMessage(playerChatName + message));
    }
}

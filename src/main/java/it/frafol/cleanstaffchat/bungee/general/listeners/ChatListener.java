package it.frafol.cleanstaffchat.bungee.general.listeners;

import it.frafol.cleanstaffchat.bungee.CleanStaffChat;
import it.frafol.cleanstaffchat.bungee.enums.BungeeConfig;
import it.frafol.cleanstaffchat.bungee.enums.BungeeMessages;
import it.frafol.cleanstaffchat.bungee.objects.PlayerCache;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ChatListener implements Listener {

    public final CleanStaffChat PLUGIN;

    public ChatListener(CleanStaffChat plugin) {
        this.PLUGIN = plugin;
    }

    @EventHandler
    public void onChat(ChatEvent event) {

        ProxiedPlayer player = (ProxiedPlayer) event.getSender();

        if (player.getServer() == null) {
            return;
        }
        Server server = player.getServer();

        if (PlayerCache.getMutedservers().contains(server.getInfo().getName()) || PlayerCache.getMutedservers().contains("all")) {

            if (player.hasPermission(BungeeConfig.MUTECHAT_BYPASS_PERMISSION.get(String.class))) {
                return;
            }

            player.sendMessage(TextComponent.fromLegacyText(BungeeMessages.STAFFCHAT_MUTED_ERROR.color()
                    .replace("%prefix%", BungeeMessages.PREFIX.color())));
            event.setCancelled(true);
        }
    }
}

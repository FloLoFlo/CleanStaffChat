package it.frafol.cleanstaffchat.bukkit.enums;

import it.frafol.cleanstaffchat.bukkit.CleanStaffChat;
import it.frafol.cleanstaffchat.bukkit.objects.PlayerCache;
import org.bukkit.ChatColor;

public enum SpigotMessages {

    PLAYER_ONLY("messages.console"),

    NO_PERMISSION("messages.no_permission"),

    PREFIX("messages.staffchat.prefix"),
    ADMINPREFIX("messages.adminchat.prefix"),
    DONORPREFIX("messages.donorchat.prefix"),

    DONORCHAT_COOLDOWN_MESSAGE("messages.donorchat.cooldown"),

    STAFFCHAT_FORMAT("messages.staffchat.staffchat_format"),
    ADMINCHAT_FORMAT("messages.adminchat.adminchat_format"),
    DONORCHAT_FORMAT("messages.donorchat.donorchat_format"),

    GLOBALPREFIX("messages.globalchat.prefix"),
    MUTECHAT_ENABLED("messages.globalchat.mutechat_enabled"),
    MUTECHAT_DISABLED("messages.globalchat.mutechat_disabled"),
    MUTECHAT_USAGE("messages.globalchat.mutechat_usage"),

    STAFFCHAT_MUTED_ERROR_DISCORD("messages.chat_muted_error_discord"),
    STAFFCHAT_MUTED_ERROR("messages.chat_muted_error"),
    ADMINCHAT_MUTED_ERROR("messages.chat_muted_error"),
    DONORCHAT_MUTED_ERROR("messages.chat_muted_error"),

    STAFFCHAT_AFK_ON("messages.staffchat.staff_afk_on_message_format"),
    STAFFCHAT_AFK_OFF("messages.staffchat.staff_afk_off_message_format"),

    STAFFCHAT_FORMAT_DISCORD("messages.staffchat.discord.staffchat_to_discord_format"),
    DONORCHAT_FORMAT_DISCORD("messages.donorchat.discord.donorchat_to_discord_format"),
    ADMINCHAT_FORMAT_DISCORD("messages.adminchat.discord.adminchat_to_discord_format"),

    STAFF_DISCORD_JOIN_MESSAGE_FORMAT("messages.staffchat.discord.discord_join_message_format"),
    STAFF_DISCORD_QUIT_MESSAGE_FORMAT("messages.staffchat.discord.discord_quit_message_format"),
    STAFF_JOIN_MESSAGE_FORMAT("messages.staffchat.staff_join_message_format"),
    STAFF_QUIT_MESSAGE_FORMAT("messages.staffchat.staff_quit_message_format"),

    COLOR_CODES("messages.deny_color_codes"),

    CONSOLE_PREFIX("settings.console_name"),

    ARGUMENTS("messages.staffchat.arguments"),
    ADMINARGUMENTS("messages.adminchat.arguments"),
    DONORARGUMENTS("messages.donorchat.arguments"),

    STAFFCHAT_TALK_ENABLED("messages.staffchat.staffchat_talk_enabled"),
    STAFFCHAT_TALK_DISABLED("messages.staffchat.staffchat_talk_disabled"),
    ADMINCHAT_TALK_ENABLED("messages.adminchat.adminchat_talk_enabled"),
    ADMINCHAT_TALK_DISABLED("messages.adminchat.adminchat_talk_disabled"),
    DONORCHAT_TALK_ENABLED("messages.donorchat.donorchat_talk_enabled"),
    DONORCHAT_TALK_DISABLED("messages.donorchat.donorchat_talk_disabled"),

    STAFFCHAT_MUTED("messages.staffchat.staffchat_muted"),
    STAFFCHAT_UNMUTED("messages.staffchat.staffchat_unmuted"),
    ADMINCHAT_MUTED("messages.adminchat.adminchat_muted"),
    ADMINCHAT_UNMUTED("messages.adminchat.adminchat_unmuted"),
    DONORCHAT_MUTED("messages.donorchat.donorchat_muted"),
    DONORCHAT_UNMUTED("messages.donorchat.donorchat_unmuted"),

    STAFFCHAT_TOGGLED_ON("messages.staffchat.staffchat_toggled_on"),
    STAFFCHAT_TOGGLED_OFF("messages.staffchat.staffchat_toggled_off"),
    ADMINCHAT_TOGGLED_ON("messages.adminchat.adminchat_toggled_on"),
    ADMINCHAT_TOGGLED_OFF("messages.adminchat.adminchat_toggled_off"),
    DONORCHAT_TOGGLED_ON("messages.donorchat.donorchat_toggled_on"),
    DONORCHAT_TOGGLED_OFF("messages.donorchat.donorchat_toggled_off"),

    RELOADED("messages.reloaded"),

    MODULE_DISABLED("messages.module_disabled"),

    DISCORD_STAFF_FORMAT("messages.staffchat.discord.staffchat_discord_format"),
    DISCORD_DONOR_FORMAT("messages.donorchat.discord.donorchat_discord_format"),
    DISCORD_ADMIN_FORMAT("messages.adminchat.discord.adminchat_discord_format"),

    LIST_HEADER("messages.stafflist.header"),
    LIST_FORMAT("messages.stafflist.format"),
    LIST_FOOTER("messages.stafflist.footer"),
    LIST_NONE("messages.stafflist.nobody"),
    LIST_USAGE("messages.stafflist.usage"),

    STAFFLIST_AFK("messages.stafflist.afk"),
    DISCORDLIST_AFK("messages.stafflist.discord.afk"),

    DISCORDLIST_HEADER("messages.stafflist.discord.header"),
    DISCORDLIST_FORMAT("messages.stafflist.discord.format"),
    DISCORDLIST_FOOTER("messages.stafflist.discord.footer"),
    DISCORDLIST_NONE("messages.stafflist.discord.nobody"),

    UPDATE("messages.new_version"),

    DONORCHAT_COOLDOWN_ERROR_DISCORD("messages.donorchat.discord.discord_cooldown_message");

    private final String path;
    public static final CleanStaffChat instance = CleanStaffChat.getInstance();

    SpigotMessages(String path) {
        this.path = path;
    }

    public <T> T get(Class<T> clazz) {
        return clazz.cast(instance.getMessagesTextFile().get(path));
    }

    public String color() {

        if (checkNonLegacy(instance.getServer().getVersion()) >= 0 && PlayerCache.hasColorCodes(get(String.class))) {
            return get(String.class).replaceAll("&#([A-Fa-f0-9]{6})", ChatColor.COLOR_CHAR + "x$1").replace("&", "§");
        }

        return get(String.class).replace("&", "§");
    }

    private int checkNonLegacy(String version) {
        return version.compareTo("1.16.5");
    }
}

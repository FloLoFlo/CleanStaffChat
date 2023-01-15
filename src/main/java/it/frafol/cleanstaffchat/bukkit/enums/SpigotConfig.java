package it.frafol.cleanstaffchat.bukkit.enums;

import it.frafol.cleanstaffchat.bukkit.CleanStaffChat;

public enum SpigotConfig {

    STAFFCHAT_JOIN_LEAVE_ALL("settings.staffchat.staff_join_all_players"),
    STAFFCHAT_QUIT_ALL("settings.staffchat.staff_quit_all_players"),

    HIDE_ADVERTS("settings.hide_advertisements"),

    STAFFCHAT_AFK_MODULE("modules.staffchat_afk_module"),
    STAFFCHAT_NO_AFK_ONCHANGE_SERVER("settings.staffchat.staff_disable_afk_on_move"),
    STAFFCHAT_AFK_PERMISSION("settings.staffchat.staffchat_afk_permission"),

    STAFF_JOIN_MESSAGE("settings.staffchat.staff_join_message"),
    STAFF_QUIT_MESSAGE("settings.staffchat.staff_quit_message"),
    COOLDOWN_BYPASS_DISCORD("settings.donorchat.donorchat_discord_cooldown_bypass"),
    COOLDOWN_BYPASS_PERMISSION("settings.donorchat.donorchat_cooldown_bypass_permission"),
    JOIN_LEAVE_DISCORD_MODULE("modules.staffchat_discord_join_leave_module"),

    STAFFCHAT_USE_PERMISSION("settings.staffchat.staffchat_use_permission"),
    ADMINCHAT_USE_PERMISSION("settings.adminchat.adminchat_use_permission"),
    DONORCHAT_USE_PERMISSION("settings.donorchat.donorchat_use_permission"),

    PREVENT_COLOR_CODES("settings.prevent_color_codes"),
    DONOR_TIMER("settings.donorchat.cooldown"),

    CONSOLE_PREFIX("settings.console_name"),

    STAFFCHAT_TALK_MODULE("modules.staffchat_talk_module"),
    ADMINCHAT_TALK_MODULE("modules.adminchat_talk_module"),
    DONORCHAT_TALK_MODULE("modules.donorchat_talk_module"),

    STAFFCHAT_MUTE_MODULE("modules.staffchat_mute_module"),
    ADMINCHAT_MUTE_MODULE("modules.adminchat_mute_module"),
    DONORCHAT_MUTE_MODULE("modules.donorchat_mute_module"),
    STAFFCHAT_MUTE_PERMISSION("settings.staffchat.staffchat_mute_permission"),
    ADMINCHAT_MUTE_PERMISSION("settings.adminchat.adminchat_mute_permission"),
    DONORCHAT_MUTE_PERMISSION("settings.donorchat.donorchat_mute_permission"),

    STAFFCHAT_TOGGLE_MODULE("modules.staffchat_toggle_module"),
    ADMINCHAT_TOGGLE_MODULE("modules.adminchat_toggle_module"),
    DONORCHAT_TOGGLE_MODULE("modules.donorchat_toggle_module"),

    STAFFCHAT_RELOAD_PERMISSION("settings.reload_permission"),

    CONSOLE_CAN_TALK("settings.console_staffchat"),
    STAFFCHAT_TOGGLE_PERMISSION("settings.staffchat.staffchat_toggle_permission"),
    ADMINCHAT_TOGGLE_PERMISSION("settings.adminchat.adminchat_toggle_permission"),
    DONORCHAT_TOGGLE_PERMISSION("settings.donorchat.donorchat_toggle_permission"),

    STATS("modules.stats"),

    UPDATE_CHECK("modules.update_check"),

    STAFFCHAT_DISCORD_MODULE("modules.staffchat_discord_module"),
    ADMINCHAT_DISCORD_MODULE("modules.adminchat_discord_module"),
    DONORCHAT_DISCORD_MODULE("modules.donorchat_discord_module"),

    STAFFCHAT("settings.use_staffchat"),
    ADMINCHAT("settings.use_adminchat"),
    DONORCHAT("settings.use_donorchat");

    private final String path;
    public static final CleanStaffChat instance = CleanStaffChat.getInstance();

    SpigotConfig(String path) {
        this.path = path;
    }

    public <T> T get(Class<T> clazz) {
        return clazz.cast(instance.getConfigTextFile().get(path));
    }

    public String color() {
        return get(String.class).replace("&", "§");
    }
}

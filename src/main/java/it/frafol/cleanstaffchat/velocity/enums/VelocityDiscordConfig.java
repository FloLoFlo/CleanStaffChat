package it.frafol.cleanstaffchat.velocity.enums;

import it.frafol.cleanstaffchat.velocity.CleanStaffChat;

public enum VelocityDiscordConfig {

    USE_EMBED("discord.embeds.use_embeds"),

    EMBEDS_STAFFCHATCOLOR("discord.embeds.staffchat_color"),
    EMBEDS_ADMINCHATCOLOR("discord.embeds.adminchat_color"),
    EMBEDS_DONORCHATCOLOR("discord.embeds.donorchat_color"),

    EMBEDS_FOOTER("discord.embeds.footer"),
    FORWARD_BOT("discord.forward_bot_messages"),

    STAFFCHAT_EMBED_TITLE("discord.staffchat_embed_title"),
    ADMINCHAT_EMBED_TITLE("discord.adminchat_embed_title"),
    DONORCHAT_EMBED_TITLE("discord.donorchat_embed_title"),
    STAFFLIST_EMBED_TITLE("discord.stafflist_embed_title"),

    DISCORD_ENABLED("discord.enabled"),
    DISCORD_TOKEN("discord.token"),
    DISCORD_ACTIVITY_TYPE("discord.activity_type"),
    DISCORD_ACTIVITY("discord.activity"),
    STAFF_CHANNEL_ID("discord.staffchat_channel_id"),
    STAFFLIST_CHANNEL_ID("discord.stafflist_channel_id"),
    DONOR_CHANNEL_ID("discord.donorchat_channel_id"),
    ADMIN_CHANNEL_ID("discord.adminchat_channel_id");

    private final String path;
    public static final CleanStaffChat instance = CleanStaffChat.getInstance();

    VelocityDiscordConfig(String path) {
        this.path = path;
    }

    public <T> T get(Class<T> clazz) {
        return clazz.cast(instance.getDiscordTextFile().getConfig().get(path));
    }

}

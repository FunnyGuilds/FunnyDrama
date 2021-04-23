package net.funnyguilds.drama.discord.webhook

data class DiscordWebhook(
    val content: String?,
    val embeds: List<DiscordWebhooksEmbed>
)

package net.funnyguilds.drama.discord.webhook

data class DiscordWebhooksEmbed(
    val title: String,
    val description: String,
    var url: String? = null,
    var color: Int = 16723502
)

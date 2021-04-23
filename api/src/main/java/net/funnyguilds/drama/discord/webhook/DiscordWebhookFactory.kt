package net.funnyguilds.drama.discord.webhook

import org.springframework.stereotype.Service

@Service
class DiscordWebhookFactory {

    fun createDramaAlert(drama: String): DiscordWebhook {
        return DiscordWebhook(null, listOf(DiscordWebhooksEmbed("Latest Drama News", drama)))
    }
}

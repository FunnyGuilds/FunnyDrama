package net.funnyguilds.drama.discord

import kong.unirest.UnirestInstance
import net.funnyguilds.drama.discord.webhook.DiscordWebhookFactory
import net.funnyguilds.drama.provider.DramaProvider
import org.springframework.http.MediaType

class DiscordDramaProviderImpl(
    val dramaProvider: DramaProvider,
    val unirest: UnirestInstance,
    val discordWebhookFactory: DiscordWebhookFactory
) : DiscordDramaProvider {

    override fun dispatchWebhook(url: String) {
        unirest.post(url)
            .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            .body(discordWebhookFactory.createDramaAlert(dramaProvider.create()))
            .asString()
    }
}

package net.funnyguilds.drama.discord

interface DiscordDramaProvider {
    fun dispatchWebhook(url: String)
}

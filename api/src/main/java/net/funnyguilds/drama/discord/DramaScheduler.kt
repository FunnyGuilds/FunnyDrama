package net.funnyguilds.drama.discord

import net.funnyguilds.drama.config.DiscordConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
@EnableScheduling
class DramaScheduler {

    @Autowired private lateinit var discordConfig: DiscordConfig
    @Autowired private lateinit var discordDramaProvider: DiscordDramaProvider

    @Scheduled(cron = "0 0 0 * * *")
    fun midnightDrama() {
        discordConfig.midnightDramaHooks.forEach { url -> discordDramaProvider.dispatchWebhook(url) }
    }
}
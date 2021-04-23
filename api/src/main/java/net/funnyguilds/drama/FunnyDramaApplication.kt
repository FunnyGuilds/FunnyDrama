package net.funnyguilds.drama

import com.sun.org.slf4j.internal.LoggerFactory
import kong.unirest.Unirest
import net.funnyguilds.drama.config.ConfigurationFactory
import net.funnyguilds.drama.config.DiscordConfig
import net.funnyguilds.drama.config.DramaConfig
import net.funnyguilds.drama.discord.DiscordDramaProvider
import net.funnyguilds.drama.discord.DiscordDramaProviderImpl
import net.funnyguilds.drama.discord.webhook.DiscordWebhookFactory
import net.funnyguilds.drama.provider.DramaProvider
import net.funnyguilds.drama.provider.DramaProviderImpl
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import java.io.File

@SpringBootApplication
open class FunnyDramaApplication {

    @Bean("dramaConfig")
    open fun configureDrama(configurationFactory: ConfigurationFactory): DramaConfig {
        return configurationFactory.createAndLoadConfig(DramaConfig::class.java, File("drama.hjson"))
    }

    @Bean("dramaProvider")
    open fun configureProvider(config: DramaConfig): DramaProvider {
        return DramaProviderImpl(config)
    }

    @Bean("discordConfig")
    open fun configureDiscord(configurationFactory: ConfigurationFactory): DiscordConfig {
        return configurationFactory.createAndLoadConfig(DiscordConfig::class.java, File("discord.hjson"))
    }

    @Bean("discordDramaProvider")
    open fun configureProvider(dramaProvider: DramaProvider, webhookFactory: DiscordWebhookFactory): DiscordDramaProvider {
        return DiscordDramaProviderImpl(dramaProvider, Unirest.spawnInstance(), webhookFactory)
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(FunnyDramaApplication::class.java)
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(FunnyDramaApplication::class.java, *args)
        }
    }
}
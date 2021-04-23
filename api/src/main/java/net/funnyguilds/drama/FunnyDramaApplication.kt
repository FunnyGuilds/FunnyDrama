/**
 * FunnyDrama
 * Copyright (C) 2021  Okaeri, Dawid Sawicki
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.funnyguilds.drama

import kong.unirest.Unirest
import net.funnyguilds.drama.config.ConfigurationFactory
import net.funnyguilds.drama.config.DiscordConfig
import net.funnyguilds.drama.config.DramaConfig
import net.funnyguilds.drama.discord.DiscordDramaProvider
import net.funnyguilds.drama.discord.DiscordDramaProviderImpl
import net.funnyguilds.drama.discord.webhook.DiscordWebhookFactory
import net.funnyguilds.drama.provider.DramaProvider
import net.funnyguilds.drama.provider.DramaProviderImpl
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
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
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<FunnyDramaApplication>(*args)
        }
    }
}
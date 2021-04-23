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

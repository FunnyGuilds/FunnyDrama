package net.funnyguilds.drama.config

import eu.okaeri.configs.OkaeriConfig
import eu.okaeri.configs.annotation.NameModifier
import eu.okaeri.configs.annotation.NameStrategy
import eu.okaeri.configs.annotation.Names

@Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
class DiscordConfig : OkaeriConfig() {
    var midnightDramaHooks = listOf("https://discord.com/api/webhooks/x/y")
}

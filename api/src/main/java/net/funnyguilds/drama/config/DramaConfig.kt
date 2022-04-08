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
package net.funnyguilds.drama.config

import eu.okaeri.configs.OkaeriConfig
import eu.okaeri.configs.annotation.NameModifier
import eu.okaeri.configs.annotation.NameStrategy
import eu.okaeri.configs.annotation.Names

@Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
class DramaConfig : OkaeriConfig() {

    var staticElements: MutableMap<String, List<String>> = linkedMapOf(
        "people" to listOf(
            "greg", "MrGregorix", "Dzikoysk", "Daffit", "GotoFinal", "PinkLolicorn", "CDFN", "Oksi",
            "wvffle", "kamcio96", "junior", "Peridot", "Rekseto", "Rivendell", "Rollczi", "szymex73",
            "insertt", "makub", "Immutable", "crejk", "bopke", "bobekrobal", "kacperduras", "NorthPL93",
            "musib spieler", "Kamilkime", "error", "Maciuś", "kernel", "WcaleNieWolny", "TheMolkaPL"
        ),
        "sites" to listOf(
            "Bookkity", "Okaeri Community", "okaeri.eu", "manager.okaeri.eu", "funnyguilds.dzikoysk.net",
            "funnyguilds.net", "panda-lang.org", "blog.gotofinal.com"
        ),
        "packs" to listOf(
            "maven central", "spigotmc index", "crates.io", "npm", "okaeri's maven", "reposilite", "panda's repo"
        ),
        "things" to listOf(
            "FunnyGuilds", "FunnyOS", "FunnyCommands", "FunnySkAddon", "Panda Language", "dzikoysk/dependency-injector", "panda-utilities", "Light", "Skript",
            "NovaGuilds", "SklepMC", "TopkaMC", "NoProxy", "AiCensor"
        ),
        "function" to listOf(
            "GotoSoft libraries", "GregSoft libraries", "Okaeri libraries", "Panda libraries", "PlaceholderAPI support", "PAPI support", "HolographicDisplays support",
            "new configuration format", "new database backend", "bloated source parts", "untrusted libraries", "less drama", "more drama"
        ),
        "adj" to listOf(
            "bad", "wrong", "illegal", "horrible", "nasty", "noncompliant with Mojang's EULA", "a serious problem", "incompatible",
            "a waste of time", "wonderful", "amazing", "toxic", "too vanilla", "shameful", "disappointing", "bloated", "outdated", "incorrect",
            "full of drama", "too realistic", "not enterprise", "not pure", "anti-patternish"
        ),
        "branches" to listOf(
            "master", "5.0"
        ),
        "classes" to listOf(
            "FunnyGuildsLogger", "PluginConfiguration", "DataModel", "DataPersistenceHandler", "DummyManager",
            "RankManager", "KickAdminCommand", "KickCommand", "PlayerJoin", "LeaveCommand", "BreakCommand",
            "WorldGuard7Hook", "JoinCommand", "ConcurrencyManager", "GuildUtils", "DummyGlobalUpdateRequest",
            "IndividualPrefixManager", "Guild", "FunnybinRequest"
        ),
        "badsoft" to listOf(
            "malware", "spyware", "adware", "DRM", "viruses", "trojans", "keyloggers", "stolen code", "easter eggs",
            "potential login stealers", "adf.ly links", "bad code", "stolen assets", "malicious code", "secret backdoors",
            "Lombok"
        ),
        "drama" to listOf(
            "bugs", "crashes", "drama", "lots of drama", "imbalance", "pain and suffering", "piracy", "adf.ly"
        ),
        "crash" to listOf(
            "crash", "explode", "break", "lag", "blow up", "corrupt chunks", "corrupt worlds"
        ),
        "ban" to listOf(
            "ban", "kick", "put a pumpkin of shame on", "add items mocking", "blacklist", "whitelist", "give admin rights to", "shame", "destroy"
        ),
        "code" to listOf(
            "code", "assets", "ideas", "concepts", "a single function", "5 lines of code", "a class", "a few files", "a ZIP file", "Gradle buildscripts",
            "a GitHub repository"
        ),
        "worse" to listOf(
            "worse", "better", "faster", "slower", "more stable", "less buggy"
        ),
        "ac1" to listOf(
            "sue", "destroy the life of", "flame", "cause drama about", "complain about", "kick"
        ),
        "price" to listOf(
            "200$", "250$", "300$", "350$", "400$", "450$", "500$", "600$"
        ),
        "activates" to listOf(
            "activates", "works", "functions", "breaks"
        ),
        "says" to listOf(
            "says", "tweets", "claims", "confirms", "denies"
        ),
        "enormous" to listOf(
            "big", "large", "huge", "gigantic", "enormous"
        ),
        "mcversion" to listOf(
            "1.6.4", "1.7.2", "1.8.8", "1.9.4", "1.10.2", "1.11.2", "1.12.2", "1.13.2", "1.14.4", "1.15.2", "1.16.5", "1.17.1", "1.18.2"
        ),
        "channels" to listOf(
            "#general", "#coding", "#support", "#secret", "#chinskie"
        )
    )

    var sentences = listOf(
        "[people] removes all channels except [channels]",
        "[people] wants to [ac1] [people] saying they only use [channels] channel",
        "[people] posts to replace [function] with [function] in [things]",
        "[people] accidentialy removes the [branches] branch",
        "[people] accidentialy removes the [branches] branch of [things]",
        "[poeple] threatens to [ac1] [people] until they add support for Minecraft [mcversion]",
        "Last update by [people] causes [things] to run [worse] on Minecraft [mcversion]",
        "[people] makes change in [classes] making it incompatible with Minecraft [mcversion]",
        "[people] says [things] will go up in smoke",
        "[people] launched a DoS attack on the website of [things]",
        "[sites] urges everyone to stop using [things]",
        "After a [enormous] amount of requests, [packs] removes [things]",
        "After a [enormous] amount of requests, [packs] adds [things]",
        "After a [enormous] amount of requests, [packs] adds [function] to [things]",
        "[people] plays [things] on Twitch",
        "[people] fixes [function] in [things] to be unlike [things]",
        "[things] makes [things] [crash], [sites] users complain",
        "[people] complained about being in [things] on [sites]",
        "[people] releases [code] of [things] for [price]",
        "[sites] considers [things] worse than [things]",
        "[people] made [things] depend on [things]",
        "[people] bans [people] from using [things] in [packs]",
        "[people] complains that [things] discussion doesn't belong on [sites]",
        "[people] has a Patreon goal to add [function] to [things] for [price] a month",
        "[people] has a Patreon goal to add [things] compatibility to [things] for [price] a month",
        "[people] complains that [people] replaced [things] by [things]",
        "[people] complains that [people] replaced [things] by [things] in [packs]",
        "[people] complains that [people] removed [function] in [packs]",
        "[people] decided that [things] is too [adj] and replaced it with [things]",
        "[people] [says] [things] is [adj].",
        "[people] [says] [things] is literally [adj].",
        "[things] is not updated for the latest version of Minecraft.",
        "[people] removes [things] from [packs].",
        "[people] adds [things] to [packs].",
        "[people] quits modding. Fans of [things] rage.",
        "[people] is found to secretly like [things]",
        "[people] openly hates [function] in [things]",
        "[people] threatens to [ac1] [people] until they remove [things] from [packs]",
        "[people] threatens to [ac1] [people] until they remove [function] from [things]",
        "[people] threatens to [ac1] [people] until they add [function] to [things]",
        "[people] came out in support of [things]",
        "[people] came out in support of [drama]",
        "[people] and [people] came out in support of [drama]",
        "[people] came out against [drama], [sites] rages",
        "[people] and [people] came out against [drama], [sites] rages",
        "[people] forks [things] causing [drama]",
        "[people] [says] to replace [things] with [things]",
        "[people] [says] [people] causes drama",
        "[things] fans claim that [things] should be more like [things]",
        "[things] fans claim that [things] should have better [function]",
        "[people] [says] that [things] should be more like [things]",
        "[people] [says] that [things] should be less like [things]",
        "[people] rebalances [things] for [packs]",
        "[people] adds [function] to [things] by request of [people]",
        "[people] removes [function] from [things] by request of [people]",
        "[people] removes compatibility between [things] and [things] by request of [people]",
        "[people] [says] [people]'s attitude is [adj]",
        "[people] [says] [sites]'s attitude is [adj]",
        "[people] quits the development team of [things]",
        "[people] [says] [things] is too much like [things]",
        "[people] [says] [things] is a ripoff of [things]",
        "[people] [says] [people] stole [code] from [people]",
        "[people] [says] [people] did not steal [code] from [people]",
        "[people] decides to [ban] [people] from [packs]",
        "[things] doesn't work with [things] since the latest update",
        "[people] sues [things]",
        "[people] [says] [things] is [adj] on [sites]",
        "[people] [says] [things] is full of [badsoft]",
        "[people] [says] [things] causes [drama]",
        "[people] [says] [things] causes [drama] when used with [things]",
        "[people] [says] using [things] and [things] together is [adj]",
        "[people] rants about [things] on [sites]",
        "[people] rants about [function] in mods on [sites]",
        "[people] steals code from [things]",
        "[things] breaks [function]",
        "[people] sues [things] developers",
        "[people] reminds you that [things] is [adj]",
        "[people] and [people] get into a drama fight on [sites]",
        "Fans of [things] and [things] argue on [sites]",
        "[people] and [people] argue about [things]",
        "[people] puts [badsoft] in [things]",
        "[people] complains about [things] breaking [things]",
        "[people] complains about [things] breaking [function]",
        "[people] complains about [things] including [function]",
        "[things] breaks [function] in [things]",
        "[things] breaks [things] support in [things]",
        "[things] adds code to [ban] [people] automatically",
        "[things] adds code to [ban] people using [things]",
        "[things] removes compatibility with [things]",
        "[people] [says] not to use [things]",
        "[people] [says] not to use [things] with [things]",
        "[people] finds [badsoft] in [things]",
        "[people] drew a nasty graffiti about [people]",
        "[people] drew a nasty graffiti about [things]",
        "[things] makes [things] [crash] when used with [things]",
        "[things] makes [things] [crash] when used by [people]",
        "[things] makes [things] crash [things] when used by [people]",
        "[things] adds [badsoft] that only [activates] in [packs]",
        "[things] adds [badsoft] that only [activates] alongside [things]",
        "[things] makes [people] invincible from [things] in [packs]",
        "[people] decides to base their entire modpack on [things]",
        "[people] tweaks balance in [things] too much, annoying [sites]",
        "[people] tweaks balance in [things] too much, annoying [people]",
        "[people] [says] [people] is worse than [people]",
        "[people] [says] [things] is [worse] than [things]",
        "[people] bans [people] from [sites]"
    )
}

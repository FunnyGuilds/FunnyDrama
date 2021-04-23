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
package net.funnyguilds.drama.provider

import net.funnyguilds.drama.config.DramaConfig
import org.slf4j.LoggerFactory
import java.util.concurrent.ThreadLocalRandom
import java.util.regex.Matcher
import java.util.regex.Pattern

class DramaProviderImpl(
    val config: DramaConfig
) : DramaProvider {

    override fun create(): String {
        return try {
            tryCreate()
        } catch (exception: DramaProviderException) {
            LOGGER.info("failed #tryCreate: " + exception.message)
            create()
        }
    }

    @Throws(DramaProviderException::class)
    fun tryCreate(): String {

        val elements: Map<String, List<String>> = config.staticElements
        val sentences: List<String> = config.sentences

        val random = ThreadLocalRandom.current()
        var sentence = sentences[random.nextInt(sentences.size)]

        val matcher = FIELD_PATTERN.matcher(sentence)
        val alreadyUsed: MutableSet<String> = HashSet()

        while (matcher.find()) {

            val fieldFull = matcher.group(0)
            val fieldType = matcher.group("name")

            if (!elements.containsKey(fieldType)) {
                throw DramaProviderException("cannot find values for field of type: " + fieldType + " [available: " + java.lang.String.join(", ", elements.keys) + "]")
            }

            val fieldElements = elements[fieldType]!!
            var randomValue = fieldElements[random.nextInt(fieldElements.size)]

            while (!alreadyUsed.add(randomValue)) {
                randomValue = fieldElements[random.nextInt(fieldElements.size)]
            }

            sentence = sentence.replaceFirst(Pattern.quote(fieldFull).toRegex(), Matcher.quoteReplacement(randomValue))
        }

        return sentence
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(DramaProviderImpl::class.java)
        private val FIELD_PATTERN = Pattern.compile("\\[(?<name>[a-zA-Z0-9_]+)\\]")
    }
}

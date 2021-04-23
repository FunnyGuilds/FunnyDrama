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

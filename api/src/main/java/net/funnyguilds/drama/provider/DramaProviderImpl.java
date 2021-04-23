package net.funnyguilds.drama.provider;

import lombok.RequiredArgsConstructor;
import net.funnyguilds.drama.config.DramaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class DramaProviderImpl implements DramaProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(DramaProviderImpl.class);
    private static final Pattern FIELD_PATTERN = Pattern.compile("\\[(?<name>[a-zA-Z0-9_]+)\\]");

    private final DramaConfig config;

    @Override
    public String create() {
        try {
            return this.tryCreate();
        } catch (DramaProviderException exception) {
            LOGGER.info("failed #tryCreate: " + exception.getMessage());
            return this.create();
        }
    }

    public String tryCreate() throws DramaProviderException {

        Map<String, List<String>> elements = this.config.getStaticElements();
        List<String> sentences = this.config.getSentences();

        ThreadLocalRandom random = ThreadLocalRandom.current();
        String sentence = sentences.get(random.nextInt(sentences.size()));

        Matcher matcher = FIELD_PATTERN.matcher(sentence);
        Set<String> alreadyUsed = new HashSet<>();

        while (matcher.find()) {

            String fieldFull = matcher.group(0);
            String fieldType = matcher.group("name");

            if (!elements.containsKey(fieldType)) {
                throw new DramaProviderException("cannot find values for field of type: " + fieldType + " [available: " + String.join(", ", elements.keySet()) + "]");
            }

            List<String> fieldElements = elements.get(fieldType);
            String randomValue = fieldElements.get(random.nextInt(fieldElements.size()));

            while (!alreadyUsed.add(randomValue)) {
                randomValue = fieldElements.get(random.nextInt(fieldElements.size()));
            }

            sentence = sentence.replaceFirst(Pattern.quote(fieldFull), Matcher.quoteReplacement(randomValue));
        }

        return sentence;
    }
}

package net.funnyguilds.drama;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import kong.unirest.Unirest;
import net.funnyguilds.drama.config.ConfigurationFactory;
import net.funnyguilds.drama.config.DiscordConfig;
import net.funnyguilds.drama.config.DramaConfig;
import net.funnyguilds.drama.discord.DiscordDramaProvider;
import net.funnyguilds.drama.discord.DiscordDramaProviderImpl;
import net.funnyguilds.drama.discord.webhook.DiscordWebhookFactory;
import net.funnyguilds.drama.provider.DramaProvider;
import net.funnyguilds.drama.provider.DramaProviderImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class FunnyDramaApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(FunnyDramaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FunnyDramaApplication.class, args);
    }

    @Bean("dramaConfig")
    public DramaConfig configureDrama(ConfigurationFactory configurationFactory) {
        return configurationFactory.createAndLoadConfig(DramaConfig.class, new File("drama.hjson"));
    }

    @Bean("dramaProvider")
    public DramaProvider configureProvider(DramaConfig config) {
        return new DramaProviderImpl(config);
    }

    @Bean("discordConfig")
    public DiscordConfig configureDiscord(ConfigurationFactory configurationFactory) {
        return configurationFactory.createAndLoadConfig(DiscordConfig.class, new File("discord.hjson"));
    }

    @Bean("discordDramaProvider")
    public DiscordDramaProvider configureProvider(DramaProvider dramaProvider, DiscordWebhookFactory webhookFactory) {
        return new DiscordDramaProviderImpl(dramaProvider, Unirest.spawnInstance(), webhookFactory);
    }
}
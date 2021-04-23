package net.funnyguilds.drama.discord;

import net.funnyguilds.drama.config.DiscordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class DramaScheduler {

    @Autowired private DiscordConfig discordConfig;
    @Autowired private DiscordDramaProvider discordDramaProvider;

    @Scheduled(cron = "0 0 0 * * *")
    public void midnightDrama() {
        this.discordConfig.getMidnightDramaHooks().forEach(this.discordDramaProvider::dispatchWebhook);
    }
}

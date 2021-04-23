package net.funnyguilds.drama.discord.webhook;

import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class DiscordWebhookFactory {

    public DiscordWebhook createDramaAlert(String drama) {
        DiscordWebhook webhook = new DiscordWebhook();
        DiscordWebhooksEmbed embed = new DiscordWebhooksEmbed();
        embed.setTitle("Latest Drama News");
        embed.setDescription(drama);
        webhook.setEmbeds(Collections.singletonList(embed));
        return webhook;
    }
}

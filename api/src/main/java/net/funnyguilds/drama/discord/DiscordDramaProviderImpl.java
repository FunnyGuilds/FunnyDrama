package net.funnyguilds.drama.discord;

import kong.unirest.UnirestInstance;
import lombok.RequiredArgsConstructor;
import net.funnyguilds.drama.discord.webhook.DiscordWebhookFactory;
import net.funnyguilds.drama.provider.DramaProvider;
import org.springframework.http.MediaType;

@RequiredArgsConstructor
public class DiscordDramaProviderImpl implements DiscordDramaProvider {

    private final DramaProvider dramaProvider;
    private final UnirestInstance unirest;
    private final DiscordWebhookFactory discordWebhookFactory;

    @Override
    public void dispatchWebhook(String url) {
        this.unirest.post(url)
                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .body(this.discordWebhookFactory.createDramaAlert(this.dramaProvider.create()))
                .asString();
    }
}

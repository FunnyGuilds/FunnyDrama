package net.funnyguilds.drama.discord.webhook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscordWebhooksEmbed {
    private String title;
    private String description;
    private String url;
    private int color = 16723502;
}

package net.funnyguilds.drama.discord.webhook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscordWebhook {
    private String content;
    private List<DiscordWebhooksEmbed> embeds;
}

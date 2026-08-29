package com.company.tpm.telegram;

import com.company.tpm.config.AppProperties;
import jakarta.annotation.PostConstruct;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class TelegramBotClient {
    private final AppProperties props;
    private final RestClient http = RestClient.create();

    public TelegramBotClient(AppProperties p) {
        props = p;
    }

    @PostConstruct
    public void registerWebhook() {
        if (!props.telegram().enabled()) {
            return;
        }

        String token = props.telegram().botToken();
        String secret = props.telegram().webhookSecret();
        String publicUrl = props.publicBaseUrl();

        if (token == null || token.isBlank()) {
            throw new IllegalStateException("Telegram token is required when TELEGRAM_ENABLED=true");
        }
        if (secret == null || secret.isBlank()) {
            throw new IllegalStateException("Telegram webhook secret is required when TELEGRAM_ENABLED=true");
        }
        if (publicUrl == null || publicUrl.isBlank()) {
            throw new IllegalStateException("PUBLIC_BASE_URL is required when TELEGRAM_ENABLED=true");
        }

        String webhookUrl = publicUrl.replaceAll("/?$", "") + "/telegram/webhook";
        http.post()
            .uri("https://api.telegram.org/bot" + token + "/setWebhook")
            .body(Map.of(
                "url", webhookUrl,
                "secret_token", secret,
                "drop_pending_updates", true
            ))
            .retrieve()
            .toBodilessEntity();
    }

    public void send(long chatId, String text) {
        if (!props.telegram().enabled()) {
            return;
        }

        String token = props.telegram().botToken();
        if (token == null || token.isBlank()) {
            throw new IllegalStateException("Telegram token is required when enabled");
        }

        http.post()
            .uri("https://api.telegram.org/bot" + token + "/sendMessage")
            .body(Map.of("chat_id", chatId, "text", text))
            .retrieve()
            .toBodilessEntity();
    }
}


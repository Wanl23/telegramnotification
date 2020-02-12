package taxi.anji.telegramnotification.controller.service;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import taxi.anji.telegramnotification.controller.model.ChatID;
import java.util.Collections;
import java.util.Set;

public class TelegramSender {

    public static void sendToBot(Set<ChatID> chatIDS, String message, String botToken) {
        chatIDS.forEach(c -> {
            final RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.telegram.org/bot" + botToken + "/sendMessage?"
                    + "chat_id=" + c
                    + "&message=" + message;
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>("body", headers);
            restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        });
    }
}

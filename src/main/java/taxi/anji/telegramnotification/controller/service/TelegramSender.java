package taxi.anji.telegramnotification.controller.service;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import taxi.anji.telegramnotification.controller.model.ChatID;
import java.util.Collections;
import java.util.Set;

public class TelegramSender {
    //    curl -s --header "Content-Type:application/json"
//    --request 'POST'
//    --data "{\"chat_id\":\"${chat}\",\"text\":\"${message}\"}"
//    "https://api.telegram.org/bot${BOT_TOKEN}/sendMessage"

    public static void send(Set<ChatID> chatIDS, String message, String botToken) {
        chatIDS.forEach(c -> {
            final RestTemplate restTemplate = new RestTemplate();

            String url = "http://localhost:8080/telegram_notification_war/test?"
                    + "chatID=" + c
                    + "&message=" + message
                    + "&botToken=" + botToken;
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>("body", headers);
            ResponseEntity<String> stringPosts = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        });


    }
}

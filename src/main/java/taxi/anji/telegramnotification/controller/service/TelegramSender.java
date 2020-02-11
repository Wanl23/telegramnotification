package taxi.anji.telegramnotification.controller.service;

import com.sun.net.httpserver.Headers;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class TelegramSender {
    //    curl -s --header "Content-Type:application/json"
//    --request 'POST'
//    --data "{\"chat_id\":\"${chat}\",\"text\":\"${message}\"}"
//    "https://api.telegram.org/bot${BOT_TOKEN}/sendMessage"

    public void send() {
        final RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/telegram_notification_war/test";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("apikey", "12123123");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        ResponseEntity<String> stringPosts = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

//        final String stringPosts = restTemplate.postForObject(url, headers, String.class);
        System.out.println(stringPosts.getHeaders().get("apikey"));
        System.out.println(stringPosts.getHeaders().getContentType());
        System.out.println();
    }
}

package taxi.anji.telegramnotification.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import taxi.anji.telegramnotification.controller.service.TelegramSender;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TelegramController {

    @Autowired
    private TelegramSender telegramSender;

    @PostMapping("/hello/")
    public void sayHello() {
        telegramSender.send();
    }

    @PostMapping("/test")
    public String test(HttpServletRequest request) {
        System.out.println(request.getHeader("apikey"));
        System.out.println(request.getContentType());
        System.out.println();
        return request.toString();
    }

    @PostMapping("/telegram_notification")
    public String telegramNotification(HttpServletRequest request) {
        String apikey = request.getHeader("apikey");

        System.out.println(request.getContentType());
        System.out.println();
        return request.toString();
    }
}

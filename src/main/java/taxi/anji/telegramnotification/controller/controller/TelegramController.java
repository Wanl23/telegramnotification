package taxi.anji.telegramnotification.controller.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import taxi.anji.telegramnotification.controller.service.JsonParserService;
import taxi.anji.telegramnotification.controller.service.TelegramSender;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;

@RestController
public class TelegramController {

    @GetMapping("/telegram_notification")
    @ResponseStatus(HttpStatus.OK)
    public void test(HttpServletRequest request,
                     @RequestParam String projectName,
                     @RequestParam ArrayList<String> groups,
                     @RequestParam String message) throws FileNotFoundException {
        String apiKey = request.getHeader("apikey");
        Set chatIDS = JsonParserService.verifyApiKeyAndGetChatIDs(apiKey, projectName, groups);
        String botToken = JsonParserService.getBotToken();
        TelegramSender.sendToBot(chatIDS, message, botToken);
    }
}

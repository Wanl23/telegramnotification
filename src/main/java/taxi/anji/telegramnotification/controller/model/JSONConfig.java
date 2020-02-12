package taxi.anji.telegramnotification.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JSONConfig {
    private String botToken;
    private ArrayList<ApiKey> apiKeys;
    private ArrayList<Project> projects;
}

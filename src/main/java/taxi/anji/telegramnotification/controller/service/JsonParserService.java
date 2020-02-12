package taxi.anji.telegramnotification.controller.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import taxi.anji.telegramnotification.controller.model.ApiKey;
import taxi.anji.telegramnotification.controller.model.JSONConfig;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class JsonParserService {

    private static final String JSON_DIRECTORY = "/opt/tomcat/conf/taxi-05-firebase.json";

    public static Set verifyApiKeyAndGetChatIDs(String apiKey, String projectName, ArrayList<String> groups) throws FileNotFoundException {
        JSONConfig jsonConfig = getJsonConfig();
        verifyApiKey(apiKey, jsonConfig);
        System.out.println("token: " + jsonConfig.getBotToken());
        Set chatIds = new HashSet();
        jsonConfig.getProjects().forEach(p -> {
            if (p.getName().equals(projectName)) {
                groups.forEach(g -> p.getGroups().forEach(gr -> {
                    if (gr.getName().equals(g)) chatIds.addAll(gr.getChatIDS());
                }));
            }
        });
        return chatIds;
    }

    private static void verifyApiKey(String apiKey, JSONConfig jsonConfig) {
        ArrayList<String> apiKeys = (ArrayList<String>) jsonConfig.getApiKeys().stream().map(ApiKey::getKey).collect(Collectors.toList());
        if (!apiKeys.contains(apiKey))
            throw new IllegalArgumentException("wrong apiKey " + apiKey);
    }

    private static JSONConfig getJsonConfig() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File jsonFile = new File(JSON_DIRECTORY);
        FileReader fileReader = new FileReader(jsonFile);
        return gson.fromJson(fileReader, JSONConfig.class);
    }

    public static String getBotToken() throws FileNotFoundException {
        JSONConfig jsonConfig = getJsonConfig();
        return jsonConfig.getBotToken();
    }
}

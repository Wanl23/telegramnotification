package taxi.anji.telegramnotification.controller.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;

public class JsonParser {

    public static void readJSON() throws IOException, ParseException {
        HashMap<String, Object> jsonMap = new HashMap<>();

        File jsonFile = new File("configuration.json");
        FileReader fileReader = new FileReader(jsonFile);
        JSONParser jsonParser = new JSONParser();
        Object parsedJson = jsonParser.parse(fileReader);
        org.json.simple.JSONObject simpleJsonObject = (org.json.simple.JSONObject) parsedJson;

        JSONObject jsonObject = new JSONObject(simpleJsonObject.toJSONString());

        JSONArray apiKeys = jsonObject.getJSONArray("apikey");
        jsonMap.put("api_keys", apiKeys);

        JSONArray projects = jsonObject.getJSONArray("projects");
        jsonMap.put("projects", projects);

//        ключи - бот токен

//        проекты
//        группы
//        чат ай ди лонг
//        мессадж


//        JSONObject obj = new JSONObject(fileInputStream.read());
//        String apikey = obj.toString();

//        JSONArray arr = obj.getJSONArray("posts");
//        for (int i = 0; i < arr.length(); i++)
//        {
//            String post_id = arr.getJSONObject(i).getString("post_id");
//        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        readJSON();
        //        System.out.println(readJSON());
    }
}

package taxi.anji.telegramnotification.controller.service;

import taxi.anji.telegramnotification.controller.model.ApiKey;
import taxi.anji.telegramnotification.controller.model.ChatID;
import taxi.anji.telegramnotification.controller.model.Group;
import taxi.anji.telegramnotification.controller.model.JSONConfig;
import taxi.anji.telegramnotification.controller.model.Project;

import java.util.ArrayList;

public class JSONConfigBuilder {

    public static JSONConfig build() {
        JSONConfig jsonConfig = new JSONConfig();

        ChatID chatID1 = new ChatID(1l);
        ChatID chatID2 = new ChatID(2l);
        ArrayList arrayList1 = new ArrayList<>();

        ChatID chatID3 = new ChatID(3l);
        ChatID chatID4 = new ChatID(4l);
        ArrayList arrayList2 = new ArrayList<>();

        ChatID chatID5 = new ChatID(5l);
        ChatID chatID6 = new ChatID(6l);
        ArrayList arrayList3 = new ArrayList<>();

        Group group1 = new Group();
        Group group2 = new Group();
        Group group3 = new Group();

        Project project1 = new Project();
        Project project2 = new Project();

        arrayList1.add(chatID1);
        arrayList1.add(chatID2);
        arrayList2.add(chatID3);
        arrayList2.add(chatID4);
        arrayList3.add(chatID5);
        arrayList3.add(chatID6);

        group1.setName("dev");
        group1.setChatIDS(arrayList1);
        group2.setName("prom");
        group2.setChatIDS(arrayList2);
        group3.setName("star");
        group3.setChatIDS(arrayList3);

        ArrayList groups1 = new ArrayList();
        ArrayList groups2 = new ArrayList();

        groups1.add(group1);
        groups1.add(group2);

        groups2.add(group2);
        groups2.add(group3);

        project1.setName("java");
        project1.setGroups(groups1);

        project2.setName("C#");
        project2.setGroups(groups2);

        ArrayList<Project> projects = new ArrayList<>();
        projects.add(project1);
        projects.add(project2);

        ApiKey apiKey1 = new ApiKey("123", "default");
        ApiKey apiKey2 = new ApiKey("234", "additional");
        ArrayList<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(apiKey1);
        apiKeys.add(apiKey2);

        jsonConfig.setApiKeys(apiKeys);
        jsonConfig.setProjects(projects);

        return jsonConfig;
    }
}

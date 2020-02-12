package taxi.anji.telegramnotification.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private String name;
    private ArrayList<Group> groups;
}

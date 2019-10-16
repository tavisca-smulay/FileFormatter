import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class JSONSerializer {
    public void serializeToJSON(Employee employee[]) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fileWriter = new FileWriter("second.json")) {
            gson.toJson(employee, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
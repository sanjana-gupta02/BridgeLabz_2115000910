package org.example;

import org.json.JSONObject;
import org.json.JSONArray;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class ReadJsonOrgJson {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("employees.json")));

            JSONObject jsonObject = new JSONObject(content);

            for (String key : jsonObject.keySet()) {
                Object value = jsonObject.get(key);
                if (value instanceof JSONArray) {
                    System.out.println(key + ": " + value);
                } else {
                    System.out.println(key + ": " + value.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

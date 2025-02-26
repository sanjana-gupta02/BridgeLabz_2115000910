package org.example;

import org.json.JSONObject;
import org.json.XML;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonToXmlOrgJson {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("user.json")));

            JSONObject jsonObject = new JSONObject(content);

            String xml = XML.toString(jsonObject, "root");

            System.out.println(xml);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

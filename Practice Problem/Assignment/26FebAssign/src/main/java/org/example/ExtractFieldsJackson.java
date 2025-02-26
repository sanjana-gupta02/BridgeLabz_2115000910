package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractFieldsJackson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode rootNode = objectMapper.readTree(new File("employees.json"));

            List<Map<String, String>> extractedList = new ArrayList<>();

            for (JsonNode node : rootNode) {
                extractedList.add(Map.of(
                        "name", node.get("name").asText(),
                        "email", node.get("email").asText()
                ));
            }

            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(extractedList);

            System.out.println(jsonOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

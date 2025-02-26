package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class FilterJsonJackson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file into List of User objects
            List<User> users = objectMapper.readValue(
                    new File("employees.json"), new TypeReference<List<User>>() {}
            );

            List<User> filteredUsers = users.stream()
                    .filter(user -> user.getAge() > 25)
                    .collect(Collectors.toList());

            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredUsers);
            System.out.println(jsonOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

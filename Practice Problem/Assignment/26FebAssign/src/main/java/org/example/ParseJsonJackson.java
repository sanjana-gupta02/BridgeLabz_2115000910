package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class ParseJsonJackson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            List<Employee> employees = objectMapper.readValue(
                    new File("employees.json"), new TypeReference<List<Employee>>() {}
            );

            List<Employee> filteredEmployees = employees.stream()
                    .filter(emp -> emp.getAge() > 25)
                    .collect(Collectors.toList());

            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredEmployees);
            System.out.println(jsonOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ListToJsonJackson {
    public static void main(String[] args) {
        try {
            List<Employee> employees = Arrays.asList(
                    new Employee("Alice", 101, "HR"),
                    new Employee("Bob", 102, "IT"),
                    new Employee("Charlie", 103, "Finance")
            );

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);

            System.out.println(jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

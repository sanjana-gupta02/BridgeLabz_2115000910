package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ValidateJsonExample {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            File jsonFile = new File("student.json");

            Student student = objectMapper.readValue(jsonFile, Student.class);

            System.out.println("JSON is valid: " + student.getName());

        } catch (Exception e) {
            System.out.println("Invalid JSON structure: " + e.getMessage());
        }
    }
}

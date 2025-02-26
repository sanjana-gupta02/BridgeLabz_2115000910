package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;
import java.io.File;
import java.io.IOException;

public class ValidateEmailJsonSchema {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode schemaNode = objectMapper.readTree(new File("schema.json"));
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);

            JsonNode jsonData = objectMapper.readTree(new File("user.json"));

            JsonValidator validator = factory.getValidator();
            if (validator.validate(schema, jsonData).isSuccess()) {
                System.out.println("✅ JSON is valid!");
            } else {
                System.out.println("❌ Invalid JSON!");
            }

        } catch (IOException | ProcessingException e) {
            e.printStackTrace();
        }
    }
}

package org.example;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.List;

public class CsvToJsonJackson {
    public static void main(String[] args) {
        try {
            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();

            CsvMapper csvMapper = new CsvMapper();

            File csvFile = new File("data.csv");
            MappingIterator<Object> iterator = csvMapper.readerFor(Object.class).with(csvSchema).readValues(csvFile);
            List<Object> data = iterator.readAll();

            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);

            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

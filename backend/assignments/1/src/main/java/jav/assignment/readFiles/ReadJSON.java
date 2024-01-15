package jav.assignment.readFiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;

import java.io.IOException;

public class ReadJSON {
    public static JsonNode JSONFileReader(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readTree(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}


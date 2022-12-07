package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Helper service for creating a json object out of POJOs.
 */
public class JSONMapperService {

    public static String convertToJSON(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        try {
            return  objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

        return "{}";
    }
}

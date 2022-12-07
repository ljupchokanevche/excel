package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

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

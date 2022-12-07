package org.example.services;

import org.example.domain.ExcelRowData;
import org.example.domain.PostRequestModel;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class PostService {

    private static final String URL = "https://hh7bty37dbpkfgclxm4zefsodi0rzlvg.lambda-url.eu-west-1.on.aws/";

    public static void postRequest(List<ExcelRowData> rowData) {
        PostRequestModel requestModel = new PostRequestModel(UUID.randomUUID(), LocalDate.now(), rowData);

        HttpClient client = HttpClient.newHttpClient();

        String json = JSONMapperService.convertToJSON(requestModel);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .POST(HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

            System.out.println(response);
        } catch (IOException | InterruptedException e) {
            System.out.println("Call didn't went through");
            throw new RuntimeException(e);
        }
    }
}

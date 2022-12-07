package org.example;

import org.example.domain.ExcelRowData;
import org.example.services.ExcelWorkerService;
import org.example.services.PostService;

import java.io.IOException;
import java.net.URL;
import java.util.List;
public class Main {
    private static final String EXCEL_FILE_URL = "https://docs.google.com/spreadsheets/d/1ceJeUKRn6q0IIVOUd9i02RrEcbj6Tx7B/export?format=xlsx&id=1ceJeUKRn6q0IIVOUd9i02RrEcbj6Tx7B";
    public static void main(String[] args) {

        try {
            URL url = new URL(EXCEL_FILE_URL);
            List<ExcelRowData> rowData = ExcelWorkerService.mapGenerator(url.openStream());
            PostService.postRequest(rowData);
        } catch (IOException e) {
            System.out.println("File not found!!");
        }

    }
}
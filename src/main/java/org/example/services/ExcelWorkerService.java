package org.example.services;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.domain.*;
import org.example.mappers.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelWorkerService {
     public static List<ExcelRowData> mapGenerator(InputStream file) {
        List<ExcelRowData> objects = new ArrayList<>();
        Workbook workbook;
        try {
            workbook = new XSSFWorkbook(file);

            int numberOfSheets = workbook.getNumberOfSheets();

            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);

                sheetWorker(sheet, objects);
            }
        } catch (IOException e) {
            throw new RuntimeException("This is not an excel file");
        }

        return objects;
    }

    private static void sheetWorker(Sheet sheet, List<ExcelRowData> objects) {
        int firstRow = sheet.getFirstRowNum();
        int numberOfRows = sheet.getPhysicalNumberOfRows();

        Row rowHeader = sheet.getRow(firstRow);

        for (int i = firstRow + 1; i < numberOfRows; i++) {
            Map<String, String> data = new HashMap<>();
            Row row = sheet.getRow(i);

            rowHeader.cellIterator().forEachRemaining(cell -> {
                int columnIndex = cell.getColumnIndex();
                if (row.getCell(columnIndex) != null) {
                    data.put(cell.getStringCellValue(), row.getCell(columnIndex).getStringCellValue());
                } else {
                    data.put(cell.getStringCellValue(), "");
                }
            });

            ExcelRowData rowData;

            switch (sheet.getSheetName()) {
                case "Products":
                    Product product = ProductMapper.mapToProduct(data);
                    rowData = new ExcelRowData(sheet.getSheetName(), product);
                    break;
                case "GTIN":
                    GTIN gtin = GTINMapper.mapToGTIN(data);
                    rowData = new ExcelRowData(sheet.getSheetName(), gtin);
                    break;
                case "Images":
                    Image image = ImageMapper.mapToImage(data);
                    rowData = new ExcelRowData(sheet.getSheetName(), image);
                    break;
                case "Prices":
                    Price price = PriceMapper.mapToPrice(data);
                    rowData = new ExcelRowData(sheet.getSheetName(), price);
                    break;
                default:
                    BaseModel baseModel = BaseModelMapper.mapToBaseModel(data);
                    rowData = new ExcelRowData(sheet.getSheetName(), baseModel);
                    break;
            }

            objects.add(rowData);
        }

    }

}

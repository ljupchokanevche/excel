package org.example.services;


import org.example.domain.ExcelRowData;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExcelWorkerServiceTest {

    @Test
    public void shouldWriteToMap() throws FileNotFoundException {

        // Given
        InputStream testFile = new FileInputStream("src/test/resources/testWorkbook.xlsx");

        // When
        List<ExcelRowData> data = ExcelWorkerService.mapGenerator(testFile);

        // Then
        assertThat(data).isNotEmpty().hasSize(1);

        ExcelRowData rowData = data.get(0);

        assertThat(rowData).isNotNull().returns("TestSheet", ExcelRowData::getDocumentType);

        assertThat(rowData.getData()).containsEntry("Name", "test");
    }

    @Test
    public void shouldThrowErrorToMap() {

        // Given
        InputStream testFile = new ByteArrayInputStream(new byte[2]);

        // When + Then
        assertThatThrownBy(() -> ExcelWorkerService.mapGenerator(testFile))
                .isInstanceOf(RuntimeException.class);
    }

}
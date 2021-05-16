package com.demo.springboot.hibernatejpademo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//import org.json.JSONObject;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {
    @GetMapping("/books")
    List<Book> getAllBooks(){
        return Arrays.asList(
                new Book(4,"Spring Fundamental","Jack Dow")
        );
    }

    @GetMapping(value="/downloadTemplate")
    public ResponseEntity<ByteArrayResource> downloadTemplate() throws Exception {
        try {
            ByteArrayOutputStream stream = writeExcel("file1","ftm");
            HttpHeaders header = new HttpHeaders();
            header.setContentType(new MediaType("application", "force-download"));
            //header.setContentType(new MediaType("application/vnd.ms-excel"));
            header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ProductTemplate.xls");
            header.set("Cache-Control", "public, must-revalidate");
            //workbook.write(stream);
            //workbook.close();
            stream.flush();
            stream.close();
            return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()),
                    header, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ByteArrayOutputStream writeExcel(String fileName,String sheetName) throws IOException {
        Workbook wb = new HSSFWorkbook();
        //OutputStream os = new FileOutputStream(fileName);
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        Sheet sheet = wb.createSheet(sheetName);
        sheet.setColumnWidth(0, 2*256);
        int rowNum = 1;
        for(int i=0;i<10;i++) {
            createRow(sheet,rowNum);
            rowNum++;
        }
        wb.write(os);

        return os;
    }

    private void createRow(Sheet sheet, int rowNum) {
        Row row = sheet.createRow(rowNum);
        createCell(row, 1, "abc");
        createCell(row, 2, "xyz");

    }

    private void createCell(Row row, int column, String cellValue) {
        Cell cell = row.createCell(column);
        if (cellValue != null) {
            cell.setCellValue(cellValue);
        }
    }


}

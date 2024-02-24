package com.example.exceldemo;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 엑셀 파일 읽기
 * */
public class Project03_A {
    public static void main(String[] args) {
        String fileName = "bookList.xls"; // 읽어 들일 파일
        List<ExcelVO> data = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            HSSFWorkbook workbook = new HSSFWorkbook(fis); // 메모리에 엑셀 파일을 올려 놓는 작업
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.rowIterator();
            rows.next(); // 첫번쨰 줄은 컬럼 제목이니까 건너 뛴다.
            String[] temp = new String[5];
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator<Cell> cells = row.cellIterator();
                int i = 0;
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    temp[i] = cell.toString();
                    i++;
                }
                ExcelVO vo = new ExcelVO(temp[0], temp[1], temp[2], temp[3], temp[4]);
                data.add(vo);
            }
            showExcelData(data); // 확인을 위한 출력
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void showExcelData(List<ExcelVO> data) {
        for (ExcelVO vo : data) {
            System.out.println(vo);
        }
    }
}

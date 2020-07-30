package com.example.demo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelParams {

    Sheet sheet;
    Row row;
    Cell cell;

    String NnDofSCF;
    String NnDofPRD;
    String TextInf;
    String NaimTov;
    String NalSt;
    String SumNal;
    String stTovYcNal;

    public ExcelParams(Sheet sheet) {
        this.sheet = sheet;
        fillParams();
    }

    void fillParams() {

        row = sheet.getRow(5);
        cell = row.getCell(0);
        System.out.println(cell.getStringCellValue());
        NnDofSCF = cell.getStringCellValue();

        row = sheet.getRow(13);
        cell = row.getCell(15);
        System.out.println(cell.getStringCellValue());
        NnDofPRD = cell.getStringCellValue();

        row = sheet.getRow(19);
        cell = row.getCell(0);
        System.out.println(cell.getStringCellValue());
        TextInf = cell.getStringCellValue();

        row = sheet.getRow(27);
        cell = row.getCell(0);
        System.out.println(cell.getStringCellValue());
        NaimTov = cell.getStringCellValue();

        row = sheet.getRow(27);
        cell = row.getCell(36);
        System.out.println(cell.getStringCellValue());
        NalSt = cell.getStringCellValue();

        row = sheet.getRow(27);
        cell = row.getCell(39);
        System.out.println(cell.getStringCellValue());
        SumNal = cell.getStringCellValue();

        row = sheet.getRow(27);
        cell = row.getCell(43);
        System.out.println(cell.getStringCellValue());
        stTovYcNal = cell.getStringCellValue();

    }

}

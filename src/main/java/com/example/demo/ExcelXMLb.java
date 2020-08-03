package com.example.demo;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelXMLb {

    public ExcelXMLb(String excelFilePath) throws IOException, TransformerException, SAXException, ParserConfigurationException {

        Workbook workbookTemplate = new XSSFWorkbook(new FileInputStream(excelFilePath));
        Sheet sheetTemplate = workbookTemplate.getSheetAt(0);

        String inputXMLFilePath = "ON_NSCHFDOPPR_2BM-7707049388-2012052807482517145600000000000_2BM-7714186804-997150001-201803160155224912276_20200604_c3fc4e4f-bc0d-4baf-88c8-c6f1c2e037d5.xml";

        String outputFilePath = "resultXML3.xml";

        ExcelParams excelParams = new ExcelParams(sheetTemplate);
        XMLParams xmlParams = new XMLParams(excelParams);

        String kpp = excelFilePath.split(" ")[1].split("\\.")[0];
        System.out.println("kpp " + kpp);
        xmlParams.kpp = kpp;

        XMLParser xmlParser = new XMLParser(inputXMLFilePath, xmlParams.nscf + ".xml", xmlParams);

    }
}

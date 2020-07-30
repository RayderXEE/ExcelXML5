package com.example.demo;

import org.apache.poi.ss.usermodel.Sheet;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class ExcelXML {

    public ExcelXML(Sheet sheet, String inputXMLFilePath, String outputXMLFilePath) throws ParserConfigurationException, TransformerException, SAXException, IOException {

        ExcelParams excelParams = new ExcelParams(sheet);
        XMLParams xmlParams = new XMLParams(excelParams);
        XMLParser xmlParser = new XMLParser(inputXMLFilePath, xmlParams.nscf + ".xml", xmlParams);

    }

}

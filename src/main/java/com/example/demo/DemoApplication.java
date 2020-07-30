package com.example.demo;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("test");

		Workbook workbookTemplate = new XSSFWorkbook(new FileInputStream("invoice.xlsx"));
		Sheet sheetTemplate = workbookTemplate.getSheetAt(0);

		String inputXMLFilePath = "ON_NSCHFDOPPR_2BM-7707049388-2012052807482517145600000000000_2BM-7714186804-997150001-201803160155224912276_20200604_c3fc4e4f-bc0d-4baf-88c8-c6f1c2e037d5.xml";

		String outputFilePath = "resultXML3.xml";

		new ExcelXML(sheetTemplate, inputXMLFilePath, outputFilePath);

	}
}

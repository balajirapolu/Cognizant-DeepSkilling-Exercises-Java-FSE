package com.cognizant.test;

import com.cognizant.factory.Document;
import com.cognizant.factory.DocumentFactory;
import com.cognizant.factory.WordDocumentFactory;
import com.cognizant.factory.PdfDocumentFactory;
import com.cognizant.factory.ExcelDocumentFactory;

public class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Factory Method Pattern ===");

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.close();

        System.out.println();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.close();

        System.out.println();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.close();

        System.out.println("\n=== Test Finished ===");
    }
}

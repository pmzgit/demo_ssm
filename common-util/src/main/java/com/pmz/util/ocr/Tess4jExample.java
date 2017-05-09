package com.pmz.util.ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * Created by pmz on 2017/4/7 16:57.
 */
public class Tess4jExample {
    public static void main(String[] args) {
        File imageFile = new File("C:\\Users\\Administrator\\Desktop\\pmz\\ocr\\xsz.jpg");
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
        instance.setDatapath("D:\\soft\\install\\Tesseract-OCR\\tessdata");
        instance.setLanguage("chi_sim+eng");
        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}

package fr.lphn.esgi.cleancode.ocr.converter;

import java.util.List;

public class ConverterFactory {

    private static Converter converter = null;

    private ConverterFactory(Converter converter) {
        this.converter = converter;
    }



}

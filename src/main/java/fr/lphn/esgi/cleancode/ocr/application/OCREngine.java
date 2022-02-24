package fr.lphn.esgi.cleancode.ocr.application;

import fr.lphn.esgi.cleancode.ocr.writer.Reader;
import fr.lphn.esgi.cleancode.ocr.writer.Writer;

import java.util.List;

public class OCREngine {

    Method method;
    Writer writer;
    Reader<List<String>> reader;

    public OCREngine(Method method, Writer writer, Reader<List<String>> reader) {
        this.method = method;
        this.writer = writer;
        this.reader = reader;
    }
}

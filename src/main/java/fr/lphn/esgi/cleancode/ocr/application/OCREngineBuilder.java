package fr.lphn.esgi.cleancode.ocr.application;

import fr.lphn.esgi.cleancode.ocr.converter.Converter;
import fr.lphn.esgi.cleancode.ocr.logger.Log;
import fr.lphn.esgi.cleancode.ocr.parser.Parser;
import fr.lphn.esgi.cleancode.ocr.writer.*;

import java.util.List;
import java.util.Map;

public class OCREngineBuilder {

    private Parser parser;
    private List<FileReader> readers;
    private Map<FileType, FileWriter> writers;
    private Log logger;

    private OCREngineBuilder() {

    }

    public OCREngineBuilder parser(Parser parser) {
        this.parser = parser;
        return this;
    }

    public OCREngineBuilder readers(List<FileReader> readers) {
        this.readers = readers;
        return this;
    }

    public OCREngineBuilder logger(Log logger) {
        this.logger = logger;
        return this;
    }

    public OCREngineBuilder writer(Map<FileType, FileWriter> writers) {
        this.writers = writers;
        return this;
    }

    public OCREngine build() {
        return new OCREngine(parser, readers, writers, logger);
    }

    public static OCREngineBuilder create() {
        return new OCREngineBuilder();
    }

    @Override
    public String toString() {
        return "OCREngineBuilder{" +
                "parser=" + parser +
                ", readers=" + readers +
                ", writers=" + writers +
                ", logger=" + logger +
                '}';
    }
}

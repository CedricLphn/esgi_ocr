package fr.lphn.esgi.cleancode.ocr.writer;

import java.io.IOException;

public interface Writer {
    void write(String message) throws IOException;
}

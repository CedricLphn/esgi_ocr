package fr.lphn.esgi.cleancode.ocr.writer;

public interface Reader<C> {
    void read();
    C get();
    int size();
}

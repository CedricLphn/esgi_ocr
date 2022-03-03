package fr.lphn.esgi.cleancode.ocr.application;

public interface Engine {
    void readFile();
    boolean checksum(String letter);
    boolean isIllegal(String letter);
    void parse();
    void write();
}

package fr.lphn.esgi.cleancode.ocr.application;

import fr.lphn.esgi.cleancode.ocr.parser.Parser;

public interface Engine {
    boolean checksum();
    boolean isIllegal();
    void parse(Parser parse);
}

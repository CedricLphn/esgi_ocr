package fr.lphn.esgi.cleancode.ocr.parser;

public interface Template<C> {
    boolean is(C input, int number);
}

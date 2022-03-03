package fr.lphn.esgi.cleancode.ocr.converter;

public interface Converter<O> {
    O convert(int row, int column);
}

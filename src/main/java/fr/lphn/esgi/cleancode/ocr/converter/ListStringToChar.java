package fr.lphn.esgi.cleancode.ocr.converter;

import java.util.List;

public class ListStringToChar implements Converter<List<String>, char[][]> {

    private final List<String> input;

    public ListStringToChar(List<String> input) {
        this.input = input;
    }

    public char[][] convert(int row, int column) {
        char[][] digits = new char[3][3];
        for(int i = 0; i < digits.length; i++) {
            digits[i] = input.get(row+i).substring(column, column + digits.length).toCharArray();
        }

        return digits;
    }
}

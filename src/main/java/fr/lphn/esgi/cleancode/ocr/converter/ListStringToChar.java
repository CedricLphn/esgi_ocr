package fr.lphn.esgi.cleancode.ocr.converter;

import java.util.ArrayList;
import java.util.List;

public class ListStringToChar implements Converter<char[][]> {

    private List<String> input;

    public ListStringToChar(List<String> input) {
        this.input = input;
    }

    public ListStringToChar() {
        this.input = new ArrayList<>();
    }

    public void setInput(List<String> input) {
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

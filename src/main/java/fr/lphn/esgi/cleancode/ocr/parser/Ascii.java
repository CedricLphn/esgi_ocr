package fr.lphn.esgi.cleancode.ocr.parser;

import java.util.Arrays;
import java.util.List;

public final class Ascii implements Template<char[][]> {

    private final List<char[][]> numbers = List.of(
            new char[][]{{' ', '_', ' '}, {'|', ' ', '|'}, {'|', '_', '|'}}, // 0
            new char[][]{{' ', ' ', ' '}, {' ', ' ', '|'}, {' ', ' ', '|'}},
            new char[][]{{' ', '_', ' '}, {' ', '_', '|'}, {'|', '_', ' '}},
            new char[][]{{' ', '_', ' '}, {' ', '_', '|'}, {' ', '_', '|'}},
            new char[][]{{' ', ' ', ' '}, {'|', '_', '|'}, {' ', ' ', '|'}},
            new char[][]{{' ', '_', ' '}, {'|', '_', ' '}, {' ', '_', '|'}},
            new char[][]{{' ', '_', ' '}, {'|', '_', ' '}, {'|', '_', '|'}},
            new char[][]{{' ', '_', ' '}, {' ', ' ', '|'}, {' ', ' ', '|'}},
            new char[][]{{' ', '_', ' '}, {'|', '_', '|'}, {'|', '_', '|'}},
            new char[][]{{' ', '_', ' '}, {'|', '_', '|'}, {' ', '_', '|'}} // 9
    );

    private boolean equals(char[][] input, char[][] args) {
        boolean result = true;
        for(int i = 0; i < 3; i++) {
            result = Arrays.equals(input[i], args[i]) && result;
        }

        return result;
    }


    @Override
    public boolean is(char[][] input, int number) {
        return equals(input, numbers.get(number));
    }
}

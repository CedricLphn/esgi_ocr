package fr.lphn.esgi.cleancode.ocr.parser;

import fr.lphn.esgi.cleancode.ocr.exceptions.IllegalNumberException;

public class Parser {

    private final Template template;

    public Parser(Template template) {
        this.template = template;
    }

    public int parse(char[][] number) throws IllegalNumberException {
        for(int i = 0; i < 10; i++) {
            if(template.is(number, i)) {
                return i;
            }
        }

        throw new IllegalNumberException("Input is not a number");
    }

    private boolean check(char[][] input, int number) {
        return template.is(input, number);
    }

}

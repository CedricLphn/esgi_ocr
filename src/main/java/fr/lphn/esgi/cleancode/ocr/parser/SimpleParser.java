package fr.lphn.esgi.cleancode.ocr.parser;

import fr.lphn.esgi.cleancode.ocr.exceptions.IllegalNumberException;

public class SimpleParser implements Parser<char[][], Integer> {

    private final Template template;
    private int output;

    public SimpleParser(Template template) {
        this.template = template;
    }

    @Override
    public Integer parse(char[][] number) throws IllegalNumberException {
        for(int i = 0; i < 10; i++) {
            if(template.is(number, i)) {
                return i;
            }
        }

        throw new IllegalNumberException("Input is not a number");
    }

}

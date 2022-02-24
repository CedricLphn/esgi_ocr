package fr.lphn.esgi.cleancode.ocr.parser;

import fr.lphn.esgi.cleancode.ocr.exceptions.IllegalNumberException;

public interface Parser<I, O> {
    O parse(I number) throws IllegalNumberException;
}

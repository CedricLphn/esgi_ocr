package fr.lphn.esgi.cleancode.ocr;

import fr.lphn.esgi.cleancode.ocr.exceptions.IllegalNumberException;
import fr.lphn.esgi.cleancode.ocr.logger.ConsoleLoggerFactory;
import fr.lphn.esgi.cleancode.ocr.logger.Log;
import fr.lphn.esgi.cleancode.ocr.parser.Ascii;
import fr.lphn.esgi.cleancode.ocr.parser.Parser;
import fr.lphn.esgi.cleancode.ocr.writer.FileWriter;

public class Main {
    public static void main(String[] args) {
        FileWriter writer = new FileWriter("C:\\Users\\cedri\\IdeaProjects\\fr.lphn.esgi.cleancode.ocr\\src\\main\\resources\\test.txt");

        char[][] test = new char[][]{{' ', '_', ' '}, {'|', ' ', '|'}, {'|', '_', '|'}};

        Log console = ConsoleLoggerFactory.of();

        console.log("Hello");

        Ascii number = new Ascii();

        writer.read();

        //console.log(String.valueOf(number.is(test, 1)));

        Ascii ascii = new Ascii();
        Parser parser = new Parser(ascii);

        try {
            System.out.println(parser.parse(test));
        } catch (IllegalNumberException e) {
            e.printStackTrace();
        }

    }
}

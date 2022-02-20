package fr.lphn.esgi.cleancode.ocr;

import fr.lphn.esgi.cleancode.ocr.logger.ConsoleLoggerFactory;
import fr.lphn.esgi.cleancode.ocr.logger.Log;
import fr.lphn.esgi.cleancode.ocr.writer.FileWriter;

public class Main {
    public static void main(String[] args) {
        FileWriter writer = new FileWriter("C:\\Users\\cedri\\IdeaProjects\\fr.lphn.esgi.cleancode.ocr\\src\\main\\resources\\test.txt");

        writer.get();

        Log console = ConsoleLoggerFactory.of();

        console.log("Hello");

    }
}

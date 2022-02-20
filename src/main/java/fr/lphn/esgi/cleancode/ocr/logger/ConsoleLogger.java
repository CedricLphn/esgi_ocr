package fr.lphn.esgi.cleancode.ocr.logger;

public class ConsoleLogger implements Log {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

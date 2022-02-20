package fr.lphn.esgi.cleancode.ocr.logger;

public class ConsoleLoggerFactory {
    private static Log log = null;

    private ConsoleLoggerFactory() {
    }

    public static Log of() {
        if(log == null)
            log = new ConsoleLogger();

        return log;
    }

}

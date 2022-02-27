package fr.lphn.esgi.cleancode.ocr.application;

import fr.lphn.esgi.cleancode.ocr.converter.ListStringToChar;
import fr.lphn.esgi.cleancode.ocr.exceptions.IllegalNumberException;
import fr.lphn.esgi.cleancode.ocr.logger.Log;
import fr.lphn.esgi.cleancode.ocr.parser.Parser;
import fr.lphn.esgi.cleancode.ocr.writer.FileReader;
import fr.lphn.esgi.cleancode.ocr.writer.FileType;
import fr.lphn.esgi.cleancode.ocr.writer.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OCREngine implements Engine {

    private List<String> letters = new ArrayList<>();
    private final Parser parser;
    private ListStringToChar converter;
    private final List<FileReader> readers;
    private final Map<FileType, FileWriter> writers;
    private List<String> output = new ArrayList<>();
    private final Log logger;

    public OCREngine(Parser parser, List<FileReader> readers, Map<FileType, FileWriter> writers, Log logger) {
        this.parser = parser;
        this.readers = readers;
        this.writers = writers;
        this.logger = logger;
        this.converter = new ListStringToChar();
    }


    @Override
    public void readFile() {
        readers.forEach(files -> {
            files.read();
            letters.addAll(files.get());
        });
        converter.setInput(letters);
    }

    @Override
    public boolean checksum(String letter) {
        boolean isValid = true;
        int checksum = 0;
        for (int i = 0; i < letter.length(); i++) {
            if (letter.charAt(i) != '?' && isValid) {
                checksum = checksum + Integer.parseInt(letter.substring(i, i + 1)) * (letter.length() - i);
            } else {
                isValid = false;
            }
        }

        return isValid && checksum % 11 == 0;

    }

    @Override
    public boolean isIllegal(String letter) {
        return letter.contains("?");
    }

    @Override
    public void parse() {
        for (int i = 0; i < letters.size(); i += 4) {
            String currentLine = letters.get(i);
            StringBuilder letter = new StringBuilder();
            for (int column = 0; column < currentLine.length(); column += 3) {
                char[][] numbers = converter.convert(i, column);
                try {
                    Integer parse = (Integer) parser.parse(numbers);
                    letter.append(parse);
                } catch (IllegalNumberException e) {
                    letter.append('?');
                    System.out.println(e.getMessage());
                }
            }
            logger.log(assignateLetters(letter.toString()));
            output.add(assignateLetters(letter.toString()));
        }
    }

    public String assignateLetters(String letter) {
        if (isIllegal(letter)) {
            return letter + " ILL";
        } else if (!checksum(letter)) {
            return letter + " ERR";
        } else {
            return letter;
        }
    }

    @Override
    public void write() {
        writers.forEach((fileType, fileWriter) -> {
            for (String letter : output) {
                try {
                    if (fileType == FileType.ALL) {
                        fileWriter.write(letter);
                    } else if (fileType == FileType.ILLEGAL && letter.contains("ILL")) {
                        fileWriter.write(letter);
                    } else if (fileType == FileType.UNKNOWN && letter.contains("ERR")) {
                        fileWriter.write(letter);
                    } else if (fileType == FileType.AUTHORIZED && !letter.contains("ERR") && !letter.contains("ILL")) {
                        fileWriter.write(letter);
                    }
                } catch (IOException e) {
                    logger.log("Unable to write file : " + e.getMessage());
                }
            }
        });

    }
}

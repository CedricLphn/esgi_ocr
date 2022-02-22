package fr.lphn.esgi.cleancode.ocr;

import fr.lphn.esgi.cleancode.ocr.converter.ConverterFactory;
import fr.lphn.esgi.cleancode.ocr.converter.ListStringToChar;
import fr.lphn.esgi.cleancode.ocr.exceptions.IllegalNumberException;
import fr.lphn.esgi.cleancode.ocr.logger.ConsoleLoggerFactory;
import fr.lphn.esgi.cleancode.ocr.logger.Log;
import fr.lphn.esgi.cleancode.ocr.parser.Ascii;
import fr.lphn.esgi.cleancode.ocr.parser.Parser;
import fr.lphn.esgi.cleancode.ocr.writer.FileReader;
import fr.lphn.esgi.cleancode.ocr.writer.FileWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader writer = new FileReader("C:\\Users\\cedri\\IdeaProjects\\fr.lphn.esgi.cleancode.ocr\\src\\main\\resources\\test.txt");

        char[][] test = new char[][]{{' ', '_', ' '}, {'|', ' ', '|'}, {'|', '_', '|'}};

        Log console = ConsoleLoggerFactory.of();

        console.log("Hello");

        Ascii number = new Ascii();

        writer.read();

        List<String> strings = writer.get();
        Ascii ascii = new Ascii();
        Parser parser = new Parser(ascii);

        List<String> accounts = new ArrayList<>();

        for(int i = 0; i < 8; i+=4) {
            String currentLine = strings.get(i);
            StringBuilder account = new StringBuilder();
            for(int column = 0; column < currentLine.length(); column += 3) {
                char[][] converter = new ListStringToChar(strings).convert(i, column);
                try {
                    account.append(parser.parse(converter));
                } catch (IllegalNumberException e) {
                    e.printStackTrace();
                }
            }

            accounts.add(account.toString());
        }

        FileWriter tst = new FileWriter(new File("hey.txt"));
        for(String account : accounts) {
            int nbr = 0;

            for(int i = 0; i <= account.length()-1; i++) {
                nbr = nbr + parseInt(account.substring(i, i+1)) * (account.length() - i);
            }
            System.out.println(nbr % 11 == 0 ? true : "ERR");
            tst.write(account);

        }

        //console.log(String.valueOf(number.is(test, 1)));
    }
}

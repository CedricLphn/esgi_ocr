package fr.lphn.esgi.cleancode.ocr;

import fr.lphn.esgi.cleancode.ocr.application.OCREngine;
import fr.lphn.esgi.cleancode.ocr.application.OCREngineBuilder;
import fr.lphn.esgi.cleancode.ocr.logger.ConsoleLogger;
import fr.lphn.esgi.cleancode.ocr.logger.Log;
import fr.lphn.esgi.cleancode.ocr.parser.Ascii;
import fr.lphn.esgi.cleancode.ocr.parser.SimpleParser;
import fr.lphn.esgi.cleancode.ocr.utils.LogoAscii;
import fr.lphn.esgi.cleancode.ocr.writer.FileReader;
import fr.lphn.esgi.cleancode.ocr.writer.FileType;
import fr.lphn.esgi.cleancode.ocr.writer.FileWriter;
import org.codehaus.plexus.util.StringUtils;

import java.util.*;

public class MainConsole {

    private static List<FileReader> input = new ArrayList<>();
    private static Map<FileType, FileWriter> output = new HashMap<>();
    private static Log logger = new ConsoleLogger();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(LogoAscii.show());
        System.out.println("Welcome to Bureau Valley OCR");


        while (true) {
            chooseInputFile();

            while (true) {
                System.out.println("How do you want to classify the numbers? (1)");
                System.out.println("1. All in the same file");
                System.out.print("2. OK, Illegal and wrong number separated\n> ");
                String choice = scanner.nextLine();
                if(choice.equals("1")) {
                    chooseSingleOutputFile();
                    break;
                }else if(choice.equals("2")) {
                    chooseOutputMultipleFile();
                    break;
                }
            }

            System.out.println("Let's recap");
            System.out.println("Input : " + StringUtils.join(input.listIterator(), ","));
            System.out.println("Output : " + StringUtils.join(new String[]{output.toString()}, ","));
            System.out.print("Is ok sir ? (y/n)\n");

            if(scanner.nextLine().equalsIgnoreCase("y")) {
                startEngine();
                break;
            }
        }

    }

    private static void startEngine() {
        SimpleParser simpleParser = new SimpleParser(new Ascii());
        OCREngine engine = OCREngineBuilder.create()
                .logger(logger)
                .readers(input)
                .writer(output)
                .parser(simpleParser)
                .build();

        engine.readFile();
        engine.parse();
        engine.write();
    }

    private static void chooseSingleOutputFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Output\n> ");
        FileWriter fw = new FileWriter(scanner.nextLine());
        output.put(FileType.ALL, fw);
    }

    private static void chooseInputFile() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the input file text (q for quit):\n> ");
            String file = scanner.nextLine();
            if(!file.equalsIgnoreCase("q")) {
                input.add(new FileReader(file));
            }else {
                break;
            }
        }
    }

    private static void chooseOutputMultipleFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Output for authorized\n> ");
        output.put(FileType.AUTHORIZED, new FileWriter(scanner.nextLine()));
        System.out.print("Output for illegal result\n> ");
        output.put(FileType.ILLEGAL, new FileWriter(scanner.nextLine()));
        System.out.print("Output for unknown result\n> ");
        output.put(FileType.UNKNOWN, new FileWriter(scanner.nextLine()));
    }
}

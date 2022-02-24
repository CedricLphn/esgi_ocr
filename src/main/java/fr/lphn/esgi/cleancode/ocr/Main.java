package fr.lphn.esgi.cleancode.ocr;

import fr.lphn.esgi.cleancode.ocr.utils.LogoAscii;
import org.codehaus.plexus.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<String> input = new ArrayList<>();
    private static List<String> output = new ArrayList<>();

    public static void main(String[] args) throws IOException {

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
            System.out.println("Output : " + StringUtils.join(output.listIterator(), ","));
            System.out.print("It's ok sir ? (y/n)\n");

            if(scanner.nextLine().equalsIgnoreCase("y")) {
                break;
            }
        }

        //Scanner scanner = new Scanner();

        /*
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

        for (int i = 0; i < strings.size(); i += 4) {
            String currentLine = strings.get(i);
            StringBuilder account = new StringBuilder();
            for (int column = 0; column < currentLine.length(); column += 3) {
                char[][] converter = new ListStringToChar(strings).convert(i, column);
                try {
                    int parse = parser.parse(converter);
                    account.append(parse);
                } catch (IllegalNumberException e) {
                    account.append('?');
                    System.out.println(e.getMessage());
                }
            }
            System.out.println(account);
            accounts.add(account.toString());
        }

        FileWriter tst = new FileWriter(new File("hey.txt"));
        for (String account : accounts) {
            int nbr = 0;

            boolean isValidAccount = true;
            for (int i = 0; i < account.length(); i++) {
                if (account.charAt(i) != '?' && isValidAccount) {
                    nbr = nbr + parseInt(account.substring(i, i + 1)) * (account.length() - i);
                } else {
                    isValidAccount = false;
                }
            }

            String result;
            if (isValidAccount && nbr % 11 == 0) result = "";
            else if (!isValidAccount) result = "ILL";
            else result = "ERR";
            //System.out.println((isValidAccount && nbr % 11 == 0) ? true : "ERR");
            tst.write(account + " " + result);

        }

        //console.log(String.valueOf(number.is(test, 1)));
         */
    }

    private static void chooseSingleOutputFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Output\n> ");
        output.add(scanner.nextLine());
    }

    private static void chooseInputFile() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the input file text (q for quit):\n> ");
            String file = scanner.nextLine();
            if(!file.equalsIgnoreCase("q")) {
                input.add(file);
            }else {
                break;
            }
        }
    }

    private static void chooseOutputMultipleFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Output for authorized\n> ");
        output.add(scanner.nextLine());
        System.out.print("Output for wrong result\n> ");
        output.add(scanner.nextLine());
        System.out.print("Output for unknown result\n> ");
        output.add(scanner.nextLine());
    }
}

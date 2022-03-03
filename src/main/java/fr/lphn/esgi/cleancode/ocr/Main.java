package fr.lphn.esgi.cleancode.ocr;

public class Main {
    public static void main(String[] args) {
        if(args.length == 0) {
            MainConsole.main(null);
        }else {
            MainCli.run(args);
        }
    }
}

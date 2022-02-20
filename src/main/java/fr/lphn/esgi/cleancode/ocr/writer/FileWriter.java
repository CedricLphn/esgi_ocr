package fr.lphn.esgi.cleancode.ocr.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileWriter implements Writer {
    private final File file;
    private List<String> output;

    public FileWriter(String filename) {
        this.file = new File(filename);
        this.output = new ArrayList<>();
    }

    @Override
    public void get() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                output.add(data);
                System.out.println(data);
            }
            scanner.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write() {

    }
}

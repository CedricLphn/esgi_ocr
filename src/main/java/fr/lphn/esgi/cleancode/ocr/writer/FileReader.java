package fr.lphn.esgi.cleancode.ocr.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader implements Reader<List<String>> {
    private final File file;
    private List<String> output;

    public FileReader(String filename) {
        this.file = new File(filename);
        this.output = new ArrayList<>();
    }

    @Override
    public void read() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                output.add(data);
            }
            scanner.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> get() {
        return output;
    }

    @Override
    public int size() {
        return output.size();
    }
}

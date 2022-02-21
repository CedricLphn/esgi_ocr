package fr.lphn.esgi.cleancode.ocr.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileWriter implements Reader<List<String>> {
    private final File file;
    private List<String> output;

    public FileWriter(String filename) {
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

    private void extract(List<String> content, int entry, int column) {
        char[][] digits = new char[3][3];
        for(int i = 0; i < digits.length; i++) {
            digits[i] = content.get(entry+i).substring(column, column + digits.length).toCharArray();
        }
    }

    @Override
    public List<String> get() {
        return output;
    }

}

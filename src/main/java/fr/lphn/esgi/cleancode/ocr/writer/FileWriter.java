package fr.lphn.esgi.cleancode.ocr.writer;

import java.io.*;

public class FileWriter implements Writer {

    private final File file;

    public FileWriter(File file) {
        this.file = file;
    }

    @Override
    public void write(String message) throws IOException {
        //file.createNewFile();
        PrintWriter fileWriter = new PrintWriter(new java.io.FileWriter(file, true));

        fileWriter.write(message + "\n");
        fileWriter.close();
    }
}

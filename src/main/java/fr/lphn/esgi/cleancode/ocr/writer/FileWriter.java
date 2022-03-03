package fr.lphn.esgi.cleancode.ocr.writer;

import java.io.*;

public class FileWriter implements Writer {

    private final File file;

    public FileWriter(String fileName) {
        this.file = new File(fileName);
    }

    @Override
    public boolean fileExist() {
        return this.file.exists();
    }

    @Override
    public void write(String message) throws IOException {
        if(!fileExist()) {
            if(!file.createNewFile())
                throw new IOException("Cannot create " + file.getName());
        }

        PrintWriter fileWriter = new PrintWriter(new java.io.FileWriter(file, true));

        fileWriter.write(message + "\n");
        fileWriter.close();
    }
}

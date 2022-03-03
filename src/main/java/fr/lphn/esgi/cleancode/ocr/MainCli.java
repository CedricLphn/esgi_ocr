package fr.lphn.esgi.cleancode.ocr;

import com.github.rvesse.airline.SingleCommand;
import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;
import com.github.rvesse.airline.annotations.OptionType;
import fr.lphn.esgi.cleancode.ocr.application.OCREngine;
import fr.lphn.esgi.cleancode.ocr.application.OCREngineBuilder;
import fr.lphn.esgi.cleancode.ocr.logger.ConsoleLogger;
import fr.lphn.esgi.cleancode.ocr.logger.Log;
import fr.lphn.esgi.cleancode.ocr.logger.SilentLogger;
import fr.lphn.esgi.cleancode.ocr.parser.Ascii;
import fr.lphn.esgi.cleancode.ocr.parser.SimpleParser;
import fr.lphn.esgi.cleancode.ocr.writer.FileReader;
import fr.lphn.esgi.cleancode.ocr.writer.FileType;
import fr.lphn.esgi.cleancode.ocr.writer.FileWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Command(name = "cli",
description = "Bureau Valley OCR")
public class MainCli {


    @Option(name = {"-s", "--silent"}, description = "Run Bureau Valley OCR in silent mode")
    public boolean silent = false;

    @Option(type = OptionType.COMMAND,
            name = {"-i", "--input"},
            description = "List of input file",
            title = "--input <INPUT> -i <INPUT>")
    public List<String> input = new ArrayList<>();

    @Option(name = {"-a", "--all-output"}, description = "Output file")
    public String allFile = "";

    @Option(name = {"-w", "--wrong-output"}, description = "Output file for wrong letter")
    public String wrongOutput = "";

    @Option(name = {"-o", "--authorized-output"}, description = "Output file for authorized letter")
    public String authorizedOutput = "";

    @Option(name = {"-l", "--illegal-output"}, description = "Output file for illegal letter")
    public String illegalOutput = "";

    public static void run(String[] args) {
        try {
            SingleCommand<MainCli> cli = SingleCommand.singleCommand(MainCli.class);
            MainCli cmd = cli.parse(args);
            if(cmd.verify()) {
                cmd.run();
            }
        }catch (Exception e) {
            ConsoleLogger consoleLogger = new ConsoleLogger();
            consoleLogger.log(e.getMessage());
        }

    }

    private boolean verify() {
        if(!wrongOutput.equals("") && !authorizedOutput.equals("") && !illegalOutput.equals("") ) {
            return true;
        }else if(!allFile.equals("")) {
            return true;
        }

        return false;
    }

    private void run() {
        Map<FileType, FileWriter> output = new HashMap<>();
        if(!wrongOutput.equals("") && !authorizedOutput.equals("") && !illegalOutput.equals("") ) {
            output.put(FileType.AUTHORIZED, new FileWriter(authorizedOutput));
            output.put(FileType.ILLEGAL, new FileWriter(illegalOutput));
            output.put(FileType.UNKNOWN, new FileWriter(wrongOutput));
        }else if(!allFile.equals("")) {
            output.put(FileType.ALL, new FileWriter(allFile));
        }
        SimpleParser parser = new SimpleParser(new Ascii());
        Log logger = silent ? new SilentLogger() : new ConsoleLogger();

        List<FileReader> fileReaders = new ArrayList<>();
        input.forEach(fileName -> {
            fileReaders.add(new FileReader(fileName));
        });

        OCREngine ocrEngine = OCREngineBuilder.create()
                .logger(logger)
                .parser(parser)
                .readers(fileReaders)
                .writer(output)
                .build();

        ocrEngine.readFile();
        ocrEngine.parse();
        ocrEngine.write();

    }

}

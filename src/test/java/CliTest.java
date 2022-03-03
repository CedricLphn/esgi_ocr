import com.github.rvesse.airline.SingleCommand;
import fr.lphn.esgi.cleancode.ocr.MainCli;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class CliTest{
    private SingleCommand<MainCli> mainCliSingleCommand = SingleCommand
            .singleCommand(MainCli.class);

    @Test
    void GivenSilentArgument_WhenSingleCommandParser_ThenTrue() {
        MainCli mainCli = mainCliSingleCommand.parse("--silent");
        assertTrue(mainCli.silent);
    }

    @Test
    void GivenOneInput_WhenSingleCommandParser_ThenTrue() {
        List<String> input = Collections.singletonList("hello.txt");
        MainCli mainCli = mainCliSingleCommand.parse("--input", "hello.txt");
        assertEquals(input, mainCli.input);
    }

    @Test
    void GivenThreeInput_WhenSingleCommandParser_ThenTrue() {
        List<String> input = List.of("hello.txt", "world.txt", "ocr.txt");
        MainCli mainCli = mainCliSingleCommand.parse("--input", "hello.txt", "-i", "world.txt", "-i", "ocr.txt");
        assertEquals(input, mainCli.input);
    }

    @Test
    void GivenAnOutput_WhenSingleCommandParser_ThenTrue() {
        String output = "output.txt";
        MainCli mainCli = mainCliSingleCommand.parse("-a", "output.txt");
        assertEquals(output, mainCli.allFile);
    }

    @Test
    void GivenAnAuthorized_WhenSingleCommandParser_ThenTrue() {
        String output = "output.txt";
        MainCli mainCli = mainCliSingleCommand.parse("-o", "output.txt");
        assertEquals(output, mainCli.authorizedOutput);
    }

    @Test
    void GivenAnIllegalOutput_WhenSingleCommandParser_ThenTrue() {
        String output = "output.txt";
        MainCli mainCli = mainCliSingleCommand.parse("--illegal-output", "output.txt");
        assertEquals(output, mainCli.illegalOutput);
    }

    @Test
    void GivenAWrongOutput_WhenSingleCommandParser_ThenTrue() {
        String output = "output.txt";
        MainCli mainCli = mainCliSingleCommand.parse("-w", "output.txt");
        assertEquals(output, mainCli.wrongOutput);
    }
}

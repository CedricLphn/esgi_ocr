import fr.lphn.esgi.cleancode.ocr.exceptions.IllegalNumberException;
import fr.lphn.esgi.cleancode.ocr.parser.Ascii;
import fr.lphn.esgi.cleancode.ocr.parser.Parser;
import fr.lphn.esgi.cleancode.ocr.parser.Template;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AsciiTest {

    private static final List<char[][]> numbers = List.of(
            new char[][]{{' ', '_', ' '}, {'|', ' ', '|'}, {'|', '_', '|'}}, // 0
            new char[][]{{' ', ' ', ' '}, {' ', ' ', '|'}, {' ', ' ', '|'}},
            new char[][]{{' ', '_', ' '}, {' ', '_', '|'}, {'|', '_', ' '}},
            new char[][]{{' ', '_', ' '}, {' ', '_', '|'}, {' ', '_', '|'}},
            new char[][]{{' ', ' ', ' '}, {'|', '_', '|'}, {' ', ' ', '|'}},
            new char[][]{{' ', '_', ' '}, {'|', '_', ' '}, {' ', '_', '|'}},
            new char[][]{{' ', '_', ' '}, {'|', '_', ' '}, {'|', '_', '|'}},
            new char[][]{{' ', '_', ' '}, {' ', ' ', '|'}, {' ', ' ', '|'}},
            new char[][]{{' ', '_', ' '}, {'|', '_', '|'}, {'|', '_', '|'}},
            new char[][]{{' ', '_', ' '}, {'|', '_', '|'}, {' ', '_', '|'}}, // 9
            new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}  // Unknown number
    );

    private static Template template;
    private static Parser parser;

    @BeforeAll
    public static void init() {
        template = new Ascii();
        parser = new Parser(template);
    }

    @Test
    public void GivenNone_ThenNone_ReturnZero() throws IllegalNumberException {
        assertEquals(0, parser.parse(numbers.get(0)), 0);
    }

    @Test
    public void GivenNone_ThenNone_ReturnOne() throws IllegalNumberException {
        assertEquals(1, parser.parse(numbers.get(1)), 0);
    }

    @Test
    public void GivenNone_ThenNone_ReturnTwo() throws IllegalNumberException {
        assertEquals(2, parser.parse(numbers.get(2)), 0);
    }

    @Test
    public void GivenNone_ThenNone_ReturnThree() throws IllegalNumberException {
        assertEquals(3, parser.parse(numbers.get(3)), 0);
    }

    @Test
    public void GivenNone_ThenNone_ReturnFour() throws IllegalNumberException {
        assertEquals(4, parser.parse(numbers.get(4)), 0);
    }

    @Test
    public void GivenNone_ThenNone_ReturnFive() throws IllegalNumberException {
        assertEquals(5, parser.parse(numbers.get(5)), 0);
    }

    @Test
    public void GivenNone_ThenNone_ReturnSix() throws IllegalNumberException {
        assertEquals(6, parser.parse(numbers.get(6)), 0);
    }

    @Test
    public void GivenNone_ThenNone_ReturnSeven() throws IllegalNumberException {
        assertEquals(7, parser.parse(numbers.get(7)), 0);
    }

    @Test
    public void GivenNone_ThenNone_ReturnEight() throws IllegalNumberException {
        assertEquals(8, parser.parse(numbers.get(8)), 0);
    }

    @Test
    public void GivenNone_ThenNone_ReturnNine() throws IllegalNumberException {
        assertEquals(9, parser.parse(numbers.get(9)), 0);
    }

    @Test
    public void GivenNone_ThenNone_ReturnThrowException() {
        assertThrows(IllegalNumberException.class, () -> {
            parser.parse(numbers.get(10));
        });
    }

}

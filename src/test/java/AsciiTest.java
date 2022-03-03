import fr.lphn.esgi.cleancode.ocr.exceptions.IllegalNumberException;
import fr.lphn.esgi.cleancode.ocr.parser.Ascii;
import fr.lphn.esgi.cleancode.ocr.parser.SimpleParser;
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
    private static SimpleParser parser;

    @BeforeAll
    public static void init() {
        template = new Ascii();
        parser = new SimpleParser(template);
    }

    @Test
    public void Given2DArray_WhenParse_ThenZero() throws IllegalNumberException {
        assertEquals(0, parser.parse(numbers.get(0)), 0);
    }

    @Test
    public void Given2DArray_WhenParse_ThenOne() throws IllegalNumberException {
        assertEquals(1, parser.parse(numbers.get(1)), 0);
    }

    @Test
    public void Given2DArray_WhenParse_ThenTwo() throws IllegalNumberException {
        assertEquals(2, parser.parse(numbers.get(2)), 0);
    }

    @Test
    public void Given2DArray_WhenParse_ThenThree() throws IllegalNumberException {
        assertEquals(3, parser.parse(numbers.get(3)), 0);
    }

    @Test
    public void Given2DArray_WhenParse_ThenFour() throws IllegalNumberException {
        assertEquals(4, parser.parse(numbers.get(4)), 0);
    }

    @Test
    public void Given2DArray_WhenParse_ThenFive() throws IllegalNumberException {
        assertEquals(5, parser.parse(numbers.get(5)), 0);
    }

    @Test
    public void Given2DArray_WhenParse_ThenSix() throws IllegalNumberException {
        assertEquals(6, parser.parse(numbers.get(6)), 0);
    }

    @Test
    public void Given2DArray_WhenParse_ThenSeven() throws IllegalNumberException {
        assertEquals(7, parser.parse(numbers.get(7)), 0);
    }

    @Test
    public void Given2DArray_WhenParse_ThenEight() throws IllegalNumberException {
        assertEquals(8, parser.parse(numbers.get(8)), 0);
    }

    @Test
    public void Given2DArray_WhenParse_ThenNine() throws IllegalNumberException {
        assertEquals(9, parser.parse(numbers.get(9)), 0);
    }

    @Test
    public void Given2DArray_WhenParse_ThenIllegalNumberException() {
        assertThrows(IllegalNumberException.class, () -> {
            parser.parse(numbers.get(10));
        });
    }

}

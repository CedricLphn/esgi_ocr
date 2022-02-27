import fr.lphn.esgi.cleancode.ocr.converter.Converter;
import fr.lphn.esgi.cleancode.ocr.converter.ListStringToChar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class ConverterTest {

    private static Converter converter;
    private static List<String> ascii = List.of(
            "    _  _     _  _  _  _  _ ",
            "  | _| _||_||_ |_   ||_||_|",
            "  ||_  _|  | _||_|  ||_| _|",
            ""
    );
    private final List<char[][]> result = List.of(
            new char[][]{{' ', ' ', ' '}, {' ', ' ', '|'}, {' ', ' ', '|'}},
            new char[][]{{' ', '_', ' '}, {' ', '_', '|'}, {'|', '_', ' '}},
            new char[][]{{' ', '_', ' '}, {' ', '_', '|'}, {' ', '_', '|'}},
            new char[][]{{' ', ' ', ' '}, {'|', '_', '|'}, {' ', ' ', '|'}},
            new char[][]{{' ', '_', ' '}, {'|', '_', ' '}, {' ', '_', '|'}},
            new char[][]{{' ', '_', ' '}, {'|', '_', ' '}, {'|', '_', '|'}},
            new char[][]{{' ', '_', ' '}, {' ', ' ', '|'}, {' ', ' ', '|'}},
            new char[][]{{' ', '_', ' '}, {'|', '_', '|'}, {'|', '_', '|'}},
            new char[][]{{' ', '_', ' '}, {'|', '_', '|'}, {' ', '_', '|'}} // 9
    );

    @BeforeAll
    static void init() {
        converter = new ListStringToChar(ascii);
    }

    @Test
    void GivenAListOfString_WhenIConvertToChar_Givenjsaispas() {
        char[][] numbers;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < ascii.size(); i += 4) {
            String currentLine = ascii.get(i);
            for(int j = 0; j < currentLine.length(); j += 3) {
                char[][] tmp = (char[][]) converter.convert(i ,j);
                res.append(tmp);
            }
        }
        //assertEquals("", res.toString());

    }

}

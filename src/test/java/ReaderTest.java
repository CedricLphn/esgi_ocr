import fr.lphn.esgi.cleancode.ocr.writer.FileReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class ReaderTest {
    private static FileReader reader;
    private static final List<String> result = List.of(
                    "    _  _     _  _  _  _  _ ",
            "  | _| _||_||_ |_   ||_||_|",
            "  ||_  _|  | _||_|  ||_| _|",
            "",
            "    _  _     _  _  _  _  _ ",
            "  | _| _||_||_ |_   ||_||_|",
            "  ||_  _|  | _||_|  ||_| _|",
            "",
            "    _  _     _  _  _  _  _ ",
            "  | _|  |  | _||_   ||_|| |",
            "  ||_  _|  | _||_|  ||_| _|",
            "",
            "    _  _     _  _  _  _  _ ",
            "  | _|  |  | _||_   ||_|| |",
            "  ||_  _|  | _||_|  ||_| _|",
            "  ");

    @BeforeAll
    static void init() {
        reader = new FileReader("src/main/resources/test.txt");
    }

    @Test
    void GivenAFile_WhenRead_ThenDataNotNull() {
        reader.read();
        List<String> strings = reader.get();

        assertEquals(result, strings);
    }


}

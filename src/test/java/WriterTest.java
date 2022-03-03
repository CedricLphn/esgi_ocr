import fr.lphn.esgi.cleancode.ocr.writer.FileReader;
import fr.lphn.esgi.cleancode.ocr.writer.FileWriter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class WriterTest {

    private static FileWriter fw;

    @BeforeAll
    private static void init() {
        fw = new FileWriter("src/main/resources/test_writer.txt");
    }

    @Test
    public void GivenNone_WhenCreate_ReturnData() throws IOException {
        fw.write("Hello");

        FileReader fr = new FileReader("src/main/resources/test_writer.txt");
        fr.read();
        String textFile = fr.get().get(0);
        assertEquals("Hello", textFile);

    }

    @AfterAll
    private static void destroy() {
        File file = new File("src/main/resources/test_writer.txt");
        file.delete();
    }

}

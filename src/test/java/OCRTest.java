import fr.lphn.esgi.cleancode.ocr.application.OCREngine;
import fr.lphn.esgi.cleancode.ocr.application.OCREngineBuilder;
import fr.lphn.esgi.cleancode.ocr.logger.SilentLogger;
import fr.lphn.esgi.cleancode.ocr.parser.Ascii;
import fr.lphn.esgi.cleancode.ocr.parser.SimpleParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.*;

public class OCRTest {

    private static OCREngine ocr;

    @BeforeAll
    static void init() {
        ocr = OCREngineBuilder.create()
                .logger(new SilentLogger())
                .parser(new SimpleParser(new Ascii()))
                .readers(null)
                .writer(null)
                .build();
    }

    @Test
    void GivenALetter_WhenChecksum_ThenTrue() {
        assertTrue(ocr.checksum("123456789"));
    }

    @Test
    void GivenWrongLetter_WhenChecksum_ThenFalse() {
        assertFalse(ocr.checksum("123456788"));
    }

    @Test
    void GivenALetter_WhenIsIllegal_ThenFalse() {
        assertFalse(ocr.isIllegal("123456789"));
    }

    @Test
    void GivenAnIllegalLetter_WhenIsIllegal_ThenTrue() {
        assertTrue(ocr.isIllegal("1234567?9"));
    }

    @Test
    void GivenALetter_WhenAssignateLetters_ThenLetter() {
        assertEquals("123456789", ocr.assignateLetters("123456789"));
    }

    @Test
    void GivenALetter_WhenAssignateLettters_ThenLetterAndERR() {
        assertEquals("123456729 ERR", ocr.assignateLetters("123456729"));
    }

    @Test
    void GivenALetter_WhenAssignateLettters_ThenLetterAndILL() {
        assertEquals("12345?789 ILL", ocr.assignateLetters("12345?789"));
    }

    @Test
    void GivenAIllegalLetter_WhenChecksum_ThenFalse() {
        assertFalse(ocr.checksum("123?56789"));
    }

}

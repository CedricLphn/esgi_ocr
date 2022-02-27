import fr.lphn.esgi.cleancode.ocr.application.OCREngine;
import fr.lphn.esgi.cleancode.ocr.application.OCREngineBuilder;
import fr.lphn.esgi.cleancode.ocr.logger.Silent;
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
                .logger(new Silent())
                .parser(new SimpleParser(new Ascii()))
                .readers(null)
                .writer(null)
                .build();
    }

    @Test
    void GivenALetter_WhenICheckTheChecksum_ThenIHaveATrueResult() {
        assertTrue(ocr.checksum("123456789"));
    }

    @Test
    void GivenWrongLetter_WhenICheckTheChecksum_ThenIHaveAFalseResult() {
        assertFalse(ocr.checksum("123456788"));
    }

    @Test
    void GivenALetter_WhenICheckanIllegalNumber_ThenIHaveAFalseResult() {
        assertFalse(ocr.isIllegal("123456789"));
    }

    @Test
    void GivenAnIllegalLetter_WhenICheckanIllegalNumber_ThenIHaveATrueResult() {
        assertTrue(ocr.isIllegal("1234567?9"));
    }

    @Test
    void GivenALetter_WhenIAssignATrueChecksumAndALegalLetter_ThenIHaveALetterResult() {
        assertEquals("123456789", ocr.assignateLetters("123456789"));
    }

    @Test
    void GivenALetter_WhenIAssignAWrongChecksumAndALegalLetter_ThenIHaveALetterResultAndERR() {
        assertEquals("123456729 ERR", ocr.assignateLetters("123456729"));
    }

    @Test
    void GivenALetter_WhenIAssignAnIllegalLetter_ThenIHaveALetterResultAndILL() {
        assertEquals("123?5672? ILL", ocr.assignateLetters("123?5672?"));
    }

}

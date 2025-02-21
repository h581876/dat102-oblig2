package oppgave2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Oppgave2Test {
	
	private Integer[] usortertTabell = {5, 9, 1, 3, 7, 6, 8, 2, 4, 0};
    private Integer[] sortertTabell = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    void testInnsettingsSortering() {
        Integer[] kopi = Arrays.copyOf(usortertTabell, usortertTabell.length);
        Oppgave2.innsettingsSortering(kopi);
        assertArrayEquals(sortertTabell, kopi);
    }

    @Test
    void testUtvalgssortering() {
        Integer[] kopi = Arrays.copyOf(usortertTabell, usortertTabell.length);
        Oppgave2.utvalgssortering(kopi);
        assertArrayEquals(sortertTabell, kopi);
    }

    @Test
    void testKvikksortering() {
        Integer[] kopi = Arrays.copyOf(usortertTabell, usortertTabell.length);
        Oppgave2.kvikksortering(kopi, 0, kopi.length - 1);
        assertArrayEquals(sortertTabell, kopi);
    }

    @Test
    void testFlettesortering() {
        Integer[] kopi = Arrays.copyOf(usortertTabell, usortertTabell.length);
        Oppgave2.flettesortering(kopi, 0, kopi.length - 1);
        assertArrayEquals(sortertTabell, kopi);
    }
}



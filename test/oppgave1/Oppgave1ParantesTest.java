package oppgave1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class Oppgave1ParantesTest {
	
	Oppgave1Parantes ps = new Oppgave1Parantes();

    @Test
    public void testErStartParantes() {
        // Test at metoden returnerer true for startparenteser
        assertTrue(ps.erStartParantes('{'));
        assertTrue(ps.erStartParantes('['));
        assertTrue(ps.erStartParantes('('));
        
        // Test at metoden returnerer false for ikke-startparenteser
        assertFalse(ps.erStartParantes('}'));
        assertFalse(ps.erStartParantes(']'));
        assertFalse(ps.erStartParantes(')'));
    }
    
    @Test
    public void testErSluttParantes() {
        // Test at metoden returnerer true for sluttparenteser
        assertTrue(ps.erSluttParantes('}'));
        assertTrue(ps.erSluttParantes(']'));
        assertTrue(ps.erSluttParantes(')'));
        
        // Test at metoden returnerer false for ikke-sluttparenteser
        assertFalse(ps.erSluttParantes('{'));
        assertFalse(ps.erSluttParantes('['));
        assertFalse(ps.erSluttParantes('('));
    }
    
    @Test
    public void testErParantesPar() {
        // Test at metoden returnerer true for gyldige par
        assertTrue(ps.erParantesPar('{', '}'));
        assertTrue(ps.erParantesPar('[', ']'));
        assertTrue(ps.erParantesPar('(', ')'));

        // Test at metoden returnerer false for ugyldige par
        assertFalse(ps.erParantesPar('{', ')'));
        assertFalse(ps.erParantesPar('[', '}'));
        assertFalse(ps.erParantesPar('(', ']'));
    }
    
    @Test
    public void testSjekkParenteser() {
        // Test at metoden returnerer true for gyldige strenger
        assertTrue(ps.sjekkParenteser("{[()]}"));
        assertTrue(ps.sjekkParenteser("()"));
        assertTrue(ps.sjekkParenteser("[]{}"));

        // Test at metoden returnerer false for ugyldige strenger
        assertFalse(ps.sjekkParenteser("{[()]}{"));
        assertFalse(ps.sjekkParenteser("[{)]"));
        assertFalse(ps.sjekkParenteser("[{(})]"));
    }

}

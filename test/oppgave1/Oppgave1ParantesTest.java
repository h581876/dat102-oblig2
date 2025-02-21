package oppgave1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class Oppgave1ParantesTest {
	
	Oppgave1Parantes ps = new Oppgave1Parantes();

    @Test
    public void testErStartParantes() {
        assertTrue(ps.erStartParantes('{'));
        assertTrue(ps.erStartParantes('['));
        assertTrue(ps.erStartParantes('('));
        
        assertFalse(ps.erStartParantes('}'));
        assertFalse(ps.erStartParantes(']'));
        assertFalse(ps.erStartParantes(')'));
    }
    
    @Test
    public void testErSluttParantes() {
        assertTrue(ps.erSluttParantes('}'));
        assertTrue(ps.erSluttParantes(']'));
        assertTrue(ps.erSluttParantes(')'));
        
        assertFalse(ps.erSluttParantes('{'));
        assertFalse(ps.erSluttParantes('['));
        assertFalse(ps.erSluttParantes('('));
    }
    
    @Test
    public void testErParantesPar() {
        assertTrue(ps.erParantesPar('{', '}'));
        assertTrue(ps.erParantesPar('[', ']'));
        assertTrue(ps.erParantesPar('(', ')'));

        assertFalse(ps.erParantesPar('{', ')'));
        assertFalse(ps.erParantesPar('[', '}'));
        assertFalse(ps.erParantesPar('(', ']'));
    }
    
    @Test
    public void testSjekkParenteser() {
        assertTrue(ps.sjekkParenteser("{[()]}"));
        assertTrue(ps.sjekkParenteser("()"));
        assertTrue(ps.sjekkParenteser("[]{}"));

        assertFalse(ps.sjekkParenteser("{[()]}{"));
        assertFalse(ps.sjekkParenteser("[{)]"));
        assertFalse(ps.sjekkParenteser("[{(})]"));
    }

}

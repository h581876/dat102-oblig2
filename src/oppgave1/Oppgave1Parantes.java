package oppgave1;



public class Oppgave1Parantes {
	
	public boolean erStartParantes(char c) {
		if (c == '{' || c == '[' || c == '(') {
			return true;
		}
		return false;
	}
	
	public boolean erSluttParantes(char c) {
		if (c == '}' || c == ']' || c == ')') {
			return true;
		}
		return false;
	}
	
	public boolean erParantesPar(char start, char slutt) {
	    return (start == '{' && slutt == '}') ||
	           (start == '[' && slutt == ']') ||
	           (start == '(' && slutt == ')');
	}
	
	public boolean sjekkParenteser(String s) {
		StabelADT<Character> stabel = new Stabel<>();
		
		for (char c: s.toCharArray()) {
			if (erStartParantes(c)) {
				stabel.push(c);
			} else if (erSluttParantes(c)) {
				if (stabel.isEmpty()) 
					return false;
				char start = stabel.pop();
				if (!erParantesPar(start, c))
					return false;
			}
		}
		return stabel.isEmpty();
	}

	
	public static void main(String[] args) {
        Oppgave1Parantes sjekker = new Oppgave1Parantes();
        System.out.println(sjekker.sjekkParenteser("({[]})")); // true
        System.out.println(sjekker.sjekkParenteser("({[})"));  // false
    }

}

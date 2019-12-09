package com.zoca.api;

public class Dna {
	private static int count = 0;
	private static final String[] SEQUENCIA_DNA_SIMIOS = {"AAAA", "CCCC", "GGGG", "TTTT"};

	public static void main(String[] args) {
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};

        Dna dna_object = new Dna();
        dna_object.isSimio(dna);
        if (count >= 2) {
        	System.out.println("É símio!");
        } else {
        	System.out.println("É Humano!");
        }
    }

    private boolean isSimio(String[] dna) {
        int n = dna.length;
        ////////////////////
        
        // Diagonal 1
        diagonal1(dna);
        
        ////////////////////////////////
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < n-3) {

                    // Diagonal
                    if (j < n-3) {
                        String d = "";
                        char gen = dna[i].charAt(j);
                        d += gen;
                        d += dna[i+1].charAt(j+1);
                        d += dna[i+2].charAt(j+2);
                        d += dna[i+3].charAt(j+3);
                        String replaced_string = d.replace(String.valueOf(gen), "");
                        if (replaced_string.length() == 0) {
                        	count++;
                            return true;
                        }
                    }

                    // Vertical
                    String v = "";
                    char gen = dna[i].charAt(j);
                    v += gen;
                    v += dna[i+1].charAt(j);
                    v += dna[i+2].charAt(j);
                    v += dna[i+3].charAt(j);
                    String replaced_string = v.replace(String.valueOf(gen), "");
                    if (replaced_string.length() == 0) {
                    	count++;
                        return true;
                    }
                }

                // Horizontal
                if (j < n-3) {
                    String h = "";
                    char gen = dna[i].charAt(j);
                    h += gen;
                    h += dna[i].charAt(j+1);
                    h += dna[i].charAt(j+2);
                    h += dna[i].charAt(j+3);
                    String replaced_string = h.replace(String.valueOf(gen), "");
                    if (replaced_string.length() == 0) {
                    	count++;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private int diagonal1(String[] dna) {
    	String dd = "";
    	char gen2 = dna[2].charAt(0);
    	dd += gen2;
    	dd += dna[3].charAt(1);
    	dd += dna[4].charAt(2);
    	dd += dna[5].charAt(3);
    	String stringSubs = dd.replace(String.valueOf(gen2), "");
    	if (stringSubs.length() == 0) {
    		return count++;
//    		return true;
    	}
		return 0;
    }
}

package com.zoca.api;

public class Dna3 {
	private int count = 0;
	private static final String[] SEQUENCIA_DNA_SIMIOS = {"AAAA", "CCCC", "GGGG", "TTTT"};

	public static void main(String[] args) {
		String[] dna = {"ATGCGA", "CAGTGC", "TTTTGT", "AAAAAG", "CCTTTA", "TCACTG"};
//		String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};

		Dna3 dna_object = new Dna3();

		if (dna_object.ehSimio(dna)) {
			System.out.println("É símio!");
		} else {
			System.out.println("É Humano!");
		}
	}

	private boolean ehSimio(String[] dna) {
		int n = dna.length;
		int contador = 0, lin = 0, col = 0;

//		for (String dnaSeq : SEQUENCIA_DNA_SIMIOS) {

			//Diagonais
//		contador += diagonal1_5(dna, lin+2, col, dnaSeq); //diagonal 1
			contador =+ diagonal1_5(dna, lin+2, col); //diagonal 1
			contador =+ diagonal2_4(dna, lin+1, col); //diagonal 2
			if (simio(contador))
				return Boolean.TRUE;
			contador =+ diagonal3(dna, lin, col);   //diagonal 3
			if (simio(contador))
				return Boolean.TRUE;
			contador =+ diagonal2_4(dna, lin, col+1); //diagonal 4
			if (simio(contador))
				return Boolean.TRUE;
			contador =+ diagonal1_5(dna, lin, col+2); //diagonal 5
			if (simio(contador))
				return Boolean.TRUE;
			contador =+ diagonal6_10(dna, lin+3, col); //diagonal 6
			if (simio(contador))
				return Boolean.TRUE;
			contador =+ diagonal7_9(dna, lin+4, col); //diagonal 7
			if (simio(contador))
				return Boolean.TRUE;
			contador =+ diagonal8(dna, lin+5, col);   //diagonal 8
			if (simio(contador))
				return Boolean.TRUE;
			contador =+ diagonal7_9(dna, lin+5, col+1); //diagonal 9
			if (simio(contador))
				return Boolean.TRUE;
			contador =+ diagonal6_10(dna, lin+5, col+2); //diagonal 10
			if (simio(contador))
				return Boolean.TRUE;
//		}

//		if (contador >= 2) {
//			return Boolean.TRUE;
//		}

		//Horizontais
		for (int i = 0; i < n; i++) {
			String h = "";
			for (int j = 0; j < n; j++) {
				h += dna[i].charAt(j);
			}
			for (String dnaSeqH : SEQUENCIA_DNA_SIMIOS) {
				if (h.contains(dnaSeqH)) {
					contador++;
				}
				if (contador >= 2) {
					return Boolean.TRUE;
				}
			}
		}

		//Verticais
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < n; j++) {
				String v = "";
				char gen = dna[i].charAt(j);
				v += gen;
				v += dna[i+1].charAt(j);
				v += dna[i+2].charAt(j);
				v += dna[i+3].charAt(j);
				v += dna[i+4].charAt(j);
				v += dna[i+5].charAt(j);
				for (String dnaSeqV : SEQUENCIA_DNA_SIMIOS) {
					if (v.contains(dnaSeqV)) {
						contador++;
					}
					if (contador >= 2) {
						return Boolean.TRUE;
					}
				}
			}
		}
		return Boolean.FALSE;
	}

	private int diagonal1_5(String[] dna, int lin, int col) {
		String d = "";
		char gen = dna[lin].charAt(col);
		d += gen;
		d += dna[lin+1].charAt(col+1);
		d += dna[lin+2].charAt(col+2);
		d += dna[lin+3].charAt(col+3);
		for (String dnaSeqD : SEQUENCIA_DNA_SIMIOS) {
			if (d.contains(dnaSeqD)) {
				++count;
			}
			if (count >= 2) {
				return count;
			}
		}
		return count;
	}
	private int diagonal6_10(String[] dna, int lin, int col) {
		String d = "";
		char gen = dna[lin].charAt(col);
		d += gen;
		d += dna[lin-1].charAt(col+1);
		d += dna[lin-2].charAt(col+2);
		d += dna[lin-3].charAt(col+3);
		for (String dnaSeqD : SEQUENCIA_DNA_SIMIOS) {
			if (d.contains(dnaSeqD)) {
				++count;
			}
			if (count >= 2) {
				return count;
			}
		}
		return count;
	}
	private int diagonal2_4(String[] dna, int lin, int col) {
		String d = "";
		char gen = dna[lin].charAt(col);
		d += gen;
		d += dna[lin+1].charAt(col+1);
		d += dna[lin+2].charAt(col+2);
		d += dna[lin+3].charAt(col+3);
		d += dna[lin+4].charAt(col+4);
		for (String dnaSeqD : SEQUENCIA_DNA_SIMIOS) {
			if (d.contains(dnaSeqD)) {
				++count;
			}
			if (count >= 2) {
				return count;
			}
		}
		return count;
	}
	private int diagonal7_9(String[] dna, int lin, int col) {
		String d = "";
		char gen = dna[lin].charAt(col);
		d += gen;
		d += dna[lin-1].charAt(col+1);
		d += dna[lin-2].charAt(col+2);
		d += dna[lin-3].charAt(col+3);
		d += dna[lin-4].charAt(col+4);
		for (String dnaSeqD : SEQUENCIA_DNA_SIMIOS) {
			if (d.contains(dnaSeqD)) {
				++count;
			}
			if (count >= 2) {
				return count;
			}
		}
		return count;
	}
	private int diagonal3(String[] dna, int lin, int col) {
		String d = "";
		char gen = dna[lin].charAt(col);
		d += gen;
		d += dna[lin+1].charAt(col+1);
		d += dna[lin+2].charAt(col+2);
		d += dna[lin+3].charAt(col+3);
		d += dna[lin+4].charAt(col+4);
		d += dna[lin+5].charAt(col+5);
		for (String dnaSeqD : SEQUENCIA_DNA_SIMIOS) {
			if (d.contains(dnaSeqD)) {
				count++;
			}
			if (count >= 2) {
				return count;
			}
		}
		return count;
	}
	//	private int diagonal3(String[] dna, int lin, int col, String dnaSeq) {
	//		String d = "";
	//		char gen = dna[lin].charAt(col);
	//		d += gen;
	//		d += dna[lin+1].charAt(col+1);
	//		d += dna[lin+2].charAt(col+2);
	//		d += dna[lin+3].charAt(col+3);
	//		d += dna[lin+4].charAt(col+4);
	//		d += dna[lin+5].charAt(col+5);
	//		if (d.contains(dnaSeq)) {
	//			return 1;
	//		}
	//		return 0;
	//	}
	private int diagonal8(String[] dna, int lin, int col) {
		String d = "";
		char gen = dna[lin].charAt(col);
		d += gen;
		d += dna[lin-1].charAt(col+1);
		d += dna[lin-2].charAt(col+2);
		d += dna[lin-3].charAt(col+3);
		d += dna[lin-4].charAt(col+4);
		d += dna[lin-5].charAt(col+5);
		for (String dnaSeqD : SEQUENCIA_DNA_SIMIOS) {
			if (d.contains(dnaSeqD)) {
				++count;
			}
			if (count >= 2) {
				return count;
			}
		}
		return count;
	}

	private boolean simio (int contador) {
		if (contador >= 2) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	//	private int horizontal (String[] dna, int lin, int col, String dnaSeq) {
	//		String h = "";
	//		char gen = dna[lin].charAt(col);
	//		h += gen;
	//		h += dna[lin].charAt(col);
	//		h += dna[lin].charAt(col);
	//		h += dna[lin].charAt(col);
	//		h += dna[lin].charAt(col);
	//		h += dna[lin].charAt(col);
	//		if (h.contains(dnaSeq)) {
	//			return 1;
	//		}
	//		return 0;
	//	}
}

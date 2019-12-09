package com.zoca.api;

public class Dna2 {
	private int count = 0;
	private static final String[] SEQUENCIA_DNA_SIMIOS = {"AAAA", "CCCC", "GGGG", "TTTT"};

	public static void main(String[] args) {
		String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};

		Dna2 dna_object = new Dna2();
		//		dna_object.isSimio(dna);
		if (dna_object.isSimio(dna)) {
			System.out.println("É símio!");
		} else {
			System.out.println("É Humano!");
		}
	}

	private boolean ehSimio (int contador) {
		if (contador >= 2) {
			return true;
		}
		return false;
	}

	private boolean isSimio(String[] dna) {
		int n = dna.length;
		int contador = 0, lin = 0, col = 0;

		for (String dnaSeq : SEQUENCIA_DNA_SIMIOS) {
			//Diagonais
			contador += diagonal1_5(dna, lin+2, col, dnaSeq); //diagonal 1
			contador += diagonal2_4(dna, lin+1, col, dnaSeq); //diagonal 2
			if (ehSimio(contador))
				break;
			contador += diagonal3(dna, lin, col, dnaSeq);   //diagonal 3
			if (ehSimio(contador))
				break;
			contador += diagonal2_4(dna, lin, col+1, dnaSeq); //diagonal 4
			if (ehSimio(contador))
				break;
			contador += diagonal1_5(dna, lin, col+2, dnaSeq); //diagonal 5
			if (ehSimio(contador))
				break;
			contador += diagonal6_10(dna, lin+3, col, dnaSeq); //diagonal 6
			if (ehSimio(contador))
				break;
			contador += diagonal7_9(dna, lin+4, col, dnaSeq); //diagonal 7
			if (ehSimio(contador))
				break;
			contador += diagonal8(dna, lin+5, col, dnaSeq);   //diagonal 8
			if (ehSimio(contador))
				break;
			contador += diagonal7_9(dna, lin+5, col+1, dnaSeq); //diagonal 9
			if (ehSimio(contador))
				break;
			contador += diagonal6_10(dna, lin+5, col+2, dnaSeq); //diagonal 10
			if (ehSimio(contador))
				break;
		}

		if (contador >= 2) {
			return Boolean.TRUE;
		}

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
					break;
				}
			}
			if (contador >= 2) {
				return Boolean.TRUE;
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
						break;
					}
				}
			}
			if (contador >= 2) {
				return Boolean.TRUE;
			}
		}
		return false;
	}
	//			}
	//			if (i == 1) {
	//				for (String dnaSeq : SEQUENCIA_DNA_SIMIOS) {
	//					diagonalTest2(dna, i, i-1, dnaSeq);	
	//				}
	//			}
	//			if (i == 2) {
	//				for (String dnaSeq : SEQUENCIA_DNA_SIMIOS) {
	//					diagonalTest1(dna, i, i-2, dnaSeq);	
	//				}
	//			}
	//			if (i == 4) {
	//				for (String dnaSeq : SEQUENCIA_DNA_SIMIOS) {
	//					diagonalTest1(dna, i, i-2, dnaSeq);	
	//				}
	//			}
	//		}
	// Diagonal 1
	//		diagonal5(dna);

	////////////////////////////////
	//		for (int i = 0; i < n; i++) {
	//			for (int j = 0; j < n; j++) {
	//				if (i < n-3) {

	//					// Diagonal
	//					if (j < n-3) {
	//						String d = "";
	//						char gen = dna[i].charAt(j);
	//						d += gen;
	//						d += dna[i+1].charAt(j+1);
	//						d += dna[i+2].charAt(j+2);
	//						d += dna[i+3].charAt(j+3);
	//						String replaced_string = d.replace(String.valueOf(gen), "");
	//						if (replaced_string.length() == 0) {
	//							count++;
	//							return true;
	//						}
	//					}
	//
	//					// Vertical
	//					String v = "";
	//					char gen = dna[i].charAt(j);
	//					v += gen;
	//					v += dna[i+1].charAt(j);
	//					v += dna[i+2].charAt(j);
	//					v += dna[i+3].charAt(j);
	//					String replaced_string = v.replace(String.valueOf(gen), "");
	//					if (replaced_string.length() == 0) {
	//						count++;
	//						return true;
	//					}
	//				}

	//				// Horizontal
	//				if (j < n-3) {
	//					String h = "";
	//					char gen = dna[i].charAt(j);
	//					h += gen;
	//					h += dna[i].charAt(j+1);
	//					h += dna[i].charAt(j+2);
	//					h += dna[i].charAt(j+3);
	//					String replaced_string = h.replace(String.valueOf(gen), "");
	//					if (replaced_string.length() == 0) {
	//						count++;
	//						return true;
	//					}
	//				}
	//			}
	//		}
	//		return false;
	//	}

	private int diagonal1_5(String[] dna, int lin, int col, String dnaSeq) {
		String d = "";
		char gen = dna[lin].charAt(col);
		d += gen;
		d += dna[lin+1].charAt(col+1);
		d += dna[lin+2].charAt(col+2);
		d += dna[lin+3].charAt(col+3);
		if (d.contains(dnaSeq)) {
			return ++count;
		}
		return 0;
	}
	private int diagonal6_10(String[] dna, int lin, int col, String dnaSeq) {
		String d = "";
		char gen = dna[lin].charAt(col);
		d += gen;
		d += dna[lin-1].charAt(col+1);
		d += dna[lin-2].charAt(col+2);
		d += dna[lin-3].charAt(col+3);
		if (d.contains(dnaSeq)) {
			return ++count;
		}
		return 0;
	}
	private int diagonal2_4(String[] dna, int lin, int col, String dnaSeq) {
		String d = "";
		char gen = dna[lin].charAt(col);
		d += gen;
		d += dna[lin+1].charAt(col+1);
		d += dna[lin+2].charAt(col+2);
		d += dna[lin+3].charAt(col+3);
		d += dna[lin+4].charAt(col+4);
		if (d.contains(dnaSeq)) {
			return ++count;
		}
		return 0;
	}
	private int diagonal7_9(String[] dna, int lin, int col, String dnaSeq) {
		String d = "";
		char gen = dna[lin].charAt(col);
		d += gen;
		d += dna[lin-1].charAt(col+1);
		d += dna[lin-2].charAt(col+2);
		d += dna[lin-3].charAt(col+3);
		d += dna[lin-4].charAt(col+4);
		if (d.contains(dnaSeq)) {
			return ++count;
		}
		return 0;
	}
	private int diagonal3(String[] dna, int lin, int col, String dnaSeq) {
		String d = "";
		char gen = dna[lin].charAt(col);
		d += gen;
		d += dna[lin+1].charAt(col+1);
		d += dna[lin+2].charAt(col+2);
		d += dna[lin+3].charAt(col+3);
		d += dna[lin+4].charAt(col+4);
		d += dna[lin+5].charAt(col+5);
		if (d.contains(dnaSeq)) {
			return 1;
		}
		return 0;
	}
	private int diagonal8(String[] dna, int lin, int col, String dnaSeq) {
		String d = "";
		char gen = dna[lin].charAt(col);
		d += gen;
		d += dna[lin-1].charAt(col+1);
		d += dna[lin-2].charAt(col+2);
		d += dna[lin-3].charAt(col+3);
		d += dna[lin-4].charAt(col+4);
		d += dna[lin-5].charAt(col+5);
		if (d.contains(dnaSeq)) {
			return 1;
		}
		return 0;
	}
	private int horizontal (String[] dna, int lin, int col, String dnaSeq) {
		String h = "";
		char gen = dna[lin].charAt(col);
		h += gen;
		h += dna[lin].charAt(col);
		h += dna[lin].charAt(col);
		h += dna[lin].charAt(col);
		h += dna[lin].charAt(col);
		h += dna[lin].charAt(col);
		if (h.contains(dnaSeq)) {
			return 1;
		}
		return 0;
	}
	//	private int diagonal1(String[] dna) {
	//		String d = "";
	//		char gen = dna[2].charAt(0);
	//		d += gen;
	//		d += dna[3].charAt(1);
	//		d += dna[4].charAt(2);
	//		d += dna[5].charAt(3);
	//		String stringSubs = d.replace(String.valueOf(gen), "");
	//		if (stringSubs.length() == 0) {
	//			return count++;
	//		}
	//		return 0;
	//	}
	//	private int diagonal2(String[] dna) {
	//		String d = "";
	//		char gen = dna[1].charAt(0);
	//		d += gen;
	//		d += dna[2].charAt(1);
	//		d += dna[3].charAt(2);
	//		d += dna[4].charAt(3);
	//		d += dna[5].charAt(4);
	//		String stringSubs = d.replace(String.valueOf(gen), "");
	//		if (stringSubs.length() == 0) {
	//			return count++;
	//		}
	//		return 0;
	//	}
	//	private int diagonal3(String[] dna) {
	//		String d = "";
	//		char gen = dna[0].charAt(0);
	//		d += gen;
	//		d += dna[1].charAt(1);
	//		d += dna[2].charAt(2);
	//		d += dna[3].charAt(3);
	//		d += dna[4].charAt(4);
	//		d += dna[5].charAt(5);
	//		String stringSubs = d.replace(String.valueOf(gen), "");
	//		if (stringSubs.length() == 0) {
	//			return count++;
	//		}
	//		return 0;
	//	}
	//	private int diagonal4(String[] dna) {
	//		String d = "";
	//		char gen = dna[0].charAt(1);
	//		d += gen;
	//		d += dna[1].charAt(2);
	//		d += dna[2].charAt(3);
	//		d += dna[3].charAt(4);
	//		d += dna[4].charAt(5);
	//		String stringSubs = d.replace(String.valueOf(gen), "");
	//		if (stringSubs.length() == 0) {
	//			return count++;
	//		}
	//		return 0;
	//	}
	//	private int diagonal5(String[] dna) {
	//		String d = "";
	//		char gen = dna[0].charAt(2);
	//		d += gen;
	//		d += dna[1].charAt(3);
	//		d += dna[2].charAt(4);
	//		d += dna[3].charAt(5);
	//		String stringSubs = d.replace(String.valueOf(gen), "");
	//		if (stringSubs.length() == 0) {
	//			return count++;
	//		}
	//		return 0;
	//	}
}

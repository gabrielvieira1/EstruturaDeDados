package EstruturaDeDados.Atividade07;

public class Program<T> {

	public static void main(String[] args) {
		int[] vetor = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		String[] vetorString = { "dario", "estrela", "fabio", "caio", "zelezin" };

		ordenacaoString(alteraCase(vetorString));

		for (String impVetor : vetorString) {
			System.out.print(impVetor + ", ");
		}
		/*
		 * for(int el: vetor) { System.out.print(el+", "); }
		 */
	}

	static void ordenacaoString(String[] v) {
		int rep = 0;

		for (int ult = v.length - 1; ult > 0; ult--) {

			for (int i = 0; i < ult; i++) {

				if (v[i].length() >= v[i + 1].length()) {
					rep = v[i + 1].length();
				} else if (v[i].length() < v[i + 1].length()) {
					rep = v[i].length();
				}
				for (int k = 0; k < rep; k++) {
					if (v[i].charAt(k) >= v[i + 1].charAt(k)) {
						if (k == 0) {
							String aux = v[i];
							v[i] = v[i + 1];
							v[i + 1] = aux;
							break;
						} else if (v[i].charAt(k - 1) == v[i + 1].charAt(k - 1)) {
							String aux = v[i];
							v[i] = v[i + 1];
							v[i + 1] = aux;
							break;
						}
					}
				}
			}
		}
	}

	public static String[] alteraCase(String[] el) {
		for (int i = 0; i < el.length; i++) {
			el[i] = el[i].substring(0, 1).toUpperCase().concat(el[i].substring(1));
		}
		return el;
	}

	/*
	 * static void bolha(int[] v) { for (int ult = v.length - 1; ult>0; ult--) { for
	 * (int i = 0; i < ult; i++) { if (v[i] > v[i+1]) { int aux = v[i]; v[i] =
	 * v[i+1]; v[i+1] = aux; } } } }
	 * 
	 */

}

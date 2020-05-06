package EstruturaDeDados.Atividade07;

import java.util.Scanner;

public class Program<T> {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] vetor = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 12, 13, 11 };
		String[] vetorString = { "Jose","calça", "caio", "josa", "joso", "josu", "Pedrin", "josi", "Maria", "Mario", "João",
				"Pedro", "Antonio","você", "voce", "camelô" };
		String[] vetorTeste = new String[5];
		
		//ordenacaoString(alteraCase(vetorTeste));
		ordenacaoString(vetorString);
		
		for (String impVetor : vetorString) {
			System.out.print(impVetor + ", ");
		}

		System.out.println();
		ordenacaoNumero(vetor);

		for (int el : vetor) {
			System.out.print(el + ", ");
		}
		
		sc.close();

	}

	private static String[] ordenacaoString(String[] vetor) {
		int rep = 0;
		String aux;

		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length; j++) {
				
				if (vetor[i].length() >= vetor[j].length()) {
					rep = vetor[j].length();
				} else if (vetor[i].length() < vetor[j].length()) {
					rep = vetor[i].length();
				}
				for (int k = 0; k < rep; k++) {
					if (nivelacao(vetor[i].charAt(k)) < nivelacao(vetor[j].charAt(k))) {
							aux = vetor[i];
							vetor[i] = vetor[j];
							vetor[j] = aux;
							break;
					} else {
						
						
						break;
					}
					
				}
			}
		}
		return vetor;
	}

	
	public static String[] alteraCase(String[] el) {
		for (int i = 0; i < el.length; i++) {
			el[i] = el[i].substring(0, 1).toUpperCase().concat(el[i].substring(1));
		}
		return el;
	}

	static void ordenacaoNumero(int[] vetor) {
		for (int ult = vetor.length - 1; ult > 0; ult--) {
			for (int i = 0; i < ult; i++) {
				if (vetor[i] > vetor[i + 1]) {
					int aux = vetor[i];
					vetor[i] = vetor[i + 1];
					vetor[i + 1] = aux;
				}
			}
		}
	}
	
	private static int nivelacao(int charInt) {

		if (charInt >= 65 || charInt <= 122) {
			if (charInt < 97) {
				charInt = charInt - 65;
			} else {
				charInt = charInt - 97;
			}

		} else {
			if ((charInt >= 225 && charInt <= 227) || (charInt >= 193 && charInt <= 195)) {
				charInt = 0;
			} else if ((charInt >= 233 && charInt <= 234) || (charInt >= 201 && charInt <= 202)) {
				charInt = 4;
			} else if ((charInt >= 237 && charInt <= 238) || (charInt >= 205 && charInt <= 206)) {
				charInt = 8;
			} else if ((charInt >= 243 && charInt <= 245) || (charInt >= 211 && charInt <= 213)) {
				charInt = 14;
			} else if ((charInt >= 250 && charInt <= 251) || (charInt >= 218 && charInt <= 219)) {
				charInt = 20;
			} else if (charInt >= 231 && charInt <= 199) {
				charInt = 2;
			}
		}
		return charInt;

	}
	
	/*  Os metodos implementados utilizam o algoritmo BubbleSort para tipo inteiro e String
	 * percorre a lista múltiplas vezes comparando todos os elementos adjacentes e troca de
	 * lugar os que estiverem fora de ordem. A cada passagem, o maior elemento da lista vai
	 * para o final dela.
	 * */

}

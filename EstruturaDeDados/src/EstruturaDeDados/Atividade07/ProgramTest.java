package EstruturaDeDados.Atividade07;

import java.util.Scanner;

public class ProgramTest {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		int x = 0;
		do {
			System.out.println(" ______________________________");
			System.out.println("|(1) para ordenação de números |");
			System.out.println("|(2) para ordenação de palavras|");
			System.out.println("|(0) para sair do software     |");
			System.out.println("|______________________________|");
			x = scan.nextInt();

			switch (x) {
			case 1:
				int[] vetorNumber = { 1, 0, 10, 8, 7, 6, 5, 4, 9, 2, 1 };

				System.out.println("\nAntes -----------------");
				for (int v : vetorNumber) {
					System.out.print(v + " ");
				}

				vetorNumber = ordenarNumber(vetorNumber);
				System.out.println("\nDepois ----------------");
				for (int v : vetorNumber) {
					System.out.print(v + " ");
				}
				System.out.println("\n");
				Thread.sleep(1000);
				break;
			case 2:
				String[] vetorString = { "Jose","alça", "caio", "josa", "joso", "josu", "Pedrin", "josi", "Maria", "Mario", "João",
					"Pedro", "Antonio","você", "voce", "camelô" };

				System.out.println("\nAntes -----------------");
				for (String v : vetorString) {
					System.out.print(v + " ");
				}
				vetorString = ordenarString(vetorString);

				System.out.println("\nDepois ----------------");
				for (String v : vetorString) {
					System.out.print(v + " ");
				}
				System.out.println("\n");
				Thread.sleep(1000);
				break;
			case 0:
				break;
			default:
				System.out.println("Digite apenas numeros de acordo com o menu");
			}

		} while (x != 0);

	}

	private static int[] ordenarNumber(int[] vetor) {
		int aux;
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length; j++) {
				if (vetor[i] < vetor[j]) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;

				}
			}
		}

		return vetor;
	}

	private static String[] ordenarString(String[] vetor) {
		String aux;
		int rep = 0;

		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length; j++) {

				if (vetor[i].length() >= vetor[j].length()) {
					rep = vetor[j].length();
				} else if (vetor[i].length() < vetor[j].length()) {
					rep = vetor[i].length();
				}

				for (int k = 0; k < rep; k++) {
					if (k == 0) {
						if (nivelacao(vetor[i].charAt(k)) < nivelacao(vetor[j].charAt(k))) {
							aux = vetor[i];
							vetor[i] = vetor[j];
							vetor[j] = aux;
							break;
						}
					} else {
						if (nivelacao(vetor[i].charAt(k - 1)) == nivelacao(vetor[j].charAt(k - 1))) {
							if (nivelacao(vetor[i].charAt(k)) < nivelacao(vetor[j].charAt(k))) {
								aux = vetor[i];
								vetor[i] = vetor[j];
								vetor[j] = aux;
								break;
							}
						} else {
							break;
						}
					}
				}
			}
		}

		return vetor;
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

}
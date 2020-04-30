package EstruturaDeDados.Atividade08;

import java.util.Scanner;

public class ProgramInterativo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int base = sc.nextInt();
		int expoente = sc.nextInt();

		System.out.println(potencia(base, expoente));
		sc.close();
	}

	public static int potencia(int base, int expoente) {
		int aux = base;
		if (expoente == 0) {
			return 1;
		}
		for (int i = 0; i < expoente - 1; i++) {
			aux = aux * base;
		}
		return aux;
	}
}

package EstruturaDeDados.Atividade08;

import java.util.Scanner;

public class ProgramRecursivo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int base = sc.nextInt();
		int expoente = sc.nextInt();
		
		System.out.println(potencia(base, expoente));
		sc.close();
	}
	
	public static int potencia(int base, int expoente) {
		
		if (expoente == 0) {
			return 1;
		} 
		return base * potencia(base, expoente - 1);
	}

}

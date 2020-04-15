package EstruturaDeDados.Atividade06;

public class Fila_exemplo {
	
	public static void main(String[] args) {
		
		Fila<Integer> fila = new Fila<>();
		
		//1
		System.out.println(fila.estaVazia()); //true
		System.out.println(fila.tamanho()); //0
		//2
		fila.enfileira(1);
		fila.enfileira(2);
		fila.enfileira(3);
		System.out.println(fila.estaVazia());//false
		System.out.println(fila.tamanho());//3
		System.out.println(fila.toString());
		
	}

}

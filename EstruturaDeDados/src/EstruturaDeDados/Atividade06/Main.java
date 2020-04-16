package EstruturaDeDados.Atividade06;

public class Main {
	
	public static void main(String[] args) {
		
		Fila<Banco> fila = new Fila<>(); 
	    Banco[] banco = new Banco[6]; 
	
		
		banco[0] = new Banco("João", 20);
		banco[1] = new Banco("Maria", 30);
		banco[2] = new Banco("Neli",66);
		banco[3] = new Banco("João",40);
		banco[4] = new Banco("Mario",25);
		banco[5] = new Banco("Ivani",67);
	/*	
		Banco c1 = new Banco("João", 20);
		Banco c2 = new Banco("Maria", 30);
		Banco c3 = new Banco("Neli",66);
		Banco c4 = new Banco("João",40);
		Banco c5 = new Banco("Mario",25);
		Banco c6 = new Banco("Ivani",67);
		
		fila.enfileira(c1);
		fila.enfileira(c2);
		fila.enfileira(c3);
		fila.enfileira(c4);
		fila.enfileira(c5);
		fila.enfileira(c6);
	
	*/	
		for (Banco cliente : banco) {
			
			if (cliente.getIdade() > 65) {
				fila.adiciona(0, cliente);
			} else {
				fila.enfileira(cliente);
			}
			
		}
		
		
		
		//1
//		System.out.println(fila.estaVazia()); //true
//		System.out.println(fila.tamanho()); //0
//		//2
//		fila.enfileira(1);
//		fila.enfileira(2);
//		fila.enfileira(3);
		System.out.println(fila.estaVazia());//false
		System.out.println(fila.tamanho());//3
		System.out.println(fila.toString());
//		
	}

}

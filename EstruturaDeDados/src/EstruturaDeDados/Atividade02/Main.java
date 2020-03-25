package EstruturaDeDados.Atividade02;

public class Main {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("gabriel", 1213, 12);
		Cliente cliente2 = new Cliente("joao", 4342, 23);
		Cliente cliente3 = new Cliente("neto", 125413, 45);
		Cliente cliente4 = new Cliente("ian", 22133, 122);
		Cliente cliente5 = new Cliente("vini", 21153, 555);
		Vetor vetor = new Vetor(4);

		vetor.adiciona(cliente1);
		vetor.adiciona(cliente2);
		vetor.adiciona(cliente3);
		vetor.adiciona(cliente4);
		vetor.adiciona(2, cliente5);
		System.out.println(vetor.busca(cliente2));
		System.out.println(vetor.buscaPosicao(3));
		vetor.remove(1);
		System.out.println(vetor.tamanho());
	    System.out.println(vetor);


	}

}

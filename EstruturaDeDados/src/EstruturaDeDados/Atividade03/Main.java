package EstruturaDeDados.Atividade03;

public class Main {

	public static void main(String[] args) {
		Lista<Cliente> vetor = new Lista<Cliente>(3);
		
		Cliente cliente1 = new Cliente("cliente 1", 123456789, "cliente1@gmail.com");
		Cliente cliente2 = new Cliente("cliente 2", 123456789, "cliente2@gmail.com");
		Cliente cliente3 = new Cliente("cliente 3", 123456789, "cliente3@gmail.com");
		Cliente cliente4 = new Cliente("cliente 4", 123456789, "cliente4@gmail.com");
		Cliente cliente5 = new Cliente("cliente 5", 123456789, "cliente5@gmail.com");

		vetor.adiciona(cliente1);
		vetor.adiciona(cliente2);
		vetor.adiciona(cliente3);
		vetor.adiciona(cliente4);
		vetor.adiciona(cliente5);
		
		System.out.println(vetor.busca(2));
		System.out.println("Tamanho: " + vetor.tamanho());
		

	}

}

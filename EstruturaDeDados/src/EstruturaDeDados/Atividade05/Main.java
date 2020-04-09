package EstruturaDeDados.Atividade05;


public class Main {
	public static void main(String[] args) {
		
		Lista<Pessoa> listaDePessoas = new Lista<>();
		
		Pessoa joao = new Pessoa();
		Pessoa pedim = new Pessoa();
		Pessoa zezim = new Pessoa();
		Pessoa pirulitu = new Pessoa();

		joao.setNome("joao");
		pedim.setNome("pedim");
		zezim.setNome("zezim");
		pirulitu.setNome("pirulitu");

		joao.setCpf("123456789");
		pedim.setCpf("123789456");
		zezim.setCpf("321987654");
		pirulitu.setCpf("951984324");

		joao.setEmail("a@gmail.com");
		pedim.setEmail("b@gmail.com");
		zezim.setEmail("c@gmail.com");
		pirulitu.setEmail("d@gmail.com");
		
		joao.setFone(94845132);
		pedim.setFone(35658421);
		zezim.setFone(65842141);
		pirulitu.setFone(63020145);
		
		listaDePessoas.addInicio(joao);
		listaDePessoas.addInicio(pedim);
		listaDePessoas.addInicio(zezim);
		listaDePessoas.addFim(pirulitu);
		listaDePessoas.imprimirTodos();
		
		System.out.println("\n");
		listaDePessoas.addPosicao(joao, 4);
		listaDePessoas.imprimirTodos();
		System.out.println("\n");
		
		// listaDePessoas.removeFim();
		// System.out.println("\n");
		// listaDePessoas.imprimirTodos();
		
		//System.out.println("\n");
		//System.out.println(listaDePessoas.indexOf(p2));
		//System.out.println(listaDePessoas.indexOf(p3));
		//System.out.println(listaDePessoas.indexOf(p));
		
		//listaDePessoas.removePosicao(2);
		//System.out.println("\n");
		//listaDePessoas.imprimirTodos();
		
		//listaDePessoas.removePosicao(0);
		//System.out.println("\n");
		//listaDePessoas.imprimirTodos();
		
		//System.out.println("\n");
		//System.out.println(listaDePessoas.indexOf(p2));
		//System.out.println(listaDePessoas.indexOf(p3));
		//System.out.println(listaDePessoas.indexOf(p));
	}
}
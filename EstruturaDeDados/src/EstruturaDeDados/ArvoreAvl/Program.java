package EstruturaDeDados.ArvoreAvl;

public class Program {

	public static void main(String[] args) {
		
		ArvoreAvl arvoreAvl = new ArvoreAvl();
		arvoreAvl.inserir(10);
		arvoreAvl.inserir(3);
		/*arvoreAvl.inserir(2);
		arvoreAvl.inserir(11);
		arvoreAvl.inserir(13);
		arvoreAvl.inserir(4);
		arvoreAvl.inserir(15);
		arvoreAvl.inserir(20);
		arvoreAvl.inserir(25);
		arvoreAvl.inserir(1);
		arvoreAvl.inserir(6);*/
		
		System.out.println(arvoreAvl.inorder());
		arvoreAvl.caminhar();

	}

}

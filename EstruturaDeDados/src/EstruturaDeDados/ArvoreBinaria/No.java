package EstruturaDeDados.ArvoreBinaria;

public class No {
	
	public long valor;
	public No noDireita, noEsquerda;
	
	public No() {
	}
	public No(long valor) {
		this.valor = valor;
	}
	
	public static No raiz;
}

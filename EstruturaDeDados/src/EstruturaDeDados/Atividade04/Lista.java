package EstruturaDeDados.Atividade04;

public class Lista<T> {
	private T[] elementos;
	private int tamanho;
	
	public Lista(int capacidade) {
		this.elementos = (T[]) new Object[capacidade];
		this.tamanho = 0;
	}
	
	public boolean adiciona(T elemento)  {
		this.aumentaCapacidade();
		if(this.tamanho < this.elementos.length) {
			elementos[tamanho] = elemento;
			tamanho++;
			return true;
		}
		return false;
	}
	
	public boolean adiciona(int posicao, T elemento) {
		this.aumentaCapacidade();
		if(!(posicao >= 0 && posicao<tamanho)) {
			throw new IllegalArgumentException("Posição Inválida!");
		}
		//mover todos os elementos
		for(int i=this.tamanho-1; i>=posicao; i--) {
			this.elementos[i + 1] = this.elementos[i];
		}
		this.elementos[posicao]=elemento;
		this.tamanho++;
		return false;
	}
	
	
	public void aumentaCapacidade() {
		if(this.tamanho == this.elementos.length) {
			Object[] elementosNovos = new Object[this.elementos.length * 2];
			for(int i = 0; i < this.tamanho; i++) {
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = (T[]) elementosNovos;
		}
		
	}
	
	public Object busca(int posicao) {
		if(!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException();
		}
		return this.elementos[posicao];
	}
	
	public int busca(T elemento) {
		for(int i = 0; i < this.elementos.length; i++) {
			if(this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}
	
	public int tamanho() {
		return this.tamanho;
	}
	
	public void mostrar() {

		for (int i = 0; i < tamanho; i++) {

			System.out.println(elementos[i]);

		}

	}

	public String toString() {

		StringBuilder s = new StringBuilder();

		s.append("[");

		for (int i = 0; i < this.tamanho - 1; i++) {

			s.append(this.elementos[i]);

			s.append(", ");

		}

		if (this.tamanho > 0) {

			s.append(this.elementos[this.tamanho - 1]);

		}

		s.append("]");

		return s.toString();

	}
}

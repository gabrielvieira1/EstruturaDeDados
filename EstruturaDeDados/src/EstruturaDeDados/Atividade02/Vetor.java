package EstruturaDeDados.Atividade02;

public class Vetor {

	private Object[] elementos;

	private int tamanho;

	public Vetor(int capacidade) {

		elementos = new Object[capacidade];

		tamanho = 0;
	}

	public boolean adiciona(Object elemento) {
		this.aumentaCapacidade();

		if (this.tamanho < this.elementos.length) {

			elementos[tamanho] = elemento;

			tamanho++;

			return true;

		}

		return false;
	}

	private void aumentaCapacidade() {

		if (this.tamanho == this.elementos.length) {

			Object[] elementosNovos = new Object[this.elementos.length * 2];

			for (int i = 0; i < this.elementos.length; i++) {

				elementosNovos[i] = this.elementos[i];

			}

			this.elementos = elementosNovos;

		}

	}

	public boolean adiciona(int posicao, Object elemento) {
	//	int posicao = this.tamanho / 2;

		this.aumentaCapacidade();
		
		if (!(posicao>=0&&posicao<tamanho)) {
			throw new IllegalArgumentException("Posicao invalida");
		}

		// mover todos os elementos

		for (int i = this.tamanho - 1; i >= posicao; i--) {

			this.elementos[i + 1] = this.elementos[i];

		}

		this.elementos[posicao] = elemento;
		this.tamanho++;
	//	System.out.println(posicao);
		//System.out.println(tamanho);
		return false;

	}

	public void mostrar() {

		for (int i = 0; i < tamanho; i++) {

			System.out.println(elementos[i]);

		}

	}

	public int tamanho() {

		return this.tamanho;
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
	

	public Object buscaPosicao(int posicao) {

		if (!(posicao >= 0 && posicao < tamanho)) {

			throw new IllegalArgumentException("Posicao inválida");

		}

		return this.elementos[posicao];

	}

	public int busca(Object elemento) {

		for (int i = 0; i < this.tamanho; i++) {

			if (this.elementos[i].equals(elemento)) {

				return i;

			}

		}

		return -1;

	}

	public void remove(int posicao) {

		if (!(posicao >= 0 && posicao < tamanho)) {

			throw new IllegalArgumentException("Posicao inválida");

		}

		for (int i = posicao; i < this.tamanho - 1; i++) {

			this.elementos[i] = this.elementos[i + 1];

		}

		this.tamanho--;

	}

}

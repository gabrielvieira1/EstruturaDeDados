package EstruturaDeDados.Atividade02;

public class Vetor {

	private Object[] clientes;

	private int tamanho;

	public Vetor(int capacidade) {

		clientes = new Object[capacidade];

		tamanho = 0;
	}

	public boolean adiciona(Object cliente) {

		if (this.tamanho < this.clientes.length) {

			clientes[tamanho] = cliente;

			tamanho++;

			return true;

		}

		return false;
	}

	private void aumentaCapacidade() {

		if (this.tamanho == this.clientes.length) {

			Object[] clientesNovos = new Object[this.clientes.length * 2];

			for (int i = 0; i < this.clientes.length; i++) {

				clientesNovos[i] = this.clientes[i];

			}

			this.clientes = clientesNovos;

		}

	}

	public boolean adicionaMeio(Object cliente) {
		int posicao = this.tamanho / 2;

		this.aumentaCapacidade();

		// mover todos os elementos

		for (int i = this.tamanho - 1; i >= posicao; i--) {

			this.clientes[i + 1] = this.clientes[i];

		}

		this.clientes[posicao] = cliente;

		this.tamanho++;
		System.out.println(posicao);
		System.out.println(tamanho);
		return false;

	}

	public void mostrar() {

		for (int i = 0; i < tamanho; i++) {

			System.out.println(clientes[i]);

		}

	}

	public int tamanho() {

		return this.tamanho;
	}

	public String toString() {

		StringBuilder s = new StringBuilder();

		s.append("[");

		for (int i = 0; i < this.tamanho - 1; i++) {

			s.append(this.clientes[i]);

			s.append(", ");

		}

		if (this.tamanho > 0) {

			s.append(this.clientes[this.tamanho - 1]);

		}

		s.append("]");

		return s.toString();

	}

	public Object buscaPosicao(int posicao) {

		if (!(posicao >= 0 && posicao < tamanho)) {

			throw new IllegalArgumentException("Posicao inválida");

		}

		return this.clientes[posicao];

	}

	public int busca(Object elemento) {

		for (int i = 0; i < this.tamanho; i++) {

			if (this.clientes[i].equals(elemento)) {

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

			this.clientes[i] = this.clientes[i + 1];

		}

		this.tamanho--;

	}

}

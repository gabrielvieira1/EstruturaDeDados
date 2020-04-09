package EstruturaDeDados.Atividade04;

public class AlunoLista {

	int qtdElementos;
	Aluno primeiro, ultimo;

	public AlunoLista() {

		this.qtdElementos = 0;
		this.primeiro = null;
		this.ultimo = null;

	}

	public void inserirNoComeco(int nota) {

		if (this.qtdElementos == 0) {

			// lista vazia

			this.ultimo = this.primeiro;

			Aluno novo = new Aluno();

			novo.getNota(nota);

			novo.setProximo(primeiro);

			this.primeiro = novo;

		} else {

			Aluno novo2 = new Aluno();

			novo2.setNota(nota);

			novo2.setProximo(primeiro);

			primeiro = novo2;

		}

		this.qtdElementos++;

	}

	public void inserirNoFinal(int nota) {

		Aluno novo = new Aluno();

		novo.setNota(nota);

		if (this.qtdElementos == 0) {

			// lista vazia

			this.ultimo = novo;

			this.primeiro = novo;

			novo.setProximo(primeiro);

		} else {

			ultimo.setProximo(novo);

			ultimo = novo;

		}

		this.qtdElementos++;

	}

	public void inserir(int posicao, int nota) {

		Aluno novo = new Aluno();

		novo.setNota(nota);

		Aluno aux = this.primeiro;

		if (posicao < 0 || posicao > this.qtdElementos) {

			System.out.println("Posição Inválida!");

		}

		if (posicao == this.qtdElementos) {

			this.inserirNoFinal(nota);

		} else

		if (posicao == 0) {

			this.inserirNoComeco(nota);

		} else {

			for (int i = 0; i < posicao - 1; i++) {

				aux = aux.getProximo();

			}

			novo.setProximo(aux.getProximo());

			aux.setProximo(novo);

			aux = novo;

		}

		this.qtdElementos++;

	}

	public void removerNoInicio() {

		if (this.qtdElementos == 0) {

			// Lista vazia

			System.out.println("Não há elementos a ser Removido.");

		} else {

			Aluno aux = primeiro;

			primeiro = primeiro.getProximo();

			aux.setProximo(null);

			this.qtdElementos--;

		}

	}

	public void removerNoFinal() {

		if (this.qtdElementos == 0) {

			// Lista vazia

			System.out.println("Não há elementos a ser Removido.");

		} else {

			Aluno aux = primeiro;

			while (aux.getProximo() != null) {

				aux = aux.getProximo();

			}

			aux.setProximo(null);

			this.qtdElementos--;

		}

	}

	public void remover(int posicao) {

		if (posicao < 0 || posicao > this.qtdElementos) {

			System.out.println("Posição Inválida!");

		}

		if (posicao == this.qtdElementos)

			this.removerNoFinal();

		else

		if (posicao == 1)

			this.removerNoInicio();

		else

		if (posicao == 0) {

			System.out.println("Lista Vazia!");

		} else {

			Aluno aux = primeiro;

			for (int i = 0; i < posicao - 1; i++) {

				if ((i == posicao - 2)) {

					aux.setProximo(aux.getProximo().getProximo());

					this.qtdElementos--;

				}

				aux = aux.getProximo();

			}

		}

	}

	public void pesquisaElemento(int nota) {

		Aluno aux = this.primeiro;

		while (aux.getProximo() != null) {

			if (aux.getNota() == nota) {

				System.out.println("Nota encontrada:" + nota);

			}

			aux = aux.getProximo();

		}

	}

	public void imprimir() {

		if (this.qtdElementos == 0) {

			System.out.println("[]");

		} else {

			System.out.print("[");

			Aluno aux = this.primeiro;

			for (int i = 0; i < this.qtdElementos - 1; i++) {

				System.out.print(aux.getNota() + ", ");

				aux = aux.getProximo();

			}

			System.out.println(aux.getNota() + "]");

		}

	}

}
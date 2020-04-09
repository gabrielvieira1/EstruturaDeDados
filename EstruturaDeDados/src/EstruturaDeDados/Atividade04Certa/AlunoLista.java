package EstruturaDeDados.Atividade04Certa;

public class AlunoLista {
	int qtdElementos;
	Aluno primeiro, ultimo;

	public AlunoLista() {
		this.qtdElementos = 0;
		this.primeiro = null;
		this.ultimo = null;
	}

	public void inserirNoComeco(int nota1, int nota2, String matricula) {

		if (this.qtdElementos == 0) {

			this.ultimo = this.primeiro;
			Aluno novo = new Aluno();
			novo.setNota1(nota1);
			novo.setNota2(nota2);
			novo.setMatricula(matricula);
			novo.setProximo(primeiro);
			this.primeiro = novo;
			this.ultimo = novo;

		} else {

			Aluno novo2 = new Aluno();
			novo2.setNota1(nota1);
			novo2.setNota2(nota2);
			novo2.setMatricula(matricula);
			novo2.setProximo(primeiro);
			primeiro = novo2;

		}

		this.qtdElementos++;
	}

	public void inserirNoFinal(int nota1, int nota2, String matricula) {
		Aluno novo = new Aluno();
		novo.setNota1(nota1);
		novo.setNota2(nota2);
		novo.setMatricula(matricula);

		if (this.qtdElementos == 0) {

			this.ultimo = novo;
			this.primeiro = novo;
			novo.setProximo(primeiro);

		} else {

			ultimo.setProximo(novo);
			ultimo = novo;

		}

		this.qtdElementos++;
	}

	public void inserir(int posicao, int nota1, int nota2, String matricula) {

		Aluno novo = new Aluno();
		novo.setNota1(nota1);
		novo.setNota2(nota2);
		novo.setMatricula(matricula);
		Aluno aux = this.primeiro;

		if (posicao < 0 || posicao > this.qtdElementos) {
			System.out.println("Posição Inválida!");
		}
		if (posicao == this.qtdElementos) {
			this.inserirNoFinal(nota1, nota2, matricula);
		} else if (posicao == 0) {

			this.inserirNoComeco(nota1, nota2, matricula);

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

	public void pesquisaElemento(String matricula) {

		Aluno aux = this.primeiro;

		while (aux.getProximo() != null) {

			if (aux.getMatricula().equals(matricula)) {

				System.out.println("Matricula encontrada: " + matricula);

			}

			aux = aux.getProximo();

		}

	}

	public void imprimir() {

		if (this.qtdElementos == 0) {

			System.out.println("[]");

		} else {


			Aluno aux = this.primeiro;

			for (int i = 0; i < this.qtdElementos - 1; i++) {

				System.out.println(aux.toString());

				aux = aux.getProximo();

			}

			System.out.println(aux.toString());

		}

	}

	public void status() {
		if (this.qtdElementos == 0) {

			System.out.println("Nenhum aluno encontrado!");

		} else {

			Aluno aux = this.primeiro;

			for (int i = 0; i < this.qtdElementos; i++) {

				if (aux.media() < 7) {
					System.out.println("Aluno de matricula (" + aux.getMatricula() + ")" + ", foi  reprovado");
				} else {
					System.out.println("Aluno de matricula (" + aux.getMatricula() + ")" + ", foi  aprovado");
				}
				aux = aux.getProximo();

			}

		}
	}

}
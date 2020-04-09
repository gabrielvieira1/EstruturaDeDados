package EstruturaDeDados.Atividade04;

import java.util.Scanner;

import EstruturaDeDados.Atividade04.Lista;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Lista<Aluno> vetor = new Lista<Aluno>(3);
		AlunoLista a = new AlunoLista();

		int matricula, nota1, nota2;
		int media;
		String terminar;
		String situacao = null;

		do {
			System.out.println("Digite a matricula do aluno:");
			matricula = scan.nextInt();
			System.out.println("Digita a nota1:");
			nota1 = scan.nextInt();
			System.out.println("Digita a nota2:");
			nota2 = scan.nextInt();
			media = ((nota1 + nota2) / 2);

			if (media < 7) {
				situacao = "Reprovado";
				a.inserirNoFinal(media);
			} else if (media >= 7) {
				a.inserirNoFinal(media);
				situacao = "Aprovado";
			}
			Aluno aluno1 = new Aluno(matricula, media, situacao);
			vetor.adiciona(aluno1);
			System.out.println("Sair s/n?");
			terminar = scan.next();

		} while (!terminar.equalsIgnoreCase("S"));

		System.out.println(vetor);
		a.imprimir();

	}

}

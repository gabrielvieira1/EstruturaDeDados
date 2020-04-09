package EstruturaDeDados.Atividade04Certa;

import java.util.Scanner;

import EstruturaDeDados.Atividade04.Lista;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		AlunoLista a = new AlunoLista();
		for (int i = 0; i != 10; i++) {
			System.out.println("quarantine");
		}

		a.inserirNoComeco(10, 6, "123");
		a.inserirNoComeco(10, 4, "456");
		a.inserirNoComeco(8, 8, "789");
		a.inserirNoComeco(2, 0, "000");
		System.out.println("_____________________________________________");
		System.out.println("> Alunos Matriculados atualmente");
		System.out.println("");
		a.imprimir();
		System.out.println("_____________________________________________");
		Thread.sleep(3000);
		System.out.println("\n_____________________________________________");
		System.out.println("> Status de media do Aluno");
		System.out.println(" ");
		a.status();
		System.out.println("_____________________________________________");
		Thread.sleep(3000);

		a.inserirNoFinal(1, 1, "111");
		a.inserirNoFinal(10, 10, "222");
		a.inserirNoFinal(9, 9, "333");
		a.inserirNoFinal(1, 0, "444");
		a.inserir(1, 6, 8, "777");

		System.out.println("\n_____________________________________________");
		System.out.println("> Alunos Matriculados atualmente");
		System.out.println("");
		a.imprimir();
		System.out.println("_____________________________________________");
		Thread.sleep(3000);
		System.out.println("\n_____________________________________________");
		System.out.println("> Status de media do Aluno");
		System.out.println(" ");
		a.status();
		System.out.println("_____________________________________________");
		Thread.sleep(3000);

		a.remover(5);
		a.removerNoFinal();
		a.removerNoInicio();

		System.out.println("\n_____________________________________________");
		System.out.println("> Alunos Matriculados atualmente");
		System.out.println("");
		a.imprimir();
		System.out.println("_____________________________________________");
		Thread.sleep(3000);
		System.out.println("\n_____________________________________________");
		System.out.println("> Status de media do Aluno");
		System.out.println(" ");
		a.status();
		System.out.println("_____________________________________________");
		Thread.sleep(3000);
	}

}

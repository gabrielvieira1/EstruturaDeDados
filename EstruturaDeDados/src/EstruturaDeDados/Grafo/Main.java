package EstruturaDeDados.Grafo;

import java.util.Scanner;

public class Main {
	static Scanner leitor = new Scanner(System.in);

	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		int option;
		while ((option = getOption()) != 4) {
			switch (option) {
			case 1:
				option = getOption("inserir");
				if (option == 1) {
					addVortex(grafo);
				} else if (option == 2) {
					addEdge(grafo);
				}
				break;
			case 2:
				if (grafo.getFirst() == null) {
					System.out.println("Grafo vazio.");
				} else {
					option = getOption("remover");

					if (option == 1) {
						removeVortex(grafo);
					} else if (option == 2) {
						removeEdge(grafo);
					}
				}
				break;
			case 3:
				if (grafo.getFirst() == null) {
					System.out.println("Grafo vazio!");
				} else {
					printShortestPath(grafo);
				}
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
		}
		System.out.println("Encerrado.");

	}

	private static void removeVortex(Grafo grafo) {
		int value;
		value = getValue("vértice para remover");
		if (grafo.get(value) == null) {
			System.out.println("Valor inexistente!");
		} else {
			grafo.removeVortex(value);
			if (grafo.get(value) == null)
				System.out.println("Valor Removido com sucesso!");
			else
				System.out.println("Falha ao remover vértice!");
		}
	}

	private static void removeEdge(Grafo grafo) {
		int value;
		Vortex origin = null, destination = null;
		value = getValue("vértice de origem");
		origin = grafo.get(value);
		value = getValue("vértice de destino");
		destination = grafo.get(value);

		if (origin == null) {
			System.out.println("Origem inexistente!");
		} else if (destination == null) {
			System.out.println("Destino inexistente!");
		} else if (grafo.getEdgeCost(origin.getValue(), destination.getValue()) > 0) {
			grafo.removeEdge(origin, destination);
			System.out.println("Removido com sucesso!");
		} else {
			System.out.println("Não existe aresta entre vértices informados!");
		}
	}

	private static void addVortex(Grafo grafo) {
		int value;
		value = getValue("vértice para inserir");
		if (grafo.get(value) == null) {
			grafo.addVortex(value);
			System.out.println("Vértice " + value + " adicionado com sucesso!");
		} else
			System.out.println("Vértice inválido ou já existente");
	}

	private static void addEdge(Grafo grafo) {
		int value;
		value = getValue("vértice de origem");
		Vortex origin = grafo.get(value);
		value = getValue("vértice de destino");
		Vortex destination = grafo.get(value);

		if (origin == null) {
			System.out.println("Origem inexistente!");
		} else if (destination == null) {
			System.out.println("Destino inexistente!");
		} else if (grafo.getEdgeCost(origin.getValue(), destination.getValue()) > 0) {
			System.out.println("Já existe uma aresta entre estes 2 vértices!");
		} else {
			value = getValue("custo");
			grafo.addEdge(origin.getValue(), destination.getValue(), value);
			System.out.println("Aresta inserida com sucesso!");
		}
	}

	static void printShortestPath(Grafo grafo) {
		int value = getValue("vértice de origem");
		Vortex originVortex = grafo.get(value);
		value = getValue("vértice de destino");
		Vortex destinationVortex = grafo.get(value);
		if (originVortex == null) {
			System.out.println("Vértice de origem inexistente!");
		} else if (destinationVortex == null) {
			System.out.println("Vértice de destino inexistente!");
		} else {
			grafo.printShortestPath(originVortex.getValue(), destinationVortex.getValue());
		}
	}

	static int getValue(String action) {
		/*
		 * Nada importante, só para reduzir algumas poucas linhas da main, quase nada na
		 * verdade.
		 */
		System.out.println("Digite o valor do " + action + ": ");
		return leitor.nextInt();
	}

	static int getOption(String type) {
		int option = 0;
		do {
			if (type.equalsIgnoreCase("Inserir"))
				System.out.println("1. Inserir Vértice\n2. Inserir Aresta\n3. Voltar\nEscolha uma opção acima: ");
			else
				System.out.println("1. Remover Vértice\n2. Remover Aresta\n3. Voltar\nEscolha uma opção acima: ");

			option = leitor.nextInt();
		} while (option < 1 || option > 3);
		return option;
	}

	static int getOption() {
		int option = 0;
		do {
			System.out.println(
					"\nMENU PRINCIPAL: \n1. Inserir\n2. Remover\n3. Exibir melhor caminho\n4. Sair\nEscolha uma opção acima: ");
			option = leitor.nextInt();
		} while (option < 1 || option > 4);
		return option;
	}
}

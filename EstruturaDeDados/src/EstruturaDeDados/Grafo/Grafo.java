package EstruturaDeDados.Grafo;

import java.util.ArrayList;

public class Grafo {

	private Vortex first;

	public Vortex getFirst() {
		return first;
	}

	public void setFirst(Vortex first) {
		this.first = first;
	}

	/* MÉTODOS PARA BUSCAR MENOR CAMINHO */
	public void printShortestPath(int origin, int destination) {
		/*
		 * Método imprime todos os vértices percorrigos, seguidos por seus custos.
		 */
		ArrayList<Vortex> vortices = searchShortestPath(origin, destination);
		if (vortices != null) {
			int totalCost = 0;
			Vortex prev = vortices.get(0);
			if (prev != null) {
				System.out.println("MOSTRAR MENOR CAMINHO\nPassou por: ");
				for (Vortex vortex : vortices) {
					int currentCost = getEdgeCost(vortex.getValue(), prev.getValue());
					System.out.println(vortex.getValue() + ", custo: " + currentCost);
					totalCost += currentCost;
					prev = vortex;
				}
				System.out.println("Custo total: " + totalCost);
			}
		}
	}

	private ArrayList<Vortex> searchShortestPath(int originValue, int destinationValue) {
		/*
		 * Método apenas chama o próximo que realmente vai procurar o menor caminho
		 */
		Vortex originVortex = get(originValue);
		Vortex destinationVortex = get(destinationValue);
		if (originVortex != null && destinationVortex != null)
			return searchShortestPath(originVortex, destinationVortex, new ArrayList<Vortex>());
		return null;

	}

	@SuppressWarnings("unchecked")
	private ArrayList<Vortex> searchShortestPath(Vortex vortex1, Vortex destination, ArrayList<Vortex> mainVortices) {
		/*
		 * Método vai percorrendo todos os sucessores dos vértices e para ao achar o
		 * destino. Ao achar o destino, continua a procurar nos demais sucessores, afim
		 * de ter certeza que o caminho encontrado é de fato o menor.
		 */
		ArrayList<Vortex> listAux = null;
		ArrayList<Vortex> copyOfVortices = (ArrayList<Vortex>) mainVortices.clone();
		copyOfVortices.add(vortex1);
		if (vortex1 != destination) {

			Edge edge = vortex1.getSuccessor();
			while (edge != null) {
				if (!copyOfVortices.contains(edge.getVortex())) {
					if (listAux == null) {
						listAux = (ArrayList<Vortex>) searchShortestPath(edge.getVortex(), destination, copyOfVortices);
					} else if (listAux.contains(destination) && countCost(listAux) > countCost(
							searchShortestPath(edge.getVortex(), destination, copyOfVortices))) {
						listAux = (ArrayList<Vortex>) searchShortestPath(edge.getVortex(), destination, copyOfVortices);
					}
					edge = edge.getNext();
				} else {
					edge = edge.getNext();
				}
			}
			copyOfVortices = listAux != null && listAux.contains(destination) ? listAux : null;
		}
		return copyOfVortices;
	}

	private int countCost(ArrayList<Vortex> vortices) {
		/*
		 * Retorna soma total dos custos que contém no array list. Caso o array list
		 * seja nulo, retorna Integer.MAX_VALUE.
		 */
		if (vortices != null) {
			int count = 0;
			Vortex prev = vortices.get(0);
			if (prev != null) {
				for (Vortex vortex : vortices) {
					count += getEdgeCost(vortex.getValue(), prev.getValue());
					prev = vortex;
				}
			}
			return count;
		}
		return Integer.MAX_VALUE;
	}

	public int getEdgeCost(int originValue, int destinationValue) {
		/* Retorna o custo entre 2 vértices. */
		Vortex originVortex = get(originValue);
		Vortex destinationVortex = get(destinationValue);
		if (originVortex != null && destinationVortex != null) {
			Edge edge = originVortex.getSuccessor();
			while (edge != null) {
				if (edge.getVortex() == destinationVortex)
					return edge.getCost();

				edge = edge.getNext();
			}
		}
		return 0;
	}

	public void addVortex(int value) {
		/* Adiciona vértice no fim da lista */
		if (first != null) {
			Vortex aux = first;
			while (aux.getNext() != null)
				aux = aux.getNext();
			aux.setNext(new Vortex(value));
		} else {
			first = new Vortex(value);
		}
	}

	public Vortex get(int value) {
		return get(value, first);
	}

	private Vortex get(int value, Vortex vortex) {
		/*
		 * Retorna o vértice de acordo com seu valor. Se não existir, retorna null.
		 */
		if (vortex != null && value == vortex.getValue())
			return vortex;
		else if (vortex != null)
			return get(value, vortex.getNext());
		return null;
	}

	public void removeVortex(int value) {
		/* Remove primeiro todas as arestas do vértice e depois o remove. */
		Vortex vortex = get(value);
		if (vortex != null) {
			Edge edge = vortex.getSuccessor();
			while (edge != null) {
				removeEdge(vortex, edge.getVortex());
				edge = edge.getNext();
			}
			first = removeVortex(vortex, first);
		}
	}

	private Vortex removeVortex(Vortex excluded, Vortex currentVortex) {
		if (excluded == currentVortex) {
			currentVortex = currentVortex.getNext();
		} else {
			currentVortex.setNext(removeVortex(excluded, currentVortex.getNext()));
		}
		return currentVortex;

	}

	public void removeEdge(Vortex origin, Vortex destination) {
		if (origin != null && destination != null) {
			origin.setSuccessor(removeEdge(origin.getSuccessor(), destination));
			origin.setLength(origin.getLength() - 1);
			destination.setSuccessor(removeEdge(destination.getSuccessor(), origin));
			destination.setLength(destination.getLength() - 1);
		}
	}

	private Edge removeEdge(Edge edge, Vortex destination) {
		if (edge != null) {
			if (edge.getVortex() == destination) {
				edge = edge.getNext();
			} else {
				edge.setNext(removeEdge(edge.getNext(), destination));
			}
		}
		return edge;
	}

	public void addEdge(int originValue, int destinationValue, int weight) {
		/* Cria arestas entre os 2 vértices informados, se existirem. */
		Vortex originVortex = get(originValue);
		Vortex destinationVortex = get(destinationValue);
		if (originVortex != null && destinationVortex != null) {
			setEdge(originVortex, destinationVortex, weight);
			setEdge(destinationVortex, originVortex, weight);
		}
	}

	private void setEdge(Vortex origin, Vortex destination, int weight) {
		Edge newEdge = new Edge(destination, weight);
		if (origin.getSuccessor() == null) {
			origin.setSuccessor(newEdge);
			origin.setLength(origin.getLength() + 1);
		} else {
			Edge edge = origin.getSuccessor();
			boolean exist = edge.getVortex().getValue() == newEdge.getVortex().getValue();
			while (edge.getNext() != null && !exist) {
				edge = edge.getNext();
				exist = edge.getVortex().getValue() == newEdge.getVortex().getValue();
			}
			if (!exist) {
				addSorted(origin, newEdge);
				origin.setLength(origin.getLength() + 1);
			}
		}
	}

	private void addSorted(Vortex originVortex, Edge newEdge) {
		/* Adiciona aresta em ordem crescente. */
		Edge edge = originVortex.getSuccessor();
		if (edge.getVortex().getValue() > newEdge.getVortex().getValue()) {
			newEdge.setNext(edge);
			originVortex.setSuccessor(newEdge);
		} else {
			while (edge.getNext() != null) {
				if (edge.getVortex().getValue() < newEdge.getVortex().getValue()
						&& newEdge.getVortex().getValue() < edge.getNext().getVortex().getValue()) {
					newEdge.setNext(edge.getNext());
					edge.setNext(newEdge);
					break;
				} else {
					edge = edge.getNext();
				}
			}
			if (edge.getNext() == null)
				edge.setNext(newEdge);
		}
	}

	public void print() {
		print(first);
		System.out.println();
	}

	private void print(Vortex vortex) {
		if (vortex != null) {
			System.out.print(vortex.getValue() + (vortex.getSuccessor() != null ? " - arestas: " : "\n"));
			printEdge(vortex.getSuccessor());
			print(vortex.getNext());
		}
	}

	private void printEdge(Edge edge) {
		if (edge != null) {
			System.out.print(edge.getVortex().getValue() + (edge.getNext() != null ? ", " : ";\n"));
			printEdge(edge.getNext());
		}
	}
}
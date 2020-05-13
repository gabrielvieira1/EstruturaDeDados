package EstruturaDeDados.Grafo;

public class Edge {

	private Vortex vortex;
	private int cost;
	private Edge next;

	public Vortex getVortex() {
		return vortex;
	}

	public void setVortex(Vortex vortex) {
		this.vortex = vortex;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int custo) {
		this.cost = custo;
	}

	public Edge getNext() {
		return next;
	}

	public void setNext(Edge next) {
		this.next = next;
	}

	public Edge() {

	}

	@Override
	public String toString() {
		return "Edge [vortex=" + vortex.getValue() + (next != null ? ", next=" + next + "]" : "]");
	}

	public Edge(Vortex value, int cost) {
		this.vortex = value;
		this.cost = cost;
	}

}

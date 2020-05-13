package EstruturaDeDados.Grafo;

public class Vortex {

	private Edge successor;
	private int value;
	private Vortex next;
	private int length;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Edge getSuccessor() {
		return successor;
	}

	public void setSuccessor(Edge vortex) {
		this.successor = vortex;
	}

	public Vortex getNext() {
		return next;
	}

	public void setNext(Vortex next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Vortex() {

	}

	@Override
	public String toString() {
		return "\nVortex [value=" + value + (successor != null ? ", sucessor=" + successor : "")
				+ (next != null ? ", next=" + next : "]");
	}

	public Vortex(int value) {
		this.value = value;
	}
}
package EstruturaDeDados.Atividade02;

public class Cliente {

	private String nome;
	private int fone;
	private String email;
	private double valorCompra;

	public Cliente(String nome, int fone, double valorCompra) {
		super();
		this.nome = nome;
		this.fone = fone;
		this.valorCompra = valorCompra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getFone() {
		return fone;
	}

	public void setFone(int fone) {
		this.fone = fone;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return getNome() + "; " + getFone() +"; "+ getValorCompra();
	}

}

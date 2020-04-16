package EstruturaDeDados.Atividade06;

public class Banco {
	
	private String cliente;
	private int idade;
	
	public Banco() {
		
	}
	
	public Banco(String cliente) {
		this.cliente = cliente;
	}
	
	public Banco(String cliente, int idade) {
		this.cliente = cliente;
		this.idade = idade;
	}
	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String toString() {
		
		return "Cliente: " + cliente + " Idade: " + idade;
	}
	

}

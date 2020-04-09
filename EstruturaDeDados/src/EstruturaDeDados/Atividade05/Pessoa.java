package EstruturaDeDados.Atividade05;


public class Pessoa {
	String nome;
	String email;
	String cpf;
	int fone;
	
	
 public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public int getFone() {
		return fone;
	}


	public void setFone(int fone) {
		this.fone = fone;
	}


	@Override
	public String toString() {
		return "[nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", fone=" + fone + "]";
	}



}

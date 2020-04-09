package EstruturaDeDados.Atividade04Certa;

public class Aluno {

	private int nota1;
	private int nota2;
	private String matricula;
	private Aluno proximo;

	public Aluno getProximo() {
		return proximo;
	}

	public void setProximo(Aluno proximo) {
		this.proximo = proximo;

	}

	public int getNota1() {
		return nota1;
	}

	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}

	public void getNota1(int nota1) {
		this.nota1 = nota1;
	}

	public int getNota2() {
		return nota2;
	}

	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}

	public void getNota2(int nota2) {
		this.nota2 = nota2;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int media() {
		int media = (this.nota1 + this.nota2) / 2;
		return media;
	}

	@Override
	public String toString() {
		return "[matricula=" + matricula + ", nota1=" + nota1 + ", nota2=" + nota2 + ", media=" + media() + "]";
	}

}

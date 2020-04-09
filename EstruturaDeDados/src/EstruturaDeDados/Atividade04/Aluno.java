package EstruturaDeDados.Atividade04;

public class Aluno {
	
	private int matricula;
	private int nota;
	private Aluno proximo;
	private String situacao;
	
	public Aluno() {
	}
	public Aluno(int matricula, int nota, String situacao) {
		this.matricula = matricula;
		this.nota = nota;
		this.situacao = situacao;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public Aluno getProximo() {
		return proximo;
	}

	public void setProximo(Aluno proximo) {
		this.proximo = proximo;
	}

	public void getNota(int nota) {
		this.nota = nota;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String toString() {
		return "Matricula: " + getMatricula()+ " Nota: "+getNota()+" Situação: "+ getSituacao();
	}

}

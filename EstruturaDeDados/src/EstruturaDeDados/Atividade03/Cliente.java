package EstruturaDeDados.Atividade03;

	public class Cliente<T> {
		
		private String nome;
		private Integer telefone;
		private String email;
		
		
		
		public Cliente(String nome, Integer telefone, String email) {
			this.nome = nome;
			this.telefone = telefone;
			this.email = email;
		}
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Integer getTelefone() {
			return telefone;
		}
		public void setTelefone(Integer telefone) {
			this.telefone = telefone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "Cliente [nome=" + nome + ", telefone=" + telefone + ", email=" + email + "]";
		}
		
		
		
	}


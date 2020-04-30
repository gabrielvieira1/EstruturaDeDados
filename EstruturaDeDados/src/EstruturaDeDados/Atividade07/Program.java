package EstruturaDeDados.Atividade07;

public class Program<T> {

	public static void main(String[] args) {
		int[] vetor = {9,8,7,6,5,4,3,2,1};
		
		bolha(vetor);

		for(int el: vetor) {
			System.out.print(el+", ");
		}
	}
	
	static void bolha(int[] v) {
		for (int ult = v.length - 1; ult>0; ult--) {
			for (int i = 0; i < ult; i++) {
				if (v[i] > v[i+1]) {
					int aux = v[i];
					v[i] = v[i+1];
					v[i+1] = aux;
				}
			}
		}
	}

	

}

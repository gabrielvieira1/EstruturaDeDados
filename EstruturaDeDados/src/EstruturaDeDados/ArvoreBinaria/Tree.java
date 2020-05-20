package EstruturaDeDados.ArvoreBinaria;


public class Tree {
	
	
	public static void inserir(No node, long valor) {
		if (node == null) {
			System.out.println("Raiz " + valor);
			No.raiz = new No(valor);
		} else {
			if (valor < node.valor) {
				if (node.noEsquerda != null) {
					inserir(node.noEsquerda, valor);
				} else {
					System.out.println("Inserindo " + valor + " a esquerda de " + node.valor);
					node.noEsquerda = new No(valor);
				}
			} else {
				if (node.noDireita != null) {
					inserir(node.noDireita, valor);
				} else {
					System.out.println("Inserindo " + valor + " a Direita de " + node.valor);
					node.noDireita = new No(valor);
				}
			}
		}
	}
	
	public static boolean buscar(No node, long valor) {
		boolean retorno = false;
		
		if (node == null) {
			retorno = false;
		} else if(node.valor == valor){
			retorno = true;
		} else {
			if (node.valor > valor) {
				retorno = buscar(node.noEsquerda, valor);
			} else {
				retorno = buscar(node.noDireita, valor);
			}
		}
		return retorno;
	}
/*	
	public static void remover(No node, long valor) {
		if (node.valor == valor) {
			node = null;
		} else if (node.valor > valor) {
			if (node.noEsquerda.valor == valor) {
				estrategiaParaRemoverNoEsquerda(node);
			} else {
				remover(node.noEsquerda, valor);
			}
		} else {
			if (node.noDireita.valor == valor) {
				estrateiaPararemoverNoDireita(node);
			} else {
				remover(node.noDireita, valor);
			}
		}
	}

	public static void estrateiaPararemoverNoDireita(No noPai) {
		long filhos = 0;
		No noRemover = null;
		
		filhos = totalFilhos(noRemover);
		if (filhos == 0) {
			removerSemFilhos(noPai, "D");
		} else if (filhos == 1) {
			removerUmFilhoDireita(noPai, "E");
		} else if (filhos == 2) {
			removerUmFilhoDireita(noPai, "D");
		}
	}
	
	public static void estrategiaParaRemoverNoEsquerda(No noPai) {
		boolean filhos;
		No noRemover = null;
		
		filhos = totalFilho(noRemover);
		if (filhos == false) {
			removerSemFilhos(noPai, "D");
		} else if (filhos == true) {
			removerUmFilhoEsquerda(noPai, "E");
		} else if (filhos == true) {
			removerUmFilhoEsquerda(noPai, "D");
		}
	}

	public static void removerFilhosEsqDir(No noPai, String subArvore) {
		if (subArvore.equals("ED")) {
			noPai.noEsquerda = noPai.noDireita.noEsquerda;
		} else {
			noPai.noDireita = noPai.noDireita.noDireita;
		}
	}

	public static void removerUmFilhoDireita(No noPai, String subArvore) {
		if (subArvore.equals("E")) {
			noPai.noDireita = noPai.noDireita.noEsquerda;
		} else {
			noPai.noDireita = noPai.noDireita.noDireita;
		}
	}
	
	public static void removerUmFilhoEsquerda(No noPai, String subArvore) {
		if (subArvore.equals("E")) {
			noPai.noEsquerda = noPai.noEsquerda.noEsquerda;
		} else {
			noPai.noEsquerda = noPai.noEsquerda.noDireita;
		}
	}

	public static void removerSemFilhos(No noPai, String subArvore) {
		if (noPai.noEsquerda == null && noPai.noDireita == null) {
			if (noPai == No.raiz) {
				No.raiz = null;
			} else if (subArvore.equals("E")) {
				noPai.noEsquerda = null;
			} else {
				noPai.noDireita = null;
			}
		}
	}

	public static long totalFilhos(No noRemover) {
		int total = 0;
		
		if (noRemover.noEsquerda != null) {
			total += 1;
		} else if (noRemover.noDireita != null) {
			total += 2;
		}
		return total;
	}
	*/
	public boolean removerNovo(long v) {
		if (No.raiz == null)
			return false;
		No atual = No.raiz;
		No pai = No.raiz;
		boolean filho_esq = true;
		
		// ****** Buscando o valor **********
		while (atual.valor != v) {
			pai = atual;
			if (v < atual.valor) {
				atual = atual.noEsquerda;
				filho_esq = true;
			} else { 
				atual = atual.noDireita;
				filho_esq = false;
			}
			if (atual == null)
				return false;
		}

		if (atual.noEsquerda == null && atual.noDireita == null) {
			if (atual == No.raiz)
				No.raiz = null;
			else if (filho_esq)
				pai.noEsquerda = null;
			else
				pai.noDireita = null;
		}

		else if (atual.noDireita == null) {
			if (atual == No.raiz)
				No.raiz = atual.noEsquerda;
			else if (filho_esq)
				pai.noEsquerda = atual.noEsquerda;
			else
				pai.noDireita = atual.noEsquerda;
		}

		else if (atual.noEsquerda == null) {
			if (atual == No.raiz)
				No.raiz = atual.noDireita;
			else if (filho_esq)
				pai.noEsquerda = atual.noDireita;
			else
				pai.noDireita = atual.noDireita;
		}

		else {
			No sucessor = no_sucessor(atual);
			
			if (atual == No.raiz)
				No.raiz = sucessor;
			else if (filho_esq)
				pai.noEsquerda = sucessor;
			else
				pai.noDireita = sucessor;
			sucessor.noEsquerda = atual.noEsquerda;
		}

		return true;
	}

	public No no_sucessor(No apaga) {
		No paidosucessor = apaga;
		No sucessor = apaga;
		No atual = apaga.noDireita;

		while (atual != null) {
			paidosucessor = sucessor;
			sucessor = atual;
			atual = atual.noEsquerda;
		}
		
		if (sucessor != apaga.noDireita) { 
			paidosucessor.noEsquerda = sucessor.noDireita;
			sucessor.noDireita = apaga.noDireita;
		}
		return sucessor;
	}

	public static void imprimirPreOrdem(No a) {
		System.out.println(a.valor + " ");
		if (a.noEsquerda != null) {
			imprimirPreOrdem(a.noEsquerda);
		}
		if (a.noDireita != null) {
			imprimirPreOrdem(a.noDireita);
		}	
	}
	
	public static void imprimirEmOrdem(No a) {
		
		if (a.noEsquerda != null) {
			imprimirEmOrdem(a.noEsquerda);
		}
		System.out.println(a.valor + " ");
		if (a.noDireita != null) {
			imprimirEmOrdem(a.noDireita);
		}	
	}
	
	public static void imprimirPosOrdem(No a) {
		
		if (a.noEsquerda != null) {
			imprimirPosOrdem(a.noEsquerda);
		}
		
		if (a.noDireita != null) {
			imprimirPosOrdem(a.noDireita);
		}	
		System.out.println(a.valor + " ");
	}

}

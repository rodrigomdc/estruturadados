//FONTE: https://www.blogcyberini.com/2018/08/quicksort-analise-e-implementacoes.html

public class QuickSort {
	//Facilita a vida: s� pede o array como argumento
	public static void quicksort(int[] A){        
		quicksort(A, 0, A.length - 1);
	}

	//Quicksort de Hoare
	private static void quicksort(int[] A, int inicio, int fim){        
		if(inicio < fim){
			//realiza a parti��o
			int q = partition(A, inicio, fim);
			//ordena a parti��o esquerda
			quicksort(A, inicio, q - 1);
			//ordena a parti��o direita
			quicksort(A, q + 1, fim);            
		}
	}

	//M�todo de parti��o
	private static int partition(int[] A, int inicio, int fim){
		//o pivo � o elemento inicial
		int pivo = A[inicio];
		//�ndice i ir� percorrer o array da esquerda para a direita
		int i = inicio + 1;
		//�ndice j ir� percorrer o array da direita para a esquerda
		int j = fim;

		//O loop ir� parar quando os �ndices se ultrapassarem
		while(i <= j){
			/*
			 * Este la�o ir� parar quando encontrar algum elemento
			 * � esquerda que � maior que o piv�, pois ele deveria estar na 
			 * parti��o direita
			 */
			while(i <= j && A[i] <= pivo){
				i = i + 1;
			}
			/*
			 * Esse la�o ir� parar quando encontrar algum elemento
			 * � direira que � menor ou igual ao piv�, pois ele deveria estar na 
			 * parti��o esquerda
			 */
			while(i <= j && A[j] > pivo){
				j = j - 1;
			}

			//se os �ndices n�o ultrapassarem, troca-os de posi��o
			if(i < j){
				swap(A, i, j);
			}
		}
		//coloca o piv� na posi��o de ordena��o
		swap(A, inicio, j);
		return j; //retorna a posi��o do piv�
	}

	//m�todo auxiliar para realizar as trocas de elementos
	private static void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}



	public static void main(String args[]) {

		int quantidade = 500000;
		int[] vet = new int[quantidade];

		for (int i = 0; i < vet.length; i++) {
			vet[i] = (int) (Math.random()*quantidade);
		}		

		long tempoInicial = System.currentTimeMillis();

		quicksort(vet);

		long tempoFinal = System.currentTimeMillis();

		for(int i = 0; i<vet.length; i++){
			System.out.println(" "+vet[i]);
		}

		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
	}

}

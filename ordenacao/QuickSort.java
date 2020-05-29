//FONTE: https://www.blogcyberini.com/2018/08/quicksort-analise-e-implementacoes.html

public class QuickSort {
	//Facilita a vida: só pede o array como argumento
	public static void quicksort(int[] A){        
		quicksort(A, 0, A.length - 1);
	}

	//Quicksort de Hoare
	private static void quicksort(int[] A, int inicio, int fim){        
		if(inicio < fim){
			//realiza a partição
			int q = partition(A, inicio, fim);
			//ordena a partição esquerda
			quicksort(A, inicio, q - 1);
			//ordena a partição direita
			quicksort(A, q + 1, fim);            
		}
	}

	//Método de partição
	private static int partition(int[] A, int inicio, int fim){
		//o pivo é o elemento inicial
		int pivo = A[inicio];
		//índice i irá percorrer o array da esquerda para a direita
		int i = inicio + 1;
		//índice j irá percorrer o array da direita para a esquerda
		int j = fim;

		//O loop irá parar quando os índices se ultrapassarem
		while(i <= j){
			/*
			 * Este laço irá parar quando encontrar algum elemento
			 * à esquerda que é maior que o pivô, pois ele deveria estar na 
			 * partição direita
			 */
			while(i <= j && A[i] <= pivo){
				i = i + 1;
			}
			/*
			 * Esse laço irá parar quando encontrar algum elemento
			 * à direira que é menor ou igual ao pivô, pois ele deveria estar na 
			 * partição esquerda
			 */
			while(i <= j && A[j] > pivo){
				j = j - 1;
			}

			//se os índices não ultrapassarem, troca-os de posição
			if(i < j){
				swap(A, i, j);
			}
		}
		//coloca o pivô na posição de ordenação
		swap(A, inicio, j);
		return j; //retorna a posição do pivô
	}

	//método auxiliar para realizar as trocas de elementos
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

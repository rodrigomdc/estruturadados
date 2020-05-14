//Fonte: https://www.devmedia.com.br/algoritmos-de-ordenacao-em-java/32693


public class InsertionSort {

	private static  int quantidade = 100000;
	private static int[] vet = new int[quantidade];

	public static void main(String[] args) {
		
		for (int i = 0; i < vet.length; i++) {
			vet[i] = (int) (Math.random()*quantidade);
		}		

		System.out.println("Vetor desordenado: ");
		for(int i = 0; i<vet.length; i++){
			System.out.println(" "+vet[i]);
		}

		System.out.println(" ");
		
		long tempoInicial = System.currentTimeMillis();

		insertionSort(vet);
		
		long tempoFinal = System.currentTimeMillis();

		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");

		System.out.println("Vetor organizado: \n");
		for(int i = 0; i<vet.length; i++){
			System.out.println(" "+vet[i]);
		}
		
		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");

	}
	
	private static void insertionSort(int[] vetor) {
		
	    int j;
	    int key;
	    int i;
	    
	    for (j = 1; j < vetor.length; j++)
	    {
	      key = vetor[j];
	      for (i = j - 1; (i >= 0) && (vetor[i] > key); i--)
	      {
	         vetor[i + 1] = vetor[i];
	      }
	        vetor[i + 1] = key;
	    }
	}

}

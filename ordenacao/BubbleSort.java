//Fonte: https://www.devmedia.com.br/algoritmos-de-ordenacao-em-java/32693


public class BubbleSort {

	/**
	 * @param args
	 */

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

		bubbleSort(vet);

		long tempoFinal = System.currentTimeMillis();

		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms \n");

		System.out.println("Vetor organizado:");
		for(int i = 0; i<vet.length; i++){
			System.out.println(" "+vet[i]);
		}
		
		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms \n");

	}

	private static void bubbleSort(int vetor[]){
		boolean troca = true;
		int aux;
		while (troca) {
			troca = false;
			for (int i = 0; i < vetor.length - 1; i++) {
				if (vetor[i] > vetor[i + 1]) {
					aux = vetor[i];
					vetor[i] = vetor[i + 1];
					vetor[i + 1] = aux;
					troca = true;
				}
			}
		}
	}

}

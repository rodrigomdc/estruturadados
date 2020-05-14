//Fonte: https://www.devmedia.com.br/algoritmos-de-ordenacao-em-java/32693

public class SelectionSort {

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

		selectionSort(vet);
		
		long tempoFinal = System.currentTimeMillis();

		
		System.out.println("Vetor organizado: \n");
		for(int i = 0; i<vet.length; i++){
			System.out.println(" "+vet[i]);
		}
		
		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms \n");

	}

	private static void selectionSort(int[] array) {

		for (int fixo = 0; fixo < array.length - 1; fixo++) {
			int menor = fixo;

			for (int i = menor + 1; i < array.length; i++) {
				if (array[i] < array[menor]) {
					menor = i;
				}
			}
			if (menor != fixo) {
				int t = array[fixo];
				array[fixo] = array[menor];
				array[menor] = t;
			}
		}

	}

}

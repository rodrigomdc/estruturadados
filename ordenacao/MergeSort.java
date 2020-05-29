
//FONTE: https://www.dcc.fc.up.pt/~pribeiro/aulas/edados1819/codigo/mergesort.html

public class MergeSort {

	// Ordenar array v entre posições start e end
	static void mergeSort(int v[], int start, int end) {
		if (start == end) return;        // caso base (tamanho 1)
		int middle = (start + end) / 2;  // ponto médio
		mergeSort(v, start, middle);     // chamada recursiva à metade esquerda
		mergeSort(v, middle+1, end);     // chamada recursiva à metade direita
		merge(v, start, middle, end);    // combinar resultados
	}

	// Juntar duas metadas já ordenadas
	static void merge(int v[], int start, int middle, int end) {
		int aux[] = new int[end-start+1]; // Novo array temporário

		int p1 = start;    // "Apontador" do array da metade esquerda
		int p2 = middle+1; // "Apontador" do array da metade direita
		int cur = 0;       // "Apontador" do array aux[] a conter juncao
		while (p1 <= middle && p2 <= end) { // Enquanto der para comparar
			if (v[p1] <= v[p2]) aux[cur++] = v[p1++]; // Escolher menor
			else aux[cur++] = v[p2++];                // e adicionar
		}
		while (p1<=middle) aux[cur++] = v[p1++]; // Adicionar o que resta
		while (p2<=end)    aux[cur++] = v[p2++];

		// Copiar array aux[] para v[]
		for (int i=0; i<cur; i++) v[start+i] = aux[i];
	}

	// -----------------------------------------------------------

	public static void main(String args[]) {
		
		int quantidade = 500000;
		int[] vet = new int[quantidade];
		
		for (int i = 0; i < vet.length; i++) {
			vet[i] = (int) (Math.random()*quantidade);
		}		

		long tempoInicial = System.currentTimeMillis();
		
		mergeSort(vet, 0, vet.length-1);
		
		long tempoFinal = System.currentTimeMillis();

		for(int i = 0; i<vet.length; i++){
			System.out.println(" "+vet[i]);
		}
		
		System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
	}


}

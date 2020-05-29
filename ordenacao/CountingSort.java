
//Fonte:https://www.programiz.com/dsa/counting-sort

import java.util.Arrays;

class CountingSort {
	
  void countSort(int array[], int size) {
    int[] output = new int[size + 1];

    // Encontro o maior elemento do vetor
    int max = array[0];
    for (int i = 1; i < size; i++) {
      if (array[i] > max)
        max = array[i];
    }
    int[] count = new int[max + 1];

    // Inicializo o vetor auxiliar com zeros
    for (int i = 0; i < max; ++i) {
      count[i] = 0;
    }

    // Faço a contagem de cada elemento e armazeno no vetor de entrada
    for (int i = 0; i < size; i++) {
      count[array[i]]++;
    }

    // Faço a frequencia acumulada nos elementos do vetor auxiliar
    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }

    //Encontro o indice de cada elemento do vetor de entrada no vetor auxiliar
    // Coloco os elementos no vetor de saida 
    for (int i = size - 1; i >= 0; i--) {
      output[count[array[i]] - 1] = array[i];
      count[array[i]]--;
    }

    // Copia do vetor de saida para o vetor original
    for (int i = 0; i < size; i++) {
      array[i] = output[i];
    }
  }

 
  public static void main(String args[]) {
	  
    int[] data = { 4, 2, 0, 8, 3, 3, 1 , 7};
    
    int size = data.length;
    
    CountingSort cs = new CountingSort();
    
    cs.countSort(data, size);
    
    System.out.println("Vetor ordenado (crescente): ");
    System.out.println(Arrays.toString(data));
  }
}

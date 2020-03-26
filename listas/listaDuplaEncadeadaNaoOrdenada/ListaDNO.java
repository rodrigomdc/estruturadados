package listaDuplaEncadeadaNaoOrdenada;

import java.util.Scanner;

/*
 * CÓDIGO FONTE EXTRAÍDO DO LIVRO: ESTRUTURA DE DADOS. ALGORITMOS, ANÁLISE DA COMPLEXIDADE E IMPLEMENTAÇÕES EM JAVA E C/C++
 * ANA FERNANDA GOMES ASCENCIO E GRAZIELA SANTOS DE ARAUJO
 */


public class ListaDNO {

	//Definindo a classe que representar� cada elemento da list
	
	private static class LISTA{
		public int num;
		public LISTA prox;
		public LISTA ant;
	}
	
	
	
	public static void main(String args[]) {

		Scanner entrada = new Scanner(System.in);

		// A lista esta vazia, logo o objeto inicio tem o valor null
		// O objeto inicio contera o endereco do primenro elemento da lista

		LISTA inicio = null;

		// O objeto fim conter� o endere�o do �ltimo elemento da lista

		LISTA fim = null;

		// O objeto aux � um objeto auxiliar

		LISTA aux;
		
		// Menu de op��es

		int op, numero, achou;

		do {
			System.out.println("\nMENU DE OPCOES\n");
			System.out.println("1 - Inserir no inicio da lista");	
			System.out.println("2 - Inserir no fim da lista");	
			System.out.println("3 - Consultar a lista do inicio ao fim");
			System.out.println("4 - Consultar a lista do fim ao inicio");
			System.out.println("5 - Remover da lista");
			System.out.println("6 - Esvaziar a lista");
			System.out.println("7 - sair");
			System.out.print("Digite sua op��o");

			op = entrada.nextInt();

			if(op == 1) {
				
				System.out.print("Digite o numero a ser inserido na lista: ");
				LISTA novo = new LISTA();					
				novo.num = entrada.nextInt();

				if(inicio == null) {

					// A lista estava vazia e o elemento sera o primeiro e o ultimo da lista
					inicio  	= novo;
					fim 		= novo;
					novo.prox 	= null;
					novo.ant	= null;									

				}else {

					// A lista j� cont�m elementos e o novo elemento ser� inserido no inicio da lista
					novo.prox	= inicio;
					inicio.ant	= novo;
					novo.ant	= null;
					inicio		= novo;					
					
				}
				System.out.println("Numero inserido no inicio da lista");
			}
			
			if(op == 2) {
				
				System.out.print("Digite o numero a ser inserido no fim da lista: ");
				LISTA novo = new LISTA();					
				novo.num = entrada.nextInt();

				if(inicio == null) {

					// A lista estava vazia e o elemento sera o primeiro e o ultimo da lista
					inicio  	= novo;
					fim 		= novo;
					novo.prox 	= null;
					novo.ant	= null;									

				}else {

					// A lista j� cont�m elementos e o novo elemento ser� inserido no fim da lista
					fim.prox	= novo;					
					novo.ant	= fim;
					novo.prox	= null;
					fim			= novo;					
					
				}
				System.out.println("Numero inserido no fim da lista");
			}

			if(op == 3) {

				if(inicio == null)
					System.out.println("Lista vazia");
				else {
					
					// A lista cont�m elementos e estes ser�o exibidos do inicio ao fim
					System.out.println("\nComputando toda a lista - INICIO -> FIM\n");
					aux		= inicio;
					
					while(aux != null) {
						System.out.print(aux.num+"  ");
						aux = aux.prox;
					}
				}
				System.out.print("\n");
			}
			
			if(op == 4) {

				if(inicio == null)
					System.out.println("Lista vazia");
				else {
					
					// A lista cont�m elementos e estes ser�o exibidos do fim ao inicio
					System.out.println("\nComputando toda a lista - FIM -> INICIO\n");
					aux		= fim;
					
					while(aux != null) {
						System.out.print(aux.num+"  ");
						aux = aux.ant;
					}
				}
				System.out.print("\n");
			}

			if(op == 5) {

				if(inicio == null)
					System.out.println("Lista vazia");
				else {

					// A lista contem elementos e o elemento a ser removide deve ser digitado
					System.out.print("\nDigite o elemeto a ser removido: ");
					numero		= entrada.nextInt();

					// Todas as ocorr�ncias da lista iguais ao numero ser� removidas
					aux			= inicio;					
					achou		= 0;

					while(aux != null) {

						if(aux.num == numero) {
							achou++;

							if(aux == inicio) {

								// O numero � o primeiro da lista								
								inicio 		= aux.prox;								
								if(inicio != null)
									inicio.ant	= null;								
								aux			= inicio;								
								
							} else if(aux == fim) {

								// O numero � o �ltimo da lista
								fim			= fim.ant;			
								fim.prox	= null;
								aux			= null;

							}else {

								// O numero esta no meio da lista
								aux.ant.prox	= aux.prox;
								aux.prox.ant	= aux.ant;
								aux				= aux.prox;

							}
						}else {							
							aux		= aux.prox;							
						}						

					} 
					if(achou == 0)
						System.out.println("Numero nao encontrado");
					else if(achou == 1)						
						System.out.println("Numero removido 1 vez");
					else
						System.out.println("Numero removido "+achou+" vezes");

				}
			}

			if(op == 6) {

				if(inicio == null) {					
					// A lista esta vazia
					System.out.println("Lista vazia!");				
				}else {

					//A lista sera esvaziada
					inicio = null;
					System.out.println("Lista esvaziada");
				}
			}

			if(op < 1 || op > 7)
				System.out.println("Op��o inv�lida");			

		}while(op != 7);
	}
}








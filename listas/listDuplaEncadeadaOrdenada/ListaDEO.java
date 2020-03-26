package listDuplaEncadeadaOrdenada;

import java.util.Scanner;

/*
 * CÓDIGO FONTE EXTRAÍDO DO LIVRO: ESTRUTURA DE DADOS. ALGORITMOS, ANÁLISE DA COMPLEXIDADE E IMPLEMENTAÇÕES EM JAVA E C/C++
 * ANA FERNANDA GOMES ASCENCIO E GRAZIELA SANTOS DE ARAUJO
 */


public class ListaDEO {

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
			System.out.println("1 - Inserir na lista");				
			System.out.println("2 - Consultar a lista do inicio ao fim");
			System.out.println("3 - Consultar a lista do fim ao inicio");
			System.out.println("4 - Remover da lista");
			System.out.println("5 - Esvaziar a lista");
			System.out.println("6 - sair");
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

					// A lista j� cont�m elementos e o novo elemento ser� inserido respeitando a ordenacao crescente
										
					aux			= inicio;
					
					while(aux != null && novo.num > aux.num) {						
						aux			= aux.prox;
					}
					
					if(aux == inicio) {
						
						// O novo numero a ser inserido � menor que todos os outros, logo sera inserido no inicio
						novo.prox	= inicio;
						novo.ant	= null;
						inicio.ant	= novo;
						inicio		= novo;
						
					}else if(aux == null) {
						
						// O novo numero a ser inserido � maior que todos os outros, logo sera inserido no fim
						fim.prox	= novo;
						novo.ant	= fim;
						fim			= novo;
						fim.prox	= null;
						
					}else {
						
						// O novo numero a ser inserido o ser� entre dois numeros que j� estao na lista
						novo.prox		= aux;
						aux.ant.prox	= novo;
						novo.ant		= aux.ant;
						aux.ant			= novo;
						
					}
					
				}
				System.out.println("Numero inserido na lista");
			}
			
			
			if(op == 2) {

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
			
			if(op == 3) {

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

			if(op == 4) {

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

			if(op == 5) {

				if(inicio == null) {					
					// A lista esta vazia
					System.out.println("Lista vazia!");				
				}else {

					//A lista sera esvaziada
					inicio = null;
					System.out.println("Lista esvaziada");
				}
			}

			if(op < 1 || op > 6)
				System.out.println("Op��o inv�lida");			

		}while(op != 6);
	}
}








package listaCircularSimplesNaoOrdenada;

import java.util.Scanner;

/*
 * CÓDIGO FONTE EXTRAÍDO DO LIVRO: ESTRUTURA DE DADOS. ALGORITMOS, ANÁLISE DA COMPLEXIDADE E IMPLEMENTAÇÕES EM JAVA E C/C++
 * ANA FERNANDA GOMES ASCENCIO E GRAZIELA SANTOS DE ARAUJO
 */



public class ListaCSNO {

	//Definindo a classe que representar� cada elemento da list
	
	private static class LISTA{
		public int num;
		public LISTA prox;
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

		// O objeto anterior � um objeto auxiliar

		LISTA anterior;

		// Menu de op��es

		int op, numero, achou;

		do {
			System.out.println("\nMENU DE OPCOES\n");
			System.out.println("1 - Inserir no inicio da lista");
			System.out.println("2 - Inserir no fim da lista");
			System.out.println("3 - Consultar toda a lista");
			System.out.println("4 - Remover da lista");
			System.out.println("5 - Esvaziar a lista");
			System.out.println("6 - sair");
			System.out.print("Digite sua op��o");

			op = entrada.nextInt();

			if(op == 1) {
				
				System.out.print("Digite o numero a ser inserido no inicio da lista: ");
				LISTA novo = new LISTA();					
				novo.num = entrada.nextInt();

				if(inicio == null) {

					// A lista estava vazia e o elemento sera o primeiro e o ultimo da lista
					inicio  	= novo;
					fim 		= novo;
					fim.prox 	= inicio; // Aponta para ele mesmo
									

				}else {

					// A lista j� cont�m elementos e o novo elemento ser� inserido no inicio da lista
					novo.prox 	= inicio;
					inicio		= novo;
					fim.prox 	= inicio; //N�o ponta para null e sim para o inicio
					
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
					fim.prox 	= inicio;

				}else{

					// A lista j� cont�m elementos e o novo elemento ser� inserido no fim da lista
					fim.prox 	= novo;
					fim			= novo;
					fim.prox 	= inicio; //Aponta para o inicio
				}
				System.out.println("Numero inserido no fim da lista");
			}

			if(op == 3) {

				if(inicio == null)
					System.out.println("Lista vazia");
				else {
					// A lista cont�m elementos e estes ser�o exibidos do inicio ao fim
					System.out.println("\nComputando toda a lista\n");

					aux		= inicio;
					//Executa o la�o pelo menos 1 vez, pois vai voltar de novo ao inicio
					do {
						System.out.print(aux.num+"  ");
						aux = aux.prox;
					}while(aux != inicio);
				}
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
					anterior	= null;
					achou		= 0;
					
					int quantidade 	= 0;
					int elemento 	= 1;
					
					// Descobre a quantidade de elementos na lista
					do {
						
						quantidade++;
						aux		= aux.prox;
						
					} while(aux != inicio);
										
					do{
						
						// Se a lista possui apenas 1 elemento
						if(inicio == fim && inicio.num == numero) {
							
							inicio 		= null; //Destroi o �nico elemento
							achou++;
							
						} else {
							
							if(aux.num == numero) {
								
								achou++;
								
								//O numero digitado foi encontrado na lista e sera removido								
								if(aux == inicio) {
									
									// O numero a ser removido � o primeiro da lista
									inicio		= aux.prox;
									fim.prox	= inicio;
									aux			= inicio;
									
								} else if(aux == fim) {
									
									// O numero digitado � o �ltimo da lista
									fim			= anterior;
									fim.prox	= inicio;
									aux 		= aux.prox;
									
								} else {
									
									//O numero a ser removido esta no meio da lista
									anterior.prox 	= aux.prox;
									aux				= aux.prox;
									
								}
								
							} else {
								
								//Nao encontrou e continua a percorrer a lista
								anterior	= aux;
								aux			= aux.prox;
								
							}
						}
						
					elemento++;

					}while(elemento <= quantidade);
					
					
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








package pilha;

import java.util.Scanner;

public class Pilha {

	/*
	 * CÓDIGO FONTE EXTRAÍDO DO LIVRO: ESTRUTURA DE DADOS. ALGORITMOS, ANÁLISE DA COMPLEXIDADE E IMPLEMENTAÇÕES EM JAVA E C/C++
	 * ANA FERNANDA GOMES ASCENCIO E GRAZIELA SANTOS DE ARAUJO
	 */

	
	//Definindo a classe que representar� cada elemento da pilha
	private static class PILHA{
		public int num;
		public PILHA prox;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner entrada = new Scanner(System.in);
		
		// A pilha est� vazia, logo o objeto topo tem valor null
		// As opera��es de inser��o e remo��o acontecem no topo
		
		PILHA topo 	= null;
		
		// Objeto aux � um objeto auxiliar
		PILHA aux;
		
		int op;
		
		do {
			
			System.out.println("\nMENU DE OPCOES\n");
			System.out.println("1 - Inserir na pilha");			
			System.out.println("2 - Consultar toda a pilha");
			System.out.println("3 - Remover da pilha");
			System.out.println("4 - Esvaziar a pilha");
			System.out.println("5 - sair");
			System.out.print("Digite sua op��o");
			
			op = entrada.nextInt();
			
			if(op < 1 || op > 5) System.out.println("Op��o inv�lida!");
			
			if(op == 1) {
				
				System.out.println("Digite o n�mero a ser inserido na pilha: ");
				
				PILHA novo 	= new PILHA();
				novo.num	= entrada.nextInt();
				novo.prox	= topo;
				topo		= novo;
				
				System.out.println("N�mero inserido na pilha");
								
			}
			
			if(op == 2) {
				
				if(topo == null) System.out.println("Pilha vazia!");
				else {
					
					// A pilha cont�m elementos e estes ser�o exibidos indo do �ltimo ao primeiro elemento
					
					aux = topo;
					while(aux != null) {
						
						System.out.println(aux.num + " ");
						aux = aux.prox;
						
					}					
					
				}
				
			}
			
			if(op == 3) {
				
				if(topo == null) System.out.println("Pilha vazia!");
				else {
					
					// A pilha cont�m elementos e o �ltimo elemento inserido sera removido
					System.out.println("N�mero " + topo.num + " removido!");
					topo  = topo.prox;	 
					
				}
				
			}
			
			if(op == 4) {
				
				if(topo == null) System.out.println("Pilha vazia!");
				else {
					
					// A pilha ser� esvaziada
					topo  = null;
					System.out.println("Pilha esvaziada");
				}
			}			
			
		}while(op != 5);		

	}

}

package fila;


/*
 * CÓDIGO FONTE EXTRAÍDO DO LIVRO: ESTRUTURA DE DADOS. ALGORITMOS, ANÁLISE DA COMPLEXIDADE E IMPLEMENTAÇÕES EM JAVA E C/C++
 * ANA FERNANDA GOMES ASCENCIO E GRAZIELA SANTOS DE ARAUJO
 */


import java.util.Scanner;

public class Fila {
	
	
	//Definindo a classe que representar� cada elemento da pilha
	private static class FILA{
		public int num;
		public FILA prox;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner entrada = new Scanner(System.in);
		
		// A fila esta vazia, logo o objeto inicio tera o valor null
		// A opera��o de remo��o acontece no INICIO
		// A opera��o de inser��o acontece no FIM
		
		FILA inicio  = null;
		FILA fim	 = null;
				
		// Objeto aux � um objeto auxiliar
		FILA aux;
		
		int op;
		
		do {
			
			System.out.println("\nMENU DE OPCOES\n");
			System.out.println("1 - Inserir na fila");			
			System.out.println("2 - Consultar toda a fila");
			System.out.println("3 - Remover da fila");
			System.out.println("4 - Esvaziar a fila");
			System.out.println("5 - sair");
			System.out.print("Digite sua opcaoo");
			
			op = entrada.nextInt();
			
			if(op < 1 || op > 5) System.out.println("Opcao invalida!");
			
			if(op == 1) {
				
				System.out.println("Digite o numero a ser inserido na fila: ");
				
				FILA novo 	= new FILA();
				novo.num	= entrada.nextInt();
				novo.prox	= null;
				
				if(inicio == null) {
					
					//Fila vazia e o numero inserido sera o primeiro e o ultimo
					inicio	= novo;
					fim		= novo;
					
				} else {
					
					fim.prox 	= novo;
					fim			= novo;
					
				}				
				
				System.out.println("Numero inserido na fila");
								
			}
			
			if(op == 2) {
				
				if(inicio == null) System.out.println("Fila vazia!");
				else {
					
					// A fila cont�m elementos e estes ser�o exibidos do primeiro ao ultimo
					
					aux = inicio;
					while(aux != null) {
						
						System.out.println(aux.num + " ");
						aux = aux.prox;
						
					}					
					
				}
				
			}
			
			if(op == 3) {
				
				if(inicio == null) System.out.println("Filha vazia!");
				else {
					
					// A fila contem elementos e o primeiro que foi inserido sera removido
					System.out.println("Numero " + inicio.num + " removido!");
					inicio  = inicio.prox;	 
					
				}
				
			}
			
			if(op == 4) {
				
				if(inicio == null) System.out.println("Fila vazia!");
				else {
					
					
					inicio  = null;
					System.out.println("Pilha esvaziada");
				}
			}			
			
		}while(op != 5);		

	}

}

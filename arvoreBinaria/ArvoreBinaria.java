package arvoreBinaria;

import java.util.Scanner;

/*
 * CÓDIGO FONTE EXTRAÍDO DO LIVRO: ESTRUTURA DE DADOS. ALGORITMOS, ANÁLISE DA COMPLEXIDADE E IMPLEMENTAÇÕES EM JAVA E C/C++
 * ANA FERNANDA GOMES ASCENCIO E GRAZIELA SANTOS DE ARAUJO
 */


public class ArvoreBinaria {

	
	// Definindo a classe que representará cada elemento da arvore binaria
	
	private static class ARVORE{
		
		public int num;
		public ARVORE esq, dir;
		
	}
	
	// Definindo a classe que representará cada elemento da arvore na pilha
	
	private static class PILHA{
		
		public ARVORE num;
		public PILHA prox;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		
		// A arvore esta vazia, logo, o objeto raiz tem o valor null
		ARVORE raiz  = null;
		
		// O objeto aux é um objeto auxiliar
		ARVORE aux;
		
		// O objeto aux1 é um objeto auxiliar
		ARVORE aux1;
		
		//O objeto novo é um objeto auxiliar
		ARVORE novo;
		
		// O objeto anterior é um objeto auxiliar
		ARVORE anterior;
		
		// O objeto topo representa o topo da pilha
		PILHA  topo;
		
		// O objeto aux_pilha é um objeto auxiliar da pilha
		PILHA aux_pilha;
		
		int op, achou, numero;
		
		do {
			
			System.out.println("\nMENU DE OPCOES\n");
			System.out.println("1 - Inserir na arvore");
			System.out.println("2 - Consultar o no da arvore");
			System.out.println("3 - Consultar toda a arvore - ordem");
			System.out.println("4 - Consultar toda a arvore - pre-ordem");
			System.out.println("5 - Consultar toda a arvore - pos-ordem");
			System.out.println("6 - excluir um no da arvore");
			System.out.println("7 - Esvaziar a lista");
			System.out.println("8 - sair");
			System.out.print("Digite sua opção");

			op = entrada.nextInt();
			
			if(op < 1 || op > 8) System.out.println("Opção inválida");
			
			if (op == 1) {
				
				System.out.print("Digite o numero a ser inserido na arvore: ");
				
				novo 	 = new ARVORE();
				novo.num = entrada.nextInt();
				novo.dir = null;
				novo.esq = null;
				
				if(raiz == null) 
					raiz = novo;
				else {
					
					aux		= raiz;
					achou	= 0;
					
					while(achou == 0) {
						
						if(novo.num < aux.num) {
							
							if(aux.esq == null) {
								
								aux.esq	= novo;
								achou	= 1;
								
							}else
								aux	= aux.esq;
							
						}else if(novo.num >= aux.num) {
							
							if(aux.dir == null) {
								
								aux.dir	= novo;
								achou	= 1;
								
							}else
								aux		= aux.dir;
							
						}						
						
					}
					
				}
				System.out.println("Numero inserido na arvore");				
			}
			
			if (op == 2) {
				
				if(raiz == null) System.out.println("Arvore vazia");
				else {
					
					System.out.println("Digite o elemento a ser consultado");
					
					numero 		= entrada.nextInt();
					achou		= 0;
					aux			= raiz;
					
					while(aux != null && achou == 0) {
						
						if(aux.num == numero) {
							
							System.out.println("Numero encontrado na arvore");
							achou 		= 1;
							
						}
						else if (numero < aux.num)							
							aux		= aux.esq;
						else
						    aux 	= aux.dir;							
					}
					
					if(achou == 0)
						System.out.println("Numero nao encontrado na arvore");					
					
				}				
				
			}
			
			if(op == 3) {
				
				if(raiz == null) System.out.println("Arvore vazia");
				else {
					
					// A arvore contém elementos e estes serao mostrados em ordem
					System.out.println("Listando todos os elementos em ordem");
					
					aux		= raiz;
					
					// A pilha, uma estrutura auxiliar, está vazia
					topo	= null;
					
					do {
						
						// Caminha na arvore pelo ramo da esquerda ate o null colocando cada elemento visitado em uma PILHA
						while(aux != null) {
							
							aux_pilha		= new PILHA();
							aux_pilha.num	= aux;
							aux_pilha.prox	= topo;
							topo			= aux_pilha;
							aux				= aux.esq;							
							
						}
						
						if(topo != null) {
							
							aux_pilha		= topo;
							System.out.println(aux_pilha.num.num + " ");
							aux				= topo.num.dir;
							topo			= topo.prox;
							
						}						
						
					}while(topo != null || aux != null);
					
				}				
				
			}
			
			if (op == 4) {
				
				if(raiz == null) System.out.println("Arvore vazia");
				else {
					
					// A arvore contém elementos e estes serao mostrados em pre-ordem
					System.out.println("Listando todos os elementos em pré-ordem");
					
					aux		= raiz;
					
					// A pilha, uma estrutura auxiliar, está vazia
					topo	= null;
					
					do {
						
						// Caminha na arvore pelo ramo da esquerda ate o null colocando cada elemento visitado em uma PILHA
						while(aux != null) {
							
							aux_pilha		= new PILHA();
							System.out.println(aux.num +" ");
							aux_pilha.num	= aux;
							aux_pilha.prox	= topo;
							topo			= aux_pilha;
							aux				= aux.esq;							
							
						}
						
						if(topo != null) {
							
							aux_pilha		= topo;	
							topo			= topo.prox;
							aux				= aux_pilha.num.dir;							
							
						}		
						
					}while(topo != null || aux != null);					
					
				}				
				
			}
			
			if(op == 5) {

				if(raiz == null) System.out.println("Arvore vazia");
				else {

					// A arvore contém elementos e estes serao mostrados em pos-ordem
					System.out.println("Listando todos os elementos em pos-ordem");

					aux		= raiz;

					// A pilha, uma estrutura auxiliar, está vazia
					topo	= null;

					do {

						// Caminha na arvore pelo ramo da esquerda ate o null colocando cada elemento visitado em uma PILHA
						// antes de colocar a raiz de cada sub-arvore na pilha caminha tambem no ramo da direita
						do {

							while(aux != null) {

								aux_pilha		= new PILHA();							
								aux_pilha.num	= aux;
								aux_pilha.prox	= topo;
								topo			= aux_pilha;
								aux				= aux.esq;							

							}

							if(topo.num.dir != null) {

								aux				= topo.num.dir;							

							}		

						}while(aux != null);

						if(topo != null) {

							System.out.println(topo.num.num+" ");

							if(topo.prox != null) {

								// Existe mais de um elemento empilhado
								if (topo.prox.num.dir != null && topo.prox.num.dir != topo.num) {

									aux		= topo.prox.num.dir;
									topo	= topo.prox;

								}else {

									while(topo.prox != null && topo.prox.num.dir == topo.num) {

										topo	= topo.prox;
										System.out.println(topo.num.num +" ");

									}

									topo	= topo.prox;
									if(topo != null)
										aux	= topo.num.dir;
									else
										aux	= null;

								}

							}else {

								topo	= topo.prox;
								aux		= null;

							}

						}

					}while(topo != null || aux != null);

				}
				
			}
			
			if(op == 6) {
				
				if(raiz == null) System.out.println("Arvore vazia");
				else {
					
					System.out.println("Digite o numero que deseja excluir");
					
					numero		= entrada.nextInt();
					aux			= raiz;
					achou		= 0;
					
					while(achou == 0 && aux != null) { // PRIMEIRO WHILE
						
						if(aux.num == numero)
							achou 	= 1;
						else if(aux.num > numero)
							// O numero esta a esquerda da arvore
							aux		= aux.esq;
						else
							// O numero esta a direita da arvore
							aux		= aux.dir;							
				}
					
					if(achou == 0) System.out.println("Numero não encontrado!");
					else {
						
						if (aux != raiz) {
							
							// O numero foi encontrado, sera excluido e não é a raiz
							// é necessario encontrar o anterior para acertar os ponteiros
							// anterior = elemento que aponta para o numero a ser excluido
							
							anterior	= raiz;
							while(anterior.dir != aux && anterior.esq != aux) { // SEGUNDO WHILE
								
								if(anterior.num > numero)
									// O numero esta a esquerda da arvore
									anterior	= anterior.esq;
								else
									// O numero esta a direita da arvore
									anterior	= anterior.dir;								
							}
							
							if(aux.dir == null && aux.esq == null) {
								
								//O numero folha sera excluido
								if(anterior.dir == aux)
									anterior.dir	= null;
								else
									anterior.esq	= null;								
							} else {
								
								// Um numero nao folha sera excluido
								if(aux.dir != null && aux.esq == null) {
									
									//Um numero que possui filhos apenas para a direita
									if(anterior.esq == aux)
										anterior.esq 	= aux.dir;
									else
										anterior.dir	= aux.dir;
									
								}else if(aux.esq != null && aux.dir == null) {
									
									// Im numero que possui filhos apenas para a esquerda
									if(anterior.esq == aux)
										anterior.esq 	= aux.esq;
									else
										anterior.dir 	= aux.esq;
									
								} else if(aux.esq != null && aux.dir != null) {
									
									//Um numero que possui filhos para a esquerda e para a direita
									if(anterior.dir == aux) {
										
										anterior.dir	= aux.dir;
										aux1			= aux.esq;
										
									}else {
										
										anterior.esq	= aux.esq;
										aux1			= aux.dir;
										
									}
									
									// Recolocando o pedaco da arvore
									aux		= anterior;
									while(aux != null) {
										
										if(aux.num < aux1.num) {
											
											if(aux.dir == null) {
												
												aux.dir	= aux1;
												aux		= null;
												
											}else
												aux		= aux.dir;											
										}else if(aux.num > aux1.num) {
											
											if(aux.esq == null) {
												
												aux.esq = aux1;
												aux		= null;
												
											}else
												aux		= aux.esq;						
										
									}
									
								}								
								
							}
							
						}
						
					} else {
						
						// O numero a ser excluido é a raiz
						if(aux.dir == null && aux.esq == null)
							// A raiz nao tem filhos e sera excluida
							raiz	= null;
						else {
							
							if(aux.dir != null && aux.esq == null)
								//A raiz sera excluida e possu filhos apenas na direita
								raiz	= aux.dir;
							else if(aux.esq != null && aux.dir == null)
								// A raiz será excluida e possuir filhos apenas para a esquerda
								raiz	= aux.esq;
							else if(aux.esq != null && aux.dir != null) {
								
								// A raiz sera excluida e possuir filhos para esquerda e direita
								raiz	= aux.dir;
								aux1	= aux.esq;
								
								// Recolocando o pedaço da arvore
								aux		= raiz;
								while(aux != null) {	
									
									if(aux.num < aux1.num) {
										
										if(aux.dir == null) {
											
											aux.dir		= aux1;
											aux			= null;
										}else
											aux			= aux.dir;
										
									}else if(aux.num > aux1.num) {
										
										aux.esq		= aux1;
										aux			= null;
									}else
										aux			= aux.esq;
									
								}
								
							}								
							
						}
						
					}
					System.out.println("Numero excluida da arvore");	
				}				
				
			}
			
		}			
			
	 } while(op != 8);				

	}

}












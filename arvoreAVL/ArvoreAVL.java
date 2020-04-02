package arvoreAVL;

import java.util.Scanner;

/*
 * CODIGO FONTE EXTRAIDO DO LIVRO: ESTRUTURA DE DADOS. ALGORITMOS, ANALISE DA COMPLEXIDADE E IMPLEMENTACOES EM JAVA E C/C++
 * ANA FERNANDA GOMES ASCENCIO E GRAZIELA SANTOS DE ARAUJO
 */

public class ArvoreAVL {

	private static class ARVORE{
		public int num;
		public int altd; //altura sad
		public int alte; //altura sae
		public ARVORE dir, esq;
	}


	public static void main(String args[]){

		Scanner entrada = new Scanner(System.in);

		ARVORE raiz = null;

		ARVORE aux;

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
			System.out.print("Digite sua opcao");


			op = entrada.nextInt();

			if(op < 1 || op > 8) System.out.println("Opcao invalida");

			if(op == 1)
			{
				System.out.println("Digite o numero a ser inserido na arvore: ");

				numero = entrada.nextInt();
				raiz = inserir(raiz, numero);

				System.out.println("Numero inserido na arvore!");				
			}

			if(op == 2){

				if(raiz == null)System.out.println("Arvore vazia ");
				else{

					System.out.println("Digite o numero do elemento a ser consultado: ");
					numero = entrada.nextInt();

					achou = 0;
					achou = consultar(raiz,numero,achou);

					if(achou == 0)System.out.println("Numero nao encontrado na arvore");
					else System.out.println("Numero encontrado na arvore");				

				}

			}

			if(op == 3) {

				if(raiz == null)System.out.println("Arvore vazia ");
				else{

					System.out.println("Listando todos os elementos da arvore EM ORDEM");
					mostraremordem(raiz);				
				}

			}

			if(op == 4){

				if(raiz == null)System.out.println("Arvore vazia ");
				else{

					System.out.println("Listando todos os elementos da arvore PRE-ORDEM");
					mostrarpreordem(raiz);				
				}				

			}

			if(op == 5){

				if(raiz == null)System.out.println("Arvore vazia ");
				else{

					System.out.println("Listando todos os elementos da arvore POS-ORDEM");

					aux = raiz;

					mostrarposordem(aux);				
				}				

			}

			if(op == 6){

				if(raiz == null)System.out.println("Arvore vazia ");
				else{

					System.out.println("Digite o numero que deseja excluir: ");

					numero = entrada.nextInt();

					achou = 0;
					achou = consultar(raiz, numero, achou);

					if(achou == 0)System.out.println("Numero nao encontrado");
					else{

						raiz = remover(raiz, numero);
						raiz = atualiza(raiz);

						System.out.println("Numero excluido da arvore!");

					}			

				}			

			}

			if(op == 7){

				if(raiz == null)System.out.println("Arvore vazia ");
				else{

					raiz = null;
					System.out.println("Arvore esvaziada");
				}			

			}

		}while(op != 8);

	}

	public static ARVORE inserir(ARVORE aux, int num){

		ARVORE novo;

		if(aux == null){

			novo = new ARVORE();
			novo.num = num;
			novo.altd = 0;
			novo.alte = 0;
			novo.esq = null;
			novo.dir = null;
			aux = novo;

		}else if(num < aux.num){

			aux.esq = inserir(aux.esq, num);

			if(aux.esq.altd > aux.esq.alte)
				aux.alte = aux.esq.altd + 1;
			else
				aux.alte = aux.esq.alte + 1;
			aux = balanceamento(aux);			

		}else{

			aux.dir = inserir(aux.dir, num);

			if(aux.dir.altd > aux.dir.alte)
				aux.altd = aux.dir.altd + 1;
			else
				aux.altd = aux.dir.alte + 1;
			aux = balanceamento(aux);				

		}

		return aux;		

	}

	public static ARVORE balanceamento(ARVORE aux){

		int d, df;

		d = aux.altd - aux.alte; // FB(n)

		if(d == 2){

			df = aux.dir.altd - aux.dir.alte;

			if(df >= 0)
				aux = rotacao_esquerda(aux);
			else{
				aux.dir = rotacao_direita(aux.dir);
				aux = rotacao_esquerda(aux);
			}			

		}else if(d == -2){

			df = aux.esq.altd - aux.esq.alte;

			if(df <= 0)
				aux = rotacao_direita(aux);
			else{
				aux.esq = rotacao_esquerda(aux.esq);
				aux = rotacao_direita(aux);
			}			

		}
		return aux;		

	}

	public static ARVORE rotacao_esquerda(ARVORE aux){

		ARVORE aux1, aux2;

		aux1 = aux.dir;
		aux2 = aux1.esq;

		aux.dir = aux2;
		aux1.esq = aux;

		if(aux.dir == null)
			aux.altd = 0;
		else if(aux.dir.alte > aux.dir.altd)
			aux.altd = aux.dir.alte + 1;
		else
			aux.altd = aux.dir.altd + 1;

		if(aux1.esq.alte > aux1.esq.altd)
			aux1.alte = aux1.esq.alte + 1;
		else
			aux1.alte = aux1.esq.altd + 1;	

		return aux1;
	}

	public static ARVORE rotacao_direita(ARVORE aux){

		ARVORE aux1, aux2;

		aux1 = aux.esq;
		aux2 = aux1.dir;

		aux.esq = aux2;
		aux1.dir = aux;

		if(aux.esq == null)
			aux.alte = 0;
		else if(aux.esq.alte > aux.esq.altd)
			aux.alte = aux.esq.alte + 1;
		else
			aux.alte = aux.esq.altd + 1;

		if(aux1.dir.alte > aux1.dir.altd)
			aux1.altd = aux1.dir.alte + 1;
		else
			aux1.altd = aux1.dir.altd + 1;	

		return aux1;
	}

	public static int consultar(ARVORE aux, int num, int achou){

		if(aux != null && achou == 0){
			if(aux.num == num)
				achou = 1;
			else if(num < aux.num)
				achou = consultar(aux.esq, num, achou);
			else
				achou = consultar(aux.dir, num, achou);			
		}

		return achou;
	}

	public static void mostraremordem(ARVORE aux){

		if(aux != null){
			mostraremordem(aux.esq);
			System.out.print(aux.num + " ");
			mostraremordem(aux.dir);
		}

	}

	public static void mostrarpreordem(ARVORE aux){

		if(aux != null){
			System.out.print(aux.num + " ");
			mostrarpreordem(aux.esq);			
			mostrarpreordem(aux.dir);
		}

	}

	public static void mostrarposordem(ARVORE aux){

		if(aux != null){			
			mostrarposordem(aux.esq);			
			mostrarposordem(aux.dir);
			System.out.print(aux.num + " ");
		}

	}

	public static ARVORE remover(ARVORE aux, int num){

		ARVORE p,p2;

		if(aux.num == num){

			if(aux.esq == aux.dir) // elemento a ser removido nao tem filho
				return null;
			else if(aux.esq == null) //elemento a ser removido nao tem filho a esquerda
				return aux.dir;
			else if(aux.dir == null) //elemento a ser removido nao tem filho para a direita
				return aux.esq;
			else{ //elemento a ser removido tem filhos para ambos os lados

				p2 = aux.dir;
				p = aux.dir;

				while(p.esq != null)
					p = p.esq;

				p.esq = aux.esq;
				return p2;				
			}			

		}else if(aux.num < num)
			aux.dir = remover(aux.dir, num);
		else
			aux.esq = remover(aux.esq, num);

		return aux;		

	}

	public static ARVORE atualiza(ARVORE aux){

		if(aux != null){

			aux.esq = atualiza(aux.esq);

			if(aux.esq == null)
				aux.alte = 0;
			else if(aux.esq.alte > aux.esq.altd)
				aux.alte = aux.esq.alte + 1;
			else
				aux.alte = aux.esq.altd + 1;

			aux.dir = atualiza(aux.dir);

			if(aux.dir == null)
				aux.altd = 0;
			else if(aux.dir.alte > aux.dir.altd)
				aux.altd = aux.dir.alte + 1;
			else
				aux.altd = aux.dir.altd + 1;

			aux = balanceamento(aux);			
		}		
		return aux;
	}


}










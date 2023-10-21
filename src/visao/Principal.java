package visao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import dominio.Musica;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner ler = new Scanner(System.in);
		Random gerador = new Random();

		int op, i, cont, cont2;
		String aux;
		
		ArrayList<Musica> playlist = new ArrayList<Musica>();
		Musica m;
		
		do {
			System.out.println("\n----------------------------------------------------");
			System.out.println("\t\t\tPLAYLIST");
			System.out.println("----------------------------------------------------");
			System.out.println("1 – Adicionar uma música");
			System.out.println("2 – Excluir uma música");
			System.out.println("3 – Tocar uma música específica (pelo título)");
			System.out.println("4 – Tocar as músicas de um cantor");
			System.out.println("3 – Tocar uma música específica (pelo título)");
			System.out.println("5 – Tocar as músicas em sequência");
			System.out.println("6 – Tocar as músicas embaralhadas (random)");
			System.out.println("7 – Ver as músicas da playlist");
			System.out.println("8 - Sair");
			System.out.println("----------------------------------------------------");
			System.out.println("Qual a opção desejada? ");
			op = ler.nextInt();
			ler.nextLine();
			switch(op) {
				case 1: System.out.println("Adicionando uma música na playlist");
					System.out.println("Digite o titulo, cantor e duração da música: ");
					m = new Musica();
					m.setTitulo(ler.nextLine());
					m.setCantor(ler.nextLine());
					m.setDuracao(ler.nextInt());
					System.out.println("Dados da musica: "+m.estado());
					playlist.add(m);
					break;
				case 2: System.out.println("Excluindo uma música");
					System.out.println("Qual o título da música que deseja excluir? ");
					aux = ler.nextLine();
					for(i=0; i<playlist.size(); i++) {
						if(aux.equals(playlist.get(i).getTitulo())) {
							playlist.remove(i);
						}
					}
					break;
				case 3: System.out.println("Tocando música por título");
					System.out.println("Qual o título da música que deseja tocar? ");
					aux = ler.nextLine();
					for(i=0; i<playlist.size(); i++) {
						if(aux.equals(playlist.get(i).getTitulo())) {
							//tocando a música...
							for(cont=0;cont<playlist.get(i).getDuracao(); cont++)
							{
								try{
									Thread.sleep(1000); // pausa de 1 segundo
								}catch(InterruptedException e){
									System.out.println("Erro na execução da música: "+e.getMessage());
								}
								System.out.print("|");
							}
						}
					}
					break;
				case 4: System.out.println("Tocando músicas por cantor");
					System.out.println("Qual o cantor que deseja tocar? ");
					aux = ler.nextLine();
					for(i=0; i<playlist.size(); i++) {
						if(aux.equals(playlist.get(i).getCantor())) {
							//tocando a música do cantor...
							System.out.println("\nTocando a música: "+playlist.get(i).getTitulo());
							for(cont=0;cont<playlist.get(i).getDuracao(); cont++)
							{
								try{
									Thread.sleep(1000); // pausa de 1 segundo
								}catch(InterruptedException e){
									System.out.println("Erro na execução da música: "+e.getMessage());
								}
								System.out.print("|");
							}
						}
					}
					break;
				case 5: System.out.println("Tocando músicas em sequência");
					for(i=0; i<playlist.size(); i++) {
						System.out.println("\nTocando a música: "+playlist.get(i).getTitulo());
						for(cont=0;cont<playlist.get(i).getDuracao(); cont++)
						{
							try{
								Thread.sleep(1000); // pausa de 1 segundo
							}catch(InterruptedException e){
								System.out.println("Erro na execução da música: "+e.getMessage());
							}
							System.out.print("|");
						}
					}
					break;
				case 6: System.out.println("Tocando músicas embaralhadas");
					//sorteando o número da música
					for(i=0; i<playlist.size(); i++) {
						cont2 = gerador.nextInt(playlist.size()-1);	
						System.out.println("cont2 = "+cont2);
						System.out.println("\nTocando a música: "+playlist.get(cont2).getTitulo());
						for(cont=0;cont<playlist.get(cont2).getDuracao(); cont++)
						{
							try{
								Thread.sleep(1000); // pausa de 1 segundo
							}catch(InterruptedException e){
								System.out.println("Erro na execução da música: "+e.getMessage());
							}
							System.out.print("|");
						}
					}
					break;
				case 7: System.out.println("Lista de músicas da playlist");
					for(i=0; i<playlist.size(); i++) {
						System.out.println("Título: "+playlist.get(i).getTitulo());
						System.out.println("Cantor: "+playlist.get(i).getCantor());
						System.out.println("Duração: "+playlist.get(i).getDuracao());
						System.out.println("\n----------------------------------------------------");
					}
					break;
				case 8: System.out.println("Fim de programa");
					break;
				default: System.out.println("Opção inválida");
			}
			
		}while(op!=8);
		
	}

}

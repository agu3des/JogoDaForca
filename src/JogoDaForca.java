package projetoPOO1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {
	private int indiceOcorrencia;
	private int tentativa;
	private String palavraSorteada;
	private String dicaSorteada;
	private int penalidadeNumero;
	private int acertos;
	private int erros;
	private ArrayList<Integer> ocorrencias = new ArrayList<>();
	private ArrayList<String> letrasAdivinhadas = new ArrayList<>();
	private ArrayList<String> listaDeLetras = new ArrayList<>();
	private ArrayList<String> listaDePalavras = new ArrayList<>(); // um array com as palavras (lidas do arquivo)
	private ArrayList<String> listaDeDicas = new ArrayList<>(); // um array com as dicas (lidas do arquivo)
	
	public JogoDaForca() throws Exception {
		// abrir arquivo palavras.txt da pasta interna "/dados" para leitura
		InputStream stream = this.getClass().getResourceAsStream("/dados/palavras.txt");
		if (stream == null)
			throw new Exception("Arquivo de palavras inexistente");
		Scanner arquivo = new Scanner(stream);

		// leitura das linhas do arquivo para as respectivas listas
		String linha;
		while (arquivo.hasNext()) {
			linha = arquivo.nextLine().toUpperCase();
			//System.out.println(linha);
			this.listaDePalavras.add(linha.split(";")[0]);
			this.listaDeDicas.add(linha.split(";")[1]);
		}
		arquivo.close();
	}	
		
	public void iniciar() {
		tentativa = 0;
		//inicializa um sorteio
		Random sorteio = new Random();
		//cria um indice dentro do tamanho da lista de palavras
		int indice = sorteio.nextInt(listaDePalavras.size());
		//pega a palavra associada ao indice
		palavraSorteada = listaDePalavras.get(indice);
		//pega a dica associada ao indice
		dicaSorteada = listaDeDicas.get(indice);
	}
	
	public String getDica() {
		String dica;
		if (tentativa == 0 || terminou())
			return dicaSorteada;
		else dica = "nao ha dica";
	}
	
	public int getTamanho() {
		return palavraSorteada.length();
	}
	
	// public ArrayList<Integer> getOcorrencias(String letraDigitada) throws Exception {
	// 	if(letraDigitada.isEmpty() || letraDigitada.length() > 1 || listaDeLetras.contains(letraDigitada)) {
	// 		throw new Exception("Entrada Inválida");
	// 	}
	// 	else {
	// 		listaDeLetras.add(letraDigitada);
	// 		for(int i = 0; i < getTamanho(); i++) {
	// 			indiceOcorrencia = i;
	// 			if (palavraSorteada.contains(letraDigitada)) {
	// 				acertos++;
	// 				return ocorrencias; 
	// 			}
	// 			else {
	// 				erros++;
	// 				getNomePenalidade();
					
	// 			}
	// 		}
	// 	}
	// }

	public ArrayList<Integer> getOcorrencias(String letraDigitada) throws Exception {
		if (letraDigitada.isEmpty() || letraDigitada.length() > 1 || listaDeLetras.contains(letraDigitada.charAt(0))) {
			throw new Exception("Entrada Inválida");
		}
	
		char letra = letraDigitada.charAt(0);
		listaDeLetras.add(letra);
	
		ocorrencias.clear();
		for (int i = 0; i < palavraSorteada.length(); i++) {
			if (palavraSorteada.charAt(i) == letra) {
				ocorrencias.add(i);
				letrasAdivinhadas.set(i, letra);
				acertos++;
			}
		}
	
		if (ocorrencias.isEmpty()) {
			erros++;
		}
	
		return ocorrencias;
	}
	
	
	public boolean terminou() {
		if (acertos == getTamanho()) {
			return true;
		}
		else if (erros == 6) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// public String getPalavraAdivinhada() {
	// 	if (ocorrencias.size() == 0){
	// 		String adivinhadas = String.join("", letrasAdivinhadas);
	// 		return adivinhadas;
	// 	}
		
	// 	else if (indiceOcorrencia == letrasAdivinhadas[i]) {
	// 		String adivinhadas = String.join(" * ", letrasAdivinhadas);
	// 		return adivinhadas;
	// 	}
	// 		letrasAdivinhadas[i] = letraDigitada; //o índice de palavras adivinhadas recebe a letra digitada
	// 		letrasAdivinhadas
	// 		String adivinhadas = Arrays.toString(letrasAdivinhadas); //o array vira string
	// 		return 
	// 	} //quando o índice for igual
	// }
	
	public String getPalavraAdivinhada() {
		StringBuilder palavraAdivinhada = new StringBuilder();
		for (char letra : letrasAdivinhadas) {
			palavraAdivinhada.append(letra).append(' ');
		}
		return palavraAdivinhada.toString().trim();
	}
	

	public int getAcertos() {
		return acertos;
	}
	
	public int getNumeroPenalidade() {
		return erros;
	}
	
	public String getNomePenalidade() {
		if (erros == 0)
			return "sem penalidades";
		else if (erros == 1)
			return "perdeu primeira perna";
		else if (erros == 2)
			return "perdeu segunda perna";
		else if (erros == 3)
			return "perdeu primeiro";
		else if (erros == 4)
			return "perdeu segundo braço";
		else if (erros == 5)
			return "perdeu tronco";
		else
			return "perdeu cabeça";
	}
	
	public String getResultado() {
		if (!terminou()) {
			return "jogo em andamento";
		}
		else {
			if (acertos == getTamanho()) {
				return "voce ganhou!";
			}
			else {
				return "voce foi enforcado!";
			}
		}
	}

}

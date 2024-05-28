import java.io.InputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class JogoDaForca {
	
	private int erros;
	private int acertos;
	private int tentativas;
	private String [] palavraSorteada;
	private String dicaDaPalavraSorteada;
	private ArrayList<String> listaDePalavras = new ArrayList<>();
	private ArrayList<String> listaDasDicas = new ArrayList<>();
	private ArrayList<String> letrasAdivinhadas = new ArrayList<>();
	private ArrayList<Integer> ocorrencias = new ArrayList<>();
	private ArrayList<String> historicoDeLetras = new ArrayList<>();

	public JogoDaForca() throws Exception {
		InputStream stream = this.getClass().getResourceAsStream("/dados/palavras.txt");
		if (stream == null)
			throw new Exception("Arquivo com dados inexistente");
		Scanner arquivo = new Scanner(stream);

		String linha;
		while (arquivo.hasNext()) {
			linha = arquivo.nextLine();
			this.listaDePalavras.add(linha.split(";")[0]);
			this.listaDasDicas.add(linha.split(";")[1]);
		}
		arquivo.close();
	}

	public void iniciar() {
		tentativas = 0;
		acertos = 0;
		erros = 0;
		String palavra;
		Random random = new Random();
		int indiceSorteado = random.nextInt(listaDePalavras.size());
		palavra = listaDePalavras.get(indiceSorteado);
		palavraSorteada = palavra.split("");
		dicaDaPalavraSorteada = listaDasDicas.get(indiceSorteado);
		
	    for(int i=1; i<=palavraSorteada.length; i++)
				letrasAdivinhadas.add("*");
	}

	public String getDica() {
		String dica;
		if (tentativas == 0 || terminou())
			return dicaDaPalavraSorteada;
		else
			return dica = "nao ha dica";
	}

	public int getTamanho() {
		return palavraSorteada.length;
	}
	
	public ArrayList<Integer> getOcorrencias(String letra) throws Exception {
	    if(letra.equals("") || letra.length() > 1 || historicoDeLetras.contains(letra)) {
	        throw new Exception("Entrada invalida. Digite novamente.");
	    }
	    
	    tentativas++;
	    historicoDeLetras.add(letra);
	    ocorrencias.clear();

	    for(int i = 0; i < palavraSorteada.length; i++) {
	        if(this.palavraSorteada[i].equalsIgnoreCase(letra)) {
	            ocorrencias.add(i);
	            acertos ++;
	            letrasAdivinhadas.set(i, letra);
	        }
	    }
	    if(ocorrencias.size() > 0) {
	    	 return ocorrencias;
	    } else {
	    	erros++;
	    }
	    return ocorrencias;
	}


	public boolean terminou() {
		if (acertos == getTamanho())
			return true;
		else if(erros == 6) {
			return true;
		}
		else {
			return false;
		}
			
	}

	public String getPalavraAdivinhada() {
			return letrasAdivinhadas.toString();
	}

	public int getAcertos() {
		return acertos;
	}

	public int getNumeroPenalidade() {
		return erros;
	}

	public String getNomePenalidade() {
	    switch (erros) {
	        case 1:
	            return "perdeu a perna esquerda";
	        case 2:
	            return "perdeu a perna direita";
	        case 3:
	            return "perdeu o braço esquerdo";
	        case 4:
	            return "perdeu o braço direito";
	        case 5:
	            return "perdeu o tronco";
	        case 6:
	            return "perdeu a cabeça";
	        default:
	            return "sem penalidade";
	    }
	}


	public String getResultado() {
		if (!terminou())
			return "jogo em andamento";
		else if (acertos == getTamanho()) 
			return "voce venceu";
		else
			return "voce foi enforcado";
	}

}
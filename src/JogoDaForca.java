import java.io.InputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class JogoDaForca {
	private ArrayList <String> listaDePalavras;
	private ArrayList<String> listaDasDicas;
	private ArrayList<Integer> ocorrencias; 
	private String palavraSorteada;
	private String dicaDaPalavraSorteada;
	private int tentativas;
	private int acertos;
	
	public JogoDaForca() throws Exception {
		InputStream stream = this.getClass().getResourceAsStream("/dados/palavras.txt");
		if (stream == null)
			throw new Exception("Arquivo com dados inexistente");
		Scanner arquivo = new Scanner(stream);
		
		String linha;
		while (arquivo.hasNext()) {
			linha = arquivo.nextLine();
			this.listaDePalavras.add(linha.split(";")[0]);
			this.listaDasDicas.add(linha.split(";")[0]);
		}
	}

	public void iniciar(){
		tentativas = 0;
		Random random = new Random();
		int indiceSorteado = random.nextInt(listaDePalavras.size());
		palavraSorteada = listaDePalavras.get(indiceSorteado);
		dicaDaPalavraSorteada = listaDasDicas.get(indiceSorteado);
	}
	
	public String getDica() {
		String dica;
		if (tentativas == 0 || terminou())
			return dica = "nao ha dica"; 
		else 
			return dicaDaPalavraSorteada;
	}
	
	public int getTamanho() {
		return palavraSorteada.length();
	}
	
	/*
	public ArrayList<Integer> getOcorrencias(String letra) throws Exception{}*/
	
	public boolean terminou() {
		if( acertos == tentativas)
			return true;
		else
			return false;
	}
	
	public String getPalavraAdivinhada() {
		return palavraSorteada;
	}
	
	public int getAcertos() {
		return acertos;
	}
	
	/*
	public int getNumeroPenalidade() {}
	
	public String getNomePenalidade() {}
	
	*/
	
	public String getResultado() {
		if (!terminou())
			return "jogo em andamento";
		else
			if ( acertos == tentativas) //ver se a logica esta certa
				return "voce venceu";
			else
				return "voce foi enforcado";
	}

}
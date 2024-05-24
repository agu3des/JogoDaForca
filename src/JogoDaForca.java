import java.io.InputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class JogoDaForca {
	private ArrayList<String> listaDePalavras = new ArrayList<>();
	private ArrayList<String> listaDasDicas = new ArrayList<>();
	private ArrayList<Integer> ocorrencias = new ArrayList<>();
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
			this.listaDasDicas.add(linha.split(";")[1]);
		}
		arquivo.close();
	}

	public void iniciar() {
		tentativas = 0;
		Random random = new Random();
		int indiceSorteado = random.nextInt(listaDePalavras.size());
		palavraSorteada = listaDePalavras.get(indiceSorteado);
		dicaDaPalavraSorteada = listaDasDicas.get(indiceSorteado);
	}

	public String getDica() {
		String dica;
		if (tentativas == 0 || terminou())
			return dicaDaPalavraSorteada;
		else
			return dica = "nao ha dica";
	}

	public int getTamanho() {
		return palavraSorteada.length();
	}

	public ArrayList<Integer> getOcorrencias(String letra) throws Exception{
		if(letra == "" || letra.length() > 1) {
			throw new Exception("Entrada invalida. Digite novamente.");}
		
		tentativas++;
		for(int i=0; i<=palavraSorteada.length(); i++)
			if (palavraSorteada.contains(letra)) {
				acertos ++;
				ocorrencias.add(i);
				return ocorrencias;}
		else
			getNomePenalidade();
			return ocorrencias; 
			}

	public boolean terminou() {
		if (tentativas == 6)
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

	public int getNumeroPenalidade() {
		return tentativas;
	}

	public String getNomePenalidade() {
		if (tentativas == 1)
			return "perdeu a perna esquerda";
		if (tentativas == 2)
			return "perdeu a perna direita";
		if (tentativas == 3)
			return "perdeu o braço esquerdo";
		if (tentativas == 4)
			return "perdeu o braço direito";
		if (tentativas == 5)
			return "perdeu o tronco";
		else
				return "perdeu a cabeça";
	}

	public String getResultado() {
		if (!terminou())
			return "jogo em andamento";
		else if (acertos == tentativas) // ver se a logica esta certa
			return "voce venceu";
		else
			return "voce foi enforcado";
	}

}
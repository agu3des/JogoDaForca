import java.io.InputStream;
//import java.net.URL;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.*;


public class JogoDaForca {
    private ArrayDeque<String> pilhaDeVencedores = new ArrayDeque<>();
    private ArrayList<String> listaDePalavras = new ArrayList<>();
    private ArrayList<String> listaDasDicas = new ArrayList<>();
    private ArrayList<String> letrasAdivinhadas = new ArrayList<>();
    private ArrayList<Integer> ocorrencias = new ArrayList<>();
    private ArrayList<String> historicoDeLetras = new ArrayList<>();
    private int erros;
    private int acertos;
    private int tentativas;
    private String[] palavraSorteada;
    private String dicaDaPalavraSorteada;
    private String palavra;

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

        File file = new File("vencedores.txt");
        if (file.exists()) {
            Scanner arquivoDosVencedores = new Scanner(file);
            String linhaVencedores;
            while (arquivoDosVencedores.hasNext()) {
                linhaVencedores = arquivoDosVencedores.nextLine() + "\n";
                this.pilhaDeVencedores.push(linhaVencedores);
            }
            arquivoDosVencedores.close();
        }
    }

    public void iniciar() {
        tentativas = 0;
        acertos = 0;
        erros = 0;
        letrasAdivinhadas.clear();
        Random random = new Random();
        int indiceSorteado = random.nextInt(listaDePalavras.size());
        palavra = listaDePalavras.get(indiceSorteado);
        palavraSorteada = palavra.split("");
        dicaDaPalavraSorteada = listaDasDicas.get(indiceSorteado);

        for (int i = 0; i < palavraSorteada.length; i++)
            letrasAdivinhadas.add("*");
    }

    public String getDica() {
        if (tentativas == 0 || terminou())
            return dicaDaPalavraSorteada;
        else
            return "Nao ha dica";
    }

    public int getTamanho() {
        return palavraSorteada.length;
    }

    public ArrayList<Integer> getOcorrencias(String letra) throws Exception {
        if (letra.equals("") || letra.length() > 1 || historicoDeLetras.contains(letra)) {
            throw new Exception("Entrada invalida. Digite novamente.");
        }

        tentativas++;
        historicoDeLetras.add(letra);
        ocorrencias.clear();

        for (int i = 0; i < palavraSorteada.length; i++) {
            if (this.palavraSorteada[i].equalsIgnoreCase(letra)) {
                ocorrencias.add(i);
                acertos++;
                letrasAdivinhadas.set(i, letra);
            }
        }
        if (ocorrencias.size() > 0) {
            return ocorrencias;
        } else {
            erros++;
        }
        return ocorrencias;
    }

    public boolean terminou() {
        return acertos == getTamanho() || erros == 6;
    }

    public String getPalavraAdivinhada() {
        return String.join("", letrasAdivinhadas);
    }

    public void escritorDosVencedores() throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter("vencedores.txt", true));
        String entry = "Palavra: " + palavra + "| Acertos: " + getAcertos() + "| Erros: " + erros + "\n";
        writer.write(entry);
        writer.close();
    }

    public String getHistoricoDeVencedores() {
        return pilhaDeVencedores.toString();
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
                return "perdeu a perna direita";
            case 2:
                return "perdeu a perna esquerda";
            case 3:
                return "perdeu o braço direito";
            case 4:
                return "perdeu o braço esquerdo";
            case 5:
                return "perdeu o tronco";
            case 6:
                return "perdeu a cabeça";
            default:
                return "";
        }
    }

    public String getResultado() throws Exception {
        if (!terminou())
            return "Jogo em andamento...";
        else if (acertos == getTamanho()) {
            escritorDosVencedores();
            return "Voce venceu!";
        } else {
            escritorDosVencedores();
            return "Voce foi enforcado!";
        }
    }
}

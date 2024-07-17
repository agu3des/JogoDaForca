<h1 align="center">PROJETO JOGO DA FORCA</h1>


`"Jogo da Forca"` - Aplicação que simula um jogo da forca. 

## Requisitos
+ `Java 8`
+ `VS Code` ou `Eclipse` ou `IntelliJ` 

## Instalação
1. Instale `Java 8` na sua máquina (caso não tenha).
2. Baixe ou clone o projeto para o seu computador.
3. Abra o terminal ou prompt de comando e navegue até o diretório do projeto.
4. Inicie o programa executando o arquivo `TelaJogo`.
5. Também é possível utilizá-lo como executável.

## Uso
>  Mini projeto desenvolvido na disciplina de Programação Orientada a Objetos (2024.1), utilizando a linguagem java, ministrada pelo professor Fausto Veras, no curso de Sistemas para Internet (IFPB).


## Exigências
+ `Aplicação Gráfica: ` Tela para o jogo ser executado.
+ `Poo: ` Lógica do jogo e estruturação de arquivos. 

## Funcionamento
O jogo funciona da seguinte maneira:
+ É um jogo em que o jogador tem 6 tentativas para adivinhar as letras de uma palavra, baseando-se apenas no tamanho e numa dica da palavra.
+ O jogo começa com o sorteio de uma palavra do arquivo palavras.txt. Em seguida, o jogador faz várias tentativas de adivinhação de cada letra da palavra (de tamanho N), onde:
  1. A cada tentativa correta, o jogador recebe as posições (entre 1 e N) das ocorrências da letra dentro da palavra.
  2. A cada tentativa errada, o jogador recebe uma penalidade que identifica a parte do corpo retirada (0-“sem penalidades”, 1-“perdeu primeira perna”, 2-“perdeu segunda perna”, 3-”perdeu primeiro braço”, 4-”perdeu segundo braço”, 5-”perdeu tronco” e 6-”perdeu cabeça”), iniciando-se em 0.
+ O jogador vence, acertando todas as letras da palavra sorteada, e perde, atingindo a penalidade 6.


## Descrição do arquivo
| Nome | Descrição |
| ------ | ----------- |
| dados | Nesta pasta são encontras as informações acerca das palavras e suas respectivas dicas.|
| palavras.txt | Neste arquivo existem palavras com dicas associadas que serão utilizadas para a forca.|
| imagens | Nesta pasta estão armazenadas as imagens da forca, que são atualizadas a cada penalidade.|
| JogoDaForca | Neste arquivo existe os métodos que definem a lógica do jogo e suas aplicações.|
| Aplicação Console | Neste arquivo existe a chamada dos métodos do jogo para o funcionamento via console.|
| TelaJogo | Neste arquivo existe a chamada dos métodos do jogo para o funcionamento via janela.|



### Alunas
- [Ananda Guedes](https://github.com/agu3des)
- [Angêlica Araújo](https://github.com/araujo-angel)

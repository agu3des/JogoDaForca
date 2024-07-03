import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import POO.Window.TelaJogo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
public class TelaJogo extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextField txtDigiteUmaLetra;
	private JButton btnNewButton_1;
	private JLabel label;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	
	
	private JogoDaForca jogo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogo frame = new TelaJogo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public TelaJogo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Iniciar");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jogo = new JogoDaForca();
					jogo.iniciar();		
					btnNewButton_1.setEnabled(true);
					lblNewLabel.setText("tamanho: " + jogo.getTamanho());
					lblNewLabel_1.setText("dica: " + jogo.getDica());
					lblNewLabel_2.setText("jogo iniciado! digite uma letra");
					lblNewLabel_4.setText("acertos: 0" );
					lblNewLabel_5.setText(""+ jogo.getNumeroPenalidade() + " - " + jogo.getNomePenalidade());
					lblNewLabel_3.setText("palavra: "+jogo.getPalavraAdivinhada());
					label.setText("" + jogo.getHistoricoDeVencedores());
					atualizarImagem(jogo.getNumeroPenalidade());
				}
				
				catch (Exception erro) {
					lblNewLabel_2.setText(erro.getMessage());
				}
			}
		});
		btnNewButton.setBounds(31, 30, 85, 21);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Tamanho:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(144, 32, 118, 17);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Dica:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setBounds(275, 30, 262, 21);
		contentPane.add(lblNewLabel_1);
		
		txtDigiteUmaLetra = new JTextField();
		txtDigiteUmaLetra.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtDigiteUmaLetra.setBounds(31, 117, 67, 19);
		contentPane.add(txtDigiteUmaLetra);
		txtDigiteUmaLetra.setColumns(10);
		
		btnNewButton_1 = new JButton("Adivinhar");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String letra = txtDigiteUmaLetra.getText();
					jogo.getOcorrencias(letra);
					lblNewLabel_2.setText(""+ jogo.getResultado());
					lblNewLabel_3.setText("palavra: "+jogo.getPalavraAdivinhada());
					lblNewLabel_4.setText("acertos: " + jogo.getAcertos());
					lblNewLabel_5.setText(""+ jogo.getNumeroPenalidade() + " - " + jogo.getNomePenalidade());
					txtDigiteUmaLetra.setText("");
					
					atualizarImagem(jogo.getNumeroPenalidade());
					
					if (jogo.terminou()){
						btnNewButton_1.setEnabled(false);
					}
				} catch (Exception erro) {
					lblNewLabel_2.setText(erro.getMessage());
				}
			}
		});
		btnNewButton_1.setBounds(132, 116, 105, 21);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_2 = new JLabel("Resultado:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setBounds(278, 93, 282, 66);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Palavra: ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3.setBounds(31, 81, 262, 13);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_4.setForeground(new Color(0, 128, 64));
		lblNewLabel_4.setBounds(31, 160, 85, 21);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setBounds(144, 159, 288, 22);
		contentPane.add(lblNewLabel_5);
		
		label = new JLabel("");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBounds(31, 192, 529, 60);
		contentPane.add(label);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(442, 61, 132, 191);
		contentPane.add(lblNewLabel_6);
	}
		
		private void atualizarImagem(int numeroPenalidade) {
		    String caminhoImagem;
		    if (numeroPenalidade == 1) {
		        caminhoImagem = "/imagens/1.png";
		    } else if (numeroPenalidade == 2) {
		        caminhoImagem = "/imagens/2.png";
		    } else if (numeroPenalidade == 3) {
		        caminhoImagem = "/imagens/3.png";
		    } else if (numeroPenalidade == 4) {
		        caminhoImagem = "/imagens/4.png";
		    } else if (numeroPenalidade == 5) {
		        caminhoImagem = "/imagens/5.png";
		    } else if (numeroPenalidade == 6) {
		        caminhoImagem = "/imagens/6.png";
		    } else {
		        caminhoImagem = "/imagens/0.png";
		    }

		    
		    ImageIcon forca = new ImageIcon(TelaJogo.class.getResource(caminhoImagem));
		    forca.setImage(forca.getImage().getScaledInstance(
		            lblNewLabel_6.getWidth(),
		            lblNewLabel_6.getHeight(),
		            Image.SCALE_DEFAULT
		    ));
		    lblNewLabel_6.setIcon(forca);
		}
	}

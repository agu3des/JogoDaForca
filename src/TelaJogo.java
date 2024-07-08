
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


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
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
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
		setBounds(100, 100, 515, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);

		
		btnNewButton = new JButton("Iniciar");
		btnNewButton.setBounds(31, 31, 85, 21);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jogo = new JogoDaForca();
					jogo.iniciar();	
					btnNewButton_1.setEnabled(true);
					lblNewLabel.setText("Tamanho: " + jogo.getTamanho());
					lblNewLabel_1.setText("Dica: " + jogo.getDica());
					lblNewLabel_2.setText("Jogo iniciado! Digite uma letra:");
					lblNewLabel_4.setText("Acertos: 0" );
					lblNewLabel_5.setText("Penalidade("+ jogo.getNumeroPenalidade() + ") - " + jogo.getNomePenalidade());
					lblNewLabel_3.setText("Palavra: "+jogo.getPalavraAdivinhada());
					textArea.setText("" + jogo.getHistoricoDeVencedores() + "\n");
					
					atualizarImagem();
				}
				catch (Exception erro) {
					lblNewLabel_2.setText(erro.getMessage());
				}
			}
		});

		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Tamanho:");
		lblNewLabel.setBounds(169, 72, 85, 17);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Dica:");
		lblNewLabel_1.setBounds(249, 70, 262, 21);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1);
		
		txtDigiteUmaLetra = new JTextField();
		txtDigiteUmaLetra.setBounds(31, 115, 67, 19);
		txtDigiteUmaLetra.setFont(new Font("Times New Roman", Font.PLAIN, 12));
    
		contentPane.add(txtDigiteUmaLetra);
		txtDigiteUmaLetra.setColumns(10);
		
		btnNewButton_1 = new JButton("Adivinhar");
		btnNewButton_1.setBounds(118, 114, 105, 21);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton_1.setEnabled(false);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String letra = txtDigiteUmaLetra.getText();
					jogo.getOcorrencias(letra);
					lblNewLabel_2.setText(""+ jogo.getResultado());
					lblNewLabel_3.setText("Palavra: "+jogo.getPalavraAdivinhada());
					lblNewLabel_4.setText("Acertos: " + jogo.getAcertos());
					lblNewLabel_5.setText("Penalidade("+ jogo.getNumeroPenalidade() + ") - " + jogo.getNomePenalidade());
					txtDigiteUmaLetra.setText("");
					
					atualizarImagem();
					

					if (jogo.terminou()){
						btnNewButton_1.setEnabled(false);
					}
				} catch (Exception erro) {
					lblNewLabel_2.setText(erro.getMessage());
				}
			}
		});

		contentPane.add(btnNewButton_1);
		
		lblNewLabel_2 = new JLabel("Resultado:");
		lblNewLabel_2.setBounds(249, 114, 282, 21);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Palavra: ");
		lblNewLabel_3.setBounds(31, 74, 262, 13);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Acertos:");
		lblNewLabel_4.setBounds(249, 153, 85, 21);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_4.setForeground(new Color(0, 128, 64));
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Penalidade:");
		lblNewLabel_5.setBounds(31, 152, 288, 22);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(31, 185, 165, 191);
		contentPane.add(lblNewLabel_6);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(238, 185, 230, 162);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setBounds(240, 184, 228, 160);
		contentPane.add(textArea);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		
	}
	private void atualizarImagem() {
	    String caminhoImagem = "imagens/" + jogo.getNumeroPenalidade() +".png";
	    ImageIcon forca = new ImageIcon(getClass().getResource(caminhoImagem));
	    lblNewLabel_6.setIcon(forca);
	}
}

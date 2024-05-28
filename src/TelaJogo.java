import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class TelaJogo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtDigiteUmaLetra;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextArea textArea;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Iniciar");
		btnNewButton.setBounds(31, 44, 85, 21);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Tamanho");
		lblNewLabel.setBounds(175, 48, 45, 13);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Dica");
		lblNewLabel_1.setBounds(255, 48, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		txtDigiteUmaLetra = new JTextField();
		txtDigiteUmaLetra.setBounds(31, 185, 67, 19);
		contentPane.add(txtDigiteUmaLetra);
		txtDigiteUmaLetra.setColumns(10);
		
		btnNewButton_1 = new JButton("Adivinhar");
		btnNewButton_1.setBounds(118, 184, 85, 21);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_2 = new JLabel("Resultado");
		lblNewLabel_2.setBounds(255, 188, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New labelNew labelNew labelNew labelNew labelNew labelNew labelNew labelNew labelNew labelNew labelNew labelNew labelNew labelNew labelNew labelNew labelNew label");
		lblNewLabel_3.setBounds(31, 136, 269, 13);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Acertos");
		lblNewLabel_4.setBounds(44, 240, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("x - Penalidade");
		lblNewLabel_5.setBounds(129, 240, 67, 13);
		contentPane.add(lblNewLabel_5);
		
		textArea = new JTextArea();
		textArea.setBounds(322, 42, 85, 52);
		contentPane.add(textArea);
	}
}
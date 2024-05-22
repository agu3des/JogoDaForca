package ProjetoPoo.src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class AplicacaoGrafica {

	private JFrame frame;
	private JTextField textField;
	private JButton button;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JButton button_1;
	private JLabel label_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacaoGrafica window = new AplicacaoGrafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AplicacaoGrafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(78, 145, 53, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		button = new JButton("Iniciar");
		button.setBounds(10, 34, 89, 23);
		frame.getContentPane().add(button);
		
		label = new JLabel("Letra:");
		label.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label.setBounds(10, 148, 46, 14);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("Dica:");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_1.setBounds(10, 112, 46, 14);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("Palavra =");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_2.setBounds(10, 197, 61, 14);
		frame.getContentPane().add(label_2);
		
		button_1 = new JButton("Adivinhar");
		button_1.setBounds(156, 144, 89, 23);
		frame.getContentPane().add(button_1);
		
		label_3 = new JLabel("Imagem:");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_3.setBounds(266, 148, 53, 14);
		frame.getContentPane().add(label_3);
	}
}

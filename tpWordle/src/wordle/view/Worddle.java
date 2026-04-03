package wordle.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import wordle.model.WordleLogica;
import wordle.presenter.WordlePresenter;

import javax.swing.JTextField;


public class Worddle implements IWordleView {

	private WordlePresenter presenter;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Worddle window = new Worddle();
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
	public Worddle() {
		initialize();
		
		this.presenter = new WordlePresenter(this, new WordleLogica());
	}

	@Override
	public String obtenerPalabra() {
		return textField.getText() + textField_1.getText() + textField_2.getText() +textField_3.getText() +textField_4.getText();
	}

	@Override
	public void setColorFondo(int indice, Color color) {
		JTextField [] cuadros= {textField, textField_1, textField_2, textField_3, textField_4};
		if(indice >=0 && indice <5) {
			cuadros[indice].setBackground(color);
			cuadros[indice].setOpaque(true);
		}
		
	}

	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("wordle!!!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(176, 32, 67, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(10, 73, 45, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(65, 73, 45, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(120, 73, 45, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(176, 73, 45, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setBounds(231, 73, 45, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_4.addKeyListener(new java.awt.event.KeyAdapter() {
		    @Override
		    public void keyReleased(java.awt.event.KeyEvent e) {
		        if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
		            presenter.validar(); 
		        }
		    }
		});
		
		
		
		
	}
}

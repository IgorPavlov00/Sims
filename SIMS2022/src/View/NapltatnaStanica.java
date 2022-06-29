package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class NapltatnaStanica extends JFrame {

	private JPanel contentPane;
	private JTextField nazivTxtField;
	private JTextField mestoTxtField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NapltatnaStanica frame = new NapltatnaStanica();
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
	public NapltatnaStanica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton dodajBtn = new JButton("Dodaj");
		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dodajBtn.setBounds(240, 232, 85, 21);
		contentPane.add(dodajBtn);
		
		JButton izmeniBtn = new JButton("Izmeni");
		izmeniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		izmeniBtn.setBounds(357, 232, 85, 21);
		contentPane.add(izmeniBtn);
		
		JButton obrisiBtn = new JButton("Obrisi");
		obrisiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		obrisiBtn.setBounds(479, 232, 85, 21);
		contentPane.add(obrisiBtn);
		
		nazivTxtField = new JTextField();
		nazivTxtField.setBounds(91, 10, 96, 19);
		contentPane.add(nazivTxtField);
		nazivTxtField.setColumns(10);
		
		JLabel nazivLbl = new JLabel("Naziv");
		nazivLbl.setBounds(10, 13, 24, 13);
		contentPane.add(nazivLbl);
		
		mestoTxtField = new JTextField();
		mestoTxtField.setBounds(91, 52, 96, 19);
		contentPane.add(mestoTxtField);
		mestoTxtField.setColumns(10);
		
		JLabel mestoLbl = new JLabel("Mesto");
		mestoLbl.setBounds(10, 55, 45, 13);
		contentPane.add(mestoLbl);
		
		JLabel napMestoLbl = new JLabel("Napltano mesto");
		napMestoLbl.setBounds(10, 96, 71, 13);
		contentPane.add(napMestoLbl);
		
		JComboBox napMestoComboBox = new JComboBox();
		napMestoComboBox.setBounds(91, 92, 96, 21);
		contentPane.add(napMestoComboBox);
		
		JComboBox sefComboBox = new JComboBox();
		sefComboBox.setBounds(91, 132, 96, 21);
		contentPane.add(sefComboBox);
		
		JLabel sefLbl = new JLabel("Sef");
		sefLbl.setBounds(10, 136, 45, 13);
		contentPane.add(sefLbl);
		
		table = new JTable();
		table.setBounds(240, 10, 324, 212);
		contentPane.add(table);
		
		JButton nazadBtn = new JButton("Nazad");
		nazadBtn.setBounds(10, 232, 85, 21);
		contentPane.add(nazadBtn);
	}
}

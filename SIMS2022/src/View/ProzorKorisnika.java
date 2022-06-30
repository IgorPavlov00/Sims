package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.Korisnik;
import Model.NaplatnaStanica;
import Model.NaplatnoMesto;
import Model.SefStanice;
import SistemZaNaplatu.Ucitavanje;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProzorKorisnika extends JFrame {

	private JPanel contentPane;
	private JTextField imeTxtField;
	private JTextField prezimeTxtField;
	private JComboBox tipKorisnikaComboBox ;
	public JTable table;
	public DefaultTableModel model=new DefaultTableModel();
	Ucitavanje u;
	private JTextField korImeTxtField;
	private JTextField sifraTxtField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProzorKorisnika frame = new ProzorKorisnika();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public ProzorKorisnika() throws IOException {
		u=new Ucitavanje();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton dodajBtn = new JButton("Dodaj");
		ArrayList<Korisnik>li=u.getListaKorisnika();
		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ime=imeTxtField.getText();
				String prezime=prezimeTxtField.getText();
				String korIme=korImeTxtField.getText();
				String sifra=sifraTxtField.getText();
				String tipKorisnika= tipKorisnikaComboBox.getSelectedItem().toString();
			    
				//Staviti klase za tip korisnika
			    model.addRow(new Object []{ime,prezime,korIme,sifra, tipKorisnika});
			}
		});
		
		dodajBtn.setBounds(240, 232, 85, 21);
		contentPane.add(dodajBtn);
		
		JButton izmeniBtn = new JButton("Izmeni");
		izmeniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
			   String red=table.getValueAt(i, 0).toString();
			 
		         model.setValueAt(imeTxtField.getText(), i, 0);
		         model.setValueAt(prezimeTxtField.getText(), i, 1);
		         model.setValueAt(korImeTxtField.getText(), i, 2);
		         model.setValueAt(sifraTxtField.getText(), i, 3);
		         model.setValueAt(tipKorisnikaComboBox.getSelectedItem().toString(), i, 4);
					
				}
			
			
		});
		izmeniBtn.setBounds(357, 232, 85, 21);
		contentPane.add(izmeniBtn);
		
		JButton obrisiBtn = new JButton("Obrisi");
		obrisiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				   model.removeRow(i);
			}
		});
		obrisiBtn.setBounds(479, 232, 85, 21);
		contentPane.add(obrisiBtn);
		
		imeTxtField = new JTextField();
		imeTxtField.setBounds(91, 10, 96, 19);
		contentPane.add(imeTxtField);
		imeTxtField.setColumns(10);
		
		JLabel imeLbl = new JLabel("Ime");
		imeLbl.setBounds(10, 10, 71, 16);
		contentPane.add(imeLbl);
		
		prezimeTxtField = new JTextField();
		prezimeTxtField.setBounds(91, 52, 96, 19);
		contentPane.add(prezimeTxtField);
		prezimeTxtField.setColumns(10);
		
		JLabel prezimeLbl = new JLabel("Prezime");
		prezimeLbl.setBounds(10, 55, 71, 13);
		contentPane.add(prezimeLbl);
		
		JLabel korImeLbl = new JLabel("Korisnicko ime");
		korImeLbl.setBounds(10, 96, 66, 13);
		contentPane.add(korImeLbl);
		
		 tipKorisnikaComboBox = new JComboBox();
		tipKorisnikaComboBox.setBounds(91, 168, 96, 21);
		contentPane.add(tipKorisnikaComboBox);
		
		JLabel sifraLbl = new JLabel("Sifra");
		sifraLbl.setBounds(10, 136, 71, 13);
		contentPane.add(sifraLbl);
		
		

//Then the Table is constructed using these data and columnNames:
       String []niz= {"ime","prezime","korisnicko ime","lozinka", "tip korisnika"};
	  for (String string : niz) {
		model.addColumn(string);
	}
		
		JButton nazadBtn = new JButton("Nazad");
		nazadBtn.setBounds(10, 232, 85, 21);
		contentPane.add(nazadBtn);
	      
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(240, 10, 303, 179);
		contentPane.add(scrollPane);
		
		for (Korisnik k : u.listaKorisnika) {
			Object[] o= {k.getIme(), k.getPrezime(),k.getKredencijali().getKorisnicko_ime(), k.getKredencijali().getLozinka(), k.getClass().getSimpleName()};
			model.addRow(o);
			table= new JTable(model);
			tipKorisnikaComboBox.addItem(k.getClass().getSimpleName());
		}
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				   String red=table.getValueAt(i, 0).toString();
				   for (Korisnik korisnik : li) {
					if(korisnik.getIme().equals(red)) {
						imeTxtField.setText(korisnik.getIme());
						prezimeTxtField.setText(korisnik.getPrezime());
						korImeTxtField.setText(korisnik.getKredencijali().getKorisnicko_ime());
						sifraTxtField.setText(korisnik.getKredencijali().getLozinka());
						
						tipKorisnikaComboBox.setSelectedItem(korisnik.getClass().getSimpleName());
						break;
					}
				}
			}
		});
	      scrollPane.setViewportView(table);
	      
	      korImeTxtField = new JTextField();
	      korImeTxtField.setBounds(91, 93, 96, 19);
	      contentPane.add(korImeTxtField);
	      korImeTxtField.setColumns(10);
	      
	      sifraTxtField = new JTextField();
	      sifraTxtField.setBounds(91, 133, 96, 19);
	      contentPane.add(sifraTxtField);
	      sifraTxtField.setColumns(10);
	      
	      JLabel tipKorLbl = new JLabel("Tip korisnika");
	      tipKorLbl.setBounds(10, 172, 71, 13);
	      contentPane.add(tipKorLbl);
	      
	}
}

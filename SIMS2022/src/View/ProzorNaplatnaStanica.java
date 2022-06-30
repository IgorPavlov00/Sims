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

public class ProzorNaplatnaStanica extends JFrame {

	private JPanel contentPane;
	private JTextField nazivTxtField;
	private JTextField mestoTxtField;
	private JComboBox napMestoComboBox;
	private JComboBox sefComboBox;
	public JTable table;
	public DefaultTableModel model = new DefaultTableModel();
	Ucitavanje u;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProzorNaplatnaStanica frame = new ProzorNaplatnaStanica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public ProzorNaplatnaStanica() throws IOException {
		u = new Ucitavanje();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton dodajBtn = new JButton("Dodaj");
		ArrayList<NaplatnaStanica> li = u.getListaNaplatnihStanica();
		ArrayList<NaplatnoMesto> mesta = new ArrayList<NaplatnoMesto>();
		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String naziv = nazivTxtField.getText();
				String mesto = mestoTxtField.getText();
				String naplatnaMesta = napMestoComboBox.getSelectedItem().toString();
				String sef = sefComboBox.getSelectedItem().toString();

				for (NaplatnoMesto nm : u.getListaNaplatnihMesta()) {
					if (String.valueOf(nm.getId()).equals(mesto))
						mesta.add(nm);
				}
				SefStanice s = new SefStanice();
				for (Korisnik k : u.getListaKorisnika()) {
					if (k.getIme().equals(sef))
						s = (SefStanice) k;
				}
				NaplatnaStanica ns = new NaplatnaStanica(naziv, mesto, mesta, s);
				li.add(ns);
				u.setListaNaplatnihStanica(li);

				model.addRow(new Object[] { naziv, mesto, naplatnaMesta, sef });

				try {
					u.upisiUFajl();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		dodajBtn.setBounds(240, 232, 85, 21);
		contentPane.add(dodajBtn);

		JButton izmeniBtn = new JButton("Izmeni");
		izmeniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				String red = table.getValueAt(i, 0).toString();
				String naziv = nazivTxtField.getText();
				String mesto = mestoTxtField.getText();
				String naplatnaMesta = napMestoComboBox.getSelectedItem().toString();
				String sef = sefComboBox.getSelectedItem().toString();

				for (NaplatnoMesto nm : u.getListaNaplatnihMesta()) {
					if (String.valueOf(nm.getId()).equals(mesto))
						mesta.add(nm);
				}
				SefStanice s = new SefStanice();
				for (Korisnik k : u.getListaKorisnika()) {
					if (k.getIme().equals(sef))
						s = (SefStanice) k;
				}
				NaplatnaStanica ns = new NaplatnaStanica(naziv, mesto, mesta, s);
				li.set(i, ns);
				u.setListaNaplatnihStanica(li);

				model.setValueAt(nazivTxtField.getText(), i, 0);
				model.setValueAt(mestoTxtField.getText(), i, 1);
				model.setValueAt(napMestoComboBox.getSelectedItem().toString(), i, 2);
				model.setValueAt(sefComboBox.getSelectedItem().toString(), i, 3);

				try {
					u.upisiUFajl();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		izmeniBtn.setBounds(357, 232, 85, 21);
		contentPane.add(izmeniBtn);

		JButton obrisiBtn = new JButton("Obrisi");
		obrisiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				li.remove(i);
				u.setListaNaplatnihStanica(li);
				model.removeRow(i);
				try {
					u.upisiUFajl();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		obrisiBtn.setBounds(479, 232, 85, 21);
		contentPane.add(obrisiBtn);

		nazivTxtField = new JTextField();
		nazivTxtField.setBounds(91, 10, 96, 19);
		contentPane.add(nazivTxtField);
		nazivTxtField.setColumns(10);

		JLabel nazivLbl = new JLabel("Naziv");
		nazivLbl.setBounds(10, 13, 45, 13);
		contentPane.add(nazivLbl);

		mestoTxtField = new JTextField();
		mestoTxtField.setBounds(91, 52, 96, 19);
		contentPane.add(mestoTxtField);
		mestoTxtField.setColumns(10);

		JLabel mestoLbl = new JLabel("Mesto");
		mestoLbl.setBounds(10, 55, 45, 13);
		contentPane.add(mestoLbl);

		JLabel napMestoLbl = new JLabel("Napltano mesto");
		napMestoLbl.setBounds(10, 96, 85, 13);
		contentPane.add(napMestoLbl);

		napMestoComboBox = new JComboBox();
		napMestoComboBox.setBounds(91, 92, 96, 21);
		contentPane.add(napMestoComboBox);

		sefComboBox = new JComboBox();
		sefComboBox.setBounds(91, 132, 96, 21);
		contentPane.add(sefComboBox);

		JLabel sefLbl = new JLabel("Sef");
		sefLbl.setBounds(10, 136, 45, 13);
		contentPane.add(sefLbl);

//Then the Table is constructed using these data and columnNames:
		String[] niz = { "naziv", "mesto", "napaltna mesta", "sef" };
		for (String string : niz) {
			model.addColumn(string);
		}

		JButton nazadBtn = new JButton("Nazad");
		nazadBtn.setBounds(10, 232, 85, 21);
		contentPane.add(nazadBtn);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(240, 10, 303, 179);
		contentPane.add(scrollPane);

		for (NaplatnaStanica n : u.listaNaplatnihStanica) {
			Object[] o = { n.getNaziv(), n.getMesto(), n.getNaplatnaMestaId(), n.getSefStanice().getIme() };
			model.addRow(o);
			table = new JTable(model);
			
		}

		napMestoComboBox.addItem(u.listaNaplatnihStanica.get(0).getNaplatnaMestaId());
		for (Korisnik k : u.listaKorisnika) {
			if (k.getClass().getSimpleName().equals("SefStanice"))
				sefComboBox.addItem(k.getIme());
		}
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				String red = table.getValueAt(i, 0).toString();
				for (NaplatnaStanica naplatnaStanica : li) {
					if (naplatnaStanica.getNaziv().equals(red)) {
						nazivTxtField.setText(naplatnaStanica.getNaziv());
						mestoTxtField.setText(naplatnaStanica.getMesto());
						napMestoComboBox.setSelectedItem(naplatnaStanica.getNaplatnaMestaId());
						sefComboBox.setSelectedItem(naplatnaStanica.getSefStanice().getIme());
						break;
					}
				}
			}
		});
		scrollPane.setViewportView(table);

	}
}

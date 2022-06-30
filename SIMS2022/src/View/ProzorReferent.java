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

import Model.Cenovnik;
import Model.Naplata;
import Model.NaplatnaStanica;
import Model.NaplatnoMesto;
import Model.ReferentNaplate;
import Model.SefStanice;
import SistemZaNaplatu.Ucitavanje;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProzorReferent extends JFrame {

	private JPanel contentPane;
	public JTable table;
	public DefaultTableModel model=new DefaultTableModel();
	Ucitavanje u;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProzorReferent frame = new ProzorReferent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ProzorReferent() throws IOException {
		u=new Ucitavanje();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

	  String []niz= {"Tablice", "Mesto ulaska", "Vreme ulaska", "Mesto izlaska", "Vreme izlaska", "Cena"};
	  for (String string : niz) {
		model.addColumn(string);
	}
		
		JButton nazadBtn = new JButton("Odjavi se");
		nazadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prijava pr=new Prijava();
				pr.setVisible(true);
				dispose();
			}
		});
		nazadBtn.setBounds(245, 232, 85, 21);
		contentPane.add(nazadBtn);
	      
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(45, 10, 498, 179);
		contentPane.add(scrollPane);
		
		for (Naplata np : u.listaNaplata) {
			Object[] o= {np.getTabliceVozila(), np.getMestoUlaska(), np.getVremeUlaska(),  np.getMestoIzlaska(), np.getVremeIzlaska(), np.getCena().getIznos() + " " + np.getCena().getValuta()};
			model.addRow(o);
			table= new JTable(model);
		}
	
	    scrollPane.setViewportView(table);	      
	}
}
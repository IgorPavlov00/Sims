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
import Model.SefStanice;
import SistemZaNaplatu.Ucitavanje;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProzorSefStanice extends JFrame {

	private static int id;
	private JPanel contentPane;
	public JTable table;
	public DefaultTableModel model=new DefaultTableModel();
	Ucitavanje u;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProzorSefStanice frame = new ProzorSefStanice(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ProzorSefStanice(int id) throws IOException {
		this.id = id;
		u=new Ucitavanje();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

      String []niz= {"Id", "Broj kucice", "Tip mesta", "Tip naplate"};
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
		
		scrollPane.setBounds(39, 10, 517, 179);
		contentPane.add(scrollPane);
		
		for (NaplatnaStanica ns : u.listaNaplatnihStanica) {
			if(ns.getSefStanice().getId() == id)
				for(NaplatnoMesto nm : ns.getNaplatnaMesta()) {
					Object[] o= {nm.getId(), nm.getBrojKucice(), nm.getTipMesta(), nm.getTipNaplate()};
					model.addRow(o);
				}
			table= new JTable(model);
		}
	    scrollPane.setViewportView(table);
	}
}
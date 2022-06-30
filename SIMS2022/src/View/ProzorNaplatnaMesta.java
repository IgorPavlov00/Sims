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

import Model.NaplatnaStanica;
import Model.NaplatnoMesto;
import Model.SefStanice;
import SistemZaNaplatu.Ucitavanje;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProzorNaplatnaMesta extends JFrame {

	private JPanel contentPane;
	private JTextField text1;
	private JComboBox combo1;
	private JComboBox combo2 ;
	private JComboBox combo3;
	public JTable table;
   public DefaultTableModel model=new DefaultTableModel();
	Ucitavanje u;
	private JTextField txt2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProzorNaplatnaMesta frame = new ProzorNaplatnaMesta();
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
	public ProzorNaplatnaMesta() throws IOException {
		u=new Ucitavanje();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton dodajBtn = new JButton("Dodaj");
		ArrayList<NaplatnoMesto>li=u.getListaNaplatnihMesta();
		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipNaplate=combo1.getSelectedItem().toString();
				String tipMesta=combo2.getSelectedItem().toString();
				String brojKucice=text1.getText();
				String periferni =combo3.getSelectedItem().toString();
			   String referent=txt2.getText();
				
			    model.addRow(new Object []{tipNaplate,tipMesta,brojKucice,periferni,referent});
			}
		});
		dodajBtn.setBounds(240, 232, 85, 21);
		contentPane.add(dodajBtn);
		
		JButton izmeniBtn = new JButton("Izmeni");
		izmeniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
			   String red=table.getValueAt(i, 0).toString();
			     model.setValueAt(combo1.getSelectedItem().toString(), i, 0);
		         model.setValueAt(combo2.getSelectedItem().toString(), i, 1);
		         
		         model.setValueAt(text1.getText(), i, 2);
		         model.setValueAt(combo3.getSelectedItem().toString(), i, 3);
		         model.setValueAt(txt2.getText(), i, 4);

					
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
		
		JLabel nazivLbl = new JLabel("TipNaplate");
		nazivLbl.setBounds(10, 13, 71, 13);
		contentPane.add(nazivLbl);
		
		text1 = new JTextField();
		text1.setBounds(101, 92, 96, 19);
		contentPane.add(text1);
		text1.setColumns(10);
		
		JLabel mestoLbl = new JLabel("TipMesta");
		mestoLbl.setBounds(10, 55, 45, 13);
		contentPane.add(mestoLbl);
		
		JLabel napMestoLbl = new JLabel("broj kucice");
		napMestoLbl.setBounds(10, 96, 85, 13);
		contentPane.add(napMestoLbl);
		
		combo1 = new JComboBox();
		combo1.setBounds(101, 9, 96, 21);
		contentPane.add(combo1);
		
		 combo2 = new JComboBox();
		combo2.setBounds(101, 51, 96, 21);
		contentPane.add(combo2);
		
		JLabel sefLbl = new JLabel("periferni uredjaji");
		sefLbl.setBounds(10, 136, 85, 13);
		contentPane.add(sefLbl);
		
		

//Then the Table is constructed using these data and columnNames:
       String []niz= {"tip naplate","tip mesta","broj kucice","periferni uredjaji","referetn"};
	  for (String string : niz) {
		model.addColumn(string);
	}
		
		JButton nazadBtn = new JButton("Nazad");
		nazadBtn.setBounds(10, 232, 85, 21);
		contentPane.add(nazadBtn);
	      
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(240, 10, 303, 179);
		contentPane.add(scrollPane);
		
		for (NaplatnoMesto n : u.listaNaplatnihMesta) {
			Object[] o= {n.getTipNaplate(),n.getTipMesta(),n.getBrojKucice(),n.getNaplatnoId(),n.getReferent().getIme()};
			model.addRow(o);
			table= new JTable(model);
		
		}
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				   String red=table.getValueAt(i, 0).toString();
				   for (NaplatnoMesto n : li) {
					if(n.getTipNaplate().equals(red)) {
						
		
						combo1.setSelectedItem(n.getTipMesta());
						combo2.setSelectedItem(n.getTipNaplate());
						text1.setText(n.getBrojKucice()+"");
						txt2.setText(n.getReferent().getIme());
						break;
					}
				}
			}
		});
	      scrollPane.setViewportView(table);
	      
	       combo3 = new JComboBox();
	      combo3.setBounds(101, 131, 96, 22);
	      contentPane.add(combo3);
	      
	      JLabel lblNewLabel = new JLabel("referent");
	      lblNewLabel.setBounds(10, 175, 46, 14);
	      contentPane.add(lblNewLabel);
	      
	      txt2 = new JTextField();
	      txt2.setBounds(101, 172, 96, 20);
	      contentPane.add(txt2);
	      txt2.setColumns(10);
	      
	}
}

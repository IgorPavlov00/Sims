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
	private JTextField nazivTxtField;
	private JTextField mestoTxtField;
	private JComboBox napMestoComboBox;
	private JComboBox sefComboBox ;
	public JTable table;
   public DefaultTableModel model=new DefaultTableModel();
	Ucitavanje u;
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
		ArrayList<NaplatnaStanica>li=u.getListaNaplatnihStanica();
		dodajBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String naziv=nazivTxtField.getText();
				String mesto=mestoTxtField.getText();
				String naplatnaMesta= napMestoComboBox.getSelectedItem().toString();
				String sef= sefComboBox.getSelectedItem().toString();
			   
				
			    model.addRow(new Object []{naziv,mesto,naplatnaMesta,sef});
			}
		});
		dodajBtn.setBounds(240, 232, 85, 21);
		contentPane.add(dodajBtn);
		
		JButton izmeniBtn = new JButton("Izmeni");
		izmeniBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
			   String red=table.getValueAt(i, 0).toString();
			 
		         model.setValueAt(nazivTxtField.getText(), i, 0);
		         model.setValueAt(mestoTxtField.getText(), i, 1);
		         model.setValueAt(napMestoComboBox.getSelectedItem().toString(), i, 2);
		         model.setValueAt(sefComboBox.getSelectedItem().toString(), i, 3);
					
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
			Object[] o= {n.getTipNaplate(),n.getTipMesta(),n.getBrojKucice(),n.getPeriferniUredjaji(),n.getReferent().getIme()};
			model.addRow(o);
			table= new JTable(model);
			napMestoComboBox.addItem(n.getTipMesta());
			sefComboBox.addItem(n.getTipNaplate());
		}
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				   String red=table.getValueAt(i, 0).toString();
				   for (NaplatnoMesto n : li) {
					if(n.getTipNaplate().equals(red)) {
						
					
						napMestoComboBox.setSelectedItem(n.getTipMesta());
						sefComboBox.setSelectedItem(n.getTipNaplate());
						break;
					}
				}
			}
		});
	      scrollPane.setViewportView(table);
	      
	}
}

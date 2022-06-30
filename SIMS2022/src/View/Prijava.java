package View;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Model.Korisnik;
import SistemZaNaplatu.Ucitavanje;

public class Prijava extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prijava frame = new Prijava();
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

	public Prijava() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("korisnicko ime:");
		lblNewLabel.setBounds(62, 73, 77, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("lozinka:");
		lblNewLabel_1.setBounds(62, 125, 46, 14);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(182, 70, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(182, 122, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("uloguj se!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ucitavanje u;
				Boolean flag = false;
			    ProzorAdministratora padmin=new ProzorAdministratora();
				ProzorMenadzera pm;
				ProzorSefStanice sf;
				ProzorReferent pr;
				ProzorProdavacTagova pt;

				try {
					pr = new ProzorReferent();
					u = new Ucitavanje();
					pm = new ProzorMenadzera();
					pt = new ProzorProdavacTagova();
					Korisnik kor = new Korisnik();
					for (Korisnik k : u.getListaKorisnika()) {
						String korIme = textField.getText();
						String lozinka = textField_1.getText();
						String trenutnoKorIme = k.getKredencijali().getKorisnicko_ime();
						String trenutnaLozinka = k.getKredencijali().getLozinka();
						
						if (korIme.equals(trenutnoKorIme) && lozinka.equals(trenutnaLozinka)) {
							flag = true;
							kor = k;
							break;
						
						} else {
							flag = false;

						}
					}
					if (flag) {
						if(kor.getClass().getSimpleName().equals("Administrator")) {
							padmin.setVisible(true);
							dispose();
						}
						if(kor.getClass().getSimpleName().equals("MenadzerSistema")) {
							pm.setVisible(true);
							dispose();
						}
						if(kor.getClass().getSimpleName().equals("SefStanice")) {
							sf = new ProzorSefStanice(kor.getId());
							sf.setVisible(true);
							dispose();
						}
						if(kor.getClass().getSimpleName().equals("ReferentNaplate")) {
							pr.setVisible(true);
							dispose();
						}
						if(kor.getClass().getSimpleName().equals("ProdavacTagova")) {
							pt.setVisible(true);
							dispose();
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "There's a bug on you!");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(179, 195, 89, 23);
		contentPane.add(btnNewButton);
	}
}

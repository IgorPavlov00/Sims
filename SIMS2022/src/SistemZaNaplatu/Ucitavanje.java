package SistemZaNaplatu;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Model.Korisnik;
import Model.Kredencijali;

public class Ucitavanje {

	public ArrayList<Korisnik> listaKorisnika = new ArrayList<Korisnik>();

	public Ucitavanje() throws IOException {

		Ucitaj();
	}

	public Ucitavanje(ArrayList<Korisnik> listaKorisnika) throws IOException {
		super();
		this.listaKorisnika = listaKorisnika;
		Ucitaj();
	}

	public ArrayList<Korisnik> getListaKorisnika() {
		return listaKorisnika;
	}

	public void setListaKorisnika(ArrayList<Korisnik> listaKorisnika) {
		this.listaKorisnika = listaKorisnika;
	}

	public void Ucitaj() throws IOException {
		FileReader fr = new FileReader("Korisnici.txt");
		BufferedReader br = new BufferedReader(fr);

		String line = "";
		while ((line = br.readLine()) != null) {
			String niz[] = line.split("\\|");
			int id = Integer.parseInt(niz[0]);
			String ime = niz[1];
			String prezime = niz[2];
			String korime = niz[3];
			String lozinka = niz[4];

			Kredencijali kred = new Kredencijali(korime, lozinka);
			Korisnik k = new Korisnik(id, ime, prezime, kred);

			listaKorisnika.add(k);

		}
		br.close();

	}

	@Override
	public String toString() {
		return "Ucitavanje [listaKorisnika=" + listaKorisnika + "]";
	}
}

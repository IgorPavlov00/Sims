package SistemZaNaplatu;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Korisnik;
import Model.Kredencijali;
import Model.NaplatnaStanica;
import Model.NaplatnoMesto;
import Model.Rampa;
import Model.ReferentNaplate;
import Model.SefStanice;
import Model.Uredjaj;
import Model.Enums.TipMesta;
import Model.Enums.TipNaplate;

public class Ucitavanje {

	public ArrayList<Korisnik> listaKorisnika = new ArrayList<Korisnik>();
	public ArrayList<NaplatnaStanica> listaNaplatnihStanica = new ArrayList<NaplatnaStanica>();

	public Ucitavanje() throws IOException {

		Ucitaj();
		UcitajNaplatnuStanicu();
	}

	public Ucitavanje(ArrayList<Korisnik> listaKorisnika, ArrayList<NaplatnaStanica> listaNaplatnihStanica) throws IOException {
		super();
		this.listaKorisnika = listaKorisnika;
		this.listaNaplatnihStanica = listaNaplatnihStanica;
		Ucitaj();
	}

	public ArrayList<Korisnik> getListaKorisnika() {
		return listaKorisnika;
	}

	public void setListaKorisnika(ArrayList<Korisnik> listaKorisnika) {
		this.listaKorisnika = listaKorisnika;
	}
	
	public ArrayList<NaplatnaStanica> getListaNaplatnihStanica() {
		return listaNaplatnihStanica;
	}

	public void setListaNaplatnihStanica(ArrayList<NaplatnaStanica> listaNaplatnihStanica) {
		this.listaNaplatnihStanica = listaNaplatnihStanica;
	}

	public void Ucitaj() throws IOException {
		FileReader fr = new FileReader("..\\SIMS2022\\src\\Korisnici.txt");
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

	public void UcitajNaplatnaMesta() throws IOException {
		FileReader fr = new FileReader("..\\SIMS2022\\src\\NaplatnaMesta.txt");
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
	
	public void UcitajNaplatnuStanicu() throws IOException {
		FileReader fr = new FileReader("..\\SIMS2022\\src\\NaplatnaStanica.txt");
		BufferedReader br = new BufferedReader(fr);

		String line = "";
		while ((line = br.readLine()) != null) {
			String niz[] = line.split("\\|");
			String naziv = niz[0];
			String mesto = niz[1];
			
			
			List<NaplatnoMesto> listaNaplatnihMesta = new ArrayList<NaplatnoMesto>();
			String nizNaplatnihMesta[] = niz[2].split("\\,");
			Kredencijali kre = new Kredencijali("korisnickiIme", "lozinka");
			for(int i = 0; i < nizNaplatnihMesta.length; i++) {
				ReferentNaplate ref = new ReferentNaplate(0, "ime", "prez", kre);
				Uredjaj u = new Rampa(false);
				List<Uredjaj> uredjaji = new ArrayList<>();
				uredjaji.add(u);
				
				NaplatnoMesto nm = new NaplatnoMesto(Integer.parseInt(nizNaplatnihMesta[i]), TipNaplate.FIZICKI, TipMesta.ULAZ, 0, uredjaji, ref);
				listaNaplatnihMesta.add(nm);
			}
			int sefId = Integer.parseInt(niz[3]);
			SefStanice sef = new SefStanice(0, "ime", "prez", kre);
			NaplatnaStanica ns = new NaplatnaStanica(naziv, mesto, listaNaplatnihMesta, sef);
			
			listaNaplatnihStanica.add(ns);
		}
		br.close();
	}

	@Override
	public String toString() {
		return "Ucitavanje [listaKorisnika=" + listaKorisnika + "]";
	}
}

package SistemZaNaplatu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Administrator;
import Model.Cena;
import Model.Cenovnik;
import Model.Citac;
import Model.Deonica;
import Model.Displej;
import Model.Korisnik;
import Model.Kredencijali;
import Model.MenadzerSistema;
import Model.Naplata;
import Model.NaplatnaStanica;
import Model.NaplatnoMesto;
import Model.ProdavacTagova;
import Model.Rampa;
import Model.ReferentNaplate;
import Model.SefStanice;
import Model.Semafor;
import Model.Tag;
import Model.Uredjaj;
import Model.Enums.TipMesta;
import Model.Enums.TipNaplate;

public class Ucitavanje {

	public ArrayList<Korisnik> listaKorisnika = new ArrayList<Korisnik>();
	public ArrayList<NaplatnaStanica> listaNaplatnihStanica = new ArrayList<NaplatnaStanica>();
	public ArrayList<NaplatnoMesto> listaNaplatnihMesta = new ArrayList<NaplatnoMesto>();
	public ArrayList<Cenovnik> listaCenovnika = new ArrayList<Cenovnik>();
	public ArrayList<Cena> listaCena = new ArrayList<Cena>();
	public ArrayList<Deonica> listaDeonica = new ArrayList<Deonica>();
	public ArrayList<Tag> listaTagova = new ArrayList<Tag>();
	public ArrayList<Naplata> listaNaplata = new ArrayList<Naplata>();

	public Ucitavanje() throws IOException {

		ucitajKorisnike();
		ucitajNaplatnaMesta();
		ucitajNaplatneStanice();
	}

	public Ucitavanje(ArrayList<Korisnik> listaKorisnika, ArrayList<NaplatnaStanica> listaNaplatnihStanica)
			throws IOException {
		super();
		this.listaKorisnika = listaKorisnika;
		this.listaNaplatnihStanica = listaNaplatnihStanica;
		ucitajKorisnike();
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

	// TODO: Ucitaj uloge i napravi odgovarajuce klase
	// Za ime klase, koristimo <nas objekat>.getClass().getSimpleName()
	// Uloge u txt fajlu su: admin, sef, men, ref, prod
	public void ucitajKorisnike() throws IOException {
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
			String uloga = niz[5];

			Kredencijali kred = new Kredencijali(korime, lozinka);
			Korisnik k = new Korisnik();
			if (uloga.equals("Administrator"))
				k = new Administrator(id, ime, prezime, kred);
			if (uloga.equals("SefStanice"))
				k = new SefStanice(id, ime, prezime, kred);
			if (uloga.equals("MenadzerSistema"))
				k = new MenadzerSistema(id, ime, prezime, kred);
			if (uloga.equals("ReferentNaplate"))
				k = new ReferentNaplate(id, ime, prezime, kred);
			if (uloga.equals("ProdavacTagova"))
				k = new ProdavacTagova(id, ime, prezime, kred);

			listaKorisnika.add(k);

		}
		br.close();
	}

	// TODO: Ucitaj naplatna mesta u listu
	// Referenta ucitavamo iz liste preko id
	// TODO: Ucitavanje uredjaja
	// Uredjaji imaju vrstu: rampa, citac, displej, semafor
	public void ucitajNaplatnaMesta() throws IOException {
		FileReader fr = new FileReader("..\\SIMS2022\\src\\NaplatnoMesto.txt");
		BufferedReader br = new BufferedReader(fr);

		String line = "";
		while ((line = br.readLine()) != null) {
			String niz[] = line.split("\\|");
			int id = Integer.parseInt(niz[0]);
			TipNaplate tipNaplate = TipNaplate.valueOf(niz[1]);
			TipMesta tipMesta = TipMesta.valueOf(niz[2]);
			int kucica = Integer.parseInt(niz[3]);
			List<Uredjaj> uredjaji = new ArrayList<Uredjaj>();
			for (String uredjaj : niz[4].split("\\,")) {
				Uredjaj u = new Uredjaj();
				if (uredjaj.equals("Rampa"))
					u = new Rampa(false);
				if (uredjaj.equals("Displej"))
					u = new Displej(false);
				if (uredjaj.equals("Semafor"))
					u = new Semafor(false);
				if (uredjaj.equals("Citac"))
					u = new Citac(false);
				uredjaji.add(u);
			}
			ReferentNaplate ref = new ReferentNaplate();
			for (Korisnik korisnik : listaKorisnika) {
				if (String.valueOf(korisnik.getId()).equals(niz[5])) {
					ref = new ReferentNaplate(korisnik);
					break;
				}
			}

			NaplatnoMesto nm = new NaplatnoMesto(id, tipNaplate, tipMesta, kucica, uredjaji, ref);
			listaNaplatnihMesta.add(nm);

		}
		br.close();
	}

	// TODO: Ucitaj naplatne stanice i resi problem sa sefom i naplatnim mestima
	// Sefa ucitaj iz liste po id
	// Naplatna mesta ucitaj po id
	public void ucitajNaplatneStanice() throws IOException {
		FileReader fr = new FileReader("..\\SIMS2022\\src\\NaplatnaStanica.txt");
		BufferedReader br = new BufferedReader(fr);

		String line = "";
		while ((line = br.readLine()) != null) {
			String niz[] = line.split("\\|");
			String naziv = niz[0];
			String mesto = niz[1];

			List<NaplatnoMesto> naplatnaMesta = new ArrayList<NaplatnoMesto>();
			for (String string : niz[2].split("\\,"))  {
				for (NaplatnoMesto nm : listaNaplatnihMesta) {
					if(String.valueOf(nm.getId()).equals(string)) naplatnaMesta.add(nm);
				}
			}
			SefStanice sef = new SefStanice();
			for (Korisnik korisnik : listaKorisnika) {
				if (String.valueOf(korisnik.getId()).equals(niz[3])) {
					sef = new SefStanice(korisnik);
					break;
				}
			}
			
			NaplatnaStanica ns = new NaplatnaStanica(naziv, mesto, listaNaplatnihMesta, sef);

			listaNaplatnihStanica.add(ns);
		}
		br.close();
	}

	// TODO: Ucitavanje cenovnika, cena, deonica, tagova, naplata
	// Cenovnik ima listu cena
	// Naplate vidi sistem -> menadzer?
	public void ucitajDeonice() throws IOException {
		FileReader fr = new FileReader("..\\SIMS2022\\src\\Korisnici.txt");
		BufferedReader br = new BufferedReader(fr);

		String line = "";
		while ((line = br.readLine()) != null) {
			String niz[] = line.split("\\|");
			String odS = niz[0];
			String doS = niz[1];
			NaplatnaStanica odNS = new NaplatnaStanica();
			NaplatnaStanica doNS = new NaplatnaStanica();
			for (NaplatnaStanica ns : listaNaplatnihStanica) {
				if (ns.getNaziv().equals(odS)) odNS = ns;
				if (ns.getNaziv().equals(doS)) doNS = ns;
			}
			Deonica deonica = new Deonica(odNS, doNS);
			listaDeonica.add(deonica);

		}
		br.close();
	}

	public void ucitajCene() throws IOException {
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

	public void ucitajCenovnik() throws IOException {
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

	public void ucitajTagove() throws IOException {
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

	public void ucitajNaplate() throws IOException {
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

	public void upisiUFajl() throws IOException {
		String str = "";
		for (Korisnik korisnik : this.listaKorisnika) {
			System.out.println(korisnik);
			str += korisnik.getId() + "|" + korisnik.getIme() + "|" + korisnik.getPrezime() + "|"
					+ korisnik.getKredencijali().getKorisnicko_ime() + "|" + korisnik.getKredencijali().getLozinka()
					+ "|" + korisnik.getClass().getSimpleName() + "\n";
		}
		str = str.substring(0, str.length() - "\n".length());
		BufferedWriter writer = new BufferedWriter(new FileWriter("..\\SIMS2022\\src\\Korisnici.txt"));
		writer.write(str);

		writer.close();

//		str = "";
//		for (Korisnik korisnik : this.listaKorisnika) {
//			System.out.println(korisnik);
//			str += korisnik.getId() + "|" + korisnik.getIme() + "|" + korisnik.getPrezime() + "|"
//					+ korisnik.getKredencijali().getKorisnicko_ime() + "|" + korisnik.getKredencijali().getLozinka()
//					+ "|" + korisnik.getClass().getSimpleName() + "\n";
//		}
//		str = str.substring(0, str.length() - "\n".length());
//		writer = new BufferedWriter(new FileWriter("..\\SIMS2022\\src\\Korisnici.txt"));
//		writer.write(str);
//
//		writer.close();
		System.out.println("USPESAN UPIS");
	}

	@Override
	public String toString() {
		return "Ucitavanje [listaKorisnika=" + listaKorisnika + "]";
	}
}

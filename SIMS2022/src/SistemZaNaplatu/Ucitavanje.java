package SistemZaNaplatu;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Model.Administrator;
import Model.Cena;
import Model.Cenovnik;
import Model.Citac;
import Model.Deonica;
import Model.Displej;
import Model.ElektronskaNaplata;
import Model.FizickaNaplata;
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
import Model.Enums.TipVozila;
import Model.Enums.Valuta;

public class Ucitavanje {

	public DateTimeFormatter vremeDTF = DateTimeFormatter.ofPattern("HH:mm");
	public DateTimeFormatter datumDTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public ArrayList<Korisnik> listaKorisnika = new ArrayList<Korisnik>();
	public ArrayList<NaplatnaStanica> listaNaplatnihStanica = new ArrayList<NaplatnaStanica>();
	public ArrayList<NaplatnoMesto> listaNaplatnihMesta = new ArrayList<NaplatnoMesto>();
	public ArrayList<Cenovnik> listaCenovnika = new ArrayList<Cenovnik>();
	public ArrayList<Cena> listaCena = new ArrayList<Cena>();
	public ArrayList<Deonica> listaDeonica = new ArrayList<Deonica>();
	public ArrayList<Tag> listaTagova = new ArrayList<Tag>();
	public ArrayList<Naplata> listaNaplata = new ArrayList<Naplata>();
	public ArrayList<Uredjaj> listaUredjaja = new ArrayList<Uredjaj>();

	public Ucitavanje() throws IOException {

		ucitajKorisnike();
		ucitajUredjaje();
		ucitajNaplatnaMesta();
		ucitajNaplatneStanice();
		ucitajDeonice();
		ucitajCene();
		ucitajCenovnik();
		ucitajTagove();
		ucitajNaplate();
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

	public ArrayList<NaplatnoMesto> getListaNaplatnihMesta() {
		return listaNaplatnihMesta;
	}

	public void setListaNaplatnihMesta(ArrayList<NaplatnoMesto> listaNaplatnihMesta) {
		this.listaNaplatnihMesta = listaNaplatnihMesta;
	}

	public ArrayList<Cenovnik> getListaCenovnika() {
		return listaCenovnika;
	}

	public void setListaCenovnika(ArrayList<Cenovnik> listaCenovnika) {
		this.listaCenovnika = listaCenovnika;
	}

	public ArrayList<Cena> getListaCena() {
		return listaCena;
	}

	public void setListaCena(ArrayList<Cena> listaCena) {
		this.listaCena = listaCena;
	}

	public ArrayList<Deonica> getListaDeonica() {
		return listaDeonica;
	}

	public void setListaDeonica(ArrayList<Deonica> listaDeonica) {
		this.listaDeonica = listaDeonica;
	}

	public ArrayList<Tag> getListaTagova() {
		return listaTagova;
	}

	public void setListaTagova(ArrayList<Tag> listaTagova) {
		this.listaTagova = listaTagova;
	}

	public ArrayList<Naplata> getListaNaplata() {
		return listaNaplata;
	}

	public void setListaNaplata(ArrayList<Naplata> listaNaplata) {
		this.listaNaplata = listaNaplata;
	}

	public ArrayList<Uredjaj> getListaUredjaja() {
		return listaUredjaja;
	}

	public void setListaUredjaja(ArrayList<Uredjaj> listaUredjaja) {
		this.listaUredjaja = listaUredjaja;
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

	public void ucitajUredjaje() throws IOException {
		FileReader fr = new FileReader("..\\SIMS2022\\src\\Uredjaj.txt");
		BufferedReader br = new BufferedReader(fr);

		String line = "";
		while ((line = br.readLine()) != null) {
			String niz[] = line.split("\\|");
			int id = Integer.parseInt(niz[0]);
			String klasa = niz[1];
			boolean stanje = Boolean.parseBoolean(niz[2]);

			Uredjaj u = new Uredjaj();
			if (klasa.equals("Displej"))
				u = new Displej(id, stanje);
			if (klasa.equals("Rampa"))
				u = new Rampa(id, stanje);
			if (klasa.equals("Citac"))
				u = new Citac(id, stanje);
			if (klasa.equals("Semafor"))
				u = new Semafor(id, stanje);

			listaUredjaja.add(u);

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
				for (Uredjaj uredjajUcitan : listaUredjaja) {
					if (String.valueOf(uredjajUcitan.getId()).equals(uredjaj))
						u = uredjajUcitan;
				}
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
			for (String string : niz[2].split("\\,")) {
				for (NaplatnoMesto nm : listaNaplatnihMesta) {
					if (String.valueOf(nm.getId()).equals(string))
						naplatnaMesta.add(nm);
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
		FileReader fr = new FileReader("..\\SIMS2022\\src\\Deonice.txt");
		BufferedReader br = new BufferedReader(fr);

		String line = "";
		while ((line = br.readLine()) != null) {
			String niz[] = line.split("\\|");
			String odS = niz[0];
			String doS = niz[1];
			NaplatnaStanica odNS = new NaplatnaStanica();
			NaplatnaStanica doNS = new NaplatnaStanica();
			for (NaplatnaStanica ns : listaNaplatnihStanica) {
				if (ns.getNaziv().equals(odS))
					odNS = ns;
				if (ns.getNaziv().equals(doS))
					doNS = ns;
			}
			Deonica deonica = new Deonica(odNS, doNS);
			listaDeonica.add(deonica);

		}
		br.close();
	}

	public void ucitajCene() throws IOException {
		FileReader fr = new FileReader("..\\SIMS2022\\src\\Cena.txt");
		BufferedReader br = new BufferedReader(fr);

		String line = "";
		while ((line = br.readLine()) != null) {
			String niz[] = line.split("\\|");
			int id = Integer.parseInt(niz[0]);
			int iznos = Integer.parseInt(niz[1]);
			Valuta valuta = Valuta.valueOf(niz[2]);
			TipVozila tipVozila = TipVozila.valueOf(niz[3]);
			String stanice[] = niz[4].split("\\,");
			Deonica d = new Deonica();
			for (Deonica deonica : listaDeonica) {
				if (deonica.getOdStanice().getNaziv().equals(stanice[0])
						&& deonica.getDoStanice().getNaziv().equals(stanice[1])) {
					d = deonica;
					break;
				}
			}
			Cena c = new Cena(id, iznos, valuta, tipVozila, d);
			listaCena.add(c);

		}
		br.close();
	}

	public void ucitajCenovnik() throws IOException {
		FileReader fr = new FileReader("..\\SIMS2022\\src\\Cenovnik.txt");
		BufferedReader br = new BufferedReader(fr);

		String line = "";
		while ((line = br.readLine()) != null) {
			String niz[] = line.split("\\|");
			boolean aktivan = Boolean.valueOf(niz[0]);
			LocalDate pocetak = LocalDate.parse(niz[1], datumDTF);
			LocalDate kraj = LocalDate.parse(niz[2], datumDTF);
			List<Cena> cene = new ArrayList<Cena>();
			for (String string : niz[3].split("\\,")) {
				for (Cena c : listaCena) {
					if (String.valueOf(c.getId()).equals(string))
						cene.add(c);
				}
			}

			Cenovnik c = new Cenovnik(aktivan, pocetak, kraj, cene);
			listaCenovnika.add(c);

		}
		br.close();
	}

	public void ucitajTagove() throws IOException {
		FileReader fr = new FileReader("..\\SIMS2022\\src\\Tag.txt");
		BufferedReader br = new BufferedReader(fr);

		String line = "";
		while ((line = br.readLine()) != null) {
			String niz[] = line.split("\\|");
			int id = Integer.parseInt(niz[0]);
			String ime = niz[1];
			String prezime = niz[2];
			TipVozila tipVozila = TipVozila.valueOf(niz[3]);
			int sredstva = Integer.parseInt(niz[4]);

			Tag t = new Tag(id, ime, prezime, tipVozila, sredstva);

			listaTagova.add(t);

		}
		br.close();
	}

	public void ucitajNaplate() throws IOException {
		FileReader fr = new FileReader("..\\SIMS2022\\src\\Naplata.txt");
		BufferedReader br = new BufferedReader(fr);

		String line = "";
		while ((line = br.readLine()) != null) {
			String niz[] = line.split("\\|");
			LocalTime vremeUlaska = LocalTime.parse(niz[0], vremeDTF);
			LocalTime vremeIzlaska = LocalTime.parse(niz[1], vremeDTF);
			NaplatnaStanica mestoUlaska = new NaplatnaStanica();
			NaplatnaStanica mestoIzlaska = new NaplatnaStanica();
			for (NaplatnaStanica ns : listaNaplatnihStanica) {
				if (ns.getNaziv().equals(niz[2]))
					mestoUlaska = ns;
				if (ns.getNaziv().equals(niz[3]))
					mestoIzlaska = ns;
			}
			String tabliceVozila = niz[4];
			float prosecnaBrzina = Float.parseFloat(niz[5]);
			Cena cena = new Cena();
			for (Cena c : listaCena) {
				if (c.getDeonica().getOdStanice().equals(mestoUlaska)
						&& c.getDeonica().getDoStanice().equals(mestoIzlaska))
					cena = c;
			}
			TipNaplate t = TipNaplate.valueOf(niz[6]);
			Naplata n = new Naplata();
			if (t.equals(TipNaplate.ELEKTRONSKI)) {
				Tag tag = new Tag();
				for (Tag tagLocal : listaTagova) {
					if (String.valueOf(tagLocal.getId()).equals(niz[7]))
						tag = tagLocal;
				}
				n = new ElektronskaNaplata(vremeIzlaska, vremeUlaska, mestoUlaska, mestoIzlaska, tabliceVozila,
						prosecnaBrzina, cena, tag);
			} else if (t.equals(TipNaplate.FIZICKI)) {
				TipVozila tipVozila = TipVozila.valueOf(niz[7]);
				n = new FizickaNaplata(vremeUlaska, vremeIzlaska, mestoUlaska, mestoIzlaska, tabliceVozila,
						prosecnaBrzina, cena, tipVozila);
			}
			listaNaplata.add(n);
		}
		br.close();
	}

	public void upisiUFajl() throws IOException {
		String str = "";
		for (Korisnik korisnik : this.listaKorisnika) {
			str += korisnik.getId() + "|" + korisnik.getIme() + "|" + korisnik.getPrezime() + "|"
					+ korisnik.getKredencijali().getKorisnicko_ime() + "|" + korisnik.getKredencijali().getLozinka()
					+ "|" + korisnik.getClass().getSimpleName() + "\n";
		}
		str = str.substring(0, str.length() - "\n".length());
		BufferedWriter writer = new BufferedWriter(new FileWriter("..\\SIMS2022\\src\\Korisnici.txt"));
		writer.write(str);

		writer.close();

		str = "";
		for (NaplatnaStanica ns : this.listaNaplatnihStanica) {
			str += ns.getNaziv() + "|" + ns.getMesto() + "|" + ns.getNaplatnaMestaId() + "|"
					+ ns.getSefStanice().getId() + "\n";
		}
		str = str.substring(0, str.length() - "\n".length());
		writer = new BufferedWriter(new FileWriter("..\\SIMS2022\\src\\NaplatnaStanica.txt"));
		writer.write(str);

		writer.close();

		str = "";
		for (NaplatnoMesto nm : this.listaNaplatnihMesta) {
			str += nm.getId() + "|" + nm.getTipNaplate().toString() + "|" + nm.getTipMesta().toString() + "|"
					+ nm.getBrojKucice() + "|" + nm.getUredjaji() + "|" + nm.getReferent().getId() + "\n";
		}
		str = str.substring(0, str.length() - "\n".length());
		writer = new BufferedWriter(new FileWriter("..\\SIMS2022\\src\\NaplatnoMesto.txt"));
		writer.write(str);

		writer.close();
		
		str = "";
		for (Uredjaj u : this.listaUredjaja) {
			str += u.getId() + "|" + u.getClass().getSimpleName() + "|" + u.isEnabled() + "\n";
		}
		str = str.substring(0, str.length() - "\n".length());
		writer = new BufferedWriter(new FileWriter("..\\SIMS2022\\src\\Uredjaj.txt"));
		writer.write(str);

		writer.close();

		str = "";
		for (Cenovnik c : this.listaCenovnika) {
			str += c.isAktivan() + "|" + c.getPocetakVazenja().format(datumDTF) + "|"
					+ c.getKrajVazenja().format(datumDTF) + "|" + c.getCeneString() + "\n";
		}
		str = str.substring(0, str.length() - "\n".length());
		writer = new BufferedWriter(new FileWriter("..\\SIMS2022\\src\\Cenovnik.txt"));
		writer.write(str);

		writer.close();

		str = "";
		for (Cena cena : this.listaCena) {
			str += cena.getId() + "|" + cena.getIznos() + "|" + cena.getValuta().toString() + "|" + cena.getTipVozila()
					+ "|" + cena.getDeonicaString() + "\n";
		}
		str = str.substring(0, str.length() - "\n".length());
		writer = new BufferedWriter(new FileWriter("..\\SIMS2022\\src\\Cena.txt"));
		writer.write(str);

		writer.close();

		str = "";
		for (Deonica d : this.listaDeonica) {
			str += d.getOdStanice().getNaziv() + "|" + d.getDoStanice().getNaziv() + "\n";
		}
		str = str.substring(0, str.length() - "\n".length());
		writer = new BufferedWriter(new FileWriter("..\\SIMS2022\\src\\Deonice.txt"));
		writer.write(str);

		writer.close();

		str = "";
		for (Tag t : this.listaTagova) {
			str += t.getId() + "|" + t.getIme() + "|" + t.getPrezime() + "|" + t.getTipVozila().toString() + "|"
					+ t.getKolicinaNovca() + "\n";
		}
		str = str.substring(0, str.length() - "\n".length());
		writer = new BufferedWriter(new FileWriter("..\\SIMS2022\\src\\Tag.txt"));
		writer.write(str);

		writer.close();

		str = "";
		for (Naplata n : this.listaNaplata) {
			str += n.getVremeUlaska().format(vremeDTF) + "|" + n.getVremeIzlaska().format(vremeDTF) + "|"
					+ n.getMestoUlaska().getNaziv() + "|" + n.getMestoIzlaska().getNaziv() + "|" + n.getTabliceVozila()
					+ "|" + n.getProsecnaBrzina();
			if (n.getClass().getSimpleName().equals("ElektronskaNaplata")) {
				str += "|" + TipNaplate.ELEKTRONSKI.toString();

			}
			if (n.getClass().getSimpleName().equals("FizickaNaplata")) {
				str += "|" + TipNaplate.FIZICKI.toString();
			}
			str += "\n";
		}
		str = str.substring(0, str.length() - "\n".length());
		writer = new BufferedWriter(new FileWriter("..\\SIMS2022\\src\\Naplata.txt"));
		writer.write(str);

		writer.close();

		System.out.println("USPESAN UPIS");
	}

//	public ArrayList<Tag> listaTagova = new ArrayList<Tag>();
//	public ArrayList<Naplata> listaNaplata = new ArrayList<Naplata>();

	@Override
	public String toString() {
		return "Ucitavanje [listaKorisnika=" + listaKorisnika + "]";
	}
}

package Model;

public class Korisnik {

	private int id;
	private String ime;
	private String prezime;
	private Kredencijali kredencijali;

	public Korisnik() {

	}

	public Korisnik(int id, String ime, String prezime, Kredencijali kredencijali) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.kredencijali = kredencijali;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Kredencijali getKredencijali() {
		return kredencijali;
	}

	public void setKredencijali(Kredencijali kredencijali) {
		this.kredencijali = kredencijali;
	}

	@Override
	public String toString() {
		return "Korisnik [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", kredencijali=" + kredencijali + "]";
	}

}

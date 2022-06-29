package Model;

public class Kredencijali {

	private String korisnicko_ime;
	private String lozinka;

	public Kredencijali() {
	}

	public Kredencijali(String korisnicko_ime, String lozinka) {
		this.korisnicko_ime = korisnicko_ime;
		this.lozinka = lozinka;
	}

	public String getKorisnicko_ime() {
		return korisnicko_ime;
	}

	public void setKorisnicko_ime(String korisnicko_ime) {
		this.korisnicko_ime = korisnicko_ime;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	@Override
	public String toString() {
		return "Kredencijali [korisnicko_ime=" + korisnicko_ime + ", lozinka=" + lozinka + "]";
	}

}

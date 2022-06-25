
public  class Korisnik {
	
	public  int id;
	public String ime;
	public String prezime;
	public String korisnicko_ime;
	public String lozinka;
	
	
	
	public Korisnik() {
		
	}



	public Korisnik(int id, String ime, String prezime, String korisnicko_ime, String lozinka) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.korisnicko_ime = korisnicko_ime;
		this.lozinka = lozinka;
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
		return "Korisnik [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", korisnicko_ime=" + korisnicko_ime
				+ ", lozinka=" + lozinka + "]";
	}
	
	

}

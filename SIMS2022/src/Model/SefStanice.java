package Model;

public class SefStanice extends Korisnik {

	public SefStanice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SefStanice(int id, String ime, String prezime, Kredencijali kredencijali) {
		super(id, ime, prezime, kredencijali);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SefStanice [" + super.toString() + "]";
	}

	
}

package Model;

public class Administrator extends Korisnik {

	public Administrator() {
		super();
	}

	public Administrator(int id, String ime, String prezime, Kredencijali kredencijali) {
		super(id, ime, prezime, kredencijali);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Administrator [" + super.toString() + "]";
	}

}

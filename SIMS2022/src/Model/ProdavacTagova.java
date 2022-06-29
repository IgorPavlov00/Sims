package Model;

public class ProdavacTagova extends Korisnik {

	public ProdavacTagova() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdavacTagova(int id, String ime, String prezime, Kredencijali kredencijali) {
		super(id, ime, prezime, kredencijali);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProdavacTagova [" + super.toString() + "]";
	}

}

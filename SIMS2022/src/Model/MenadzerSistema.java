package Model;

public class MenadzerSistema extends Korisnik {

	public MenadzerSistema() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenadzerSistema(int id, String ime, String prezime, Kredencijali kredencijali) {
		super(id, ime, prezime, kredencijali);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MenadzerSistema [" + super.toString() + "]";
	}

}

package Model;

public class ReferentNaplate extends Korisnik{

	public ReferentNaplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReferentNaplate(int id, String ime, String prezime, Kredencijali kredencijali) {
		super(id, ime, prezime, kredencijali);
		// TODO Auto-generated constructor stub
	}

	public ReferentNaplate(Korisnik k) {
		super(k.getId(), k.getIme(), k.getPrezime(), k.getKredencijali());
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "ReferentNaplate [" + super.toString() + "]";
	}

}

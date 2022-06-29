package Model;

import java.time.LocalDate;
import java.util.List;

public class Cenovnik {
	private boolean aktivan;
	private LocalDate pocetakVazenja;
	private LocalDate krajVazenja;
	private List<Cena> cene;

	public Cenovnik() {
	}

	public Cenovnik(boolean aktivan, LocalDate pocetakVazenja, LocalDate krajVazenja) {
		this.aktivan = aktivan;
		this.pocetakVazenja = pocetakVazenja;
		this.krajVazenja = krajVazenja;
	}

	public Cenovnik(boolean aktivan, LocalDate pocetakVazenja, LocalDate krajVazenja, List<Cena> cene) {
		this.aktivan = aktivan;
		this.pocetakVazenja = pocetakVazenja;
		this.krajVazenja = krajVazenja;
		this.cene = cene;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public LocalDate getPocetakVazenja() {
		return pocetakVazenja;
	}

	public void setPocetakVazenja(LocalDate pocetakVazenja) {
		this.pocetakVazenja = pocetakVazenja;
	}

	public LocalDate getKrajVazenja() {
		return krajVazenja;
	}

	public void setKrajVazenja(LocalDate krajVazenja) {
		this.krajVazenja = krajVazenja;
	}

	public List<Cena> getCene() {
		return cene;
	}

	public void setCene(List<Cena> cene) {
		this.cene = cene;
	}

	@Override
	public String toString() {
		return "Cenovnik [aktivan=" + aktivan + ", pocetakVazenja=" + pocetakVazenja + ", krajVazenja=" + krajVazenja
				+ ", cene=" + cene + "]";
	}

}

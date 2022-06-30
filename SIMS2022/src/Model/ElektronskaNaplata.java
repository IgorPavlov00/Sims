package Model;

import java.time.LocalTime;

public class ElektronskaNaplata extends Naplata {

	private Tag tag;

	public ElektronskaNaplata() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElektronskaNaplata(LocalTime vremeUlaska, NaplatnaStanica mestoUlaska, String tabliceVozila,
			float prosecnaBrzina, Tag tag) {
		super(vremeUlaska, mestoUlaska, tabliceVozila, prosecnaBrzina);
		this.tag = tag;
	}

	public ElektronskaNaplata(LocalTime vremeUlaska, LocalTime vremeIzlaska, NaplatnaStanica mestoUlaska,
			NaplatnaStanica mestoIzlaska, String tabliceVozila, float prosecnaBrzina, Cena cena, Tag tag) {
		super(vremeUlaska, vremeIzlaska, mestoUlaska, mestoIzlaska, tabliceVozila, prosecnaBrzina, cena);
		this.tag = tag;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "ElektronskaNaplata [tag=" + tag + ", " + super.toString() + "]";
	}

}

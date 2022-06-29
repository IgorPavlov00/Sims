package Model;

import java.time.LocalDate;

public class ElektronskaNaplata extends Naplata {

	private Tag tag;
	
	public ElektronskaNaplata() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElektronskaNaplata(LocalDate vremeUlaska, NaplatnaStanica mestoUlaska, String tabliceVozila,
			float prosecnaBrzina) {
		super(vremeUlaska, mestoUlaska, tabliceVozila, prosecnaBrzina);
		// TODO Auto-generated constructor stub
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

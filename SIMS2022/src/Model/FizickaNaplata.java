package Model;

import java.time.LocalDate;

import Model.Enums.TipVozila;

public class FizickaNaplata extends Naplata {
	private TipVozila tipVozila;

	public FizickaNaplata() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FizickaNaplata(LocalDate vremeUlaska, NaplatnaStanica mestoUlaska, String tabliceVozila,
			float prosecnaBrzina) {
		super(vremeUlaska, mestoUlaska, tabliceVozila, prosecnaBrzina);
		// TODO Auto-generated constructor stub
	}

	public TipVozila getTipVozila() {
		return tipVozila;
	}

	public void setTipVozila(TipVozila tipVozila) {
		this.tipVozila = tipVozila;
	}

	@Override
	public String toString() {
		return "FizickaNaplata [tipVozila=" + tipVozila + ", " + super.toString() + "]";
	}

}

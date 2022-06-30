package Model;

import java.time.LocalTime;

import Model.Enums.TipVozila;

public class FizickaNaplata extends Naplata {
	private TipVozila tipVozila;

	public FizickaNaplata() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FizickaNaplata(LocalTime vremeUlaska, NaplatnaStanica mestoUlaska, String tabliceVozila,
			float prosecnaBrzina, TipVozila tipVozila) {
		super(vremeUlaska, mestoUlaska, tabliceVozila, prosecnaBrzina);
		this.tipVozila = tipVozila;
	}

	public FizickaNaplata(LocalTime vremeUlaska, LocalTime vremeIzlaska, NaplatnaStanica mestoUlaska,
			NaplatnaStanica mestoIzlaska, String tabliceVozila, float prosecnaBrzina, Cena cena, TipVozila tipVozila) {
		super(vremeUlaska, vremeIzlaska, mestoUlaska, mestoIzlaska, tabliceVozila, prosecnaBrzina, cena);
		this.tipVozila = tipVozila;
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

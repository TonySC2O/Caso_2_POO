package Control;
import Objetos.Edificio;

public class ControlEdificio {
	private Edificio edificio;
	private String fuenteEnergia;
	private int[] consumosxHora;
	private boolean conEnergia;
	
	public ControlEdificio(Edificio pEdificio, String pFuenteEnergia, int[] pConsumosxHora) {
		this.edificio = pEdificio;
		this.fuenteEnergia = pFuenteEnergia;
		this.consumosxHora = pConsumosxHora;
		this.conEnergia = false;
	}
	
	public int CalcularConsumo(int pHora) {
		
		int consumo = 0;
		if(pHora >= 21 || pHora <= 5) {
			consumo = consumosxHora[4];
		}else if(pHora > 5 && pHora <= 9){
			consumo = consumosxHora[0];
		}else if(pHora > 9 && pHora <= 13){
			consumo = consumosxHora[1];
		}else if(pHora > 13 && pHora <= 17){
			consumo = consumosxHora[2];
		}else if(pHora > 17 && pHora <= 21){
			consumo = consumosxHora[3];
		}
		
		consumo = consumo + (-50 + (int)(Math.random() * ((50 - -50) + 1)));
		edificio.setGastoEnergia(consumo);
		return consumo;
	}
	
	public boolean CalcularEstabilidad() {
		if(CalcularMedia() <= 0 && edificio.getEnergiaRecibida() != edificio.getGastoEnergia()) {
			conEnergia = false;
			return conEnergia;
		}
		conEnergia = true;
		return conEnergia;
	}
	
	public int CalcularMedia() {
		return edificio.getEnergiaRecibida() - edificio.getGastoEnergia();
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	public String getFuenteEnergia() {
		return fuenteEnergia;
	}

	public void setFuenteEnergia(String fuenteEnergia) {
		this.fuenteEnergia = fuenteEnergia;
	}

	public int[] getConsumosxHora() {
		return consumosxHora;
	}

	public void setConsumosxHora(int[] consumosxHora) {
		this.consumosxHora = consumosxHora;
	}

	public boolean isConEnergia() {
		return conEnergia;
	}

	public void setConEnergia(boolean conEnergia) {
		this.conEnergia = conEnergia;
	}
	
}

package Control;
import Objetos.Edificio;

public class ControlEdificio {
	Edificio edificio;
	String fuenteEnergia;
	int[] consumosxHora;
	
	public ControlEdificio(Edificio pEdificio, String pFuenteEnergia, int[] pConsumosxHora) {
		this.edificio = pEdificio;
		this.fuenteEnergia = pFuenteEnergia;
		this.consumosxHora = pConsumosxHora;
	}
	
	public int CalcularConsumo(int pHora) {
		int consumo = 0;
		
		return consumo;
	}
	
	public boolean CalcularEstabilidad(int pEnergiaTotal) {
		return false;
	}
	
	public int CalcularMedia(int pEnergiaTotal) {
		return 0;
	}
	
}

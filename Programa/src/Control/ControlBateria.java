package Control;
import Objetos.BateriaSolar;

public class ControlBateria {
	BateriaSolar bateria;
	boolean usarBateria;
	
	public ControlBateria(BateriaSolar pBateria, boolean pUsarBateria) {
		this.bateria = pBateria;
		this.usarBateria = pUsarBateria;
	}
	
	public int CalcularFlujoEnergia(int pProduccionTotal, int pGastoTotal) {
		int flujo = 0;
		
		return flujo;
	}
	
	public int CalcularDurabilidad(int pGastoTotal) {
		int durabilidad = 0; // En horas
		
		return durabilidad;
	}

	public BateriaSolar getBateria() {
		return bateria;
	}

	public void setBateria(BateriaSolar bateria) {
		this.bateria = bateria;
	}

	public boolean isUsarBateria() {
		return usarBateria;
	}

	public void setUsarBateria(boolean usarBateria) {
		this.usarBateria = usarBateria;
	}
	
}

package Control;
import Objetos.BateriaSolar;

public class ControlBateria {
	private BateriaSolar bateria;
	private boolean usarBateria;
	
	public ControlBateria(BateriaSolar pBateria, boolean pUsarBateria) {
		this.bateria = pBateria;
		this.usarBateria = pUsarBateria;
	}
	
	public int CalcularFlujoEnergia(int pDiferenciaEnergia) {
		if(pDiferenciaEnergia <= 0) {
			bateria.setFlujoEnergia(0);
			return 0;
		}
		
		bateria.setFlujoEnergia(pDiferenciaEnergia);
		return pDiferenciaEnergia;
	}
	
	public int CalcularDurabilidad(int pGastoTotal) {
		int durabilidad = (int) (bateria.getEnergiaAlmacenada() / pGastoTotal); // En horas
		bateria.setDurabilidad(durabilidad);
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

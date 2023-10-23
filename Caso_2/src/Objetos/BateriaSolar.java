package Objetos;

public class BateriaSolar {
	private int energiaAlmacenada;
	private int flujoEnergia;
	private int capacidad;
	private int durabilidad;
	
	public BateriaSolar(int pEnergiaAlmacenada, int pFlujoEnergia, int pCapacidad, int pDurabilidad) {
		this.energiaAlmacenada = pEnergiaAlmacenada;
		this.flujoEnergia = pFlujoEnergia;
		this.capacidad = pCapacidad;
		this.durabilidad = pDurabilidad;
	}
	public int getEnergiaAlmacenada() {
		return energiaAlmacenada;
	}
	public void setEnergiaAlmacenada(int energiaAlmacenada) {
		this.energiaAlmacenada = energiaAlmacenada;
	}
	public int getFlujoEnergia() {
		return flujoEnergia;
	}
	public void setFlujoEnergia(int flujoEnergia) {
		this.flujoEnergia = flujoEnergia;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getDurabilidad() {
		return durabilidad;
	}
	public void setDurabilidad(int durabilidad) {
		this.durabilidad = durabilidad;
	}
	
	
}

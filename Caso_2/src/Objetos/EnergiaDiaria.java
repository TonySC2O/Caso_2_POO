package Objetos;

public class EnergiaDiaria {
	int GastoEnergia;
	int ProduccionEnergia;
	int ConsumoBateria;
	String Fecha;
	
	public EnergiaDiaria(int pGastoEnergia, int pProduccionEnergia, int pConsumoBateria, String pFecha) {
		this.GastoEnergia = pGastoEnergia;
		this.ProduccionEnergia = pProduccionEnergia;
		this.ConsumoBateria = pConsumoBateria;
		this.Fecha = pFecha;
	}
	public int getGastoEnergia() {
		return GastoEnergia;
	}
	public void setGastoEnergia(int gastoEnergia) {
		GastoEnergia = gastoEnergia;
	}
	public int getProduccionEnergia() {
		return ProduccionEnergia;
	}
	public void setProduccionEnergia(int produccionEnergia) {
		ProduccionEnergia = produccionEnergia;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public int getConsumoBateria() {
		return ConsumoBateria;
	}
	public void setConsumoBateria(int consumoBateria) {
		ConsumoBateria = consumoBateria;
	}
	
}

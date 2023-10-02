package Objetos;

public class EnergiaDiaria {
	int GastoEnergia;
	int ProduccionEnergia;
	String Fecha;
	
	public EnergiaDiaria(int pGastoEnergia, int pProduccionEnergia, String pFecha) {
		GastoEnergia = pGastoEnergia;
		ProduccionEnergia = pProduccionEnergia;
		Fecha = pFecha;
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
	
	
}

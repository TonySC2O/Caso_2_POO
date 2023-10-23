package Objetos;

import java.util.Date;

public class EnergiaDiaria {
	private int GastoEnergia;
	private int ProduccionEnergia;
	private int ConsumoBateria;
	private Date Fecha;
	
	public EnergiaDiaria(int pGastoEnergia, int pProduccionEnergia, int pConsumoBateria, Date pFecha) {
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
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public int getConsumoBateria() {
		return ConsumoBateria;
	}
	public void setConsumoBateria(int consumoBateria) {
		ConsumoBateria = consumoBateria;
	}
	
}

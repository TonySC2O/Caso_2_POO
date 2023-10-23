package Objetos;

public class Edificio {
	private int gastoEnergia;
	private int energiaRecibida;
	private int media;
	
	public Edificio(int pGastoEnergia, int pEnergiaRecibida, int pMedia) {
		this.gastoEnergia = pGastoEnergia;
		this.energiaRecibida = pEnergiaRecibida;
		this.media = pMedia;
	}

	public int getGastoEnergia() {
		return gastoEnergia;
	}

	public void setGastoEnergia(int gastoEnergia) {
		this.gastoEnergia = gastoEnergia;
	}

	public int getEnergiaRecibida() {
		return energiaRecibida;
	}

	public void setEnergiaRecibida(int energiaRecibida) {
		this.energiaRecibida = energiaRecibida;
	}

	public int getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}
	
}

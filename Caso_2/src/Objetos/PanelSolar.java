package Objetos;

public class PanelSolar {
	private int energiaGenerada;
	private int areaPanel;
	private double eficiencia = 0.20;
	
	public PanelSolar(int pEnergiaGenerada, int pAreaPanel, double pEficiencia){
		this.energiaGenerada = pEnergiaGenerada;
		this.areaPanel = pAreaPanel;
		this.eficiencia = pEficiencia;
	}

	public int getEnergiaGenerada() {
		return energiaGenerada;
	}

	public void setEnergiaGenerada(int pEnergiaGenerada) {
		energiaGenerada = pEnergiaGenerada;
	}

	public int getAreaPanel() {
		return areaPanel;
	}

	public void setAreaPanel(int areaPanel) {
		this.areaPanel = areaPanel;
	}

	public double getEficiencia() {
		return eficiencia;
	}

	public void setEficiencia(double eficiencia) {
		this.eficiencia = eficiencia;
	}
	
}

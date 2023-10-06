package Control;
import Objetos.PanelSolar;

public class ControlPanelSolar {
	private PanelSolar[] paneles;
	private int cantidadPaneles;
	private boolean activos;
	
	public ControlPanelSolar(PanelSolar[] pPaneles, int pCantidadPaneles, boolean pActivos) {
		this.paneles = pPaneles;
		this.cantidadPaneles = pCantidadPaneles;
		this.activos = pActivos;
	}

	public int RadiacionAProduccion(int pRadiacion, int pAreaPanel, double pEficienciaPanel) {
		return (int) (pRadiacion * pAreaPanel * pEficienciaPanel * 0.35);
	}
	
	public int CalcularProduccionTotal() {
		
		if(!activos) {
			return 0;
		}
		
		int produccion = 0;
		
		for(int i = 0; i < paneles.length; i++) {
			produccion = produccion + paneles[i].getEnergiaGenerada();
		}
		
		return produccion;
	}
	
	public int CalcularProduccionEspecifica(int pIndex) {

		if(!activos) {
			return 0;
		}
		
		return paneles[pIndex].getEnergiaGenerada();
	}
	
	public void AsignarProduccion(int pRadiacion) {
		for(int i = 0; i < paneles.length; i++) {
			paneles[i].setEnergiaGenerada(RadiacionAProduccion(pRadiacion, paneles[i].getAreaPanel(), paneles[i].getEficiencia()));
		}
	}
	
	public PanelSolar[] getPaneles() {
		return paneles;
	}
	public void setPaneles(PanelSolar[] paneles) {
		this.paneles = paneles;
	}
	public int getCantidadPaneles() {
		return cantidadPaneles;
	}
	public void setCantidadPaneles(int cantidadPaneles) {
		this.cantidadPaneles = cantidadPaneles;
	}
	public boolean isActivos() {
		return activos;
	}
	public void setActivos(boolean activos) {
		this.activos = activos;
	}
	
	
}

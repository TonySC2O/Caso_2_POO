package Control;
import Objetos.PanelSolar;

public class ControlPanelSolar {
	PanelSolar[] paneles;
	int cantidadPaneles;
	boolean activos;
	
	public ControlPanelSolar(PanelSolar[] pPaneles, int pCantidadPaneles, boolean pActivos) {
		this.paneles = pPaneles;
		this.cantidadPaneles = pCantidadPaneles;
		this.activos = pActivos;
	}
	
	public int CalcularProduccionTotal(int pRadiacion) {
		int produccion = 0;
		
		
		return produccion;
	}
	
	public int CalcularProduccionEspecifica(int pRadiacion) {
		int produccion = 0;
		
		
		return produccion;
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

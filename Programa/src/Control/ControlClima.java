package Control;

public class ControlClima {
	int radiacion;
	String[] estadosClima;
	String climaActual;
	
	public ControlClima(int radiacion, String[] estadosClima, String climaActual) {
		this.radiacion = radiacion;
		this.estadosClima = estadosClima;
		this.climaActual = climaActual;
	}
	
	public void CambiarClima(String pClima) {
		
	}
	
	public int RadiacionAProduccion() {
		return 0;
	}
	
	public String CalcularClima() {
		return "";
	}

	public int getRadiacion() {
		return radiacion;
	}

	public void setRadiacion(int radiacion) {
		this.radiacion = radiacion;
	}

	public String[] getEstadosClima() {
		return estadosClima;
	}

	public void setEstadosClima(String[] estadosClima) {
		this.estadosClima = estadosClima;
	}
	
}

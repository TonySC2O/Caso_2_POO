package Control;

public class ControlClima {
	private int[] radiacionxClima;
	private String[] estadosClima;
	private String climaActual;
	private int radiacionActual;
	
	public ControlClima(int[] radiacionxClima, String[] estadosClima, String climaActual) {
		this.radiacionxClima = radiacionxClima;
		this.estadosClima = estadosClima;
		this.climaActual = climaActual;
	}
	
	public String CalcularClima(int pTiempo) {
		
		if(pTiempo >= 17 && pTiempo < 19) {
			return "Anochecer";
		}
		if(pTiempo >= 19 || pTiempo < 5) {
			return "Noche";
		}
		
		return estadosClima[(int)(Math.random() * (2 + 1))];
	}
	
	public int CalcularRadiacion() {
		
		if(climaActual.equals("Noche")) {
			return 0;
		}
		
		int index = 0;
		
		if(climaActual != "Anochecer") {
			for(int i = 0; i < estadosClima.length; i++) {
				if(estadosClima[i].equals(climaActual)) {
					index = i;
					break;
				}
			}
		}else {
			index = 3;
		}
		
		radiacionActual = radiacionxClima[index] + (-50 + (int)(Math.random() * ((50 - -50) + 1)));
		
		return radiacionActual;
	}
	
	

	public int getRadiacionActual() {
		return radiacionActual;
	}

	public void setRadiacionActual(int radiacionActual) {
		this.radiacionActual = radiacionActual;
	}

	public int[] getRadiacionxClima() {
		return radiacionxClima;
	}

	public void setRadiacionxClima(int[] radiacionxClima) {
		this.radiacionxClima = radiacionxClima;
	}

	public String[] getEstadosClima() {
		return estadosClima;
	}

	public void setEstadosClima(String[] estadosClima) {
		this.estadosClima = estadosClima;
	}

	public String getClimaActual() {
		return climaActual;
	}

	public void CambiarClima(String pClimaActual) {
		this.climaActual = pClimaActual;
	}
	
}

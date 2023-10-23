package Manager;

import java.util.Date;

import Control.*;
import Objetos.*;
import Soporte.Clock;
import Soporte.Util;

public class ManagerControl {
	
	private ControlBateria controlBateria;
	private ControlClima controlClima;
	private ControlEdificio controlEdificio;
	private ControlEnergia controlEnergia;
	private ControlPanelSolar controlPanel;
	
	private int ConsumoTotalDiario;
	private int ProduccionTotalDiaria;
	private int ConsumoTotalBateria;
	
	public ManagerControl(ControlBateria pCBateria, ControlClima pCClima, ControlEdificio pCEdificio, ControlEnergia pCEnergia, ControlPanelSolar pCPanel) {
		
		this.controlBateria = pCBateria;
		this.controlClima = pCClima;
		this.controlEdificio = pCEdificio;
		this.controlEnergia = pCEnergia;
		this.controlPanel = pCPanel;
	}
	
	//=====================================Paneles==========================================================================
	
	public int VerificarProduccion() {
		
		int produccion = controlPanel.CalcularProduccionTotal();
		Util.report("La producción total de los paneles es de: " + Integer.toString(produccion) + " kWh", produccion, "Produccion");
		return produccion;
	}
	
	public void VerificarActividad() {
		
		String clima = controlClima.CalcularClima(Main.main.threadControl.getTiempo());
		String respuesta = "Los paneles están innactivos";
		if(clima != "Noche") {
			if(controlPanel.isActivos()) {
				respuesta = "Los paneles están activos";
			}
		}
		Util.report(respuesta, controlPanel.isActivos(), "PanelActivo");
	}
	
	
	
	//=====================================Bateria==========================================================================
	
	
	
	public void VerificarFlujo() {
		int flujo = controlBateria.CalcularFlujoEnergia(controlEdificio.CalcularMedia());
		Util.report("El flujo de energía que entra a la batería es de " + Integer.toString(flujo) + " kWh", flujo, "Flujo");
	}
	
	public int VerificarDurabilidad() {
		int durabilidad = controlBateria.CalcularDurabilidad(controlEdificio.getEdificio().getGastoEnergia());
		Util.report("La bateria puede alimentar el edificio aproximadamente " + Integer.toString(durabilidad) + " horas", durabilidad, "Durabilidad");
		return durabilidad;
	}
	
	public void AlimentarBateria() {
		
		int energia = 0;
		if(controlEdificio.CalcularEstabilidad()) {
			
			energia = controlBateria.getBateria().getEnergiaAlmacenada() + controlBateria.getBateria().getFlujoEnergia();
			controlBateria.getBateria().setEnergiaAlmacenada(energia);
			if(controlBateria.getBateria().getEnergiaAlmacenada() > controlBateria.getBateria().getCapacidad()) {
				controlBateria.getBateria().setEnergiaAlmacenada(controlBateria.getBateria().getCapacidad());
			}
		}
		
		Util.report("Se han almacenado " + Integer.toString(energia) + " kW a la batería", energia, "EnergiaGuardada");
	}
	
	public int VerificarEnergiaBateria() {
		
		int energia = controlBateria.getBateria().getEnergiaAlmacenada();
		Util.report("La batería tiene almacenados " + Integer.toString(energia) + " kW", energia, "EnergiaAlmacenada");
		return energia;
	}
	
	public int ConsumirBateria() {
		
		int energia = controlBateria.getBateria().getEnergiaAlmacenada();		

		if(energia == 0) {
			Util.report("La batería está vacia", null, "BateriaAlmacenada");
			return 0;
		}
		
		int gasto = controlEdificio.getEdificio().getGastoEnergia();
		
		int energiaRestante = energia - gasto;
		
		if(energiaRestante < 0) {
			
			energiaRestante = 0;
			gasto = energia;
			
		}
		
		controlBateria.getBateria().setEnergiaAlmacenada(energiaRestante);
		Util.report("Se han consumido " + Integer.toString(gasto) + " kW de la batería", null, "BateriaAlmacenada");
		return gasto;
	}
	
	
	
	//=====================================Edificio==========================================================================
	
	
	
	public void ConsumirEnergia() {
		
		int consumo = controlEdificio.CalcularConsumo(Main.main.threadControl.getTiempo());
		Util.report("El edificio ahora consume " + Integer.toString(consumo) + " kWh", consumo, "Consumo");
	}
	
	public boolean VerificarEstabilidad() {
		
		boolean estable = controlEdificio.CalcularEstabilidad();
		
		if(estable) {
			controlEdificio.setConEnergia(true);
			Util.report("La energía es suficiente", estable, "Estabilidad");
			return true;
		}
		
		if (Main.main.threadControl.getTiempo() >= 19 || Main.main.threadControl.getTiempo() < 5) {
			controlEdificio.setConEnergia(false);
			Util.report("Energia de batería acabada", estable, "Estabilidad");
			return false;
		}
		
		String fuente;
		if (controlPanel.isActivos()) {
			fuente = "Bateria";
		}else {
			fuente = "Paneles";
		}
		
		CambiarFuenteEnergia(fuente, "");
		AlimentarEdificio();
		
		estable = controlEdificio.CalcularEstabilidad();
		
		if(estable) {
			controlEdificio.setConEnergia(true);
			Util.report("La energía es suficiente", estable, "Estabilidad");
			return true;
		}
		
		controlEdificio.setConEnergia(false);
		Util.report("Energia ineficiente", estable, "Estabilidad");
		return false;
	}
	
	public int VerificarConsumo() {
		
		int consumo = controlEdificio.getEdificio().getGastoEnergia();
		Util.report("Se están consumiendo " + Integer.toString(consumo) + " kWh", null, "Consumo");
		return consumo;
	}
	
	public void AlimentarEdificio() {
		
		int produccion = 0;
		
		if (!controlBateria.isUsarBateria()) {
			produccion = controlPanel.CalcularProduccionTotal();
		}else {
			produccion = ConsumirBateria();
		}
		
		controlEdificio.getEdificio().setEnergiaRecibida(produccion);
		Util.report("El edificio ahora recibe " + Integer.toString(produccion) + " kWh", produccion, "Produccion");
	}
	
	
	
	//=====================================Clima==========================================================================

	
	
	public void VerificarClima() {
		
		String clima = controlClima.CalcularClima(Main.main.threadControl.getTiempo());
		controlClima.CambiarClima(clima);
		Util.report("El Clima actual es: " + clima, clima, "Clima");
	}
	
	public void EnviarRadiacion() {
		
		int radiacion = controlClima.CalcularRadiacion();
		controlPanel.AsignarProduccion(radiacion);
		Util.report("La radiación actual es de: " + Integer.toString(radiacion) + " W/m2", radiacion, "Radiacion");
	}
	
	//Extras
	
	public void CambiarFuenteEnergia(String pFuente, String pNull) {
		
		String fuente;
		if(pFuente.equals("Bateria")) {
			controlBateria.setUsarBateria(true);
			controlEdificio.setFuenteEnergia("Batería");
			controlPanel.setActivos(false);
			fuente = "la batería";
		}else {
			controlBateria.setUsarBateria(false);
			controlEdificio.setFuenteEnergia("Paneles");
			controlPanel.setActivos(true);
			fuente = "los paneles";
		}
		
		
		if (pNull != null) {
			Util.report("Se ha cambiado la fuente de energia a " + fuente, null, "");
		}
	}
	
	public void VerificarFuenteEnergia() {
		
		if(Main.main.threadControl.getTiempo() >= 19 || Main.main.threadControl.getTiempo() < 5) {
			if(!controlBateria.isUsarBateria()) {
				CambiarFuenteEnergia("Bateria", null);
			}
		}else {
			if(controlBateria.isUsarBateria()) {
				CambiarFuenteEnergia("Paneles", null);
			}
		}
		
		if(controlBateria.isUsarBateria()) {
			Util.report("Se está utilizando la bateria como fuente de energía", "Bateria", "Fuente");
		}else {
			Util.report("Se están utilizando los paneles como fuente de energía", "Paneles", "Fuente");
		}
	}
	
	
	
	//=====================================Registro Energia==========================================================================
	
	
	
	public void GuardarRegistroHora() {
		
		int consumo = 0;
		int produccion = 0;
		int consumoBateria = 0;
		
		consumo = controlEdificio.getEdificio().getGastoEnergia();
		
		
		if(controlBateria.isUsarBateria() && controlEdificio.isConEnergia()) {
			consumoBateria = controlEdificio.getEdificio().getGastoEnergia();
		}else if(!controlBateria.isUsarBateria()){
			produccion = controlPanel.CalcularProduccionTotal();
		}
		
		ConsumoTotalDiario = ConsumoTotalDiario + consumo;
		ProduccionTotalDiaria = ProduccionTotalDiaria + produccion;
		ConsumoTotalBateria = ConsumoTotalBateria + consumoBateria;
	}
	
	public void GuardarRegistroDiario() {
		Date fecha = Main.main.threadControl.getTime();

		long tiempoFecha = fecha.getTime();

		Date fechaGuardada = new Date(tiempoFecha);
		
		Util.report(fechaGuardada + "\n"
					+ "Consumo Total Diario: " + Integer.toString(ConsumoTotalDiario) + "\n"
					+ "Producción Total Diaria: " + Integer.toString(ProduccionTotalDiaria) + "\n"
					+ "Consumo Total Batería: " + Integer.toString(ConsumoTotalBateria) + "\n", null, "");
		

		EnergiaDiaria registro = new EnergiaDiaria(ConsumoTotalDiario, ProduccionTotalDiaria, ConsumoTotalBateria, fechaGuardada);
		controlEnergia.AñadirRegistro(registro);
		
		ConsumoTotalDiario = 0;
		ProduccionTotalDiaria = 0;
		ConsumoTotalBateria = 0;
	}
}

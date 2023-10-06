package Manager;

import Control.*;

public class TaskManager implements ITask{
	
	ManagerControl manager;
	
	public TaskManager(ControlBateria pCBateria, ControlClima pCClima, ControlEdificio pCEdificio, ControlEnergia pCEnergia, ControlPanelSolar pCPanel) {
		manager = new ManagerControl(pCBateria, pCClima, pCEdificio, pCEnergia, pCPanel);
	}
	
	@Override
	public void execute(Action pAction) {
		
		//Paneles
		
		if (pAction==Action.verificarProduccion) {
			manager.VerificarProduccion();
		}

		if (pAction==Action.verificarActividad) {
			manager.VerificarActividad();
		}
		
		//Bateria

		if (pAction==Action.verificarFlujo) {
			manager.VerificarFlujo();
		}

		if (pAction==Action.verificarDurabilidad) {
			manager.VerificarDurabilidad();
		}

		if (pAction==Action.verificarEnergiaBateria) {
			manager.VerificarEnergiaBateria();
		}

		if (pAction==Action.alimentarBateria) {
			manager.AlimentarBateria();
		}
		
		//Edificio

		if (pAction==Action.consumirEnergia) {
			manager.ConsumirEnergia();
		}

		if (pAction==Action.verificarEstabilidad) {
			manager.VerificarEstabilidad();
		}

		if (pAction==Action.verificarConsumo) {
			manager.VerificarConsumo();
		}

		if (pAction==Action.alimentarEdificio) {
			manager.AlimentarEdificio();
		}
		
		//Clima
		
		if (pAction==Action.verificarClima) {
			manager.VerificarClima();
		}

		if (pAction==Action.enviarRadiacion) {
			manager.EnviarRadiacion();
		}
		
		//Extra

		if (pAction==Action.verificarFuenteEnergia) {
			manager.VerificarFuenteEnergia();
		}
		
		//Registro energia

		if (pAction==Action.guardarRegistroHora) {
			manager.GuardarRegistroHora();
		}

		if (pAction==Action.guardarRegistroDiario) {
			manager.GuardarRegistroDiario();
		}
		
	}

}

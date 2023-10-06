package Main;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import GUI.Ventana;
import Objetos.*;
import Control.*;
import Manager.Action;
import Manager.TaskManager;
import Soporte.*;

public class main {
	
	public static Ventana frame = new Ventana();
	private static TaskManager task;

	public static void main(String[] args) {
		
		ArrayList<EnergiaDiaria> registroEnergia = new ArrayList<EnergiaDiaria>();
		
		String[] climas = {"Soleado", "Parcial Nublado", "Nublado"};
		int[] radiacionxClimas = {1000, 500, 250, 150};
		
		int[] consumoxHora = {100, 180, 240, 160, 80};
		
		PanelSolar[] paneles = new PanelSolar[5];
		
		int[] areasPaneles = {1, 2, 2, 3, 1};
		Double[] eficienciaPaneles = {0.20, 0.15, 0.35, 0.10, 0.30};
		
		for(int i = 0; i < paneles.length; i++) {
			paneles[i] = new PanelSolar(0, areasPaneles[i], eficienciaPaneles[i]);
		}
		
		ControlBateria controlBateria = new ControlBateria(new BateriaSolar(0, 0, 5000, 0), false);
		ControlClima controlClima = new ControlClima(radiacionxClimas, climas, "Soleado");
		ControlEdificio controlEdificio = new ControlEdificio(new Edificio(480, 0, 0), "Paneles", consumoxHora);
		ControlEnergia controlEnergia = new ControlEnergia(registroEnergia);
		ControlPanelSolar controlPaneles = new ControlPanelSolar(paneles, paneles.length, true);
		
		task = new TaskManager(controlBateria, controlClima, controlEdificio, controlEnergia, controlPaneles);
		
		
		Information myInformation = new Information();
		Clock threadControl = new Clock(myInformation);
		threadControl.start();
		
		
		/*SwingUtilities.invokeLater(() -> {
	        frame.setVisible(true);
	    });
	    
	    for(int i = 0; i < 65; i++) {
			controlEnergia.AñadirRegistro(new EnergiaDiaria(i, i, i, "e"));
		}
		
		String tipo = "Mes";
		
		ArrayList<ArrayList<EnergiaDiaria>> registro = controlEnergia.getRegistro(tipo, 1, 2023);
		
		for(int i = 0; i < registro.size(); i++) {
			System.out.println(tipo + " " + Integer.toString(i+1));
			for(int j = 0; j < registro.get(i).size(); j++) {
				System.out.println(registro.get(i).get(j).getGastoEnergia());
			}
		}
		*/
	}
	
	public static void runnable(int pHoras) {
		
		Util.report("==========================", null, "");
		
		
		System.out.println(Clock.getFecha() + " Hora: " + Integer.toString(pHoras) + ":00");
		
		task.execute(Action.verificarFuenteEnergia);
		
		System.out.println("\nCLIMA:");
		task.execute(Action.verificarClima);
		task.execute(Action.enviarRadiacion);
		
		System.out.println("\nPANELES:");
		task.execute(Action.verificarProduccion);
		task.execute(Action.verificarActividad);
		
		System.out.println("\nEDIFICIO:");
		task.execute(Action.consumirEnergia);
		task.execute(Action.alimentarEdificio);
		task.execute(Action.verificarConsumo);
		task.execute(Action.verificarEstabilidad);
		
		System.out.println("\nBATERÍA:");
		task.execute(Action.verificarFlujo);
		task.execute(Action.alimentarBateria);
		task.execute(Action.verificarEnergiaBateria);
		task.execute(Action.verificarDurabilidad);

		task.execute(Action.guardarRegistroHora);
		
		System.out.println();
		
		if(pHoras == 23) {
			task.execute(Action.guardarRegistroDiario);
		}
		
	}

}

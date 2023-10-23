package Main;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import GUI.Ventana;
import Objetos.*;
import Control.*;
import Manager.Action;
import Manager.TaskManager;
import Soporte.*;

/*
 * Acuerdo:
   Display de información sobre el sistema de energía solar, donde se podrá ver el
   sistema estándar con 5 paneles solares y una batería de almacenamiento, el usuario
   no ingresa información en este apartado, como resultado, se indicará cuantos kWh
   genera el sistema y gasta el edificio anual, mensual y semanalmente, además de la
   energía que se almacena en la batería de almacenamiento y el estado del clima.
   
 * Estrategia:
   Implementar los controllers y las clases de mi modelo completas de tal forma que desde
   el main se puedan verificar que todo funciona correctamente y con sentido, para al final
   hacer las pantallas y aplicar el sistema del .json como sistema de almacenamiento y carga
   de datos.
 */

public class main {
	
	public static Ventana frame = new Ventana();
	public static Information myInformation = new Information();

	public static void main(String[] args) {
		
		ArrayList<EnergiaDiaria> registroEnergia = new ArrayList<EnergiaDiaria>();
		
		String[] climas = {"Soleado", "Parcial Nublado", "Nublado"};
		int[] radiacionxClimas = myInformation.getRadiacionxClimas();
		
		int[] consumoxHora = myInformation.getConsumoxHora();
		
		PanelSolar[] paneles = new PanelSolar[5];
		
		int[] areasPaneles = myInformation.getAreasPaneles();
		double[] eficienciaPaneles = myInformation.getEficienciaPaneles();
		
		for(int i = 0; i < paneles.length; i++) {
			paneles[i] = new PanelSolar(0, areasPaneles[i], eficienciaPaneles[i]);
		}
		
		ControlBateria controlBateria = new ControlBateria(new BateriaSolar(0, 0, myInformation.getCapacidadBateria(), 0), false);
		ControlClima controlClima = new ControlClima(radiacionxClimas, climas, "Soleado");
		ControlEdificio controlEdificio = new ControlEdificio(new Edificio(0, 0, 0), "Paneles", consumoxHora);
		ControlEnergia controlEnergia = new ControlEnergia(registroEnergia);
		ControlPanelSolar controlPaneles = new ControlPanelSolar(paneles, paneles.length, true);
		
		TaskManager task = new TaskManager(controlBateria, controlClima, controlEdificio, controlEnergia, controlPaneles);
		
		Clock threadControl = new Clock(myInformation, task);
		myInformation.setTiempo(threadControl.getTime());
		threadControl.start();
		
		
		SwingUtilities.invokeLater(() -> {
	        frame.setVisible(true);
	    });
		
	}

}

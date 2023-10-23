package Soporte;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import Manager.Action;
import Manager.TaskManager;
import Objetos.EnergiaDiaria;

public class Clock extends Thread {
	private boolean running = true;
	private Calendar calendar = new GregorianCalendar().getInstance();
	private Date currentTime = calendar.getTime();
	private Information information;
	private TaskManager task;
	
	public Clock(Information pInformation, TaskManager pTask) {
		this.information = pInformation;
		this.task = pTask;
		long tiempoFecha = information.getFechaGuardada().getTime();
		currentTime = new Date(tiempoFecha);
		calendar.setTime(currentTime);
	}
	
	public void stopTimer() {
		running = false;
	}
	
	public void run() {
		currentTime.setSeconds(0);
		currentTime.setMinutes(0);
		while (running) {
			try {
				
				runnable();
				Thread.sleep(1000);	// controlar la escala de tiempo
				
				calendar.setTime(currentTime);
				calendar.add(Calendar.HOUR_OF_DAY, 1);
				currentTime = calendar.getTime();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public int getTiempo() {
		return this.currentTime.getHours();
	}
	
	public Date getTime() {
		return this.currentTime;
	}

	public Calendar getCalendar() {
		return this.calendar;
	}
	
	public void runnable() {
		
		Util.report("==========================", null, "");
		
		System.out.println(currentTime);
		
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
		
		if(calendar.get(Calendar.HOUR_OF_DAY) == 23) {
			Main.main.myInformation.setTiempo(currentTime);
			task.execute(Action.guardarRegistroDiario);
		}
		
	}
}

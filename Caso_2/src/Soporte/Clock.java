package Soporte;

import java.util.Calendar;
import java.util.Date;

import Manager.Action;
import Manager.TaskManager;

public class Clock extends Thread {
	private static boolean running = true;
	private static Date currentTime = Calendar.getInstance().getTime();
	private static int horas =  currentTime.getHours();
	private static int maxMes = 31;
	private static int dia = 1;
	private static int mes = 1;
	private static int año = 2023;
	private Information information;
	private TaskManager task;
	
	public Clock(Information pInformation, TaskManager pTask) {
		information = pInformation;
		this.task = pTask;
	}
	
	public void stopTimer() {
		running = false;
	}
	
	public void run() {
		currentTime.setSeconds(0);
		currentTime.setMinutes(0);
		Calendar calendar = Calendar.getInstance();
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
	
	public static int getSecondsToNow(Date pBaseTime) {
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(pBaseTime);
        
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        
        // total seconds
        return (hours * 3600) + (minutes * 60) + seconds;		
	}
	
	public static int getTiempo() {
		return currentTime.getHours();
	}
	
	public static  Date getTime() {
		return currentTime;
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
		
		if(horas == 23) {
			task.execute(Action.guardarRegistroDiario);
			Main.main.myInformation.setTiempo(currentTime);
		}
		
	}
}

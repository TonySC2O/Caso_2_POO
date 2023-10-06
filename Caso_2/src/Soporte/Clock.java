package Soporte;

import java.util.Calendar;
import java.util.Date;

import Manager.Action;

public class Clock extends Thread {
	private static boolean running = true;
	private static Date currentTime;
	private static int horas = 7;
	private static int maxMes = 31;
	private static int dia = 1;
	private static int mes = 1;
	private static int año = 2023;
	private Information information;
	
	public Clock(Information pInformation) {
		information = pInformation;
	}
	
	public void stopTimer() {
		running = false;
	}
	
	public void run() {
		while (running) {
			try {
				currentTime = Calendar.getInstance().getTime();
				
				Main.main.runnable(horas);
				Thread.sleep(1000);	// controlar la escala de tiempo
				
				horas++;
				
				if(horas > 23) {
					horas = 0;
					dia++;
				}
				
				if(dia > maxMes) {
					dia = 1;
					mes++;
					maxMes = CalcularMaxMes(mes, año);
				}
				
				if(mes > 12) {
					año++;
				}
				
				
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
		return horas;
	}
	
	public static int getMaxMes() {
		return maxMes;
	}
	
	public static int CalcularMaxMes(int pMes, int pAño) {
		
		int max = 0;
		
		if(pMes == 4 || pMes == 6 || pMes == 9 || pMes == 10) {
			max = 30;
		}else if(pMes == 2){
			if(pAño % 4 == 0 && pAño % 100 != 0 || pAño % 400 == 0) {
				max = 29;
			}else {
				max = 28;
			}
		}else {
			max = 31;
		}
		
		return max;
	}
	
	public static String getFecha() {
		return Integer.toString(dia) + "-" + Integer.toString(mes) + "-" + Integer.toString(año);
	}
	
	public static Date getTime() {
		return currentTime;
	}
}

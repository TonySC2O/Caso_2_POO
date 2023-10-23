package Soporte;

import java.util.ArrayList;
import java.util.Date;

import javax.json.JsonObject;



public class Information {

	private int[] radiacionxClimas;
	private int[] consumoxHora;
	private int[] areasPaneles;
	private double[] eficienciaPaneles;
	private int capacidadBateria;
	private InformationParser parser;
	
	public Information() {
		
		parser = new InformationParser();
		radiacionxClimas = parser.getRadiacionxClimas();
		consumoxHora = parser.getConsumoxHora();
		areasPaneles = parser.getAreasPaneles();
		eficienciaPaneles = parser.getEficienciaPaneles();
		capacidadBateria = parser.getCapacidadBateria();
	}
	
	public int[] getRadiacionxClimas() {
		return radiacionxClimas;
	}
	
	public int[] getConsumoxHora() {
		return consumoxHora;
	}
	
	public int[] getAreasPaneles() {
		return areasPaneles;
	}

	public double[] getEficienciaPaneles() {
		return eficienciaPaneles;
	}

	public int getCapacidadBateria() {
		return capacidadBateria;
	}
	
	public void setTiempo(Date currentTime){
		parser.setTiempoJson(currentTime);
	}

}

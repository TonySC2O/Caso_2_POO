package Soporte;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.json.JsonObject;

import Objetos.EnergiaDiaria;



public class Information {

	private int[] radiacionxClimas;
	private int[] consumoxHora;
	private int[] areasPaneles;
	private double[] eficienciaPaneles;
	private int capacidadBateria;
	private InformationParser parser;
	private ArrayList<EnergiaDiaria> registroEnergia;
	private Date fechaGuardada;
	
	public Information() {
		
		parser = new InformationParser();
		radiacionxClimas = parser.getRadiacionxClimas();
		consumoxHora = parser.getConsumoxHora();
		areasPaneles = parser.getAreasPaneles();
		eficienciaPaneles = parser.getEficienciaPaneles();
		capacidadBateria = parser.getCapacidadBateria();
		registroEnergia = parser.getRegistroEnergia();
		
		int[] elementosFecha = parser.getElementosFecha();
		Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.DAY_OF_MONTH, elementosFecha[0]);
        calendar.set(Calendar.MONTH, elementosFecha[1] - 1);
        calendar.set(Calendar.YEAR, elementosFecha[2]);
        calendar.set(Calendar.HOUR, elementosFecha[3]);
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        fechaGuardada = calendar.getTime();
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

	public ArrayList<EnergiaDiaria> getRegistroEnergia() {
		return registroEnergia;
	}
	public Date getFechaGuardada() {
		return fechaGuardada;
	}
	
	public void setTiempo(Date pCurrentTime){
		parser.setTiempoJson(pCurrentTime);
	}

}

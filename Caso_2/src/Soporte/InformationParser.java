package Soporte;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import java.io.FileWriter;
import java.io.IOException;

//https://mvnrepository.com/artifact/javax.json/javax.json-api/1.1.4

public class InformationParser {
	private JsonObject json;
	
	public InformationParser() {
		loadJson();
	}

	public int[] getRadiacionxClimas() {

        JsonObject variables = json.getJsonObject("RadiacionesClima");
        int[] radiaciones = {variables.getInt("RadSoleado"),variables.getInt("RadParcialNublado"),
        					 variables.getInt("RadNublado"),variables.getInt("RadAnocheciendo")};
        return radiaciones;
	}

	public int[] getConsumoxHora() {

        JsonArray Array = json.getJsonArray("ConsumoxHora");

        int[] consumos = new int[Array.size()];

        for (int i = 0; i < Array.size(); i++) {
        	consumos[i] = Array.getInt(i);
        }
		return consumos;
	}
	
	public int[] getAreasPaneles() {

        JsonArray Array = json.getJsonArray("AreasPaneles");

        int[] areas = new int[Array.size()];

        for (int i = 0; i < Array.size(); i++) {
        	areas[i] = Array.getInt(i);
        }
		return areas;
	}
	
	public double[] getEficienciaPaneles() {

        JsonArray Array = json.getJsonArray("AreasPaneles");

        double[] eficiencias = new double[Array.size()];

        for (int i = 0; i < Array.size(); i++) {
        	eficiencias[i] = Array.getJsonNumber(i).doubleValue();
        }
		return eficiencias;
	}
	
	public int getCapacidadBateria() {

        int capacidad = json.getInt("CapacidadBateria");
        
		return capacidad;
	}
	
	public void setTiempoJson(Date currentTime){
		
	}
	
	private void loadJson() {
		String pathtofile = "C:\\Users\\Tony\\Documents\\TEC\\POO\\Caso_2_POO\\Caso_2\\src\\Soporte\\info.json";
        
		try ( JsonReader reader = Json.createReader(new FileReader(pathtofile))) {
            json = reader.readObject();       
        } catch (Exception e) {
            e.printStackTrace();
        }		
	}
}

package Soporte;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

import Objetos.EnergiaDiaria;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//https://mvnrepository.com/artifact/javax.json/javax.json-api/1.1.4

public class InformationParser {
	private JsonObject json;
	private String pathtofile = "C:\\Users\\Tony\\Documents\\TEC\\POO\\Caso_2_POO\\Caso_2\\src\\Soporte\\info.json";
	
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

        JsonArray Array = json.getJsonArray("EficienciaPaneles");

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
	
	public ArrayList<EnergiaDiaria> getRegistroEnergia(){
		
		ArrayList<EnergiaDiaria> registro = new ArrayList<>();

        try {
            
            JsonArray registroEnergiaArray = json.getJsonArray("RegistroEnergia");

            for (JsonObject jsonEnergiaDiaria : registroEnergiaArray.getValuesAs(JsonObject.class)) {
                int gastoEnergia = jsonEnergiaDiaria.getInt("GastoEnergia");
                int produccionEnergia = jsonEnergiaDiaria.getInt("ProduccionEnergia");
                int consumoBateria = jsonEnergiaDiaria.getInt("ConsumoBateria");
                String fechaStr = jsonEnergiaDiaria.getString("Fecha");

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = dateFormat.parse(fechaStr);

                EnergiaDiaria energiaDiaria = new EnergiaDiaria(gastoEnergia, produccionEnergia, consumoBateria, fecha);

                registro.add(energiaDiaria);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

		return registro;
	}
	
	public void setTiempoJson(Date pCurrentTime){

		long tiempoFecha = pCurrentTime.getTime();
		Date currentTime = new Date(tiempoFecha);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentTime);
		try {

            JsonObject tiempoObject = json.getJsonObject("Tiempo");

            JsonObjectBuilder modifiedTiempoObjectBuilder = Json.createObjectBuilder(tiempoObject)
                    .add("Dia", calendar.get(Calendar.DAY_OF_MONTH))
                    .add("Mes", calendar.get(Calendar.MONTH)+1)
                    .add("Año", calendar.get(Calendar.YEAR))
                    .add("Hora", 23);

            JsonObjectBuilder modifiedJsonObjectBuilder = Json.createObjectBuilder(json);
            modifiedJsonObjectBuilder.add("Tiempo", modifiedTiempoObjectBuilder);

            JsonObject modifiedJsonObject = modifiedJsonObjectBuilder.build();

            JsonWriter jsonWriter = Json.createWriter(new FileWriter(pathtofile));
            jsonWriter.writeObject(modifiedJsonObject);
            jsonWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public int[] getElementosFecha() {
		
		JsonObject variables = json.getJsonObject("Tiempo");
        int[] elementos = {variables.getInt("Dia"),variables.getInt("Mes"),
        					 variables.getInt("Año"),variables.getInt("Hora")};

		return elementos;
	}
	
	private void loadJson() {
		
        
		try ( JsonReader reader = Json.createReader(new FileReader(pathtofile))) {
            json = reader.readObject();   
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }		
	}
}

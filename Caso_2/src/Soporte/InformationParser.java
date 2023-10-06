package Soporte;

import java.io.FileReader;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

//https://mvnrepository.com/artifact/javax.json/javax.json-api/1.1.4

public class InformationParser {
	private JsonArray jsontasks;
	private JsonObject json;
	
	public InformationParser() {
		loadJson();
	}

	public ArrayList<Task> getTasks() {
		ArrayList<Task> result = new ArrayList<Task>();
        
        return result;
	}	
	
	private void loadJson() {
		String pathtofile = "C:\\Users\\Tony\\Desktop\\TEC\\POO\\Caso_2_POO\\Caso_2\\src\\Soporte\\info.json";
        
		try ( JsonReader reader = Json.createReader(new FileReader(pathtofile))) {
            json = reader.readObject();
            JsonObject variables = json.getJsonObject("Tiempo");
            
            
            System.out.println(json); 
            System.out.println(jsontasks);           
        } catch (Exception e) {
            e.printStackTrace();
        }		
	}
}

package Control;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;

import Objetos.EnergiaDiaria;

public class ControlEnergia {
	private ArrayList<EnergiaDiaria> registroEnergia;

	public ControlEnergia(ArrayList<EnergiaDiaria> registroEnergia) {
		this.registroEnergia = registroEnergia;
	}
	
	public void AñadirRegistro(EnergiaDiaria pRegistroDiario) {
		
		registroEnergia.add(pRegistroDiario);
		String pathtofile = "C:\\Users\\Tony\\Documents\\TEC\\POO\\Caso_2_POO\\Caso_2\\src\\Soporte\\info.json";
		
		try {
            JsonReader jsonReader = Json.createReader(new FileReader(pathtofile));
            JsonObject json = jsonReader.readObject();
            jsonReader.close();

            JsonArrayBuilder energiaDiariaArrayBuilder = Json.createArrayBuilder();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            for (EnergiaDiaria energiaDiaria : registroEnergia) {
                JsonObjectBuilder energiaDiariaBuilder = Json.createObjectBuilder();
                energiaDiariaBuilder.add("GastoEnergia", energiaDiaria.getGastoEnergia());
                energiaDiariaBuilder.add("ProduccionEnergia", energiaDiaria.getProduccionEnergia());
                energiaDiariaBuilder.add("ConsumoBateria", energiaDiaria.getConsumoBateria());
                energiaDiariaBuilder.add("Fecha", dateFormat.format(energiaDiaria.getFecha()));
                energiaDiariaArrayBuilder.add(energiaDiariaBuilder);
            }

            JsonObjectBuilder updatedJsonBuilder = Json.createObjectBuilder(json);
            updatedJsonBuilder.remove("RegistroEnergia");
            updatedJsonBuilder.add("RegistroEnergia", energiaDiariaArrayBuilder);

            JsonWriter jsonWriter = Json.createWriter(new FileWriter(pathtofile));
            jsonWriter.writeObject(updatedJsonBuilder.build());
            jsonWriter.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public ArrayList<EnergiaDiaria> getRegistroEnergia(){
		return registroEnergia;
	}
}

package Control;

import java.util.ArrayList;

import Objetos.EnergiaDiaria;
import Soporte.Clock;

public class ControlEnergia {
	private ArrayList<EnergiaDiaria> registroEnergia;

	public ControlEnergia(ArrayList<EnergiaDiaria> registroEnergia) {
		this.registroEnergia = registroEnergia;
	}
	
	public void AñadirRegistro(EnergiaDiaria pRegistroDiario) {
		registroEnergia.add(pRegistroDiario);
	}
	
	public ArrayList<ArrayList<EnergiaDiaria>> getRegistro(){
		return null;
	}
}

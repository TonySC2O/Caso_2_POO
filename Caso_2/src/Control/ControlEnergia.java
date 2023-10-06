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
	
	public ArrayList<ArrayList<EnergiaDiaria>> getRegistro(String pTipoRegistro, int pMes, int pAño){
		
		int intervalo = 0;
		
		switch(pTipoRegistro) {
		case "Semana":
			intervalo = 7;
			break;
		case "Año":
			intervalo = 365;
			break;
		case "Mes":
			intervalo = Clock.CalcularMaxMes(pMes, pAño);
			break;
		default:
			return null;
		}
		
		ArrayList<ArrayList<EnergiaDiaria>> registro = new ArrayList<ArrayList<EnergiaDiaria>>();
		
		int loops = registroEnergia.size() / intervalo;
		if(registroEnergia.size() % intervalo > 0) {loops++;}
		
		int i = 0;
		for(int j = 0; j < loops; j++) {
			registro.add(new ArrayList<EnergiaDiaria>());
			for(int k = 0; k < intervalo; k++) {
				
				registro.get(j).add(registroEnergia.get(i));
				i++;
				
				if(i == registroEnergia.size()) {
					break;
				}
			}
			
			if(pTipoRegistro.equals("Mes")) {
				pMes++;
				if(pMes > 12) {
					pMes = 1;
					pAño++;
				}
				intervalo = Clock.CalcularMaxMes(pMes, pAño);
			}
		}
		
		return registro;
	}
}

package Manager;

public enum Action {
	
	//Paneles
	verificarProduccion, verificarActividad,
	
	//Bateria
	verificarFlujo, verificarDurabilidad,
	verificarEnergiaBateria, alimentarBateria,
	
	//Edificio
	consumirEnergia, verificarEstabilidad, 
	verificarConsumo, alimentarEdificio,
	
	//Clima
	verificarClima, enviarRadiacion,
	
	//Registro Energia
	
	guardarRegistroHora, guardarRegistroDiario,
	
	//Extras
	verificarFuenteEnergia
}

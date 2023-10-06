package Soporte;

import java.util.ArrayList;



public class Information {
	
	private ArrayList<Task> tasks;
	
	public Information() {
		
		
		InformationParser parser = new InformationParser();
		tasks = parser.getTasks();
	}
	
	public void processTasks() {
		
	}
}

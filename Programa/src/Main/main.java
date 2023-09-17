package Main;

import javax.swing.SwingUtilities;

import GUI.Ventana;

public class main {
	
	public static Ventana frame = new Ventana();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
	        frame.setVisible(true);
	    });
	}

}

package GUI;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	public Ventana() {
		setTitle("SolarSystem");
	    setSize(600, 750); // Set the desired size
	    setResizable(false); // Disable frame resizing
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
        setLocationRelativeTo(null);
	}
}

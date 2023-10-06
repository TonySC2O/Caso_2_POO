package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class Ventana extends JFrame{

	private MatteBorder borde = new MatteBorder(2, 2, 2, 2, Color.BLACK);
	private JPanel panelPrincipal = new JPanel(new CardLayout());
	private PanelInfo panelInformacion = new PanelInfo();
	private PanelPaneles panelPaneles = new PanelPaneles();
	private PanelBateria panelBateria = new PanelBateria();
	private PanelClima panelClima = new PanelClima();
	
	JMenuBar menuBar = new JMenuBar();
	
	public Ventana() {
		setTitle("SolarSystem");
	    setSize(600, 670); // Set the desired size
	    setResizable(false); // Disable frame resizing
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // Se agrega la barra de menú y sus items.
	    
	    setJMenuBar(menuBar);
	    
		JMenu menuInformacion = new JMenu("Información");
		menuInformacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuInformacion.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            panelInformacion.setVisible(true);
	            panelClima.setVisible(false);
	            panelPaneles.setVisible(false);
	            panelBateria.setVisible(false);
	         }
	     });
		menuBar.add(menuInformacion);
		
		JMenu menuPaneles = new JMenu("Paneles");
		menuPaneles.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuPaneles.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            panelPaneles.setVisible(true);
	            panelClima.setVisible(false);
	            panelInformacion.setVisible(false);
	            panelBateria.setVisible(false);
	         }
	     });
		menuBar.add(menuPaneles);

		JMenu menuBateria = new JMenu("Bateria");
		menuBateria.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuBateria.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            panelBateria.setVisible(true);
	            panelPaneles.setVisible(false);
	            panelClima.setVisible(false);
	            panelInformacion.setVisible(false);
	         }
	     });
		menuBar.add(menuBateria);
		
		JMenu menuClima = new JMenu("Clima");
		menuClima.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menuClima.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            panelClima.setVisible(true);
	            panelInformacion.setVisible(false);
	            panelPaneles.setVisible(false);
	            panelBateria.setVisible(false);
	         }
	     });
		menuBar.add(menuClima);
		
		// Se agregan los paneles.

	    panelPrincipal.add(panelInformacion);
	    panelPrincipal.add(panelClima);
	    panelPrincipal.add(panelPaneles);
	    panelPrincipal.add(panelBateria);
	    getContentPane().add(panelPrincipal);
	    
        setLocationRelativeTo(null);
	}
}

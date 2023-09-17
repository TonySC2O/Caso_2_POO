package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class PanelPaneles extends JPanel{
	
	private MatteBorder borde = new MatteBorder(2, 2, 2, 2, Color.BLACK);
	
	public void Colocar_label(JLabel pLabel, JPanel pPanel, int x, int y, int h, int w, boolean pOpacity, Color pFondo, int pTamaño, boolean pBorde) {
		pLabel.setFont(new Font("Arial", Font.BOLD, pTamaño)); // Set font and sizO
		pLabel.setForeground(Color.black); // Set text color
		pLabel.setBackground(pFondo); // Set text color
		pLabel.setHorizontalAlignment(SwingConstants.CENTER);
		if(pBorde == true) {pLabel.setBorder(borde);}
		pLabel.setOpaque(pOpacity);
		pLabel.setBounds(x, y, h ,w);
		if(pPanel == null) {add(pLabel);}
		else {pPanel.add(pLabel);}
	}
	
	public void Colocar_panel(JPanel pPanel, int x, int y, int h, int w, Color pFondo) {
		pPanel.setLayout(null);
		pPanel.setBackground(pFondo);
		pPanel.setBounds(x, y, h, w);
		pPanel.setBorder(borde);
        add(pPanel);
	}
	
	public PanelPaneles() {
		setLayout(null);
		setBackground(Color.lightGray);
		
		JLabel label = new JLabel("Paneles");
		Colocar_label(label, null, 10, 20, 565, 80, true, Color.white, 24, true);
		
		JLabel lblNumPanel = new JLabel("Panel #1");
		Colocar_label(lblNumPanel, null, 10, 110, 373, 50, true, Color.white, 0, true);
		
		JLabel lblImagen = new JLabel();
		Colocar_label(lblImagen, null, 10, 165, 373, 315, true, Color.white, 0, true);

		JLabel lblIzquierda = new JLabel("Izquierda");
		Colocar_label(lblIzquierda, null, 10, 490, 180, 100, true, Color.white, 18, true);

		JLabel lblDerecha = new JLabel("Derecha");
		Colocar_label(lblDerecha, null, 203, 490, 180, 100, true, Color.white, 18, true);
		
		JPanel pnlCambios = new JPanel();
		Colocar_panel(pnlCambios, 395, 110, 180, 120, Color.white);
		
		String sCantidad = "<html>Paneles en total:<br>5</html>";
		JLabel lblCantidad = new JLabel(sCantidad);
		Colocar_label(lblCantidad, null, 395, 240, 180, 70, true, Color.white, 20, true);
		
		String sProduccion = "<html>kWh producido:<br>"
				+ "1000 kWh<br><br>"
				+ "Bono Actual:<br>"
				+ "Soleado (+50%)<br><br>"
				+ "kWh neto:<br>"
				+ "1500 kWh</html>";
		
		JLabel lblProduccion = new JLabel(sProduccion);
		Colocar_label(lblProduccion, null, 395, 320, 180, 230, true, Color.white, 20, true);

		JLabel lblEstado = new JLabel();
		Colocar_label(lblEstado, null, 395, 560, 180, 30, true, new Color(0,160,50), 20, true);
	}

}

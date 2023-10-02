package GUI;

import java.awt.Color;
import java.awt.Cursor;
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
		
		JLabel lblNumPanel = new JLabel("Panel 1/5");
		Colocar_label(lblNumPanel, null, 10, 110, 373, 50, true, Color.white, 18, true);
		
		JLabel lblImagen = new JLabel();
		Colocar_label(lblImagen, null, 10, 180, 373, 195, true, Color.white, 0, true);
		
		JLabel lblKwh = new JLabel("kW por hora: 1000 kW", SwingConstants.RIGHT);
		Colocar_label(lblKwh, null, 10, 390, 373, 50, true, Color.white, 18, true);

		JLabel lblAtras = new JLabel("Atrás");
		Colocar_label(lblAtras, null, 10, 450, 180, 100, true, Color.white, 18, true);
		lblAtras.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblSiguiente = new JLabel("Siguiente");
		Colocar_label(lblSiguiente, null, 203, 450, 180, 100, true, Color.white, 18, true);
		lblSiguiente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblInfoPanel = new JLabel("Paneles General");
		Colocar_label(lblInfoPanel, null, 395, 110, 180, 50, true, Color.white, 18, true);
		
		String sCantidad = "<html>Paneles en total:<br>5</html>";
		JLabel lblCantidad = new JLabel(sCantidad);
		Colocar_label(lblCantidad, null, 395, 180, 180, 70, true, Color.white, 18, true);
		
		String sProduccion = "<html>kWh producido:<br>"
				+ "1000 kWh<br><br>"
				+ "Clima:<br>"
				+ "Soleado<br><br>"
				+ "Estado:<br>"
				+ "Activos</html>";
		
		JLabel lblProduccion = new JLabel(sProduccion);
		Colocar_label(lblProduccion, null, 395, 270, 180, 240, true, Color.white, 20, true);

		JLabel lblEstado = new JLabel();
		Colocar_label(lblEstado, null, 395, 520, 180, 30, true, new Color(0,160,50), 20, true);
	}

}

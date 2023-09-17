package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class PanelBateria extends JPanel{
	
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
	
	public PanelBateria() {
		setLayout(null);
		setBackground(Color.lightGray);
		
		JLabel label = new JLabel("Batería");
		Colocar_label(label, null, 10, 20, 565, 80, true, Color.white, 24, true);
		
		JLabel lblImagen = new JLabel();
		Colocar_label(lblImagen, null, 10, 110, 373, 370, true, Color.white, 0, true);
		
		String s = "<html><center>kW almacenados:<br>"
				+ "1200<br>"
				+ "Modo uso energia:<br>"
				+ "desactivado</center></html>";
		
		JLabel lblinfo = new JLabel(s);
		Colocar_label(lblinfo, null, 10, 490, 373, 100, true, Color.white, 18, true);
		
		JPanel pnlCapMax = new JPanel();
		Colocar_panel(pnlCapMax, 395, 110, 180, 120, Color.white);
		
		String sAlmacen = "<html>kWh almacenados:<br>50 kW</html>";
		JLabel lblAlmacen = new JLabel(sAlmacen);
		Colocar_label(lblAlmacen, null, 395, 240, 180, 70, true, Color.white, 18, true);
		
		String sUsoEnergia = "<html>Modo uso energía<br><br>"
				+ "Gasto por hora:<br>"
				+ "0 kWh<br><br>"
				+ "La energía se<br>"
				+ "agotará en<br>"
				+ "aproximadamente:<br>"
				+ "No activo</html>";
		
		JLabel lblUsoEnergia = new JLabel(sUsoEnergia);
		Colocar_label(lblUsoEnergia, null, 395, 320, 180, 270, true, Color.white, 18, true);
	}
}

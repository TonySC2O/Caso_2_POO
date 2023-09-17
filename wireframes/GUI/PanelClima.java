package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class PanelClima extends JPanel{
	
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
	
	public PanelClima() {
		setLayout(null);
		setBackground(Color.lightGray);
		
		JLabel label = new JLabel("Clima");
		Colocar_label(label, null, 10, 20, 565, 80, true, Color.white, 24, true);
		
		JLabel lblImagen = new JLabel();
		Colocar_label(lblImagen, null, 10, 110, 373, 370, true, Color.white, 0, true);
		
		String e = "<html>Bonos:<br><br>"
				+ "Soleado (+50%)<br><br>"
				+ "Despejado(0%)<br><br>"
				+ "Parcialmente<br>"
				+ "Nublado (-25%)<br><br>"
				+ "Lloviendo (-50%<br><br>"
				+ "Noche (-100%)<br><br>"
				+ "(El último bono<br>"
				+ "activa el uso de<br>"
				+ "energia<br>"
				+ "almacenada en<br>"
				+ "batería)</html>";
		
		JLabel lblBonos = new JLabel(e);
		Colocar_label(lblBonos, null, 395, 110, 180, 480, true, Color.white, 20, true);

		JComboBox cmbClima = new JComboBox<String>();
		cmbClima.addItem("Soleado");
		cmbClima.addItem("Despejado");
		cmbClima.addItem("Parcialmente Nublado");
		cmbClima.addItem("Lloviendo");
		cmbClima.addItem("Noche");
		cmbClima.setFocusable(false);
		cmbClima.setFont(new Font("Arial", Font.BOLD, 20));
		cmbClima.setBounds(10, 490, 373, 100);
		
		add(cmbClima);
	}
}

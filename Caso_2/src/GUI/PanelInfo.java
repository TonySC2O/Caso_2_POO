package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class PanelInfo extends JPanel{
	
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
	
	public PanelInfo(){
		setLayout(null);
		setBackground(Color.lightGray);
		
		JLabel label = new JLabel("Información general de equipo solar");
		Colocar_label(label, null, 10, 20, 565, 80, true, Color.white, 24, true);
		
		JPanel pnlGastoHora = new JPanel();
		Colocar_panel(pnlGastoHora, 10, 110, 373, 370, Color.white);

		JPanel pnlGastoSemana = new JPanel();
		Colocar_panel(pnlGastoSemana, 10, 490, 180, 100, Color.white);

		JPanel pnlGastoMes = new JPanel();
		Colocar_panel(pnlGastoMes, 203, 490, 180, 100, Color.white);

		JPanel pnlGastoAño = new JPanel();
		Colocar_panel(pnlGastoAño, 395, 490, 180, 100, Color.white);
		
		JPanel pnlClima = new JPanel();
		Colocar_panel(pnlClima, 395, 110, 180, 180, Color.white);
		
		JPanel pnlAlmacenamiento = new JPanel();
		Colocar_panel(pnlAlmacenamiento, 395, 300, 180, 180, Color.white);
	}
}

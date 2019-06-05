package menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChargerPartie extends ImagePanel {

	private static final long serialVersionUID = 1L;
	private Bouton Retour,Enregistrer;
	private JFrame containter;


	public ChargerPartie(JFrame container) {
		super(Jeu.instance.fondecran);
		this.containter=container;
		
		initCanvas();
	}

	private void initCanvas() {
		String Pseudo = "<html>"
				+ "<font size='10' color='white'><strong> Entrez votre Pseudo :  </strong> </font> + </html>";
		JTextField titleText = new JTextField();
		titleText.setPreferredSize(new Dimension(150, 35));
		Retour = new Bouton("Retour");
		Enregistrer = new Bouton("Enregistrer");

		Retour.addActionListener(new BoutonActionListener(8,containter));
		Enregistrer.addActionListener(new BoutonActionListener(11,containter));
		add(Retour);
		add(Enregistrer);
		Enregistrer.setEnabled(false);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy++;
		add(new JLabel(Pseudo), c);
		c.gridy++;
		add(titleText);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 5;
		add(Retour, c);
		c.gridy = 5;
		add(Enregistrer, c);
		
		
		titleText.addKeyListener(new KeyAdapter() { 
			@Override
			public void keyReleased(KeyEvent e) {
				if(titleText.getText().equals("")) {
					Enregistrer.setEnabled(false);
				}
				else {
					Enregistrer.setEnabled(true);
				}
				
			}
		});
		
	}

}

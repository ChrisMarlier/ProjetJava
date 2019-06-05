package menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class FenetreNPartie2 extends ImagePanel {

	private static final long serialVersionUID = 1L;
	private Bouton Retour,Enregistrer;
	private JFrame container;
	public static JTextField titleText = new JTextField();

	public FenetreNPartie2(JFrame container) {
		
		
		super(Jeu.instance.fondecran);
		this.container=container;
		initCanvas();
	}

	private void initCanvas() {
		String Pseudo1 = "<html>"
				+ "<font size='8' color='white'><strong> Pseudo :  </strong> </font> + </html>";
	

		
		
		titleText.setPreferredSize(new Dimension(150, 35));

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy++;
		add(new JLabel(Pseudo1), c);
		add(titleText, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy++;
		
		Retour = new Bouton("Retour");
		Enregistrer = new Bouton("Enregistrer");

		Retour.addActionListener(new BoutonActionListener(10,container));
		Enregistrer.addActionListener(new BoutonActionListener(9,container));
		Enregistrer.setEnabled(false);
		add(Retour);
		add(Enregistrer);

		c.fill = GridBagConstraints.VERTICAL;
		c.gridy = 10;
		add(Retour, c);
		c.fill = GridBagConstraints.VERTICAL;
		c.gridy=10;
		add(Enregistrer, c);
		// un ecouteur est ajoute sur l'evenemnt relache touche clavier , si apres l'evenemnt le texte est vide  , on ne peut pas clic sur le buton 
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

package menu;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class FenetreNPartie extends ImagePanel {

	private static final long serialVersionUID = 1L;
	private Bouton Retour,Enregistrer;
	private JFrame frame;
	public static JTextField titleText1 = new JTextField();
	public static JTextField titleText2 = new JTextField();

	public FenetreNPartie(JFrame frame) {
		super(Jeu.instance.fondecran);
		this.frame=frame;
		
		initCanvas();
	}

	private void initCanvas() {
		String Pseudo1 = "<html>"
				+ "<font size='8' color='white'><strong> Pseudo Joueur 1  :  </strong> </font> + </html>";
		String Pseudo2 = "<html>"
				+ "<font size='8' color='white'><strong> Pseudo Joueur 2  :  </strong> </font> + </html>";



		titleText1.setPreferredSize(new Dimension(150, 35));
		titleText2.setPreferredSize(new Dimension(150, 35));

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy++;
		add(new JLabel(Pseudo1), c);
		c.gridy++;
		add(new JLabel(Pseudo2), c);
		add(titleText1, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = 0;
		add(titleText2, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy++;
		
		Retour = new Bouton("Retour");
		Enregistrer = new Bouton("Enregistrer");

		Retour.addActionListener(new BoutonActionListener(10,frame));
		Enregistrer.addActionListener(new BoutonActionListener(13,frame));
		add(Retour);
		Enregistrer.setEnabled(false);
		add(Enregistrer);

		c.fill = GridBagConstraints.VERTICAL;
		c.gridy = 10;
		add(Retour, c);
		c.fill = GridBagConstraints.VERTICAL;
		c.gridy=10;
		add(Enregistrer, c);
		
		titleText1.addKeyListener(new KeyAdapter() { 
			@Override
			public void keyReleased(KeyEvent e) {
				if(titleText1.getText().equals("") || titleText2.getText().equals("")) {
					Enregistrer.setEnabled(false);
				}
				else {
					Enregistrer.setEnabled(true);
				}
				
			}
		});
		
		titleText2.addKeyListener(new KeyAdapter() { 
			@Override
			public void keyReleased(KeyEvent e) {
				if(titleText1.getText().equals("") || titleText2.getText().equals("")) {
					Enregistrer.setEnabled(false);
				}
				else {
					Enregistrer.setEnabled(true);
				}
				
			}
		});
		



	}

}

package menu;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class TypePartie extends ImagePanel {

	private static final long serialVersionUID = 1L;
	private Bouton IA;
	private Bouton Joueurs;
	private Bouton Retour;
	private JFrame container;

	public TypePartie(JFrame container) {
		super(Jeu.instance.fondecran);
		this.container=container;
		initCanvas();
	}

	private void initCanvas() {
		Joueurs = new Bouton("2 Joueurs ");
		IA = new Bouton("IA");
		Retour = new Bouton("Retour");

		Joueurs.addActionListener(new BoutonActionListener(4,container));
		IA.addActionListener(new BoutonActionListener(5,container));
		Retour.addActionListener(new BoutonActionListener(7,container));

		setLayout(new GridLayout(4, 1, 0, 0));
		add(Joueurs);
		add(IA);
		add(Retour);
	}

}

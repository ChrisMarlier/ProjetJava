package menu;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;

import javax.swing.JFrame;

public class Aide extends ImagePanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font;
	int tailleInitiale = 20;
	private Bouton Retour;
	private JFrame container;


	

	public Aide(JFrame container) {
		super(Jeu.instance.fondecran);
		this.container=container;
		initCanvas();
	}


	private void initCanvas() {
		String text = ("Le joueur aura la possibilité de choisir entre 2 modes de jeu : le mode multi-joueurs ou le mode solo. En mode multi-joueurs, 2 joueurs pourront s'affronter sur le même écran. En solo, le deuxième joueur sera contrôlé par l'ordinateur.\n"
				+ "\n" + "Ensuite, deux scénarios seront possibles.\n" + "\n"
				+ "Le premier est la destruction totale de l’équipe adverse. Il faut éliminer toutes les unités adverses jusqu'à la dernière.\n"
				+ "\n"
				+ "Le deuxième scénario est la capture (ou défense) d’un point stratégique. Une équipe défend un point de la carte pendant que l’autre doit tout faire pour réussir à atteindre/détruire ce point avant un nombre de tours donné.\n"
				+ "\n"
				+ "Nous pensons par exemple à la défense d’un pont stratégique. Ce pont est l'accès principal pour atteindre une ville, il faut le détruire pour éviter que les renforts ennemis arrivent et reprennent le contrôle de la ville.\n"
				+ "\n"
				+ "Nous souhaitons faire différents scénarios qui rendraient le jeu plus réaliste et vivant. Reprendre des batailles ou évènements marquants de la seconde guerre mondiale, faire des batailles navales, des défenses de convois ou flotte commerciales, …\n"
				+ "\n"
				+ "Des médecins pourront soigner les unités blessées et des mécaniciens pourront réparer les véhicules et bâtiments endommagés.\n"
				+ "\n"
				+ "Nous avons aussi pour but d’activer des renforts durant la partie pour rendre les combats intéressants et dynamiques. Ils pourraient retourner la face du combat !	");

		TextArea t = new TextArea(text, 30, 65);
		
		Retour = new Bouton("Retour");

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		add(Retour);
		c.fill = GridBagConstraints.VERTICAL;
		c.gridy = 10;
		add(Retour, c);
		add(t);
		Retour.addActionListener(new BoutonActionListener(12,container));


		
	}

	
	

}

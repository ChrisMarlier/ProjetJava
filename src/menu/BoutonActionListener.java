package menu;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import modele.GestionMap;
import visuel.Fenetre;
import visuel.Panneau;

public class BoutonActionListener implements ActionListener {

	private int index;
	private JFrame container;

	// private JPanel mainMenu;
	public BoutonActionListener(int index, JFrame container) {

		this.container = container;
		this.index = index;
		// this.mainMenu=(JPanel) container.getContentPane();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (index) {

		case 1:
			Jeu.instance.updatePanel(new TypePartie(container));
			System.out.println("Bouton 1 ");
			break;

		case 2:
			Jeu.instance.updatePanel(new ChargerPartie(container));
			System.out.println("Bouton 2");
			break;

		case 3:
			Jeu.instance.updatePanel(new Aide(container));
			System.out.println("Bouton 3");
			break;

		case 4:
			Jeu.instance.updatePanel(new FenetreNPartie(container));
			System.out.println("Bouton 4");
			break;
		case 5:
			Jeu.instance.updatePanel(new FenetreNPartie2(container));
			System.out.println("Bouton 5");
			break;

		case 6:
			// TODO retour
			System.out.println("Bouton 6");

			break;

		case 7:
			// TODO retour
			System.out.println("Bouton 7");

			Jeu.instance.reset();

			break;

		case 8:
			System.out.println("Bouton 8");
			Jeu.instance.reset();
			

			break;

		case 9:
			// TODO Enregistrer(ChargerPartie)
			System.out.println("Bouton 9 : IA");
			GestionMap.setModeJeu(1);
			new GestionMap();
			
			// container
			Runnable gui = new Runnable() {
				public void run() {
					@SuppressWarnings("unused")
					Fenetre fen = new Fenetre(container, "WarGame", GestionMap.getMap().size(),
							GestionMap.getMap().get(0).size(), 16);
				}
			};
			SwingUtilities.invokeLater(gui);
			break;

		case 10:
			Jeu.instance.updatePanel(new TypePartie(container));
			System.out.println("Bouton 10");
			break;

		case 11:
			// TODO Enregistrer(ChargerPartie)
			System.out.println("Bouton 11 : ChargePartie (Enregistrer)");

			GestionMap test1 = new GestionMap();
			// container
			Runnable gui1 = new Runnable() {
				public void run() {
					@SuppressWarnings("unused")
					Fenetre fen = new Fenetre(container, "WarGame", GestionMap.getMap().size(),
							GestionMap.getMap().get(0).size(), 16);
				}
			};
			SwingUtilities.invokeLater(gui1);
			break;

		case 12:
			// TODO retour(aide)
			System.out.println("Bouton 12 : retour aide");

			Jeu.instance.reset();
			break;
		case 13: 
			System.out.println("Bouton 13 : multijoueurs");
			GestionMap.setModeJeu(2);
			new GestionMap();
			

			// container
			Runnable gui2 = new Runnable() {
				public void run() {
					@SuppressWarnings("unused")
					Fenetre fen = new Fenetre(container, "WarGame", GestionMap.getMap().size(),
							GestionMap.getMap().get(0).size(), 16);
				}
			};
			SwingUtilities.invokeLater(gui2);
			break;
			
		}
	}

}

package visuel;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Panneau extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panneau(final int rows, final int columns, final int side) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
	Panneau2 grille = new Panneau2(rows, columns, side);
	//JPanel pannel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH,grille , 36, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, grille, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, grille, -77, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, grille, 535, SpringLayout.WEST, this);
		add(grille);
		
		JLabel lblPrvisualisation = new JLabel("Pr\u00E9visualisation :");
		springLayout.putConstraint(SpringLayout.NORTH, lblPrvisualisation, 0, SpringLayout.NORTH, grille);
		springLayout.putConstraint(SpringLayout.WEST, lblPrvisualisation, 6, SpringLayout.EAST, grille);
		lblPrvisualisation.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblPrvisualisation);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 18, SpringLayout.SOUTH, lblPrvisualisation);
		springLayout.putConstraint(SpringLayout.WEST, panel, 43, SpringLayout.EAST, grille);
		springLayout.putConstraint(SpringLayout.EAST, panel, -44, SpringLayout.EAST, this);
		add(panel);
		
		JLabel lblNomUnit = new JLabel("Nom unit\u00E9 : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNomUnit, 211, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNomUnit, 23, SpringLayout.EAST, grille);
		add(lblNomUnit);
		
		JLabel lblPointsDeVie = new JLabel("Points de vie :");
		springLayout.putConstraint(SpringLayout.NORTH, lblPointsDeVie, 13, SpringLayout.SOUTH, lblNomUnit);
		springLayout.putConstraint(SpringLayout.WEST, lblPointsDeVie, 23, SpringLayout.EAST, grille);
		add(lblPointsDeVie);
		
		JLabel lblNewLabel = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, lblNomUnit);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 23, SpringLayout.EAST, lblNomUnit);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, lblPointsDeVie);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel);
		add(lblNewLabel_1);
		
		JLabel lblAttaque = new JLabel("Attaque :");
		springLayout.putConstraint(SpringLayout.WEST, lblAttaque, 23, SpringLayout.EAST, grille);
		add(lblAttaque);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblAttaque, 0, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 19, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		add(lblNewLabel_2);
		
		JLabel lblDplacement = new JLabel("D\u00E9placement :");
		springLayout.putConstraint(SpringLayout.NORTH, lblDplacement, 19, SpringLayout.SOUTH, lblAttaque);
		springLayout.putConstraint(SpringLayout.WEST, lblDplacement, 23, SpringLayout.EAST, grille);
		add(lblDplacement);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 0, SpringLayout.SOUTH, lblDplacement);
		add(lblNewLabel_3);
		
		JLabel lblVision = new JLabel("Vision :");
		springLayout.putConstraint(SpringLayout.NORTH, lblVision, 22, SpringLayout.SOUTH, lblDplacement);
		springLayout.putConstraint(SpringLayout.WEST, lblVision, 23, SpringLayout.EAST, grille);
		add(lblVision);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, lblVision);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
		add(lblNewLabel_4);
		
		JButton btnPasserLeTour = new JButton("Passer le tour");
		add(btnPasserLeTour);
		
		JLabel lblCaractristiques = new JLabel("Caract\u00E9ristiques :");
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, lblCaractristiques);
		springLayout.putConstraint(SpringLayout.SOUTH, lblCaractristiques, -461, SpringLayout.SOUTH, this);
		lblCaractristiques.setFont(new Font("Tahoma", Font.BOLD, 13));
		springLayout.putConstraint(SpringLayout.WEST, lblCaractristiques, 6, SpringLayout.EAST, grille);
		add(lblCaractristiques);
		
		JLabel lblJoueur = new JLabel("Joueur :");
		lblJoueur.setFont(new Font("Tahoma", Font.BOLD, 13));
		springLayout.putConstraint(SpringLayout.NORTH, lblJoueur, 33, SpringLayout.SOUTH, lblVision);
		springLayout.putConstraint(SpringLayout.WEST, lblJoueur, 6, SpringLayout.EAST, grille);
		add(lblJoueur);
		
		JLabel lblNewLabel_5 = new JLabel("Points de d\u00E9placement restant :");
		springLayout.putConstraint(SpringLayout.EAST, btnPasserLeTour, 0, SpringLayout.EAST, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 20, SpringLayout.SOUTH, lblJoueur);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNomUnit);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 0, SpringLayout.NORTH, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_6, -10, SpringLayout.EAST, this);
		add(lblNewLabel_6);
		
		JLabel lblPointDactionRestant = new JLabel("Point d'action restant :");
		springLayout.putConstraint(SpringLayout.NORTH, lblPointDactionRestant, 16, SpringLayout.SOUTH, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.WEST, lblPointDactionRestant, 0, SpringLayout.WEST, lblNomUnit);
		add(lblPointDactionRestant);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_7, 0, SpringLayout.SOUTH, lblPointDactionRestant);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_7, 0, SpringLayout.EAST, lblNewLabel_6);
		add(lblNewLabel_7);
		
		JLabel lblNombreDeTour = new JLabel("Nombre de tour restant :");
		springLayout.putConstraint(SpringLayout.NORTH, btnPasserLeTour, 39, SpringLayout.SOUTH, lblNombreDeTour);
		springLayout.putConstraint(SpringLayout.NORTH, lblNombreDeTour, 20, SpringLayout.SOUTH, lblPointDactionRestant);
		springLayout.putConstraint(SpringLayout.WEST, lblNombreDeTour, 0, SpringLayout.WEST, lblNomUnit);
		add(lblNombreDeTour);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 0, SpringLayout.NORTH, lblNombreDeTour);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_8, 0, SpringLayout.EAST, lblNewLabel_6);
		add(lblNewLabel_8);
		
		JLabel lblCestLeTour = new JLabel("C'est le tour de :");
		lblCestLeTour.setFont(new Font("Tahoma", Font.BOLD, 13));
		springLayout.putConstraint(SpringLayout.WEST, lblCestLeTour, 36, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblCestLeTour, -28, SpringLayout.SOUTH, this);
		add(lblCestLeTour);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 0, SpringLayout.NORTH, lblCestLeTour);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_9, 17, SpringLayout.EAST, lblCestLeTour);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_9, 82, SpringLayout.EAST, lblCestLeTour);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.ITALIC, 13));
		add(lblNewLabel_9);
		
		JMenuBar menuBar = new JMenuBar();
		springLayout.putConstraint(SpringLayout.WEST, menuBar, 0, SpringLayout.WEST, grille);
		springLayout.putConstraint(SpringLayout.SOUTH, menuBar, -6, SpringLayout.NORTH, grille);
		add(menuBar);
		
		JMenu mnFichier = new JMenu("Options");
		menuBar.add(mnFichier);
		
		JMenuItem mntmMenu = new JMenuItem("Menu");
		mnFichier.add(mntmMenu);
		
		JMenuItem mntmSauvegarder = new JMenuItem("Sauvegarder");
		mnFichier.add(mntmSauvegarder);
		
		JMenuItem mntmQuittere = new JMenuItem("Quitter");
		mnFichier.add(mntmQuittere);

	}
}

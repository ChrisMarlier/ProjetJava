package visuel;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controleur.actionIU;
import modele.GestionMap;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Panneau extends JPanel {
	//Voir exemple dans actionIU
	public static JLabel lblNewLabel = new JLabel(""); // Nom unité à set 
	public static JLabel lblNewLabel_1 = new JLabel("");// pt de vie à set
	public static JLabel lblNewLabel_2 = new JLabel("");// attaque à set
	public static JLabel lblNewLabel_3 = new JLabel("");//Déplacement à set 
	public static JLabel lblNewLabel_4 = new JLabel("");//vision à set
	public static JButton btnPasserLeTour = new JButton("Passer le tour"); //bouton à set (ActionListener)
	public static JLabel lblNewLabel_6 = new JLabel(""); // pts de déplacement restant à set
	public static JLabel lblNewLabel_7 = new JLabel(""); // pts d'action restant à set
	public static JLabel lblNewLabel_8 = new JLabel(""); // nbr de tour à set
	public static JLabel lblNewLabel_9 = new JLabel(""); // nom du joueur à set
	public static JLabel lblNewLabel_11 = new JLabel("");//nbr de pts d'action necessaire pour l'unite
	public int unite;
    public static Previsualisation preview = new Previsualisation();
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
		//Panel pour la preview : 
		//JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, preview, 18, SpringLayout.SOUTH, lblPrvisualisation);
		springLayout.putConstraint(SpringLayout.WEST, preview, 43, SpringLayout.EAST, grille);
		springLayout.putConstraint(SpringLayout.SOUTH, preview, -443, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, preview, -44, SpringLayout.EAST, this);
		add(preview);
		
		//Nom unité : 
		
		JLabel lblNomUnit = new JLabel("Nom unit\u00E9 : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNomUnit, 211, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNomUnit, 23, SpringLayout.EAST, grille);
		add(lblNomUnit);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, lblNomUnit);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 23, SpringLayout.EAST, lblNomUnit);
		add(lblNewLabel);
		
		//Point de vie : 
		
		JLabel lblPointsDeVie = new JLabel("Points de vie :");
		springLayout.putConstraint(SpringLayout.NORTH, lblPointsDeVie, 13, SpringLayout.SOUTH, lblNomUnit);
		springLayout.putConstraint(SpringLayout.WEST, lblPointsDeVie, 23, SpringLayout.EAST, grille);
		add(lblPointsDeVie);
		
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, lblPointsDeVie);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel);
		add(lblNewLabel_1);
		
		//Attaque : 
		
		JLabel lblAttaque = new JLabel("Attaque :");
		springLayout.putConstraint(SpringLayout.WEST, lblAttaque, 23, SpringLayout.EAST, grille);
		add(lblAttaque);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, lblAttaque, 0, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 19, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		add(lblNewLabel_2);
		
		//Déplacement : 
		
		JLabel lblDplacement = new JLabel("D\u00E9placement :");
		springLayout.putConstraint(SpringLayout.NORTH, lblDplacement, 19, SpringLayout.SOUTH, lblAttaque);
		springLayout.putConstraint(SpringLayout.WEST, lblDplacement, 23, SpringLayout.EAST, grille);
		add(lblDplacement);
		
		
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 0, SpringLayout.SOUTH, lblDplacement);
		add(lblNewLabel_3);
		
		//Vision : 
		
		JLabel lblVision = new JLabel("Vision :");
		springLayout.putConstraint(SpringLayout.NORTH, lblVision, 22, SpringLayout.SOUTH, lblDplacement);
		springLayout.putConstraint(SpringLayout.WEST, lblVision, 23, SpringLayout.EAST, grille);
		add(lblVision);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, lblVision);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
		add(lblNewLabel_4);
		
		//bouton passer le tour :
		
		
		add(btnPasserLeTour);
		btnPasserLeTour.addActionListener(new actionIU());
		JLabel lblCaractristiques = new JLabel("Caract\u00E9ristiques :");
		springLayout.putConstraint(SpringLayout.WEST, lblCaractristiques, 6, SpringLayout.EAST, grille);
		springLayout.putConstraint(SpringLayout.SOUTH, lblCaractristiques, -6, SpringLayout.NORTH, lblNomUnit);
		preview.setLayout(new SpringLayout());
		lblCaractristiques.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblCaractristiques);
		
		JLabel lblJoueur = new JLabel("Joueur :");
		lblJoueur.setFont(new Font("Tahoma", Font.BOLD, 13));
		springLayout.putConstraint(SpringLayout.NORTH, lblJoueur, 33, SpringLayout.SOUTH, lblVision);
		springLayout.putConstraint(SpringLayout.WEST, lblJoueur, 6, SpringLayout.EAST, grille);
		add(lblJoueur);
		
		//Points de déplacement :
 		
		JLabel lblNewLabel_5 = new JLabel("Points de d\u00E9placement restant :");
		springLayout.putConstraint(SpringLayout.EAST, btnPasserLeTour, 0, SpringLayout.EAST, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 20, SpringLayout.SOUTH, lblJoueur);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNomUnit);
		add(lblNewLabel_5);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 0, SpringLayout.NORTH, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_6, -10, SpringLayout.EAST, this);
		add(lblNewLabel_6);
		
		//Point d'action : 
		
		JLabel lblPointDactionRestant = new JLabel("Point d'action restant :");
		springLayout.putConstraint(SpringLayout.NORTH, lblPointDactionRestant, 16, SpringLayout.SOUTH, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.WEST, lblPointDactionRestant, 0, SpringLayout.WEST, lblNomUnit);
		add(lblPointDactionRestant);
		
		
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_7, 0, SpringLayout.SOUTH, lblPointDactionRestant);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_7, 0, SpringLayout.EAST, lblNewLabel_6);
		add(lblNewLabel_7);
		
		//Nombre de tour : 
		
		JLabel lblNombreDeTour = new JLabel("Nombre de tour restant :");
		springLayout.putConstraint(SpringLayout.NORTH, btnPasserLeTour, 39, SpringLayout.SOUTH, lblNombreDeTour);
		springLayout.putConstraint(SpringLayout.NORTH, lblNombreDeTour, 20, SpringLayout.SOUTH, lblPointDactionRestant);
		springLayout.putConstraint(SpringLayout.WEST, lblNombreDeTour, 0, SpringLayout.WEST, lblNomUnit);
		add(lblNombreDeTour);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 0, SpringLayout.NORTH, lblNombreDeTour);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_8, 0, SpringLayout.EAST, lblNewLabel_6);
		add(lblNewLabel_8);
		
		//Nom du joueur : 
		JLabel lblCestLeTour = new JLabel("C'est au tour de :");
		lblCestLeTour.setFont(new Font("Tahoma", Font.BOLD, 13));
		springLayout.putConstraint(SpringLayout.WEST, lblCestLeTour, 36, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblCestLeTour, -28, SpringLayout.SOUTH, this);
		add(lblCestLeTour);
		
		
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
		
		JLabel lblPointDaction = new JLabel("Points d'action :");
		springLayout.putConstraint(SpringLayout.WEST, lblPointDaction, 0, SpringLayout.WEST, lblNomUnit);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPointDaction, -6, SpringLayout.NORTH, lblJoueur);
		add(lblPointDaction);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_11, 0, SpringLayout.NORTH, lblPointDaction);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_11, 6, SpringLayout.WEST, lblNewLabel);
		add(lblNewLabel_11);
		
		
	
		
    }
}
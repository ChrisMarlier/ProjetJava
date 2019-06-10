package visuel;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controleur.actionIU;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinJeu extends JPanel {
	public static JButton btnRetourAuMenu = new JButton("Retour au menu");
	public static JButton btnQuitter = new JButton("Quitter");
	public static JLabel lblNewLabel = new JLabel(""); //Gagnant
	public static JLabel lblNewLabel_1 = new JLabel(""); //perdant
	public FinJeu() {
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 201, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, -514, SpringLayout.EAST, this);
		setLayout(springLayout);
		
		JLabel lblFinDuJeu = new JLabel("Fin du jeu");
		springLayout.putConstraint(SpringLayout.NORTH, lblFinDuJeu, 51, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblFinDuJeu, 332, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblFinDuJeu, 523, SpringLayout.WEST, this);
		lblFinDuJeu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 29));
		add(lblFinDuJeu);
		
		JLabel lblLeGagnantEst = new JLabel("Le gagnant est :");
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 201, SpringLayout.EAST, lblLeGagnantEst);
		springLayout.putConstraint(SpringLayout.NORTH, lblLeGagnantEst, 237, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblLeGagnantEst, 69, SpringLayout.WEST, this);
		add(lblLeGagnantEst);
		
		
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 39, SpringLayout.EAST, lblLeGagnantEst);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, lblLeGagnantEst);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		add(lblNewLabel);
		
		JLabel lblLePerdantEst = new JLabel("Le perdant est :");
		springLayout.putConstraint(SpringLayout.NORTH, lblLePerdantEst, 19, SpringLayout.SOUTH, lblLeGagnantEst);
		springLayout.putConstraint(SpringLayout.WEST, lblLePerdantEst, 0, SpringLayout.WEST, lblLeGagnantEst);
		add(lblLePerdantEst);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 0, SpringLayout.SOUTH, lblLePerdantEst);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		add(lblNewLabel_1);
		

		btnRetourAuMenu.addActionListener(new actionIU());
		springLayout.putConstraint(SpringLayout.WEST, btnRetourAuMenu, 276, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnRetourAuMenu, -232, SpringLayout.SOUTH, this);
		add(btnRetourAuMenu);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, btnQuitter, 0, SpringLayout.NORTH, btnRetourAuMenu);
		springLayout.putConstraint(SpringLayout.WEST, btnQuitter, 7, SpringLayout.EAST, btnRetourAuMenu);
		springLayout.putConstraint(SpringLayout.EAST, btnQuitter, 132, SpringLayout.EAST, btnRetourAuMenu);
		btnQuitter.addActionListener(new actionIU());
		add(btnQuitter);

	}
}

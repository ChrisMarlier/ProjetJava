package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visuel.Panneau;

public class actionIU implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Exemple :
			if (arg0.getSource() == Panneau.btnPasserLeTour) {
				System.out.println("Test");
				Panneau.lblNewLabel.setText("Axel");
				Panneau.lblNewLabel_1.setText("100");
				Panneau.lblNewLabel_2.setText("50");
				Panneau.lblNewLabel_3.setText("10");
				Panneau.lblNewLabel_4.setText("0.5");
				Panneau.lblNewLabel_6.setText("5");
				Panneau.lblNewLabel_7.setText("100");
				Panneau.lblNewLabel_8.setText("2");
				Panneau.lblNewLabel_9.setText("Joueur 1 ");
		}
		
	}

}

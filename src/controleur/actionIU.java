package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Unite.*;
import visuel.Panneau;

public class actionIU implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Exemple :
			Tank tanktest = new Tank(0,16);
			if (arg0.getSource() == Panneau.btnPasserLeTour) {
				System.out.println("Test");
				Panneau.lblNewLabel.setText(tanktest.getClass().getName());
				Panneau.lblNewLabel_1.setText(tanktest.getPvMax()+"");
				Panneau.lblNewLabel_2.setText(tanktest.getAtk()+"");
				Panneau.lblNewLabel_3.setText(tanktest.getPtDepMax()+"");
				Panneau.lblNewLabel_4.setText(tanktest.getPorteeAtk()+"");
				Panneau.lblNewLabel_6.setText("5");
				Panneau.lblNewLabel_7.setText("100");
				Panneau.lblNewLabel_8.setText("2");
				Panneau.lblNewLabel_9.setText("Joueur 1 ");
		}
		
	}

}

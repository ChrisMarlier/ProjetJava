package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Unite.*;
import modele.GestionMap;
import visuel.Panneau;

public class actionIU implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Exemple :
		if (arg0.getSource() == Panneau.btnPasserLeTour) {
			GestionMap.passerTour();
			
			if(GestionMap.getModeJeu() == 1) {
				System.out.println("C'est à l'ia de jouer");
				GestionMap.IA();
			}
			
			this.update();
		}
		
	}
	public void update() {
		Tank tanktest = new Tank(0,16);
		int unite = -1;
		if( (GestionMap.getJoueur1().piecedanstableau(GestionMap.caseCliquee.getI(), GestionMap.caseCliquee.getJ()) != -1)) {
			unite=GestionMap.getJoueur1().piecedanstableau(GestionMap.caseCliquee.getI(), GestionMap.caseCliquee.getJ());
			
			Panneau.lblNewLabel.setText(GestionMap.getJoueur1().getUnites().get(unite).getClass().getName());
			Panneau.lblNewLabel_1.setText(GestionMap.getJoueur1().getUnites().get(unite).getPV()+"");
			Panneau.lblNewLabel_2.setText(GestionMap.getJoueur1().getUnites().get(unite).getAtk()+"");
			Panneau.lblNewLabel_3.setText(GestionMap.getJoueur1().getUnites().get(unite).getPtDepMax()+"");
			Panneau.lblNewLabel_4.setText(GestionMap.getJoueur1().getUnites().get(unite).getPorteeAtk()+"");
			
		}
		if( (GestionMap.getJoueur2().piecedanstableau(GestionMap.caseCliquee.getI(), GestionMap.caseCliquee.getJ()) != -1)) {
			unite=GestionMap.getJoueur2().piecedanstableau(GestionMap.caseCliquee.getI(), GestionMap.caseCliquee.getJ());
			
			Panneau.lblNewLabel.setText(GestionMap.getJoueur2().getUnites().get(unite).getClass().getName());
			Panneau.lblNewLabel_1.setText(GestionMap.getJoueur2().getUnites().get(unite).getPV()+"");
			Panneau.lblNewLabel_2.setText(GestionMap.getJoueur2().getUnites().get(unite).getAtk()+"");
			Panneau.lblNewLabel_3.setText(GestionMap.getJoueur2().getUnites().get(unite).getPtDepMax()+"");
			Panneau.lblNewLabel_4.setText(GestionMap.getJoueur2().getUnites().get(unite).getPorteeAtk()+"");
			
		}
			
			
			if(GestionMap.getJoueurActuel() == 1 ) {
				Panneau.lblNewLabel_6.setText(GestionMap.getJoueur1().getPM()+"");
				Panneau.lblNewLabel_7.setText(GestionMap.getJoueur1().getPA()+"");
				Panneau.lblNewLabel_8.setText(GestionMap.getNbrTourRestant()+"");
				Panneau.lblNewLabel_9.setText(GestionMap.getJoueur1().getNom());
			}
			else {
				Panneau.lblNewLabel_6.setText(GestionMap.getJoueur2().getPM()+"");
				Panneau.lblNewLabel_7.setText(GestionMap.getJoueur2().getPA()+"");
				Panneau.lblNewLabel_8.setText(GestionMap.getNbrTourRestant()+"");
				Panneau.lblNewLabel_9.setText(GestionMap.getJoueur2().getNom());
			}

	}

}

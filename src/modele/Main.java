package modele;
import javax.swing.SwingUtilities;

import visuel.Fenetre;

public class Main {

	public static void main(String[] args) {
		
		GestionMap test = new GestionMap();
		test.chargementMap();

		//Unit� unit�=new Unit�(10,10,5,5,10,10,10,0,3);
	//	test.calculeD�placementValide(unit�);
		
		Runnable gui = new Runnable() {
			 public void run() {
				 @SuppressWarnings("unused")
				Fenetre fen = new Fenetre("WarGame",GestionMap.getMap().get(0).size(),GestionMap.getMap().size(),16);
			 }
		};
		 SwingUtilities.invokeLater(gui);
		
	}

}
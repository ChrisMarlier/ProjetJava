package visuel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import modele.GestionMap;
  
@SuppressWarnings("serial")
public class Previsualisation extends JPanel{
    private Image tileset,tank,jeep,inf,tank2,jeep2,inf2;
	int unite = -1;
	private Graphics g;
	public Previsualisation() {

    	//Charge les images : 
    	try {
    		tileset = ImageIO.read(new File("src/resources/fantasyhextiles_v3_borderless.png"));
    		tank = ImageIO.read(new File("src/resources/tank_bleu.png"));
    		jeep = ImageIO.read(new File("src/resources/jeep_bleu.png"));
    		inf = ImageIO.read(new File("src/resources/infanterie_bleu.png"));

    		tank2 = ImageIO.read(new File("src/resources/tank_rouge.png"));
    		jeep2 = ImageIO.read(new File("src/resources/jeep_rouge.png"));
    		inf2 = ImageIO.read(new File("src/resources/infanterie_rouge.png"));
    	}catch(IOException exec) {
    		System.out.println("Erreur source image");
    		exec.printStackTrace();
    	}
    }

    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	  Graphics2D g3 = (Graphics2D)g;
         if(GestionMap.getJoueur1().piecedanstableau(GestionMap.caseCliquee.getI(), GestionMap.caseCliquee.getJ()) != -1) {
           	 unite=GestionMap.getJoueur1().piecedanstableau(GestionMap.caseCliquee.getI(), GestionMap.caseCliquee.getJ());
	    	 switch(GestionMap.getJoueur1().getUnites().get(unite).getClass().getName()) {
	    	 	case "Unite.Tank" :
	    	 		g3.drawImage(tank, 0,0,this);
	    	 		break;
	    	 	case "Unite.Jeep" :
	    	 		g3.drawImage(jeep, 0,0,this);
	    	 		break;
	    	 	case "Unite.InfanterieLegere":
	    	 		g3.drawImage(inf,0,0,this);
	    	 		break;
	    	
	    	 }
         }
         if(GestionMap.getJoueur2().piecedanstableau(GestionMap.caseCliquee.getI(), GestionMap.caseCliquee.getJ()) != -1) {
           	 unite=GestionMap.getJoueur2().piecedanstableau(GestionMap.caseCliquee.getI(), GestionMap.caseCliquee.getJ());
	    	 switch(GestionMap.getJoueur2().getUnites().get(unite).getClass().getName()) {
	    	 	case "Unite.Tank" :
	    	 		g3.drawImage(tank2, 0,0,this);
	    	 		break;
	    	 	case "Unite.Jeep" :
	    	 		g3.drawImage(jeep2, 0,0,this);
	    	 		break;
	    	 	case "Unite.InfanterieLegere":
	    	 		g3.drawImage(inf2,0,0,this);
	    	 		break;
	    	
	    	 }
         }
   
       
    }


    
    
    

	 
    
}

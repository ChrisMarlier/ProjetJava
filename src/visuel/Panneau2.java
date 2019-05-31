package visuel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import modele.GestionMap;
  
@SuppressWarnings("serial")
public class Panneau2 extends JPanel{
    private static final int tW = 32; // tile width
    private static final int tH = 48; // tile height
    private Image tileset,tank,jeep,inf,tank2,jeep2,inf2;
    private final Polygon hexagone = new Polygon();
    private final BasicStroke bs1 = new BasicStroke(1);
    private final BasicStroke bs3 = new BasicStroke(3);
    private final Point focusedHexagonLocation = new Point();
    private final Dimension dimension;
    private final int rows, columns, side;
    private Point mousePosition;
    private int number;
	private Graphics2D g3;
	private int dim1;
	private int dim2;
    //TODO JavBar , GameUI, Previsualisation de l'unite ...
    public Panneau2(final int rows, final int columns, final int side) {
    	this.rows=rows;
    	this.columns=columns;
    	this.side=side;
    	dimension=getHexagon(0,0).getBounds().getSize();
    	MouseInputAdapter mouseHandler = new MouseInputAdapter() {
            @Override
            public void mouseMoved(final MouseEvent e) {
                mousePosition = e.getPoint();
                repaint();
            }
            @Override
            //Donne le num de l'h�xagone quand on clique dessus
            public void mousePressed(final MouseEvent e) {
                int x= e.getX();
                int y=e.getY();
                if (x <= 465 && y <= 510) {
                
              
                if (number != -1) {
                    System.out.println("Hexagon " + (number + 1));
                    
                }
                System.out.println("XX="+ x + "YY=" + y);
                }
                else {
                System.out.println("Clic en dehors de la map");
                }
            }

                private void and(boolean b) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
        };
        //addMouseListener(new GestionClic());
        addMouseMotionListener(mouseHandler);
        addMouseListener(mouseHandler);
        
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
    	//conversion du graphic g en graphique 2D
    	 Graphics2D g2 = (Graphics2D) g;
    	 
    	//efface l'�cran
    	 g2.clearRect(0, 0, getWidth(), getHeight());
    	 g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                 RenderingHints.VALUE_ANTIALIAS_ON);
         g2.setStroke(bs1);
         number = -1;
         
         //Schema type even-q : 
         for (int row = 0; row < rows; row++) {
             for (int column = 1; column < columns; column += 2) {
            	 System.out.println("x:"+(int) (column * side * 1.5 )+"y:"+ row * (dimension.height));
                 getHexagon((int) (column * side * 1.5), (row * (dimension.height)));
                 
                 //D�limite un hexagone
                 if (mousePosition !=null && hexagone.contains(mousePosition)){
                     focusedHexagonLocation.y = row * (dimension.height);
                     focusedHexagonLocation.x= (int) (column * side*1.5 );
                     number = column * rows + row;
                 }
                
               //Dessine les images donn�es par la map
             /* 
                 drawTile(g2,modele.GestionMap.getMap().get(row).get(column),(int)(hexagone.getBounds().x ),
                       (int) (hexagone.getBounds().y-20));
             */
              
              // DEBUG : Dessine une grille :  
                 g2.draw(hexagone);
              
             }
         }
         
         
         for (int row = 0; row < rows; row++) {
             for (int column = 0; column < columns; column += 2) {
            	 
                 getHexagon((int) (column * side * 1.5 ),row * (dimension.height) + dimension.height/ 2
                         );
                 //D�limite un hexagone :
                 if (mousePosition!= null && hexagone.contains(mousePosition)){
                     focusedHexagonLocation.y = row * (dimension.height)
                             + dimension.height / 2;
                     focusedHexagonLocation.x =(int) (column * side * 1.5 );
                     number = column * rows + row;
                 }
                 //Dessine les images donn�es par la map
               /*
                 drawTile(g2,GestionMap.getMap().get(row).get(column),(int)(hexagone.getBounds().x ),
                       (int) (hexagone.getBounds().y-20)); 
               */
           //DEBUG :  Dessine une grille  : 
                g2.draw(hexagone);
             
             }
         }
         
         //Affichage Unit�sJ1 : 
         g3=(Graphics2D) g;

         for(int i = 0; i < GestionMap.getJoueur1().getUnites().size() ; i++) {
    
        	 
        	 dim1 = (int) ((GestionMap.getJoueur1().getUnites().get(i).getCoordonneeI()*side*1.5)+8);
        	 dim2 = ((GestionMap.getJoueur1().getUnites().get(i).getCoordonneeJ()* (dimension.height))+7);
        	 
        	 if(GestionMap.getJoueur1().getUnites().get(i).getCoordonneeI()%2 == 0) {
        		 dim1 = (int) ((GestionMap.getJoueur1().getUnites().get(i).getCoordonneeI()*side*1.5)+8);
        		 dim2 = ((GestionMap.getJoueur1().getUnites().get(i).getCoordonneeJ()*(dimension.height)
                     + dimension.height / 2 )+7);
        		 }
        	 
        	 switch(GestionMap.getJoueur1().getUnites().get(i).getClass().getCanonicalName()) {
        	 	case "Unite.Tank" :
        	 		g3.drawImage(tank, dim1,dim2,this);
        	 		break;
        	 	case "Unite.Jeep" :
        	 		g3.drawImage(jeep, dim1,dim2,this);
        	 		break;
        	 	case "Unite.InfanterieLegere":
        	 		g3.drawImage(inf,dim1,dim2,this);
        	 		break;
        	
        	 }
         }
         //Affichage Unit�s J2 :
         for(int i = 0; i < GestionMap.getJoueur2().getUnites().size() ; i++) {
        	 
        	 int dim1;
        	 int dim2;
        	 
        	 
        	 dim1 = (int) ((GestionMap.getJoueur2().getUnites().get(i).getCoordonneeI()*side*1.5)+8);
        	 dim2 = ((GestionMap.getJoueur2().getUnites().get(i).getCoordonneeJ()* (dimension.height))+7);
        	 
        	 if(GestionMap.getJoueur2().getUnites().get(i).getCoordonneeI()%2 == 0) {
        		 dim1 = (int) ((GestionMap.getJoueur2().getUnites().get(i).getCoordonneeI()*side*1.5)+8);
        		 dim2 = ((GestionMap.getJoueur2().getUnites().get(i).getCoordonneeJ()*(dimension.height)
                     + dimension.height / 2 )+7);
        		 }
        	 
        	 switch(GestionMap.getJoueur2().getUnites().get(i).getClass().getCanonicalName()) {
        	 	case "Unite.Tank" :
        	 		g3.drawImage(tank2, dim1,dim2,this);
        	 		break;
        	 	case "Unite.Jeep" :
        	 		g3.drawImage(jeep2, dim1,dim2,this);
        	 		break;
        	 	case "Unite.InfanterieLegere":
        	 		g3.drawImage(inf2,dim1,dim2,this);
        	 		break;
        	
        	 }
         }
         //surbrillance case
         if (number != -1) {
             g2.setColor(Color.red);
             g2.setStroke(bs3);
             Polygon focusedHexagon = getHexagon(focusedHexagonLocation.x,
                     focusedHexagonLocation.y);
             g2.draw(focusedHexagon);
         }
       
    }
    //D�finit les coordonn�es des 6 points d'un hexagone
    public Polygon getHexagon(final int x, final int y) {
        hexagone.reset();
        int h = side / 2;
        int w = (int) (side * (Math.sqrt(3) / 2));
        hexagone.addPoint(x + h, y);//1
        hexagone.addPoint(x , y + w);//2
        hexagone.addPoint(x + h, y +  2 * w);//3
        hexagone.addPoint(x + (int) (1.5 * side) , y + 2 * w);//4
        hexagone.addPoint(x + 2 * side , y + w);//5
        hexagone.addPoint(x + (int) (1.5 * side), y );//6
        return hexagone;
    }
    
    //decoupe le "Tile" demand� du Tileset
    protected void drawTile(Graphics g, int t, int x, int y){
    	 Graphics2D g2 = (Graphics2D) g;
        //
        int mx = t%8;
        int my = t/8;
        g2.drawImage(tileset, x, y, x+tW, y+tH,
                mx*tW, my*tH,  mx*tW+tW, my*tH+tH, this);
        
    }
}

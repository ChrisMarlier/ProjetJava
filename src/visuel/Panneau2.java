package visuel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.event.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import modele.GestionMap;

@SuppressWarnings("serial")
public class Panneau2 extends JPanel{
    private static final int tW = 32; // tile width
    private static final int tH = 48; // tile height
    private Image tileset;
    private final Polygon hexagon = new Polygon();
    private final BasicStroke bs1 = new BasicStroke(1);
    private final BasicStroke bs3 = new BasicStroke(3);
    private final Point focusedHexagonLocation = new Point();
    private final Dimension dimension;
    private final int rows, columns, side;
    private Point mousePosition;
    private int number;

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
            //Donne le num de l'hexagone quand on clique dessus
            public void mousePressed(final MouseEvent e) {
                if (number != -1) {
                    System.out.println("Hexagon " + (number + 1));
                }
            }
        };
        addMouseMotionListener(mouseHandler);
        addMouseListener(mouseHandler);

    	//Charge l'image Tileset qui contient tous les tiles
    	try {
    		tileset = ImageIO.read(new File("src/resources/fantasyhextiles_v3_borderless.png"));
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

    	//efface l'ecran
    	 g2.clearRect(0, 0, getWidth(), getHeight());
    	 g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                 RenderingHints.VALUE_ANTIALIAS_ON);
         g2.setStroke(bs1);
         number = -1;

         //Schema type even-q :
         for (int column = 0; column < columns; column++) {
             for (int row = 1; row < rows; row += 2) {

                 getHexagon((int) (row * side * 1.5), ((int)(column * (dimension.width-5))));

                 //Delimite un hexagone
                 if (mousePosition !=null && hexagon.contains(mousePosition)){
                     focusedHexagonLocation.y = column * (dimension.width-5);
                     focusedHexagonLocation.x= (int) (row * side * 1.5);
                     number = row * columns + column;
                 }
               //Dessine les images donnees par la map
                 drawTile(g2,modele.GestionMap.getMap().get(column).get(row),(int)(hexagon.getBounds().x ),
                         (int) (hexagon.getBounds().y-20));
             // Dessine une grille :  g2.draw(hexagon);

             }
         }

         for (int column = 0; column < columns; column++) {
             for (int row = 0; row < rows; row += 2) {

                 getHexagon((int) (row * side * 1.5 + 0.5),column * (dimension.width-5) + dimension.width / 2
                         );
                 //Delimite un hexagone :
                 if (mousePosition!= null && hexagon.contains(mousePosition)){
                     focusedHexagonLocation.y = column * (dimension.width-5)
                             + dimension.width / 2;
                     focusedHexagonLocation.x =(int) (row * side * 1.5 + 0.5);
                     number = row * columns + column;
                 }
                 //Dessine les images donnees par la map
                 drawTile(g2,GestionMap.getMap().get(column).get(row),(int)(hexagon.getBounds().x ),
                         (int) (hexagon.getBounds().y-20));
           //   Dessine une grille : g2.draw(hexagon);

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
    //Definit les coordonnees des 6 points d'un hexagone
    public Polygon getHexagon(final int x, final int y) {
        hexagon.reset();
        int h = side / 2;
        int w = (int) (side * (Math.sqrt(3) / 2));
        hexagon.addPoint(x + h, y);//1
        hexagon.addPoint(x , y + w);//2
        hexagon.addPoint(x + h, y +  2 * w);//3
        hexagon.addPoint(x + (int) (1.5 * side) , y + 2 * w);//4
        hexagon.addPoint(x + 2 * side , y + w);//5
        hexagon.addPoint(x + (int) (1.5 * side), y );//6
        return hexagon;
    }

    //decoupe le "Tile" demande du Tileset
    protected void drawTile(Graphics g, int t, int x, int y){
    	 Graphics2D g2 = (Graphics2D) g;
        //
        int mx = t%8;
        int my = t/8;
        g2.drawImage(tileset, x, y, x+tW, y+tH,
                mx*tW, my*tH,  mx*tW+tW, my*tH+tH, this);

    }
}

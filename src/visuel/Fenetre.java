package visuel;
import javax.swing.*;

import java.awt.*;
public class Fenetre {
	private static JFrame frame;
	private static Panneau panneau;
	private static JPanel container = new JPanel();
	public Fenetre(JFrame frame,String ptitre,int columns, int rows,int side) {
		panneau  = new Panneau(columns,rows,side);
		frame.setTitle(ptitre);
		frame.setSize(900,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(panneau,BorderLayout.CENTER);
		frame.setContentPane(container);
		

	}
	public static void Fin() {
		FinJeu fin = new FinJeu();
		panneau.setVisible(false);
		container.add(fin,BorderLayout.CENTER);

	}

}
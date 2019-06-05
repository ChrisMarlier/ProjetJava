package visuel;
import javax.swing.*;

import java.awt.*;
@SuppressWarnings("serial")
public class Fenetre {
	private JFrame frame;
	
	private JPanel container = new JPanel();
	public Fenetre(JFrame frame,String ptitre,int columns, int rows,int side) {
		Panneau panneau = new Panneau(columns,rows,side);
		frame.setTitle(ptitre);
		frame.setSize(900,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(panneau,BorderLayout.CENTER);
		frame.setContentPane(container);
		

	}

}

package visuel;
import javax.swing.*;

import java.awt.*;
@SuppressWarnings("serial")
public class Fenetre extends JFrame{
	
	private JPanel container = new JPanel();
	public Fenetre(String ptitre,int columns, int rows,int side) {
		Panneau panneau = new Panneau(columns,rows,side);
		this.setTitle(ptitre);
		this.setSize(900,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(panneau,BorderLayout.CENTER);
		this.setContentPane(container);
		this.setVisible(true);

	}

}
package menu;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Bouton extends JButton {

	private static final long serialVersionUID = 1L;

	public Bouton(String txt)
	{
		super(txt);
		setFont(getFont().deriveFont(16.0f));

		setForeground(Color.WHITE);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(false);

		setHorizontalAlignment(SwingConstants.CENTER);
		setHorizontalTextPosition(SwingConstants.CENTER);

		setIcon(new ImageIcon("src/resources/btn1.png"));
		setRolloverIcon(new ImageIcon("src/resources/btn2.png"));
	}

}

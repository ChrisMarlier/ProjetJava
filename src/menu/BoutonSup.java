package menu;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class BoutonSup extends JButton {

	private static final long serialVersionUID = 1L;

	public BoutonSup(String txt)
	{
		super(txt);
		setFont(getFont().deriveFont(16.0f));

		setForeground(Color.WHITE);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(false);

		setHorizontalTextPosition(SwingConstants.CENTER);

		setIcon(new ImageIcon("images/btn1.png"));
		setRolloverIcon(new ImageIcon("images/btn2.png"));
	}

}

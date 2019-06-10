package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import visuel.FinJeu;

public class Jeu extends JFrame {

	private static final long serialVersionUID = 1L;

	public Image fondecran;
	private String title;
	private ImagePanel panel;

	private JLabel gameTitle;
	private Bouton nouvellePartieBtn;
	private Bouton chargerPartieBtn;
	private Bouton aideBtn;
	private JPanel menuPrincipal;
	public static Jeu instance = null;

	public Jeu(String title) {
		if (instance != null)
			return;
		instance = this;
		this.title = title;
		
		chargerRessources();
		initCanvas();
	}

	private void chargerRessources() {
		try {
			fondecran = ImageIO.read(new File("src/resources/bg.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void updatePanel(ImagePanel panel) {
		remove(this.panel);
		this.panel = panel;
		add(panel);
		pack();
	}
	public void reset() {
		remove(this.panel);
		chargerRessources();
		initCanvas();
		
	}


	public void initCanvas() {
		Dimension d = new Dimension(800, 700);
		setAutoRequestFocus(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		setMinimumSize(d);
		setMaximumSize(d);
		setPreferredSize(d);
		setSize(d);

		gameTitle = new JLabel(title);
		gameTitle.setForeground(Color.WHITE);
		gameTitle.setFont(gameTitle.getFont().deriveFont(64.0f));
		gameTitle.setHorizontalAlignment(SwingConstants.CENTER);

		nouvellePartieBtn = new Bouton("Nouvelle Partie");
		chargerPartieBtn = new Bouton("Charger Partie");
		aideBtn = new Bouton("Aide");

		nouvellePartieBtn.addActionListener(new BoutonActionListener(1,this));
		chargerPartieBtn.addActionListener(new BoutonActionListener(2,this));
		aideBtn.addActionListener(new BoutonActionListener(3,this));

		panel = new ImagePanel(fondecran);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		panel.add(gameTitle);
		panel.add(nouvellePartieBtn);
		panel.add(chargerPartieBtn);
		panel.add(aideBtn);
		setMenuPrincipal(panel);
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public JPanel getMenuPrincipal() {
		return menuPrincipal;
	}

	public void setMenuPrincipal(JPanel menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}

	

}

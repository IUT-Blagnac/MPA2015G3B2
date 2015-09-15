import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class sprint0 {
	public static void main(String[] args) {
		//Fabrique la fenetre
		JFrame fenetre = new JFrame();
		//Conteneur des onglets
		JTabbedPane tabbedPane = new JTabbedPane();
		//Définit le BorderLayout (ce qui organise les éléments dans la fenêtre)
		Container pane = fenetre.getContentPane();
		pane.setLayout(new BorderLayout());
		//Définit l'ecouteur pour le bouton "Quitter"
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane pan = new JOptionPane();
				if (JOptionPane.showConfirmDialog(pan,
						"Voulez-vous vraiment quitter ?") == 0) {
					System.exit(0);
				}
				;
			}
		};

		//Crée la bouton Quitter
		JButton quitter = new JButton("Quitter");
		//Crée la zone de texte
		JLabel test = new JLabel();
		JLabel rien = new JLabel();
		//Ajoute au bouton "Quitter", l'écouteur
		quitter.addActionListener(actionListener);
		//Définit le texte dans le Jlabel
		test.setText("<HTML>Liste des membres du groupe : <br>"
				+ "- Florian SEGUIN <br>" + "- Guilhem SABATHIER <br>"
				+ "- Cedric DOULIEZ <br>" + "- Simon TAILLEFER <br>"
				+ "- Antoine BADOC <br>" + "- Mickael BAUTISTA <br>"
				+ "Université Toulouse 2 <br>" + "DUT de Blagnac <br>"
				+ "Projet OPTI <br>");
		//Ajout de l'élement dans les onglets
		tabbedPane.addTab("Test", rien);
		tabbedPane.addTab("A propos", test);
		//Mise en place des éléments
		pane.add(quitter, BorderLayout.PAGE_END);
		pane.add(tabbedPane);
		fenetre.pack();
		fenetre.setVisible(true);
	}



}

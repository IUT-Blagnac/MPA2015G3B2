import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Sprint {
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

		//Crée la zone de texte
		JLabel apropos = new JLabel();
		//Crée la bouton Quitter
		JButton quitter = new JButton("Quitter");
		//Ajoute au bouton "Quitter", l'écouteur
		quitter.addActionListener(actionListener);
		//Définit le texte dans le Jlabel
		apropos.setText("<HTML>Liste des membres du groupe : <br>"
				+ "- Florian SEGUIN <br>" + "- Guilhem SABATHIER <br>"
				+ "- Cedric DOULIEZ <br>" + "- Simon TAILLEFER <br>"
				+ "- Antoine BADOC <br>" + "- Mickael BAUTISTA <br>"
				+ "Université Toulouse 2 <br>" + "DUT de Blagnac <br>"
				+ "Projet OPTI <br>");
		
		
		JPanel sujets = new JPanel(new BorderLayout());
		JPanel Centre = new JPanel();
		JPanel Sud = new JPanel(new FlowLayout());
		JButton creersujet = new JButton("Créer un sujet");
		JButton modifiersujet = new JButton("Modifier un sujet");
		JButton supprimersujet = new JButton("Supprimer un sujet");
		Sud.add(creersujet);
		Sud.add(modifiersujet);
		Sud.add(supprimersujet);
		
		
		
		//Ajout de l'élement dans les onglets
		tabbedPane.addTab("Sujets", sujets);
		tabbedPane.addTab("A propos", apropos);
		//Mise en place des éléments
		pane.add(quitter, BorderLayout.PAGE_END);
		pane.add(tabbedPane);
		fenetre.pack();
		fenetre.setVisible(true);
	}



}

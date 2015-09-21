import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

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
		JPanel Sud = new JPanel(new FlowLayout());
		JButton creersujet = new JButton("Créer un sujet");
		JButton modifiersujet = new JButton("Modifier un sujet");
		JButton supprimersujet = new JButton("Supprimer un sujet");
		JList<String> Centre = new JList<String>();
		JScrollPane elderscrolls = new JScrollPane();
		Centre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		elderscrolls.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		elderscrolls.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		elderscrolls.setViewportView(Centre);
		Sud.add(creersujet);
		Sud.add(modifiersujet);
		Sud.add(supprimersujet);
		sujets.add(Sud, BorderLayout.SOUTH);
		sujets.add(elderscrolls,BorderLayout.CENTER);
		
		
		
		//Ajout de l'élement dans les onglets
		tabbedPane.addTab("Sujets", sujets);
		tabbedPane.addTab("A propos", apropos);
		//Mise en place des éléments
		pane.add(quitter, BorderLayout.PAGE_END);
		pane.add(tabbedPane);
		fenetre.pack();
		fenetre.setVisible(true);
		
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Créer un sujet")) {
					JFrame creer = new JFrame();
					JPanel Topcreer = new JPanel(new BorderLayout());
					JPanel Botcreer = new JPanel(new BorderLayout());
					JLabel nomnomsujet = new JLabel("Nom du Sujet : ");
					JLabel nomtitre = new JLabel("Titre : ");
					JTextField nomsujet = new JTextField();
					JTextField titre = new JTextField();
					creer.setLayout(new BorderLayout());
					Topcreer.add(nomnomsujet, BorderLayout.NORTH);
					Topcreer.add(nomsujet, BorderLayout.CENTER);
					Botcreer.add(nomtitre, BorderLayout.NORTH);
					Botcreer.add(titre, BorderLayout.CENTER);
					creer.add(Topcreer, BorderLayout.NORTH);
					creer.add(Botcreer, BorderLayout.CENTER);
					creer.setVisible(true);
					creer.pack();
					
				}
			}
			
		};
		
		creersujet.addActionListener(action);
		
	}



}

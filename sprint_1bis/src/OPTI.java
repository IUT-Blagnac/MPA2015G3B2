import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class OPTI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JTabbedPane tabbedPane;
	
	public OPTI(String title){
		super(title);
		this.setLayout(new BorderLayout());
		addTabbedPane();
		addQuitButton();
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(
	    		  new WindowAdapter(){
	    		    public void windowClosing(WindowEvent e) {
	    		    	if (JOptionPane.showConfirmDialog(new JOptionPane(),
	    						"Voulez-vous vraiment quitter ?") == 0) {
	    					System.exit(0);
	    				}
	    		    }
	    		  });
	}
	
	private void addTabbedPane(){
		tabbedPane = new JTabbedPane();
		String sujet = "csv/sujets2014_2015.csv";
		String etudiant = "csv/etudiants2014_2015.csv";
		String intervenant = "csv/intervenants2014_2015.csv";
		String projet = "csv/projets2014_2015.csv";
		JPanel etu = new JPanel(new BorderLayout());
		JPanel suj = new JPanel(new BorderLayout());
		JPanel interv = new JPanel(new BorderLayout());
		JPanel sud = new JPanel(new FlowLayout());
		JPanel sud2 = new JPanel(new FlowLayout());
		JPanel sud3 = new JPanel(new FlowLayout());
		JButton ajoutetu = new JButton("Ajouter un étudiant");
		JButton modifetu = new JButton("Modifier un étudiant");
		JButton suppretu = new JButton("Supprimer un étudiant");
		JButton ajoutsuj = new JButton("Ajout d'un sujet");
		JButton modifsuj = new JButton("Modifier un sujet");
		JButton supprsuj = new JButton("Supprimer un sujet");
		JButton ajoutinterv = new JButton("Ajout d'un intervenant");
		JButton modifinterv = new JButton("Modifier un intervenant");
		JButton supprinterv = new JButton("Supprimer un intervenant");
		
		ajoutsuj.addActionListener(new Action());
		try {
			etu.add(new OPTITableau(LibCSV.readValues(etudiant), LibCSV.readTitles(etudiant)), BorderLayout.CENTER);
			suj.add(new OPTITableau(LibCSV.readValues(sujet), LibCSV.readTitles(sujet)), BorderLayout.CENTER);
			interv.add(new OPTITableau(LibCSV.readValues(intervenant), LibCSV.readTitles(intervenant)));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		sud.add(ajoutetu);
		sud.add(modifetu);
		sud.add(suppretu);
		sud2.add(ajoutsuj);
		sud2.add(modifsuj);
		sud2.add(supprsuj);
		sud3.add(ajoutinterv);
		sud3.add(modifinterv);
		sud3.add(supprinterv);
		etu.add(sud, BorderLayout.SOUTH);
		suj.add(sud2, BorderLayout.SOUTH);
		interv.add(sud3, BorderLayout.SOUTH);
		try{
		tabbedPane.addTab("Etudiants", etu);
		tabbedPane.addTab("Sujets", suj);
		tabbedPane.addTab("Intervenants",interv);
		//NE FONCTIONNE PAS//tabbedPane.addTab("Projets", new OPTITableau(LibCSV.readValues(projet), LibCSV.readTitles(projet)));
		tabbedPane.addTab("A propos", new JLabel("<HTML>Liste des membres du groupe : <br>"
				+ "- Florian SEGUIN <br>" + "- Guilhem SABATHIER <br>"
				+ "- Cedric DOULIEZ <br>" + "- Simon TAILLEFER <br>"
				+ "- Antoine BADOC <br>" + "- Mickael BAUTISTA <br>"
				+ "Université Toulouse 2 <br>" + "IUT de Blagnac <br>"
				+ "DUT INFO S3/Module MPA <br>" + "Projet OPTI <br>"
				+ "SPRINT 1"));
		this.add(tabbedPane, BorderLayout.CENTER);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, e.toString());
		}
	}
	
	private void addQuitButton(){
		JPanel southPane = new JPanel(new BorderLayout());
			JButton quitter = new JButton("Quitter");
			quitter.addActionListener(new Quitter());
		southPane.add(quitter, BorderLayout.CENTER);
		this.add(southPane, BorderLayout.SOUTH);
	}
	
	class Action implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			final JFrame creer = new JFrame("Ajout d'un sujet");
			if (e.getActionCommand().equals("Créer un sujet")) {
				ActionListener actioninaction = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand().equals("Annuler")) {
							creer.dispose();
						}
					}
				};
				JPanel Topcreer = new JPanel(new BorderLayout());
				JPanel Centrecreer = new JPanel(new BorderLayout());
				JPanel Botcreer = new JPanel(new FlowLayout());
				JLabel nomnomsujet = new JLabel("Nom du Sujet : ");
				JLabel nomtitre = new JLabel("Titre : ");
				JButton validbouton = new JButton("Valider");
				JButton annulbouton = new JButton("Annuler");
				JTextField nomsujet = new JTextField();
				JTextField titre = new JTextField();
				creer.setLayout(new BorderLayout());
				Botcreer.add(validbouton);
				Botcreer.add(annulbouton);
				Topcreer.add(nomnomsujet, BorderLayout.NORTH);
				Topcreer.add(nomsujet, BorderLayout.CENTER);
				Centrecreer.add(nomtitre, BorderLayout.NORTH);
				Centrecreer.add(titre, BorderLayout.CENTER);
				creer.add(Topcreer, BorderLayout.NORTH);
				creer.add(Centrecreer, BorderLayout.CENTER);
				creer.add(Botcreer, BorderLayout.SOUTH);
				creer.setVisible(true);
				creer.pack();
				annulbouton.addActionListener(actioninaction);				
			}
		}
	}
	
	class Quitter implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {
			JOptionPane pan = new JOptionPane();
			if (JOptionPane.showConfirmDialog(pan,
					"Voulez-vous vraiment quitter ?") == 0) {
				System.exit(0);
			}
		}
	}
	
	public static void main(String[] args) {
		OPTI f = new OPTI("test");
		f.setLocationRelativeTo(null);
		f.pack();
		f.setVisible(true);
		/*
		//Fabrique la fenetre
		JFrame fenetre = new JFrame("OTPI PROJET");
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
				+ "Université Toulouse 2 <br>" + "IUT de Blagnac <br>"
				+ "DUT INFO S3/Module MPA <br>" + "Projet OPTI <br>"
				+ "SPRINT 1");
		
		
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
		
		JPanel voeux = new JPanel(new BorderLayout());
		JPanel Sud2 = new JPanel(new FlowLayout());
		JButton defgroupe = new JButton("Définir un groupe");
		JButton associeretu = new JButton("Associer à un groupe...");
		JList<String> Centre2 = new JList<String>();
		JScrollPane elderscrolls2 = new JScrollPane();
		Centre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		elderscrolls2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		elderscrolls2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		elderscrolls2.setViewportView(Centre2);
		Sud2.add(defgroupe);
		Sud2.add(associeretu);
		voeux.add(Sud2, BorderLayout.SOUTH);
		voeux.add(elderscrolls2,BorderLayout.CENTER);
		
		
		JPanel affectation = new JPanel();
		JPanel Sud3 = new JPanel(new FlowLayout());
		JButton affecinter = new JButton("Affecter un intervenant");
		JButton affecgroupe = new JButton("Affecter un groupe");
		Sud3.add(affecgroupe);
		Sud3.add(affecinter);
		affectation.add(Sud3, BorderLayout.SOUTH);

		
		
		
		//Ajout de l'élement dans les onglets
		tabbedPane.addTab("Sujets", sujets);
		tabbedPane.addTab("Voeux", voeux);
		tabbedPane.addTab("Affactations", affectation);
		tabbedPane.addTab("A propos", apropos);
		//Mise en place des éléments
		pane.add(quitter, BorderLayout.PAGE_END);
		pane.add(tabbedPane);
		fenetre.pack();
		fenetre.setVisible(true);
		
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFrame creer = new JFrame("Ajout d'un sujet");
				if (e.getActionCommand().equals("Créer un sujet")) {
					ActionListener actioninaction = new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (e.getActionCommand().equals("Annuler")) {
								creer.dispose();
							}
		
						}
						
					};
					JPanel Topcreer = new JPanel(new BorderLayout());
					JPanel Centrecreer = new JPanel(new BorderLayout());
					JPanel Botcreer = new JPanel(new FlowLayout());
					JLabel nomnomsujet = new JLabel("Nom du Sujet : ");
					JLabel nomtitre = new JLabel("Titre : ");
					JButton validbouton = new JButton("Valider");
					JButton annulbouton = new JButton("Annuler");
					JTextField nomsujet = new JTextField();
					JTextField titre = new JTextField();
					creer.setLayout(new BorderLayout());
					Botcreer.add(validbouton);
					Botcreer.add(annulbouton);
					Topcreer.add(nomnomsujet, BorderLayout.NORTH);
					Topcreer.add(nomsujet, BorderLayout.CENTER);
					Centrecreer.add(nomtitre, BorderLayout.NORTH);
					Centrecreer.add(titre, BorderLayout.CENTER);
					creer.add(Topcreer, BorderLayout.NORTH);
					creer.add(Centrecreer, BorderLayout.CENTER);
					creer.add(Botcreer, BorderLayout.SOUTH);
					creer.setVisible(true);
					creer.pack();
					annulbouton.addActionListener(actioninaction);				
				}
			}
			
		};
		creersujet.addActionListener(action);
		*/
	}



}

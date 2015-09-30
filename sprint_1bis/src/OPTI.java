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
			final JFrame creer = new JFrame("Ajout d'un objet");
			if (e.getActionCommand().equals("Ajout d'un sujet")) {
				ActionListener actioninaction = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand().equals("Annuler")) {
							creer.dispose();
						}
					}
				};
				JPanel Botcreer = new JPanel(new FlowLayout());
				JButton validbouton = new JButton("Valider");
				JButton annulbouton = new JButton("Annuler");
				creer.setLayout(new BorderLayout());
				try {
					JPanel[] layouts = new JPanel[LibCSV.readTitles("csv/sujets2014_2015.csv").length];
					Object position[] = {BorderLayout.NORTH, BorderLayout.CENTER, BorderLayout.SOUTH};
					int k = 0;
					for(int i = 0; i< LibCSV.readTitles("csv/sujets2014_2015.csv").length; i++){
						if(! LibCSV.readTitles("csv/sujets2014_2015.csv")[i].equals("id")){
							layouts[i] = new JPanel(new BorderLayout());
							layouts[i].add(new JLabel(LibCSV.readTitles("csv/sujets2014_2015.csv")[i]), BorderLayout.NORTH);
							layouts[i].add(new JTextField(), BorderLayout.SOUTH);
							creer.add(layouts[i], position[k]);
							k++;
						}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Botcreer.add(validbouton);
				Botcreer.add(annulbouton);
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
	}



}

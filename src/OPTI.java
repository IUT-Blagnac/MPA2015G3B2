import java.awt.BorderLayout;
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
		String groupe = "csv/groupes2014_2015.csv";
		try{
		tabbedPane.addTab("Etudiants", new OPTITableau(etudiant));
		tabbedPane.addTab("Sujets", new OPTITableau(sujet));
		tabbedPane.addTab("Intervenants",new OPTITableau(intervenant));
		tabbedPane.addTab("Projets", new OPTITableauProjet(projet));
		tabbedPane.addTab("Groupes", new OPTITableau(groupe));
		tabbedPane.addTab("A propos", new JLabel("<HTML>Liste des membres du groupe : <br>"
				+ "- Florian SEGUIN <br>" + "- Guilhem SABATHIER <br>"
				+ "- Cedric DOULIEZ <br>" + "- Simon TAILLEFER <br>"
				+ "- Antoine BADOC <br>" + "- Mickael BAUTISTA <br>"
				+ "Université Toulouse 2 <br>" + "IUT de Blagnac <br>"
				+ "DUT INFO S3/Module MPA <br>" + "Projet OPTI <br>"
				+ "SPRINT 1bis"));
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
		OPTI f = new OPTI("OPTI");
		f.setLocationRelativeTo(null);
		f.pack();
		f.setVisible(true);
	}
}

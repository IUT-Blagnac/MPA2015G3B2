package ihm;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

	


public class OPTITableauProjet extends OPTITableau{
	private static final long serialVersionUID = 1L;
	
	

	public OPTITableauProjet(Csv csv) {
		super(csv);
		this.addButton();
	}
	
	private void addButton(){
		JPanel button = new JPanel(new FlowLayout());
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.addActionListener(new Ajouter());
		button.add(ajouter);
		
		JButton cloner = new JButton("Cloner");
		cloner.addActionListener(new Cloner());
		button.add(cloner);
		
		JButton supprimer = new JButton("Supprimer");
		supprimer.addActionListener(new Supprimer());
		button.add(supprimer);
		
		JButton sauver = new JButton("Sauver");
		sauver.addActionListener(new Sauver());
		button.add(sauver);
		
		this.add(button, BorderLayout.SOUTH);
	}
	
	class Cloner implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int[] lignes = table.getSelectedRows();
			if(lignes.length != 1){
				JOptionPane.showMessageDialog(getParent(), "Vous ne pouvez cloner qu'un projet à la fois !");
			}
			else{
				ArrayList<String> row = new ArrayList<String>();
				for(int i = 0; i< csv.names.length; i++){
					if(csv.getIDColumn() == i){
						row.add(csv.getID());
					}
					else{
						row.add((String) csv.getValueAt(table.getSelectedRow(), i));
					}
				}
				csv.addRow(row.toArray(new String[row.size()]));
			}
		}
	}

	public static void main(String[] args) {
		String file = "csv/sujets2014_2015.csv";
		JFrame f = new JFrame("test");
		try{
		f.add(new OPTITableauProjet(file));
		}catch(Exception e){
			System.out.println("OUPS ERREUR : "+e.toString());
		}
		f.addWindowListener(
	    		  new WindowAdapter(){
	    		    public void windowClosing(WindowEvent e) {
	    				System.exit(0);
	    		    }
	    		  });
		f.setLocationRelativeTo(null);
		f.pack();
		f.setVisible(true);

	}

}

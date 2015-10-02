import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class OPTITableau extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTable table;
	private CSV csv;
	
	public OPTITableau(String filepath) {
		super(new BorderLayout());
		this.csv = new CSV(filepath);
		this.table = new JTable(csv);
		this.table.getTableHeader().setReorderingAllowed(false);
		this.table.setRowSorter(new TableRowSorter<TableModel>(this.table.getModel()));
		addScrollPane();
		addButton();
	}
	
	private void addScrollPane(){
		JScrollPane scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setViewportView(table);
		this.add(scroll,BorderLayout.CENTER);
	}
	
	private void addButton(){
		JPanel button = new JPanel(new FlowLayout());
		
		JButton ajouter = new JButton("Ajouter(faire tout planter)");
		ajouter.addActionListener(new Ajouter());
		button.add(ajouter);
		
		JButton supprimer = new JButton("Supprimer");
		supprimer.addActionListener(new Supprimer());
		button.add(supprimer);
		
		JButton sauver = new JButton("Sauver");
		sauver.addActionListener(new Sauver());
		button.add(sauver);
		
		this.add(button, BorderLayout.SOUTH);
	}
	
	public void supprimer(){
		int[] lignes = table.getSelectedRows();
		if(lignes != null && lignes.length > 0){
			int[] modelIndexes = new int[lignes.length];
			 
	        for(int i = 0; i < lignes.length; i++){
	            modelIndexes[i] = table.getRowSorter().convertRowIndexToModel(lignes[i]);
	        }
	 
	        Arrays.sort(modelIndexes);
			
			for(int i=lignes.length-1; i>=0; i--){
				this.csv.removeRow(lignes[i]);
			}
		}else{
			JOptionPane.showMessageDialog(getParent(), "Vous n'avez séléctionner aucunes lignes !");
		}
	}
	
	class Ajouter implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {
			final ArrayList<JTextField> textes = new ArrayList<JTextField>();
			
			final JFrame creer = new JFrame("Saisir les valeurs souhaitées :");
			creer.setLayout(new BorderLayout());
			JPanel pane = new JPanel(new GridLayout(0,1));
			for(String d : csv.getColumnsNames())
				if(!(d.compareTo("id") == 0)){
					pane.add(new JLabel(d+" : "));
					JTextField text = new JTextField();
					textes.add(text);
					pane.add(text);
				}
			creer.add(pane, BorderLayout.CENTER);
			
			JPanel buttonpane = new JPanel(new FlowLayout());
			JButton validbouton = new JButton("Valider");
			validbouton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent actionEvent){
						ArrayList<String> row = new ArrayList<String>();
						for(JTextField text : textes){
							row.add(text.getText());
						}
						csv.addRow(row.toArray(new String[row.size()]));
						creer.dispose();
					}
				});
			JButton annulbouton = new JButton("Annuler");
			annulbouton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent actionEvent){
						creer.dispose();
					}
				});
			buttonpane.add(validbouton);
			buttonpane.add(annulbouton);
			creer.add(buttonpane, BorderLayout.SOUTH);
			
			creer.setLocationRelativeTo(null);
			creer.setVisible(true);
			creer.pack();
		}
	}
	
	class Sauver implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {
			csv.save();
			File f = new File(csv.getFilePath());
			JOptionPane.showMessageDialog(getParent(), "Les données ont été sauvé à l'emplacement :\n"+f.getAbsolutePath());
		}
	}
	
	class Supprimer implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {
			if (JOptionPane.showConfirmDialog(new JOptionPane(),
					"Voulez-vous vraiment supprimer les lignes sélectionner ?") == 0) {
				supprimer();
			}
		}
	}
	
	
	public static void main(String[] args){
		String file = "csv/sujets2014_2015.csv";
		JFrame f = new JFrame("test");
		try{
		f.add(new OPTITableau(file));
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

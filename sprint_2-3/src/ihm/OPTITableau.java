package ihm;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import lib.Csv;

public class OPTITableau extends JPanel {
	private static final long serialVersionUID = 1L;
	
	protected JTable table;
	protected Csv csv;
	protected int[] id;
	
	public OPTITableau(Csv csv) {
		super(new BorderLayout());
		this.csv = csv;
		addJTable();
		addScrollPane();
		addButton();
	}
	
	private void addJTable(){
		this.table = new JTable(csv);
		this.table.getTableHeader().setReorderingAllowed(false);
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		for(int i=0; i<csv.getColumnCount(); i++)
			sorter.setComparator(i,new Comparator<Object>() {
			         @Override
			         public int compare(Object o1, Object o2){
			        	try{
			        		if(o1.getClass() == Integer.class || o1.getClass() == int.class){
			        			return (int)o1 - (int)o2;
			        		}else if(o1.getClass() == Character.class || o1.getClass() == char.class){
			        			return Character.compare((Character)o1, (Character)o2);
			        		}else{
			        			String s1 = (String)o1;
				         		String s2 = (String)o2;
				         		return s1.compareTo(s2);
			        		}
			         	}catch(Exception e){
			         		String s1 = (String)o1;
			         		String s2 = (String)o2;
			         		return s1.compareTo(s2);
			         	}
			         }
			     });
		 this.table.setRowSorter(sorter);
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
		
		JButton ajouter = new JButton("Ajouter");
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
		int[] modelIndexes = new int[lignes.length];
			 
	    for(int i = 0; i < lignes.length; i++)
	        modelIndexes[i] = table.getRowSorter().convertRowIndexToModel(lignes[i]);  
	    Arrays.sort(modelIndexes);
			
		for(int i=lignes.length-1; i>=0; i--)
			this.csv.removeRow(modelIndexes[i]);
		//csv.maj();
	}
	
	class Ajouter implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {/*
			final ArrayList<JTextField> textes = new ArrayList<JTextField>();
			
			final JFrame creer = new JFrame("Saisir les valeurs souhaitées :");
			creer.setLayout(new BorderLayout());
			JPanel pane = new JPanel(new GridLayout(0,1));
			for(String d : csv.getColumnsNames()){
				if(d.toLowerCase().compareTo("id") == 0){
					pane.add(new JLabel("ID : "));
					JLabel id = new JLabel(csv.getID());
					textes.add(new JTextField(id.getText()));
					pane.add(id);
				}else{
					pane.add(new JLabel(d+" : "));
					JTextField text = new JTextField();
					textes.add(text);
					pane.add(text);
				}
			}
			creer.add(pane, BorderLayout.CENTER);
			
			JPanel buttonpane = new JPanel(new FlowLayout());
			JButton validbouton = new JButton("Valider");
			validbouton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent actionEvent){
						ArrayList<String> row = new ArrayList<String>();
						for(JTextField t : textes)
							row.add(t.getText());
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
			creer.pack();*/
		}
	}
	
	class Sauver implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {
			/*JFileChooser dialogue = new JFileChooser(".");
			if(dialogue.showSaveDialog(null) ==  JFileChooser.APPROVE_OPTION){
				String path = dialogue.getSelectedFile().getAbsolutePath();
				if(!path.endsWith(".csv"))
					path = path+".csv";
				csv.save(path);
				csv.save(csv.getFilePath());
			}*/
		}
	}
	
	class Supprimer implements ActionListener{
		public void actionPerformed(ActionEvent actionEvent) {
			System.out.println(csv.getColumnClass(0));
			int[] lignes = table.getSelectedRows();
			if(lignes != null && lignes.length > 0){
				if (JOptionPane.showConfirmDialog(new JOptionPane(),
						"Voulez-vous vraiment supprimer les lignes sélectionner ?") == 0) {
					supprimer();
				}
			}else{
				JOptionPane.showMessageDialog(getParent(), "Vous n'avez séléctionner aucunes lignes !");
			}
		}
	}
	
	/*
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
	}*/
}

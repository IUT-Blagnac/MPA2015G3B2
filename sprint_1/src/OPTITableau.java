import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class OPTITableau extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Object[][] data;
	private JTable table;
	
	public OPTITableau(Object[][] rowData, Object[] columnNames) {
		super(new BorderLayout());
		table = new JTable(rowData, columnNames);
		this.data = rowData;
		addScrollPane();
	}
	
	private void addScrollPane(){
		JScrollPane scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setViewportView(table);
		this.add(scroll,BorderLayout.CENTER);
	}
	
	public static void main(String[] args){
		String file = "csv/sujets2014_2015.csv";
		JFrame f = new JFrame("test");
		try{
		f.add(new OPTITableau(LibCSV.readValues(file), LibCSV.readTitles(file)));
		}catch(Exception e){
			System.out.println("OUPS ERREUR : "+e.toString());
		}
		f.setLocationRelativeTo(null);
		f.pack();
		f.setVisible(true);
	}
}

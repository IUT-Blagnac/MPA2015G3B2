package lib;

import javax.swing.table.AbstractTableModel;

public abstract class Csv extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	public String[] getColumnsNames(){return null;}
	
	public String getFilePath(){return null;}
	
	public void addRow(Object[] ligne){}
    
	public void removeRow(int rowIndex){}
}

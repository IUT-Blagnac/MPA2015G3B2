package lib;

import javax.swing.table.AbstractTableModel;

public abstract class Csv extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	abstract String[] getColumnsNames();
	
	abstract String getFilePath();
}

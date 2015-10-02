import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CSV extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private List<Object[]> data;
    private Object[] names;
    private String filepath;
    
    public CSV(String filepath){
        super();
        this.filepath = filepath;
		try{
			this.data = LibCSV.readValues(filepath);
			this.names= LibCSV.readTitles(filepath);
		}catch(Exception e){
			e.printStackTrace();
		}
    }

    public int getRowCount(){
        return this.data.size();
    }
    
    public int getColumnCount(){
        return this.names.length;
    }
    
    public String getColumnName(int columnIndex) {
        return (String)names[columnIndex];
    }
    
    public String[] getColumnsNames(){
    	String[] cn = new String[getColumnCount()];
    	for(int i=0; i<cn.length; i++)
    		cn[i] = (String)getColumnName(i);
        return cn;
    }
    
    public boolean isCellEditable(int row, int column){
		return !(this.getColumnName(column).compareTo("id") == 0);
	}
    
    public Object getValueAt(int rowIndex, int columnIndex){
        return this.data.get(rowIndex)[columnIndex];
    }
    
    public Object setValueAt(int rowIndex, int columnIndex){
        return this.data.get(rowIndex)[columnIndex];
    }
    
    public Class<?> getColumnClass(int columnIndex){
    	if(this.data.get(0)[columnIndex] != null){
    		return data.get(0)[columnIndex].getClass();
    	}
    	return Object.class;
    }
    
    public String getFilePath(){
		return this.filepath;
	}
 
    public void addRow(String[] ligne){
    	this.data.add(ligne);
        
        fireTableRowsInserted(this.data.size() -1, this.data.size() -1);
    }
 
    public void removeRow(int rowIndex){
    	this.data.remove(rowIndex);
 
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public void save(){
		List<Object[]> file = new ArrayList<Object[]>();
		file.add(this.names);
		file.addAll(this.data);
		try{
			LibCSV.save(file, filepath);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

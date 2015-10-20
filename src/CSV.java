import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CSV extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	protected List<Object[]> data;
	protected Object[] names;
	protected String filepath;
    
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
    
    @Override
    public int getColumnCount(){
        return this.names.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return (String)names[columnIndex];
    }
    
    public String[] getColumnsNames(){
    	String[] cn = new String[getColumnCount()];
    	for(int i=0; i<cn.length; i++)
    		cn[i] = (String)getColumnName(i);
        return cn;
    }
    
    @Override
    public boolean isCellEditable(int row, int column){
		return !(this.getColumnName(column).compareTo("id") == 0);
	}
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        return this.data.get(rowIndex)[columnIndex];
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex){
        this.data.get(rowIndex)[columnIndex] = value;
        fireTableCellUpdated(rowIndex, columnIndex);
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
    
    public void save(String filepath){
		List<Object[]> file = new ArrayList<Object[]>();
		file.add(this.names);
		file.addAll(this.data);
		try{
			LibCSV.save(file, filepath);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
    
    public boolean isID(){
    	for(String name : getColumnsNames()){
    		name.toLowerCase();
    		if(name.compareTo("id") == 0)
    			return true;
    	}
    	return false;
    }
    
    public int getIDColumn(){
    	String[] names = getColumnsNames();
    	for(int i=0; i<getColumnCount(); i++)
    		if(names[i].toLowerCase().compareTo("id") == 0)
    			return i;
    	return -1;
    }
    
    public String getID(){
    	if(isID()){
    		int id = -1;
    		try{
		    	for(int i = 0; i<data.size(); i++){
		    		int n =Integer.parseInt((String)data.get(i)[getIDColumn()]);
		    		if(n > id)
		    			id = n;
		    	}
    		}catch(Exception e){e.printStackTrace();}
    		id = id+1;
    		return ""+id;
    	}else
    		return null;
    }
    
    public void maj(){
    	if(isID()){
    		try{
    			int id = 1;
		    	for(int i = 0; i<data.size(); i++){
		    		int n =Integer.parseInt((String)data.get(i)[getIDColumn()]);
		    		if(n != id){
		    			data.get(i)[getIDColumn()] = ""+id;
		    			fireTableCellUpdated(i, getIDColumn());
		    		}
		    		id++;
		    	}
    		}catch(Exception e){e.printStackTrace();}
    	}
    }
}

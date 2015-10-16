package lib;

import java.util.ArrayList;
import java.util.List;

public class CsvGroupe extends Csv {
	private static final long serialVersionUID = 1L;
	
	private List<Groupe> groupe = new ArrayList<Groupe>();
    private String[] names;
    private String filepath;
    
    public CsvGroupe(String[] names, ArrayList<Groupe> groupe){
        super();
        this.names = names;
		this.groupe = groupe;
    }
    
    @Override
    public int getRowCount(){
        return this.groupe.size();
    }
    
    @Override
    public int getColumnCount(){
        return this.names.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return this.names[columnIndex];
    }
    
    public String[] getColumnsNames(){
        return this.names;
    }
    
    @Override
    public boolean isCellEditable(int row, int column){
		return false;
	}
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
    	switch(columnIndex){
    	case 0:
    		return this.groupe.get(rowIndex).getId();
    	default:
    		return this.groupe.get(rowIndex).getEtudiant(columnIndex-1);
    	}
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex){
    	switch(columnIndex){
    	case 0:
    		String val = (String)value;
    		this.groupe.get(rowIndex).setId(val.trim().charAt(0));
    		break;
    	default:
    		this.groupe.get(rowIndex).setEtudiant(Integer.parseInt(value.toString()), columnIndex-1);
    		break;
    	}
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public String getFilePath(){
		return this.filepath;
	}
    
    public void addRow(Object[] ligne){
    	char groupe = (char)ligne[0];
    	int[] etus = new int[ligne.length-1];
    	for(int i=1; i<ligne.length; i++)
    		etus[i-1] = Integer.parseInt((String)ligne[1]);
    	
    	this.groupe.add(new Groupe(groupe,etus));
        fireTableRowsInserted(this.groupe.size() -1, this.groupe.size() -1);
    }
    
    public void removeRow(int rowIndex){
    	this.groupe.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    /*
    public void save(String filepath){
		List<String[]> file = new ArrayList<String[]>();
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
		    		int n =Integer.parseInt(data.get(i)[getIDColumn()]);
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
		    		int n =Integer.parseInt(data.get(i)[getIDColumn()]);
		    		if(n != id){
		    			data.get(i)[getIDColumn()] = ""+id;
		    			fireTableCellUpdated(i, getIDColumn());
		    		}
		    		id++;
		    	}
    		}catch(Exception e){e.printStackTrace();}
    	}
    }*/
}
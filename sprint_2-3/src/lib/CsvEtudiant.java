package lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

public class CsvEtudiant extends Csv {
	private static final long serialVersionUID = 1L;
	
	private List<Etudiant> etudiant = new ArrayList<Etudiant>();
    private String[] names;
    private String filepath;
    
    private Map<Character,Integer[]> groupes = new HashMap<Character,Integer[]>();
    
    public CsvEtudiant(String filepath){
        super();
        this.filepath = filepath;
		try{
			List<String[]> data = LibCSV.readValues(filepath);
			this.names= LibCSV.readTitles(filepath);
			for(String[] ligne : data){
				int id = Integer.parseInt(ligne[1]);
				char[] groupe = ligne[0].trim().toCharArray();
				etudiant.add(new Etudiant(id,ligne[2],ligne[3],groupe[0]));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
    }
    
    @Override
    public int getRowCount(){
        return this.etudiant.size();
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
		return true;
	}
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
    	switch(columnIndex){
    	case 0:
    		return this.etudiant.get(rowIndex).getGroupe();
    	case 1:
    		return this.etudiant.get(rowIndex).getID();
    	case 2:
    		return this.etudiant.get(rowIndex).getNom();
    	case 3:
    		return this.etudiant.get(rowIndex).getPrenom();
    	}
        return null;
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex){
    	switch(columnIndex){
    	case 0:
    		this.etudiant.get(rowIndex).setGroupe((char)value);
    	case 1:
    		this.etudiant.get(rowIndex).setID((int)value);
    	case 2:
    		this.etudiant.get(rowIndex).setNom((String)value);
    	case 3:
    		this.etudiant.get(rowIndex).setPrenom((String)value);
    	}
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
    	switch(columnIndex){
    	case 0:
    		return Character.class;
    	case 1:
    		return Integer.class;
    	case 2:
    		return String.class;
    	case 3:
    		return String.class;
    	}
        return Object.class;
    }
    
    public String getFilePath(){
		return this.filepath;
	}
    
    public void addRow(Object[] ligne){
    	char groupe = (char)ligne[0];
    	int id = (int)ligne[1];
    	String nom = (String)ligne[2];
    	String prenom = (String)ligne[3];
    	
    	this.etudiant.add(new Etudiant(id,nom,prenom,groupe));
        fireTableRowsInserted(this.etudiant.size() -1, this.etudiant.size() -1);
    }
    
    public void removeRow(int rowIndex){
    	this.etudiant.remove(rowIndex);
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
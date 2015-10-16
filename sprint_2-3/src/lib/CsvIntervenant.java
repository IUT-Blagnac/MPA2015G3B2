package lib;

import java.util.ArrayList;
import java.util.List;

public class CsvIntervenant extends Csv {
	private static final long serialVersionUID = 1L;
	
	private List<Intervenant> intervenant = new ArrayList<Intervenant>();
    private String[] names;
    private String filepath;
    
    public CsvIntervenant(String filepath){
        super();
        this.filepath = filepath;
		try{
			List<String[]> data = LibCSV.readValues(filepath);
			this.names= LibCSV.readTitles(filepath);
			for(String[] ligne : data){
				int id = Integer.parseInt(ligne[0]);
				String nom = ligne[1].trim();
				String prenom = ligne[2].trim();
				intervenant.add(new Intervenant(id,nom,prenom));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
    }
    
    @Override
    public int getRowCount(){
        return this.intervenant.size();
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
    		return this.intervenant.get(rowIndex).getId();
    	case 1:
    		return this.intervenant.get(rowIndex).getNom();
    	case 2:
    		return this.intervenant.get(rowIndex).getPrenom();
    	}
        return null;
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex){
    	switch(columnIndex){
    	case 0:
    		this.intervenant.get(rowIndex).setId(Integer.parseInt((String)value));
    		break;
    	case 1:
    		this.intervenant.get(rowIndex).setNom((String)value);
    		break;
    	case 2:
    		this.intervenant.get(rowIndex).setPrenom((String)value);
    		break;
    	}
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public String getFilePath(){
		return this.filepath;
	}
    
    public Intervenant getIntervenantFromId(int id){
    	for(Intervenant inter : intervenant){
    		if(inter.getId() == id)
    			return inter;
    	}
		return null;
	}
	
	public Intervenant getIntervenantFromName(String nom){
		for(Intervenant inter : intervenant){
    		if(inter.getNom() == nom)
    			return inter;
    	}
		return null;
	}
    
    public void addRow(Object[] ligne){
    	int id = (int)ligne[0];
    	String nom = (String)ligne[1];
    	String prenom = (String)ligne[2];
    	
    	this.intervenant.add(new Intervenant(id,nom,prenom));
        fireTableRowsInserted(this.intervenant.size() -1, this.intervenant.size() -1);
    }
    
    public void removeRow(int rowIndex){
    	this.intervenant.remove(rowIndex);
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
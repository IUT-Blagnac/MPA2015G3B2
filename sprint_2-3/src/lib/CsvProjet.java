package lib;

import java.util.ArrayList;
import java.util.List;

public class CsvProjet extends Csv {
	private static final long serialVersionUID = 1L;
	
	private List<Projet> projet = new ArrayList<Projet>();
	private Gestion gestion;
    private String[] names;
    private String filepath;
    
    public CsvProjet(String filepath, Gestion g){
        super();
        this.filepath = filepath;
        this.gestion = g;
		try{
			List<String[]> data = LibCSV.readValues(filepath);
			this.names= LibCSV.readTitles(filepath);
			for(String[] ligne : data){
				int id = Integer.parseInt(ligne[0]);
				char[] groupe = ligne[1].trim().toCharArray();
				Sujet sujet = gestion.getSujetFromId(Integer.parseInt(ligne[2]));
				Intervenant[] intervenants = new Intervenant[3];
				for(int i=3; i<ligne.length; i++)
					intervenants[i-3] = gestion.getIntervenantFromId(Integer.parseInt(ligne[i]));
				projet.add(new Projet(id,groupe[0],sujet,intervenants));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
    }
    
    @Override
    public int getRowCount(){
        return this.projet.size();
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
    		return this.projet.get(rowIndex).getId();
    	case 1:
    		return this.projet.get(rowIndex).getGroupe();
    	case 2:
    		return this.projet.get(rowIndex).getSujet().getId();
    	case 3:
    		return this.projet.get(rowIndex).getClient().getId();
    	case 4:
    		return this.projet.get(rowIndex).getSuperviseur().getId();
    	case 5:
    		return this.projet.get(rowIndex).getSupportTechnique().getId();
    	}
        return null;
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex){
    	switch(columnIndex){
    	case 0:
    		this.projet.get(rowIndex).setId((int)value);
    	case 1:
    		this.projet.get(rowIndex).setGroupe((char)value);
    	case 2:
    		this.projet.get(rowIndex).setSujet(gestion.getSujetFromId((int)value));
    	case 3:
    		this.projet.get(rowIndex).setClient(gestion.getIntervenantFromName((String)value));
    	case 4:
    		this.projet.get(rowIndex).setSuperviseur(gestion.getIntervenantFromName((String)value));
    	case 5:
    		this.projet.get(rowIndex).setSupportTechnique(gestion.getIntervenantFromName((String)value));
    	}
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
    	switch(columnIndex){
    	case 0:case 2:case 3:case 4:case 5:
    		return Integer.class;
    	case 1:
    		return Character.class;
    	}
        return Object.class;
    }
    
    public String getFilePath(){
		return this.filepath;
	}
    
    public void addRow(Object[] ligne){
    	int id = (int)ligne[0];
    	char groupe = (char)ligne[1];
    	int sujet = (int)ligne[2];
    	Intervenant[] intervenant = new Intervenant[3];
    	intervenant[0] = gestion.getIntervenantFromId((int)ligne[3]);
    	intervenant[1] = gestion.getIntervenantFromId((int)ligne[4]);
    	intervenant[2] = gestion.getIntervenantFromId((int)ligne[5]);
    	
    	this.projet.add(new Projet(id,groupe,gestion.getSujetFromId(sujet),intervenant));
        fireTableRowsInserted(this.projet.size() -1, this.projet.size() -1);
    }
    
    public void removeRow(int rowIndex){
    	this.projet.remove(rowIndex);
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
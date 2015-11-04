import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class MOWTest {
	public static void main(String args[]){
		File etudiantjs = new File ("C:\\Users\\Etudiant\\Documents\\groupe3B2\\sprint_4\\OPTIweb\\test\\etudiants2014_2015test.json");
		File intervenantjs = new File ("C:\\Users\\Etudiant\\Documents\\groupe3B2\\sprint_4\\OPTIweb\\test\\intervenants2014_2015test.json");
		CSV etudiantcsv = new CSV("C:\\Users\\Etudiant\\Documents\\groupe3B2\\sprint_4\\OPTIweb\\test\\etudiants2014_2015.csv");
		CSV intervenantcsv = new CSV("C:\\Users\\Etudiant\\Documents\\groupe3B2\\sprint_4\\OPTIweb\\test\\intervenants2014_2015.csv");
		String recup = "";
		try
		{
		    FileWriter fwetujs = new FileWriter (etudiantjs);
		    recup += "[\n";
		    for(int i = 0; i < etudiantcsv.getRowCount(); i++){
		    	recup += "{";
		    	for(int j = 0; j < etudiantcsv.getColumnCount(); j++){
		    		if(j == 0){
		    			recup +="\"group\": \""+ etudiantcsv.getValueAt(i,j)+"\"";
		    		}
		    		else{
		    			recup +="\""+ etudiantcsv.getColumnName(j)+"\": \""+ etudiantcsv.getValueAt(i,j)+"\"";
		    		}
		    		if(j != etudiantcsv.getColumnCount()-1){
		    			recup += ",\n";
		    		}
		    	}
		    	if(i != etudiantcsv.getRowCount()-1){
		    		recup += "},\n";
		    	}
		    }
		    recup += "}\n]";
		    fwetujs.write(recup);
		    fwetujs.close();
		}
		catch (IOException exception)
		{
		    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
		recup = "";
		try
		{
		    FileWriter fwinterjs = new FileWriter (intervenantjs);
		    recup += "[\n";
		    for(int i = 0; i < intervenantcsv.getRowCount(); i++){
		    	recup += "{";
		    	for(int j = 1; j < intervenantcsv.getColumnCount(); j++){
		    			recup +="\""+ intervenantcsv.getColumnName(j)+"\": \""+ intervenantcsv.getValueAt(i,j)+"\"";
		    		if(j != intervenantcsv.getColumnCount()-1){
		    			recup += ",\n";
		    		}
		    	}
		    	if(i != intervenantcsv.getRowCount()-1){
		    		recup += "},\n";
		    	}
		    }
		    recup += "}\n]";
		    fwinterjs.write(recup);
		    fwinterjs.close();
		}
		catch (IOException exception)
		{
		    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
		}
	}
}

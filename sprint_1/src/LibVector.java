import java.util.Vector;

public class LibVector {
	
	public static void ajouter(Vector<String[]> csv, String[] newLine)throws Exception{
		if(csv.get(0).length == newLine.length)
			throw new Exception("ERREUR La ligne ajouter contient trop de colonne");
		csv.add(newLine);
	}
	
	public static void supprimer(Vector<String[]> csv, int id){
		csv.remove(id);
	}
}

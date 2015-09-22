import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Vector;

public class LibCSV {
	
	public static Vector<String[]> read(String filepath)throws Exception{
		if(!filepath.endsWith(".csv"))
			throw new Exception("ERREUR Le fichier n'est pas sous format CSV");
		Vector<String[]> tableau = new Vector<String[]>();
		String[] colonne;
		try{
			InputStream ips=new FileInputStream(filepath);
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			
			String ligne;
			while ((ligne=br.readLine())!=null){
				colonne = ligne.split(";");
				tableau.add(colonne);
			}
			br.close();
		}catch (Exception e){
			throw new Exception(e.toString());
		}
		return tableau;
	}
	
	public static void save(Vector<String[]> tableau, String filepath)throws Exception{
		if(tableau == null)
			throw new Exception("ERREUR ArrayList est NULL");
		if(!filepath.endsWith(".csv"))
			throw new Exception("ERREUR Le fichier n'est pas sous format CSV");
		try {
			FileWriter fw = new FileWriter(filepath);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter fichierSortie = new PrintWriter(bw);
				for(int i=0; i<tableau.size(); i++){
					for(int j=0; j<tableau.get(i).length; j++){
						if(j<tableau.get(i).length-1)
							fichierSortie.print(tableau.get(i)[j]+';');
						else
							fichierSortie.print(tableau.get(i)[j]);
					}
					fichierSortie.print('\n');
				}
			fichierSortie.close();
		}catch (Exception e){
			throw new Exception(e.toString());
		}
	}
	
	// Demonstration
	/*
	public static void main(String[] args){
		String file = "csv/test.csv";
		
		ArrayList<String> al = new ArrayList<String>();
		String ligne1 ="Nom;Prenom;Date de Naissance";
		String ligne2 ="Paul;Henry;02/45/1962";
		al.add(ligne1);
		al.add(ligne2);
		try{
			save(al,file);
			al = read(file);
			System.out.println(al.get(0)+"\n"+al.get(1));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	*/
}
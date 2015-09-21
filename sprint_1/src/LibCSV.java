import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;


public class LibCSV {
	public static ArrayList<String> read(String filepath)throws Exception{
		if(!filepath.endsWith(".csv"))
			throw new Exception("ERREUR Le fichier n'est pas sous format CSV");
		//lecture du fichier csv
		ArrayList<String> tableau = new ArrayList<String>();
		
		try{
			InputStream ips=new FileInputStream(filepath);
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			
			String ligne;
			while ((ligne=br.readLine())!=null){
				tableau.add(ligne);
			}
			br.close();
		}catch (Exception e){
			throw new Exception(e.toString());
		}
		return tableau;
	}
	
	public static void save(ArrayList<String> tableau, String filepath)throws Exception{
		if(tableau == null)
			throw new Exception("ERREUR ArrayList est NULL");
		if(!filepath.endsWith(".csv"))
			throw new Exception("ERREUR Le fichier n'est pas sous format CSV");
		//création ou ajout dans le fichier csv
		try {
			FileWriter fw = new FileWriter(filepath);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter fichierSortie = new PrintWriter(bw);
				for(int i=0; i<tableau.size(); i++){
					fichierSortie.print(tableau.get(i));
					fichierSortie.print('\n');
			}
			fichierSortie.close();
		}catch (Exception e){
			throw new Exception(e.toString());
		}
	}
	
	
	
	// Demonstration
	public static void main(String[] args){
		ArrayList<String> al = new ArrayList<String>();
		String ligne1 ="Nom;Prenom;Date de Naissance";
		String ligne2 ="Paul;Henry;02/45/1962";
		al.add(ligne1);
		al.add(ligne2);
		try{
			save(al,"test.csv");
			al = read("test.csv");
			System.out.println(al.get(0)+"\n"+al.get(1));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
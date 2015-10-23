
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibCSV {
	/**
	 * @param filepath
	 * @return title
	 * @throws Exception
	 */
	public static String[] readTitles(String filepath)throws Exception{
		// Vérification que le format est bien CSV
		if(!filepath.endsWith(".csv"))
			throw new Exception("ERREUR Le fichier n'est pas sous format CSV");
		// On initialise à null pour etre sur de renvoyer un Objet
		String[] title = null;
		// Récuperation des données du fichier csv
		try{
			InputStream ips=new FileInputStream(filepath);
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			
			String ligne;
			if((ligne=br.readLine())!=null)
				title = readLine(ligne);
			
			br.close();
		}catch (Exception e){
			throw new Exception(e.toString());
		}
		return title;
	}
	
	/**
	 * @param filepath
	 * @return csv
	 * @throws Exception
	 */
	public static ArrayList<String[]> readValues(String filepath)throws Exception{
		// Vérification que le format est bien CSV
		if(!filepath.endsWith(".csv"))
			throw new Exception("ERREUR Le fichier n'est pas sous format CSV");
		
		ArrayList<String[]> csv = new ArrayList<String[]>();
		String[] test = null;
		String[] colonne;
		// Récuperation des données du fichier csv
		try{
			
			InputStream ips=new FileInputStream(filepath);
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			
			String ligne;
			if ((ligne=br.readLine())!=null){
				// On récupère l'entete du fichier
				test = readLine(ligne);
				while ((ligne=br.readLine())!=null){
					colonne = readLine(ligne);
					csv.add(colonne);
				}
			}
			
			br.close();
		}catch (Exception e){
			throw new Exception(e.toString());
		}
		// On test que toute les lignes de données sont de même longueur que l'entete
		for(int i=0; i<csv.size(); i++)
			if(csv.get(i).length != test.length)
				throw new Exception("ERREUR Le nombre de colonne varie");
		return csv;
	}
	
	/**
	 * @param csv
	 * @param filepath
	 * @throws Exception
	 */
	public static void save(List<String[]> csv, String filepath)throws Exception{
		if(csv == null)
			throw new Exception("ERREUR Matrice est NULL");
		if(!filepath.endsWith(".csv"))
			throw new Exception("ERREUR Le fichier n'est pas sous format CSV");
		try {
			FileWriter fw = new FileWriter(filepath);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter fichierSortie = new PrintWriter(bw);
				for(int i=0; i<csv.size(); i++){
					for(int j=0; j<csv.get(i).length; j++){
						if(j<csv.get(i).length-1)
							fichierSortie.print(csv.get(i)[j]+';');
						else
							fichierSortie.print(csv.get(i)[j]);
					}
					if(i<csv.size()-1)
						fichierSortie.print('\n');
				}
			fichierSortie.close();
		}catch (Exception e){
			throw new Exception(e.toString());
		}
	}
	
	/**
	 * @param line
	 * @return
	 */
	private static String[] readLine(String line){
		ArrayList<String> donnees = new ArrayList<String>();
		Scanner sc = new Scanner(line);
		
		// Récuperation des données de la ligne
		sc.useDelimiter(";");
		while (sc.hasNext()){
			if(sc.hasNext("(\\n|\\r|\\t)")){
				donnees.add(" ");
			}else if(sc.hasNext("")){
				donnees.add(" ");
			}else
				donnees.add(sc.next());
		}
		sc.close();
		return donnees.toArray(new String[donnees.size()]);
	}
	
	public static void main(String[] args) {
		try{
		for(Object d : LibCSV.readValues("csv/test.csv"))
			System.out.println(d);
		}catch(Exception e){
			
		}
		
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LibCSV {
	
	public static String[] readTitles(String filepath)throws Exception{
		if(!filepath.endsWith(".csv"))
			throw new Exception("ERREUR Le fichier n'est pas sous format CSV");
		String[] title = null;
		try{
			InputStream ips=new FileInputStream(filepath);
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			
			String ligne;
			if((ligne=br.readLine())!=null){
				title = ligne.split(";");
			}
			br.close();
		}catch (Exception e){
			throw new Exception(e.toString());
		}
		return title;
	}
	
	public static Object[][] readValues(String filepath)throws Exception{
		if(!filepath.endsWith(".csv"))
			throw new Exception("ERREUR Le fichier n'est pas sous format CSV");
		ArrayList<String[]> al = new ArrayList<String[]>();
		Object[][] csv;
		String[] colonne;
		try{
			
			InputStream ips=new FileInputStream(filepath);
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			
			String ligne;
			if ((ligne=br.readLine())!=null)
				while ((ligne=br.readLine())!=null){
					colonne = ligne.split(";");
					al.add(colonne);
				}
			br.close();
		}catch (Exception e){
			throw new Exception(e.toString());
		}
		csv = new Object[al.size()][0];
		colonne = readTitles(filepath);
		for(int i=0; i<al.size(); i++){
			if(al.get(i).length != colonne.length)
				throw new Exception("ERREUR Le nombre de colonne varie");
			csv[i] = al.get(i);
		}
		return csv;
	}
	
	public static void save(Object[][] csv, String filepath)throws Exception{
		if(csv == null)
			throw new Exception("ERREUR Matrice est NULL");
		if(!filepath.endsWith(".csv"))
			throw new Exception("ERREUR Le fichier n'est pas sous format CSV");
		try {
			FileWriter fw = new FileWriter(filepath);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter fichierSortie = new PrintWriter(bw);
				for(int i=0; i<csv.length; i++){
					for(int j=0; j<csv[i].length; j++){
						if(j<csv[i].length-1)
							fichierSortie.print(csv[i][j].toString()+';');
						else
							fichierSortie.print(csv[i][j]);
					}
					if(i<csv.length-1)
						fichierSortie.print('\n');
				}
			fichierSortie.close();
		}catch (Exception e){
			throw new Exception(e.toString());
		}
	}
	
	public static Object[][] readAll(String filepath)throws Exception{
		if(!filepath.endsWith(".csv"))
			throw new Exception("ERREUR Le fichier n'est pas sous format CSV");
		ArrayList<String[]> al = new ArrayList<String[]>();
		Object[][] csv;
		String[] colonne;
		try{
			InputStream ips=new FileInputStream(filepath);
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			
			String ligne;
			while ((ligne=br.readLine())!=null){
				colonne = ligne.split(";");
				al.add(colonne);
			}
			br.close();
		}catch (Exception e){
			throw new Exception(e.toString());
		}
		csv = new Object[al.size()][0];
		for(int i=0; i<al.size(); i++)
			csv[i] = al.get(i);
		return csv;
	}
	
	// Demonstration
	public static void main(String[] args){
		String file = "csv/test.csv";
		
		Object[][] csv = new Object[2][0];
		String[] ligne1 ={"Nom","Prenom","Date de Naissance"};
		String[] ligne2 ={"Paul","Henry","02/45/1962"};
		csv[0]= ligne1;
		csv[1]= ligne2;
		try{
			save(csv,file);
			csv = readAll(file);
			System.out.println(csv[0][0]+"\t"+csv[0][1]+"\t"+csv[0][2]);
			System.out.println(csv[1][0]+"\t"+csv[1][1]+"\t"+csv[1][2]);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
}
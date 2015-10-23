import java.util.HashMap;


public class Intervenant {
	private String nom;
	private String prenom;
	
	public Intervenant(String nom, String prenom){
		this.setNom(nom);
		this.setPrenom(prenom);
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public static HashMap<Integer,Intervenant> remplirinter(CSV intervenants){
		HashMap<Integer,Intervenant> liste = new HashMap<Integer,Intervenant>();
		for(int i = 0; i<intervenants.getRowCount(); i++){
			liste.put(i, new Intervenant((String) intervenants.getValueAt(i, 2), (String) intervenants.getValueAt(i, 1)));
		}
		return liste;
		
	}
	public static void main(String args[]){
		HashMap<Integer,Intervenant> liste = remplirinter(new CSV("csv/intervenants2014_2015.csv"));
		for(int i = 0; i<liste.size(); i++){
			System.out.println(liste.get(i).getPrenom());
		}
		
	}
	
}

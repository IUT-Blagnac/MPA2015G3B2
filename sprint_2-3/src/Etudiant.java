import java.util.HashSet;


public class Etudiant {
	private String nom;
	private String prenom;
	private int id;
	
	public Etudiant(int id, String nom, String prenom){
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
	
	public static HashSet<Etudiant> rempliretu(CSV etudiants){
		HashSet<Etudiant> liste = new HashSet<Etudiant>();
		for(int i = 0; i<etudiants.getRowCount(); i++){
			liste.add(new Etudiant(Integer.parseInt((String)etudiants.getValueAt(i, 1)),(String) etudiants.getValueAt(i, 2), (String) etudiants.getValueAt(i, 3)));
		}
		return liste;
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static void main(String args[]){
		@SuppressWarnings("unused")
		HashSet<Etudiant> liste = rempliretu(new CSV("csv/etudiants2014_2015.csv"));
	}


	
}

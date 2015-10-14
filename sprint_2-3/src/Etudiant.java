import java.util.HashMap;

public class Etudiant {
	private String nom;
	private String prenom;

	public Etudiant(String nom, String prenom) {
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

	public static HashMap<Integer, Etudiant> remplirinter(CSV Etudiant) {
		HashMap<Integer, Etudiant> liste = new HashMap<Integer, Etudiant>();
		for (int i = 0; i < Etudiant.getRowCount(); i++) {
			liste.put(i, new Etudiant((String) Etudiant.getValueAt(i, 3),
					(String) Etudiant.getValueAt(i, 2)));
		}
		return liste;

	}

	public static void main(String args[]) {
		HashMap<Integer, Etudiant> liste = remplirinter(new CSV(
				"csv/etudiants2014_2015.csv"));
		for (int i = 0; i < liste.size(); i++) {
			System.out.println(liste.get(i).getPrenom());
		}

	}

}

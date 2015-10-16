package lib;

public class Groupe {
	
	private char id;
	private int[] etudiant;
	
	public Groupe(char groupe, int... etudiant){
		this.id = groupe;
		this.etudiant = etudiant;
	}

	public int[] getEtudiants() {
		return etudiant;
	}
	
	public int getEtudiant(int i) {
		if(i >= etudiant.length)
			return -99999;
		return etudiant[i];
	}

	public void setEtudiants(int[] etudiant) {
		this.etudiant = etudiant;
	}
	
	public void setEtudiant(int etudiant, int i) {
		this.etudiant[i] = etudiant;
	}

	public char getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}
}
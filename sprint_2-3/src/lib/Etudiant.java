package lib;

public class Etudiant {
	
	private int id;
	private String nom;
	private String prenom;
	private char groupe;
	
	public Etudiant(int id, String nom, String prenom, char groupe){
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.groupe = groupe;
	}
	
	public int getID(){
		return this.id;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public String getPrenom(){
		return this.prenom;
	}
	
	public char getGroupe(){
		return this.groupe;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public void setPrenom(String prenom){
		this.prenom = prenom;
	}
	
	public void setGroupe(char groupe){
		this.groupe = groupe;
	}
}
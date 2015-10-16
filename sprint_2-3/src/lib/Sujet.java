package lib;

public class Sujet {
	
	private int id;
	private String nom;
	private String titre;
	
	public Sujet(int id, String nom, String titre){
		this.id = id;
		this.nom = nom;
		this.titre = titre;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public String getTitre(){
		return this.titre;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
}
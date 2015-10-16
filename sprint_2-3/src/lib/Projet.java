package lib;

public class Projet {
	
	private int id;
	private char groupe;
	private Sujet sujet;
	private Intervenant client;
	private Intervenant superviseur;
	private Intervenant support_technique;
	
	public Projet(int id, char groupe, Sujet sujet, Intervenant[] inter){
		this.id = id;
		this.groupe = groupe;
		this.sujet = sujet;
		this.client = inter[0];
		this.superviseur = inter[1];
		this.support_technique = inter[2];
	}
	
	public int getId(){
		return this.id;
	}
	
	public char getGroupe(){
		return this.groupe;
	}
	
	public Sujet getSujet(){
		return this.sujet;
	}
	
	public Intervenant getClient(){
		return this.client;
	}
	
	public Intervenant getSuperviseur(){
		return this.superviseur;
	}
	
	public Intervenant getSupportTechnique(){
		return this.support_technique;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setGroupe(char groupe){
		this.groupe = groupe;
	}
	
	public void setSujet(Sujet sujet){
		this.sujet = sujet;
	}
	
	public void setClient(Intervenant client){
		this.client = client;
	}
	
	public void setSuperviseur(Intervenant superviseur){
		this.superviseur = superviseur;
	}
	
	public void setSupportTechnique(Intervenant support_technique){
		this.support_technique = support_technique;
	}
}
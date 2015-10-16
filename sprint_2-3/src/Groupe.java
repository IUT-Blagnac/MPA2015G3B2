import java.util.HashSet;


public class Groupe {
	private Character lettre;
	private HashSet<Etudiant> listeetu;
	private HashSet<Groupe> groupes;
	
	public Groupe(char groupe, HashSet<Etudiant> listetu){
		this.setListeetu(listetu);
		this.setLettre(groupe);
		this.groupes = setListegroupe(this);

	}

	public HashSet<Etudiant> getListeetu() {
		return listeetu;
	}

	public void setListeetu(HashSet<Etudiant> listeetu) {
		this.listeetu = listeetu;
	}

	public Character getLettre() {
		return lettre;
	}

	public void setLettre(Character lettre) {
		this.lettre = lettre;
	}
	
	public HashSet<Groupe> setListegroupe(Groupe groupe){
		groupes.add(groupe);
		return this.groupes;	
	}
	
	public void addEtu(Groupe groupe, Etudiant etu) throws Exception{
		for(int i = 0; i < groupes.size(); i++){
			if(groupes.iterator().next().listeetu.contains(etu)){
				throw new Exception("L'étudiant est déjà dans un autre groupe");
			}
		}
		groupe.listeetu.add(etu);
	}
	
	
}

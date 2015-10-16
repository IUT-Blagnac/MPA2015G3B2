package lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Gestion {
	
	private CsvEtudiant etudiant;
	private CsvSujet sujet;
	private CsvIntervenant intervenant;
	private CsvProjet projet;
	private CsvGroupe groupe;
	
	public Gestion(CsvEtudiant etudiant, CsvSujet sujet, CsvIntervenant intervenant){
		this.etudiant = etudiant;
		this.sujet = sujet;
		this.intervenant = intervenant;
	}
	
	public void setCsvProjet(CsvProjet projet){
		this.projet = projet;
	}
	
	public Etudiant getEtudiantFromId(int id){
		return this.etudiant.getEtudiantFromId(id);
	}
	
	public Sujet getSujetFromId(int id){
		return this.sujet.getSujetFromId(id);
	}
	
	public Intervenant getIntervenantFromId(int id){
		return this.intervenant.getIntervenantFromId(id);
	}
	
	public Intervenant getIntervenantFromName(String nom){
		return this.intervenant.getIntervenantFromName(nom);
	}
	
	public CsvGroupe genererGroupes(){
		
		Map<Character,Integer[]> grp = new HashMap<Character,Integer[]>();
		
		for(Etudiant etu : etudiant.getListEtudiant()){
			if(!grp.containsKey(etu.getGroupe())){
				Integer[] list = {etu.getId()};
				grp.put(etu.getGroupe(), list);
			}else{
				Integer[] oldlist = grp.get(etu.getGroupe());
				Integer[] newlist = new Integer[oldlist.length+1];
				for(int i=0; i<oldlist.length; i++)
					newlist[i] = oldlist[i];
				newlist[oldlist.length] = etu.getId();
				grp.put(etu.getGroupe(), newlist);
			}
		}
		
		ArrayList<Groupe> gp = new ArrayList<Groupe>();
		int max = 0;
		
		for(char id : grp.keySet()){
			int[] list = new int[grp.get(id).length];
			Integer[] inte = grp.get(id);
			for(int i=0; i<list.length; i++)
				list[i] = inte[i];
			if(list.length > max)
				max = list.length;
			gp.add(new Groupe(id, list));
		}
		
		String[] names = new String[max+1];
		names[0] = "groupe";
		for(int i=1; i<names.length; i++)
			names[i] = "etudiant "+(i-1);
		
		CsvGroupe cg = new CsvGroupe(names, gp);
		this.groupe = cg;
		return cg;
		
	}
}
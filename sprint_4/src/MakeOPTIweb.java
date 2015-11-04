
import java.io.*;
import java.util.*;

public class MakeOPTIweb{
	
	private static ArrayList<String[]> listProjet;
	private static ArrayList<String[]> listSujet;
	private static ArrayList<String[]> listEtudiant;
	private static ArrayList<String[]> listIntervenant;
	
	public static void main(String[] args){
		try{
			listProjet = LibCSV.readValues("OPTIweb/test/projets2014_2015.csv");
			listSujet = LibCSV.readValues("OPTIweb/test/sujets2014_2015.csv");
			listEtudiant = LibCSV.readValues("OPTIweb/test/etudiants2014_2015.csv");
			listIntervenant = LibCSV.readValues("OPTIweb/test/intervenants2014_2015.csv");
		}catch(Exception e){
			System.out.println("ERREUR lors de la lecture : "+e.toString());
		}
		creerJson();
		String html = "";

		html += "<!DOCTYPE html>\n"+
"<html>\n"+
"<head>\n"+
"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n"+
"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"+
"<meta name=\"generator\" content=\"OPTIweb VOPTIweb\" />\n"+
"<title>0.1 - V0.1</title>\n"+
"<link rel=\"stylesheet\" href=\"http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css\" />\n"+
"<link rel=\"stylesheet\" href=\"http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.css\" />\n"+
"<script src=\"http://code.jquery.com/jquery-1.9.1.min.js\"></script>\n"+
"<script>\n" +
"$(document).bind('mobileinit',function(){\n" +
"    $.mobile.changePage.defaults.changeHash = false;\n" +
"    $.mobile.hashListeningEnabled = false;\n" +
"    $.mobile.pushStateEnabled = false;\n" +
"});\n" +
"</script>\n" +
"<script src=\"http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js\"></script>\n"+
"<style type='text/css'>    \n"+
"@media all and (orientation:portrait) { .landscape {display: none;} }\n"+
"@media all and (orientation:landscape) { .landscape {display: inline;} }\n"+
"</style>\n"+
"</head><body>\n"+
"<!-- DEBUT page accueil -->\n"+
"<div data-role=\"page\" id=\"accueil\" data-title=\"OPTIweb - V0.1\">\n"+
"<div data-role=\"header\" data-add-back-btn=\"true\">\n"+
"<h1>P<span class=\"landscape\">rojets </span>tut<span class=\"landscape\">orés</span> 2014-2015<br/>Département INFO<span class=\"landscape\">RMATIQUE</span><br/>IUT de Blagnac</h1>\n"+
"<a href=\"#credits\" data-theme=\"b\" class=\"ui-btn-right\">Crédits</a>\n"+
"</div>\n"+
"<div data-role=\"content\">\n"+
"<ul data-role=\"listview\" data-inset=\"true\" id=\"listeSources\">\n"+
"  <li><a href=\"#projets\"><i class=\"fa fa-tasks\"></i> Projets</a></li>\n"+
"  <li><a href=\"#sujets\"><i class=\"fa fa-copy\"></i> Sujets</a></li>\n"+
"  <li><a href=\"#etudiants\"><i class=\"fa fa-group\"></i> Etudiants</a></li>\n"+
"  <li><a href=\"#intervenants\"><i class=\"fa fa-group\"></i> Intervenants</a></li>\n"+
"</ul>\n"+
"</div>\n"+
"<div data-role=\"footer\"> \n"+
" <h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa- fa-2x\"></i></h4> \n"+
"</div>\n"+
"</div>\n"+
"<!-- FIN page accueil -->\n"+
"<!-- DEBUT page credits -->\n"+
"<div data-role=\"page\" id=\"credits\" data-title=\"OPTIweb - V0.1 - Crédits\">\n"+
"<div data-role=\"header\" data-add-back-btn=\"true\">\n"+
"<h1>Crédits</h1>\n"+
"</div>\n"+
"<div data-role=\"content\">\n"+
"    <p>Cette application a été réalisée dans le cadre du module M3301/MPA du DUT Informatique à l'IUT de Blagnac.</p>\n"+
"<ul data-role=\"listview\" data-inset=\"true\" id=\"contacts\" data-theme=\"a\" data-divider-theme=\"b\">\n"+
"    <li data-role=\"list-divider\">Product Owner</li>\n"+
"    <li>André PÉNINOU</li>\n"+
"    <li>Université Toulouse 2 - IUT de Blagnac\n"+
"    <br/>Département INFORMATIQUE</li>\n"+
"</ul>\n"+
"<ul data-role=\"listview\" data-inset=\"true\" id=\"listecredits\" data-theme=\"a\" data-divider-theme=\"b\">\n"+
"    <li data-role=\"list-divider\">Membres de l'équipe enseignante</li>\n"+
"<li>Jean-Michel BRUEL</li><li>Jean-Michel INGLEBERT</li><li>André PÉNINOU</li><li>Olivier ROQUES</li>\n"+
"</ul>\n"+
"<ul data-role=\"listview\" data-inset=\"true\" id=\"listepowered\" data-theme=\"a\" data-divider-theme=\"b\">\n"+
"    <li data-role=\"list-divider\">Propulsé par</li>\n"+
"    <li><a href=\"http://jquerymobile.com/\" target=\"autrePage\">http://jquerymobile.com/</a></li>\n"+
"    <li><a href=\"http://fortawesome.github.io/Font-Awesome/\" target=\"autrePage\">http://fortawesome.github.io/Font-Awesome/</a></li>\n"+
"</ul>\n"+
"</div>\n"+
"<div data-role=\"footer\"> \n"+
" <h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa- fa-2x\"></i></h4> \n"+
"</div>\n"+
"</div>\n"+
"<!-- FIN page credits -->\n"+
"\n"+//DEBUT PROJET
"<!-- DEBUT page projets -->\n"+
"<div data-role=\"page\" id=\"projets\" data-title=\"OPTIweb - V0.1\">\n"+
"<div data-role=\"header\" data-add-back-btn=\"true\">\n"+
"<h1>Projets 2014-2015</h1>\n"+
"</div>\n"+
"<div data-role=\"content\">\n"+
"<form class=\"ui-filterable\"><input id=\"autocomplete-input-projet\" name=\"projet\" data-type=\"search\" placeholder=\"Vous cherchez ?...\"></form>"+
"	<ol id=\"listeprojets\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-projet\">";
		html += pageProjetHTML();
		html += "	</ol>\n"+
"</div>\n"+
"<div data-role=\"footer\">\n"+
"<h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa-tasks fa-2x\"></i></h4> \n"+
"</div>\n"+
"</div>\n"+
"<!-- FIN page projets -->\n"+
"\n"+//DEBUT SUJET
"<!-- DEBUT page sujets -->\n"+
"<div data-role=\"page\" id=\"sujets\" data-title=\"OPTIweb - V0.1\">\n"+
"<div data-role=\"header\" data-add-back-btn=\"true\">\n"+
"<h1>Sujets 2014-2015</h1>\n"+
"</div>\n"+
"<div data-role=\"content\">\n"+
"  <form class=\"ui-filterable\"><input id=\"autocomplete-input-sujet\" name=\"sujet\" data-type=\"search\" placeholder=\"Vous cherchez ?\"></form>" +
"	<ol id=\"listesujets\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-sujet\" data-divider-theme=\"b\" data-count-theme=\"a\">";
		html += pageSujetHTML();
		html += "	</ol>\n"+
"</div>\n"+
"<div data-role=\"footer\"> \n"+
" <h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa-copy fa-2x\"></i></h4> \n"+
"</div>\n"+
"</div>\n"+
"<!-- FIN page sujets -->\n"+
"\n"+//DEBUT ETUDIANT
"<!-- DEBUT page etudiants -->\n"+
"<div data-role=\"page\" id=\"etudiants\" data-title=\"OPTIweb - V0.1\">\n"+
"<div data-role=\"header\" data-add-back-btn=\"true\">\n"+
"<h1>Etudiants 2014-2015</h1>\n"+
"</div>\n"+
"<div data-role=\"content\">\n"+
"  <form class=\"ui-filterable\"><input id=\"autocomplete-input-etudiant\" name=\"etudiant\" data-type=\"search\" placeholder=\"Etudiant ou Groupe X\"></form>\n"+
"  <ol id=\"listeetudiants\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-etudiant\" data-divider-theme=\"b\">\n";
		html += pageEtudiantHTML();
		html += "  </ol>\n"+
"</div>\n"+
"<div data-role=\"footer\">\n"+ 
" <h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa-group fa-2x\"></i></h4>\n"+
"</div>\n"+
"</div>\n"+
"<!-- FIN page etudiants -->\n"+
"\n"+//DEBUT INERVENANT
"<!-- DEBUT page intervenants -->\n"+
"<div data-role=\"page\" id=\"intervenants\" data-title=\"OPTIweb - V0.1\">\n"+
"<div data-role=\"header\" data-add-back-btn=\"true\">\n"+
"<h1>Intervenants 2014-2015</h1>\n"+
"</div>\n"+
"<div data-role=\"content\">\n"+
"  <form class=\"ui-filterable\"><input id=\"autocomplete-input-intervenant\" name=\"intervenant\" data-type=\"search\" placeholder=\"Intervenant\"></form>\n"+
"	<ul id=\"listeintervenants\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-intervenant\" data-divider-theme=\"b\">\n";
		html += pageIntervenantHTML();
		html += "	</ul>\n"+
"</div>\n"+
"<div data-role=\"footer\"> \n"+
" <h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa-group fa-2x\"></i></h4> \n"+
"</div>\n"+
"</div>\n"+
"<!-- FIN page intervenants -->\n"+
"\n";
		html += "<script>\n"+
" // li click handler which fills the projects search bar \n"+
" // with the value of the current data-find attribute\n"+
" $( 'li[data-find]' ).on( 'click',function(event){\n"+
"  $(\"#autocomplete-input-projet\").val($(this).attr('data-find')).trigger('change');\n"+
" });\n"+
"</script>\n"+
"</body>\n"+
"</html>";
		try {
			FileWriter fw = new FileWriter("./OPTIwebTEST.html");
				fw.write(html);
			fw.close();
		}catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public static String pageProjetHTML(){
		String html = "";
		
		for(String[] projet : listProjet){
			String nomSujet = "";
			String titreSujet = "";
			String nomClient = "";
			String nomSuperviseur = "";
			String listEtudiants = "";
			for(String[] sujet : listSujet)
				if(sujet[0].compareToIgnoreCase(projet[2]) == 0){
					nomSujet = sujet[1];
					titreSujet = sujet[2];
				}
			for(String[] intervenant : listIntervenant){
				if(intervenant[0].compareToIgnoreCase(projet[3]) == 0)
					nomClient = intervenant[1]+" "+intervenant[2];
				if(intervenant[0].compareToIgnoreCase(projet[4]) == 0)
					nomSuperviseur = intervenant[1]+" "+intervenant[2];
			}
			for(String[] etudiant : listEtudiant){
				if(etudiant[0].compareToIgnoreCase(projet[1]) == 0)
					listEtudiants += etudiant[3]+" "+etudiant[2]+" - ";
			}
			html += "<li><p><b>["
					+ nomSujet
					+ "]</b> "
					+ titreSujet
					+ "</p><p><b>Client :</b> "
					+ nomClient
					+ "</p><p><b>Superviseur :</b> "
					+ nomSuperviseur
					+ "</p><p><b>Groupe "
					+ projet[1]
					+ ":</b> "
					+ listEtudiants
					+ "</p></li>";
		}
		return html;
	}
	
	public static String pageEtudiantHTML(){
		String html = "";

		html += "<li data-role=\"list-divider\">Etudiant"
				+ "<span class=\"ui-li-count\" title=\"Groupe\" style=\"right: 40px !important;\">Groupe"
				+ "</span></li>";
		
		for(String[] etudiant : listEtudiant){
			html += "<li data-find=\""
					+ etudiant[3] +" "+ etudiant[2]
					+ "\"><a href=\"#projets\">"
					+ etudiant[2] +" "+ etudiant[3]
					+ "<span class=\"ui-li-count\" title=\"Groupe\">Groupe "
					+ etudiant[0]
					+ "</span></a></li>";
		}
		return html;
	}
	
	public static String pageIntervenantHTML(){
		String html = "";
		
		html += "<li data-role=\"list-divider\">Intervenant"
				+ "<span class=\"ui-li-count\" style=\"right: 110px !important;\" title=\"Client\">Client"
				+ "</span><span class=\"ui-li-count\" title=\"Superviseur\">Superviseur"
				+ "</span></li>";
		
		for(String[] intervenant : listIntervenant){
			int conteurClient = 0;
			int conteurSuperviseur = 0;
			for(String[] projet : listProjet){
				if(projet[3].compareToIgnoreCase(intervenant[0]) == 0)
					conteurClient ++;
				if(projet[4].compareToIgnoreCase(intervenant[0]) == 0)
					conteurSuperviseur ++;
			}
			html += "<li data-find=\""
					+ intervenant[1] +" "+ intervenant[2]
					+ "\"><a href=\"#projets\">"
					+ intervenant[2] +" "+ intervenant[1]
					+ "<span class=\"ui-li-count\" style=\"right: 120px !important;\" title=\"Client\">"
					+ conteurClient
					+ "</span><span class=\"ui-li-count\" title=\"Superviseur\">"
					+ conteurSuperviseur
					+ "</span></a></li>";
		}
		return html;
	}
	
	public static String pageSujetHTML(){
		String html = "";
		
		html += "<li data-role=\"list-divider\">Sujet"
				+ "<span class=\"ui-li-count\" title=\"Groupe\" style=\"right: 40px !important;\">Groupe"
				+ "</span></li>";
		
		for(String[] sujet : listSujet){
			String groupe = "";
			for(String[] projet : listProjet){
				if(projet[2].compareToIgnoreCase(sujet[0]) == 0)
					groupe = projet[1];
			}
			html += "<li data-find=\"["
					+ sujet[1]
					+ "]\"><a href=\"#projets\">["
					+ sujet[1]
					+ "]<br/><div style=\"white-space:normal;\"><span><b>"
					+ sujet[2]
					+ "</b></span><span class=\"ui-li-count\">"
					+ groupe
					+ "</span></div></a></li>";
		}
		return html;
	}

	public static void creerJson(){
		String[] titleSujet = null;
		String[] titleEtudiant = null;
		String[] titleIntervenant = null;
		try{
			titleSujet = LibCSV.readTitles("OPTIweb/test/sujets2014_2015.csv");
			titleEtudiant = LibCSV.readTitles("OPTIweb/test/etudiants2014_2015.csv");
			titleIntervenant = LibCSV.readTitles("OPTIweb/test/intervenants2014_2015.csv");
		}catch(Exception e){
			System.out.println("ERREUR lors de la lecture : "+e.toString());
		}
		String etudiant = "";
		String sujet = "";
		String intervenant = "";
		//ETUDIANT//
		etudiant += "[\n";
		for(int i = 0; i < listEtudiant.size(); i++){
		    etudiant += "{";
		    for(int j = 0; j < titleEtudiant.length; j++){
		    	if(j == 0)
		    		etudiant +="\"group\": \""+ listEtudiant.get(i)[j]+"\"";
		    	else
		    		etudiant +="\""+ titleEtudiant[j]+"\": \""+ listEtudiant.get(i)[j]+"\"";
		    	if(j != titleEtudiant.length-1)
		    		etudiant += ",\n";
		    }
		    if(i != listEtudiant.size()-1)
		    	etudiant += "},\n";
		}
		etudiant += "}\n]";
		//INTERVENANT//
		intervenant += "[\n";
		for(int i = 0; i < listIntervenant.size(); i++){
			intervenant += "{";
		    for(int j = 1; j < titleIntervenant.length; j++){
		    	intervenant +="\""+ titleIntervenant[j]+"\": \""+ listIntervenant.get(i)[j]+"\"";
		    	if(j != titleIntervenant.length-1)
		    		intervenant += ",\n";
		    }
		    if(i != listIntervenant.size()-1)
		    	intervenant += "},\n";
		}
		intervenant += "}\n]";
		//SUJET//
		sujet += "[\n";
		for(int i = 0; i < listSujet.size(); i++){
			sujet += "[";
		    for(int j = 1; j < titleSujet.length; j++){
		    	sujet +="\""+ listSujet.get(i)[j]+"\"";
		    	if(j != titleSujet.length-1)
		    		sujet += ",";
		    }
		    if(i != listSujet.size()-1)
		    	sujet += "],\n";
		}
		sujet += "]\n]";
		
		try{
			FileWriter etujs = new FileWriter("OPTIweb/test/etudiants2014_2015test.json");
			etujs.write(etudiant);
			etujs.close();
			FileWriter interjs = new FileWriter("OPTIweb/test/intervenants2014_2015test.json");
			interjs.write(intervenant);
			interjs.close();
			FileWriter sujjs = new FileWriter("OPTIweb/test/sujets2014_2015test.json");
			sujjs.write(sujet);
			sujjs.close();
		}catch(Exception e){
			System.out.println("ERREUR lors de l'écriture : "+e.toString());
		}
	}
}
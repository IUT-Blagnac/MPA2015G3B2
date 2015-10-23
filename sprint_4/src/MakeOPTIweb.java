
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MakeOPTIweb{
	public static void main(String[] args){
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
"<!-- DEBUT page etudiants -->\n"+
"<div data-role=\"page\" id=\"etudiants\" data-title=\"OPTIweb - V0.1\">\n"+
"<div data-role=\"header\" data-add-back-btn=\"true\">\n"+
"<h1>Etudiants 2014-2015</h1>\n"+
"</div>\n"+
"<div data-role=\"content\">\n"+
"  <form class=\"ui-filterable\"><input id=\"autocomplete-input-etudiant\" name=\"etudiant\" data-type=\"search\" placeholder=\"Etudiant ou Groupe X\"></form>\n"+
"  <ol id=\"listeetudiants\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-etudiant\" data-divider-theme=\"b\">\n";
		try{
			html += pageEtudiantHTML();
		}catch(Exception e){
			System.out.println(e.toString());
		}
		html += "  </ol>\n"+
"</div>\n"+
"<div data-role=\"footer\">\n"+ 
" <h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa-group fa-2x\"></i></h4>\n"+
"</div>\n"+
"</div>\n"+
"<!-- FIN page etudiants -->\n";
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
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter fichierSortie = new PrintWriter(bw);
				fichierSortie.print(html);
			fichierSortie.close();
		}catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public static String pageEtudiantHTML() throws Exception{
		String html = "";
		ArrayList<String[]> listEtudiant = LibCSV.readValues("OPTIweb/test/etudiants2014_2015.csv");

		html += "<li data-role=\"list-divider\">Etudiant"
				+ "<span class=\"ui-li-count\" title=\"Groupe\" style=\"right: 40px !important;\">Groupe"
				+ "</span></li>";
		
		for(String[] etudiant : listEtudiant){
			html += "<li data-find=\""
					+ etudiant[3] + etudiant[2]
					+ "\"><a href=\"#projets\">"
					+ etudiant[2] + etudiant[3]
					+ "<span class=\"ui-li-count\" title=\"Groupe\">Groupe "
					+ etudiant[0]
					+ "</span></a></li>";
		}
		return html;
	}
	
	public static String pageIntervenantHTML() throws Exception{
		String html = "";
		ArrayList<String[]> listIntervenant = LibCSV.readValues("OPTIweb/test/intervenants2014_2015.csv");
		
		html += "<li data-role=\"list-divider\">Intervenant"
				+ "<span class=\"ui-li-count\" style=\"right: 110px !important;\" title=\"Client\">Client"
				+ "</span><span class=\"ui-li-count\" title=\"Superviseur\">Superviseur"
				+ "</span></li>";
		
		for(String[] intervenant : listIntervenant){
			html += "<li data-find=\""
					+ intervenant[3] + intervenant[2]
					+ "\"><a href=\"#projets\">"
					+ intervenant[2] + intervenant[3]
					+ "<span class=\"ui-li-count\" style=\"right: 120px !important;\" title=\"Client\">"
					+ ""//conter le nombre de fois client
					+ "</span><span class=\"ui-li-count\" title=\"Superviseur\">"
					+ ""//conter le nombre de fois superviseur
					+ "</span></a></li>";
		}
		return html;
	}
	
	public static String pageSujetHTML() throws Exception{
		String html = "";
		ArrayList<String[]> listSujet = LibCSV.readValues("OPTIweb/test/intervenants2014_2015.csv");
		
		html += "<li data-role=\"list-divider\">Sujet"
				+ "<span class=\"ui-li-count\" title=\"Groupe\" style=\"right: 40px !important;\">Groupe"
				+ "</span></li>";
		
		for(String[] sujet : listSujet){
			html += "<li data-find=\"["
					+ sujet[3] + sujet[2]
					+ "]\"><a href=\"#projets\">["
					+ sujet[2] + sujet[3]
					+ "]<span class=\"ui-li-count\" style=\"right: 120px !important;\" title=\"Client\">"
					+ ""//conter le nombre de fois client
					+ "</span><span class=\"ui-li-count\" title=\"Superviseur\">"
					+ ""//conter le nombre de fois superviseur
					+ "</span></a></li>";
		}
		//<li data-find="[ApexEComm]"><a href="#projets">[ApexEComm] <br/><div style="white-space:normal;"><span><b>Application et tutoriel Oracle Apex pour un site d'e-commerce</b></span><span class="ui-li-count">I</span></div></a></li><li data-find="[Archeologie]"><a href="#projets">[Archeologie] <br/><div style="white-space:normal;"><span><b>Groupe de recherche Chasséen Méridional</b></span><span class="ui-li-count">A</span></div></a></li><li data-find="[Architekt]"><a href="#projets">[Architekt] <br/><div style="white-space:normal;"><span><b>Architekt</b></span><span class="ui-li-count">N O</span></div></a></li><li data-find="[BDM NoSQL]"><a href="#projets">[BDM NoSQL] <br/><div style="white-space:normal;"><span><b>Développement d’un logiciel de conception d’une base de données multidimensionnelles</b></span><span class="ui-li-count">F</span></div></a></li><li data-find="[Carsat]"><a href="#projets">[Carsat] <br/><div style="white-space:normal;"><span><b>Questionnaire client sur page web et traitement des données</b></span><span class="ui-li-count">P</span></div></a></li><li data-find="[E-ICGD]"><a href="#projets">[E-ICGD] <br/><div style="white-space:normal;"><span><b>Environnement d'intégration continue de génération de documentation</b></span><span class="ui-li-count">G</span></div></a></li><li data-find="[GESDEP]"><a href="#projets">[GESDEP] <br/><div style="white-space:normal;"><span><b>Finalisation et déploiement de l'application de gestion des déplacements des personnels</b></span><span class="ui-li-count">D</span></div></a></li><li data-find="[PrestaShop]"><a href="#projets">[PrestaShop] <br/><div style="white-space:normal;"><span><b>Application et tutoriel sur Prestashop (logiciel e-commerce gratuit )</b></span><span class="ui-li-count">H Q</span></div></a></li><li data-find="[Prodif]"><a href="#projets">[Prodif] <br/><div style="white-space:normal;"><span><b>Refactoring de l'application Java PRODIF</b></span><span class="ui-li-count">K</span></div></a></li><li data-find="[Recon
		return html;
	}
}
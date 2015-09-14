import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class sprint0 {
	public static void main(String[] args){
		JFrame fenetre = new JFrame();
		fenetre.setSize(400, 100);
		JTabbedPane tabbedPane = new JTabbedPane();
		JTextArea test = new JTextArea();
		fenetre.add(tabbedPane);
		test.append("Liste des membres du groupe : \n"
				+ "- Florian SEGUIN \n"
				+ "- Guilhem SABATHIER \n"
				+ "- Cedric DOULIEZ \n"
				+ "- Simon TAILLEFER \n"
				+ "- Antoine BADOC \n"
				+ "- Mickael BAUTISTA \n"
				+ "");
		test.setEnabled(false);
		tabbedPane.addTab("A propos", test);
		fenetre.setVisible(true);
	}
	
}

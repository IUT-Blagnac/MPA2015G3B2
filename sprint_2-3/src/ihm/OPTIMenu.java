package ihm;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public class OPTIMenu extends JMenuBar {
	private static final long serialVersionUID = 1L;
	
	private OPTI parent;
	
	public OPTIMenu(OPTI opti){
		parent = opti;
		
		JMenu menu = new JMenu("Fichier");
		JMenuItem item;
		
		item = new JMenuItem("Enregistrer");
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
		menu.add(item);
		
		item = new JMenuItem("Enregistrer sous...");
		menu.add(item);
		
		this.add(menu);
	}
	
}

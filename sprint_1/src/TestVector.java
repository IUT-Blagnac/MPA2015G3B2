import java.awt.*;


import java.awt.event.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;

import javax.swing.*;


/*
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;
*/

class MyJFrame extends JFrame{
	private JList<String> theJList;
    private JScrollPane scrollPane;
    private JButton bok;
    
    public MyJFrame(String _title, String filepath) {
        super(_title);

        this.setBounds(20, 20, 600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JScrollPane pour les ascenseurs de la JList.
        this.scrollPane = new JScrollPane();
        this.scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // On met la JScrollPane dans la fenêtre
        this.add(this.scrollPane, BorderLayout.CENTER);
        
        // Créer la JList + paramétrage
        this.theJList = new JList<String>();
        this.theJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // On met les données dans la JList
        //this.theJList.setListData(LibCSV.read(filepath));
        //List<String> kist = Files.readAllLines(Paths.get(filepath), Charset.defaultCharset());
        
        // On met la JList dans la JScrollPane
        this.scrollPane.setViewportView(this.theJList);
    }    
        private Vector<String> getValues() {
            Vector<String> v;
            // Créer les valeurs (ici des chaines) que l'on veut afficher
            v = new Vector<String>();
            v.add("Test");
            v.add("Swag");
            v.add("Retest");
            return v;
    }
        
    public class TestVector {
        public void main(String[] args) {
                MyJFrame maFen = new MyJFrame("titre", "filepath");
                maFen.setVisible(true);
        }
    }   
}

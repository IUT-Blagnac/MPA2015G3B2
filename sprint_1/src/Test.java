import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

class MyJFrame extends JFrame {
        private JList<String> theJList;
        private JScrollPane scrollPane;
        private JButton bok;

        public MyJFrame(String _title, int _nbValues) {
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
                this.theJList.setListData(this.getValuesFromSomewhere(_nbValues));

                // On met la JList dans la JScrollPane
                this.scrollPane.setViewportView(this.theJList);

                // Parfois on pré-sélectionne une ligne au hasard
                if (_nbValues > 0 && Math.random() > 0.5) {
                        this.theJList.setSelectedIndex((int)(Math.random() * _nbValues));
                }
                if (this.theJList.getSelectedIndex() >= 0) {
                        this.theJList.ensureIndexIsVisible(this.theJList.getSelectedIndex());
                }

                // On ajoute un bouton dans la fenêtre pour tester
                this.bok = new JButton("Test");
                this.add(this.bok, BorderLayout.SOUTH);
                this.bok.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                                doBok();
                        }
                });
        }

        // Pour tester …
        public void doBok() {
                if (this.theJList.getSelectedIndex() >= 0) {
                        JOptionPane.showMessageDialog(this, "Selected range : " + this.theJList.getSelectedIndex());
                        JOptionPane.showMessageDialog(this, "Selected value : " + this.theJList.getSelectedValue());
                } else {
                        JOptionPane.showMessageDialog(this, "No Selection ...");
                }

                // Désélectionner la sélection ...
                this.theJList.setSelectedIndices(new int[0]);
        }

        // Récupère des données à afficher ... qui pourraient venir de n'importe où ...
        private Vector<String> getValuesFromSomewhere (int _nbValues) {
                Vector<String> v;
                // Créer les valeurs (ici des chaines) que l'on veut afficher
                v = new Vector<String>();
                for (int i = 0; i < _nbValues; i++) {
                        v.add("Selectable value : " + i);
                }
                return v;
        }
} // Fin MaFen

public class Test {
        public static void main(String[] args) {
                MyJFrame maFen = new MyJFrame("titre", 50);
                maFen.setVisible(true);
        }
}
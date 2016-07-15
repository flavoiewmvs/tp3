/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.plaf.FontUIResource;

/**
 *
 * @author flavo
 */
//public class Guiex extends JFrame implements ActionListener {
public class Planificateur extends JFrame {

    public static final int BORDURE_X = 430;
    public static final int BORDURE_Y = 120;
    JButton btnJouerNote;
    JMenuBar barreMenuOnde;
    JLabel titreChamps;
    JLabel titreChamps1;
    JTextField saisieADSR_R;
    JTextField saisieADSR_R1;

    Container contenu;
    JPanel panneau_de_composants;

    public Planificateur() {
        setUIFont(new FontUIResource(new Font("Arial", 0, 40)));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        contenu = getContentPane();
        panneau_de_composants = new JPanel();
        panneau_de_composants.setLayout(new GridLayout(2, 2));
        panneau_de_composants.setBackground(Color.LIGHT_GRAY);
        titreChamps = new JLabel("Test1 :                         ");
        saisieADSR_R = new JTextField("");
        panneau_de_composants.add(titreChamps);
        panneau_de_composants.add(saisieADSR_R);
        titreChamps1 = new JLabel("Test2 :                         ");
        saisieADSR_R1 = new JTextField("");
        panneau_de_composants.add(titreChamps1);
        panneau_de_composants.add(saisieADSR_R1);
        contenu.add(panneau_de_composants, BorderLayout.CENTER);
        afficherMenu();
        pack();
        setVisible(true);
    }

    public static void setUIFont(FontUIResource f) {
        Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                FontUIResource orig = (FontUIResource) value;
                Font font = new Font(f.getFontName(), orig.getStyle(), f.getSize());
                UIManager.put(key, new FontUIResource(font));
            }
        }
    }

    private void afficherMenu() {

        barreMenuOnde = new JMenuBar();

        // Ajouter la barre de menu sur la fenetre
        setJMenuBar(barreMenuOnde);

        // Ajouter le menu de choix d'onde sur la barre
        JMenu menu = new JMenu("Menu Choisir Test");
        barreMenuOnde.add(menu);

        // Ajouter les differents choix au menu
        JMenuItem opt1 = new JMenuItem("1- Nom");
        opt1.setActionCommand("t1");

        JMenuItem opt2 = new JMenuItem("2- Prenom");
        opt2.setActionCommand("t2");

        opt1.addActionListener((e) -> titreChamps.setText(opt1.getText()));

//        opt1.addActionListener(this);
        opt2.addActionListener((e) -> titreChamps.setText(opt2.getText()));

        menu.add(opt1);
        menu.add(opt2);
    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == btnJouerNote) {
//            /**
//             * Le reste c'est a vous le completer
//             */
//        }
//        // rendre visible les changements sur la fenetre
//        this.setVisible(true);
//    }

    public static void jouerNote(int a) {
        int qq = 0;
    }

    public static void main(String[] args) {
        Planificateur ecran = new Planificateur();
    }

}

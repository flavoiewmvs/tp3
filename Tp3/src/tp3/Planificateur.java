package tp3;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.plaf.FontUIResource;

/**
 *
 * @author flavoie Fabien Lavoie lavf27046702
 *
 * planificateur hebdomadaire. Cette interface va permettre l’ajout, la
 * modification et la suppression d’activité. Ces activités vont être placé en
 * ordre d’heure de début et contenir une courte description.
 */
//public class Guiex extends JFrame implements ActionListener {
public class Planificateur extends JFrame {

//    public static final int BORDURE_X = 430;
//    public static final int BORDURE_Y = 120;
    JButton btnNouveaua;

    JLabel Filler1;
    JLabel Filler2;
    JLabel Filler3;
    JLabel Filler4;
    JLabel titre;
    JLabel Heure;
    JLabel Description;
    JTextField saisieTitre;
    JTextField saisieHeure;
    JTextArea saisieDescription;

    Container contenu;
    JPanel DetailItem;
    JPanel DetailItem1;
    JPanel DetailItem2;
    JPanel DetailItem3;

    public Planificateur() {
        setUIFont(new FontUIResource(new Font("Arial", 0, 40)));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        contenu = getContentPane();
        //Construction de la section detail
        DetailItem = new JPanel();
        DetailItem.setLayout(new GridLayout(3, 1));
        DetailItem.setBackground(Color.LIGHT_GRAY);
        DetailItem1 = new JPanel();
        DetailItem1.setLayout(new GridLayout(4, 2));
        DetailItem1.setBackground(Color.LIGHT_GRAY);
        DetailItem2 = new JPanel();
        DetailItem2.setLayout(new GridLayout(1, 2));
        DetailItem2.setBackground(Color.LIGHT_GRAY);
        DetailItem3 = new JPanel();
        DetailItem3.setLayout(new GridLayout(1, 3));
        DetailItem3.setBackground(Color.LIGHT_GRAY);

        Filler1 = new JLabel("");
        DetailItem1.add(Filler1);
        Filler1 = new JLabel("");
        DetailItem1.add(Filler1);
        Filler1 = new JLabel("");
        DetailItem1.add(Filler1);
        Filler1 = new JLabel("");
        DetailItem1.add(Filler1);

        titre = new JLabel("Titre :");
        DetailItem1.add(titre);
        saisieTitre = new JTextField("");
        DetailItem1.add(saisieTitre);

        Heure = new JLabel("Heure :");
        DetailItem1.add(Heure);
        saisieHeure = new JTextField("");
        DetailItem1.add(saisieHeure);

        Description = new JLabel("Description : ");
        DetailItem2.add(Description);
        saisieDescription = new JTextArea("");
        saisieDescription.setColumns(20);
        saisieDescription.setRows(10);
        DetailItem2.add(saisieDescription);

        DetailItem.add(DetailItem1);
        DetailItem.add(DetailItem2);
        DetailItem.add(DetailItem3);
        contenu.add(DetailItem, BorderLayout.CENTER);

        //fin de section detail
        pack();
        setVisible(true);
    }

    public static void setUIFont(FontUIResource f) {
        // methode pour ajuster la font 
        // besoin d<ajuster font sur ecran 4k
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

    public static void main(String[] args) {
        Planificateur ecran = new Planificateur();
    }

}

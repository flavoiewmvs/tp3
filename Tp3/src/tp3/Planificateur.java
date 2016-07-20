package tp3;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
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
//champs section action
    JPanel action;
    JButton btnAjouter;
    JButton btnSupprimer;
//champ section detail
    JLabel Filler1;
    JLabel Filler2;
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
    JPanel DetailItem4;
    JButton btnSauvegarder;
//champ secton ListeTitra
//    JPanel ListeTitre;
//    JLabel Titre1;
    JList<String> ListeTitre;

    public Planificateur() {
        setUIFont(new FontUIResource(new Font("Arial", 0, 40)));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        contenu = getContentPane();
        afficheAction();
        afficheListeTitre();
        afficheDetail();

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

    private void afficheAction() {
        //Construction de la section detail
        action = new JPanel();
        action.setLayout(new GridLayout(1, 4));

        btnAjouter = new JButton("Ajouter");
        btnSupprimer = new JButton("Supprimer");
        Filler1 = new JLabel("");
        action.add(Filler1);
        action.add(btnAjouter);
        action.add(btnSupprimer);
        Filler1 = new JLabel("");
        action.add(Filler1);

        contenu.add(action, BorderLayout.NORTH);
    }

    private void afficheListeTitre() {
        //Construction de la section detail
        ListeTitre = new javax.swing.JList<>();
        ListeTitre.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {"Titre 1             ", "Titre 2", "Titre 3", "Titre 4", "Titre 5", "Titre 6", "Titre 7", "Titre 8", "Titre 9", "Titre 10"};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        ListeTitre.addListSelectionListener((e) -> saisieTitre.setText(ListeTitre.getSelectedValue()));
        contenu.add(ListeTitre, BorderLayout.WEST);
    }

    private void faireItem(String text, double par, String text1) {
        Item monItem = new Item(saisieTitre.getText(), 10.5, saisieDescription.getText());
        ABR_activités mesActivités = new ABR_activités(monItem);
        System.out.println(mesActivités.ParcoursInfixe());
        System.out.println("item ajouté");
    }

    private void afficheDetail() {
        //Construction de la section detail
        //je divise en trois ma section detail pour le formatage
        DetailItem = new JPanel();
        DetailItem.setLayout(new GridLayout(3, 1));
        DetailItem.setBackground(Color.LIGHT_GRAY);
        //portion detail titre et heure
        DetailItem1 = new JPanel();
        DetailItem1.setLayout(new GridLayout(6, 2));
        DetailItem1.setBackground(Color.LIGHT_GRAY);
        //portion de la description
        DetailItem2 = new JPanel();
        DetailItem2.setLayout(new GridLayout(1, 2));
        DetailItem2.setBackground(Color.LIGHT_GRAY);
        //portion de l action
        DetailItem3 = new JPanel();
        DetailItem3.setLayout(new GridLayout(6, 2));
        DetailItem3.setBackground(Color.LIGHT_GRAY);
        DetailItem4 = new JPanel();
        DetailItem4.setLayout(new BorderLayout());
        DetailItem4.setBackground(Color.LIGHT_GRAY);

//ajout de champs vide pour avoir un hauteur de champs normal
        for (int i = 1; i <= 8; ++i) {
            Filler1 = new JLabel("");
            DetailItem1.add(Filler1);
        }

        titre = new JLabel("Titre :");
        DetailItem1.add(titre);
        saisieTitre = new JTextField("");
        DetailItem1.add(saisieTitre);

        Heure = new JLabel("Heure :");
        DetailItem1.add(Heure);
        saisieHeure = new JTextField("");
        saisieHeure.setToolTipText("hh:mm (hh=0..23) (mm=0..59)");
        DetailItem1.add(saisieHeure);

        Description = new JLabel("Description : ");
        DetailItem2.add(Description);
        saisieDescription = new JTextArea("");
        saisieDescription.setColumns(20);
        saisieDescription.setRows(10);
        DetailItem2.add(saisieDescription);

        Filler2 = new JLabel("");
        DetailItem3.add(Filler2);
        btnSauvegarder = new JButton("Sauvegarder");
        DetailItem3.add(DetailItem4);
        DetailItem4.add(btnSauvegarder, BorderLayout.EAST);

        DetailItem.add(DetailItem1);
        DetailItem.add(DetailItem2);
        DetailItem.add(DetailItem3);
        contenu.add(DetailItem, BorderLayout.CENTER);
//               ListeTitre.addListSelectionListener((e) -> saisieTitre.setText(ListeTitre.getSelectedValue()));
        btnSauvegarder.addActionListener((action) -> faireItem(saisieTitre.getText(), 11.5, saisieDescription.getText()));
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

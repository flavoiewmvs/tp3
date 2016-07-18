/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

/**
 *
 * @author flavoi Fabien Lavoie lavf27046702
 */
public class Item implements Comparable<Item>{
// cette class contient notre reférence a notre objet contenue dans le tableau

    private String titre;
    private double heure;
    private String description;

    public Item(String titre, double heure) {
        this.titre = titre;
        this.heure = heure;
    }

    public Item(String titre, double heure, String description) {
        this.titre = titre;
        this.heure = heure;
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getHeure() {
        return heure;
    }

    public void setHeure(float heure) {
        this.heure = heure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
@Override
    public int compareTo( final Item o) {
        return Double.compare(this.getHeure(), o.getHeure());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import javax.swing.AbstractListModel;

/**
 *
 * @author flavo
 */
public class FaitListe extends AbstractListModel {

//    AbstractListModel maListe = new AbstractListModel<String>();
    String[] strings = {"Titre 1             ", "", "", "", "", "", "", "", "", ""};

    public void setValeur(String valeur, int indice) {
        this.strings[indice] = valeur;
    }

    @Override
    public int getSize() {
        return strings.length;
    }

    @Override
    public String getElementAt(int i) {
        return strings[i];
    }
}

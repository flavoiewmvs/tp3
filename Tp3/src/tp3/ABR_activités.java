/*
cette class contient chacun des items activités
l'utilisation d'un arbre binaire me permet d'effectuer une recherche efficace de mes items
J'ai repris la structure vue en classe
 code: (watt & brown 2001)
        guy lapalme 2011)
        (b.m   2016)

 */
package tp3;

/**
 *
 * @author flavoie Fabien Lavoie lavf27046702
 */
public class ABR_activités<E extends Comparable<E>> {

    protected E _element;
    protected ABR_activités<E> _gauche;
    protected ABR_activités<E> _droite;

    public ABR_activités() {
    }

    public ABR_activités(E element) {
        _element = element;
        _gauche = null;
        _droite = null;
    }

    public ABR_activités<E> inserer(E element) {
        int direction = element.compareTo(_element);
        if (direction < 0) {
            _gauche = (_gauche == null) ? new ABR_activités<E>(element) : _gauche.inserer(element);
        } else if (direction > 0) {
            _droite = (_droite == null) ? new ABR_activités<E>(element) : _droite.inserer(element);
        }
        return this;
    }
public E parcoursInfixe(ABR_activités<E> a) 
{
//  if (a == null)
    
  parcoursInfixe(a._gauche);
//  System.out.print(a._element + " ");
  parcoursInfixe(a._droite);
  return a._element;
}

    public int taille() {
        return ((_gauche == null) ? 0 : _gauche.taille()) + ((_droite == null) ? 0 : _droite.taille()) + 1;
    }

 
}

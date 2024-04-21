package tp2.etudiant.section;

import tp2.application.AbstractProduit;
import tp2.etudiant.boite.Boite;

import java.util.*;

public class Vrac implements AireI {

    private Collection<AbstractProduit> produitsVersCharite;

    private Charite charite;
    public final static int idDefault = 0;
    public double capaciteMax = 100;
    public int sectionId;
    private Map<String, Set<AbstractProduit>> contenu;



    public Vrac (){
        this.sectionId = idDefault;
        contenu = new HashMap<>();
        produitsVersCharite = new ArrayList<>();
        this.charite = new Charite();
    }

    /**
     * decrit le vrac, utile pour savoir le volume courant par rapport à la capacité max
     * @return
     */
    @Override
    public String decrit() {
        return "Vrac ID:0, volume utilisé - " + calculVolumeTotal() + " / capacité totale - " + capaciteMax;
    }

    /**
     * méthode permetant de retirer le produit sélectionné
     * @param items
     * @return
     */
    @Override
    public Collection<AbstractProduit> retireProduits(Collection<AbstractProduit> items) {
        for (Map.Entry<String, Set<AbstractProduit>> entry : contenu.entrySet()) {
            String key = entry.getKey();
            contenu.get(key).removeAll(items);
            if (contenu.get(key).isEmpty()) {
                contenu.remove(key);
            }
        }
        return items;
//
    }

    /**
     * permet de voir les produits dans le vrac
     * @return
     */
    @Override
    public Collection<AbstractProduit> getAllProduits() {
        Collection<AbstractProduit> contenuCollection = new ArrayList<>();
        for (Map.Entry<String, Set<AbstractProduit>> entry : contenu.entrySet()) {
            String cle = entry.getKey();
            contenuCollection.addAll(contenu.get(cle));
        }
        return contenuCollection;
    }


    /**
     * Place les produits des boîtes dans l'entrepôt dans le Vrac
     * @param produits
     * @return
     */
    @Override
    public Collection<AbstractProduit> placerProduits(Boite produits) {
        List<AbstractProduit> listeProduit = produits.getContenu();
        Collection<AbstractProduit> retCol = new ArrayList<>();
        for (AbstractProduit produit : listeProduit) {
            double totalVolume = calculVolumeTotal();
            if (totalVolume + produit.getVolumeProduit() <= capaciteMax) {
                String nomProduit = produit.getNom();
                contenu.computeIfAbsent(nomProduit, k -> new HashSet<>()).add(produit);
                totalVolume += produit.getVolumeProduit();
            } else {
                produitsVersCharite.add(produit);
                retCol.add(produit);
                charite.donneProduit(produit);
                System.out.println("Voici les produits dans la charité : " + produitsVersCharite);
            }
        }
        return retCol;
//
    }

    @Override
    public boolean placerProduits(Collection<AbstractProduit> produits) {
        return false;
    }


    public boolean ajouterProduit(HashSet<AbstractProduit> Produit) {

        boolean ajout = false;

        return ajout;
    }

    /**
     * calcule le volume total courant du Vrac, parcours tous les sets dans le vrac et additione les volumes (permet de s'assurer que l'on reste sous la capacité max)
     * @return
     */
    public double calculVolumeTotal() {
        double totalVolumeVrac = 0;
        for (Set<AbstractProduit> produits : contenu.values()) {
            for (AbstractProduit produit : produits) {
                totalVolumeVrac += produit.getVolumeProduit();
            }
        }
        return totalVolumeVrac;
    }
    @Override
    public void viderAire() {

    }

    @Override
    public void gereSurplus(Collection<AbstractProduit> restant) {
        produitsVersCharite.addAll(restant);
    }
}

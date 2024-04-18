package tp2.etudiant.section;

import tp2.application.AbstractProduit;
import tp2.etudiant.boite.Boite;

import java.util.*;

public class Vrac implements AireI {


    public final static int idDefault = 0;
    double capaciteMax = 100;
    int sectionId;
    Map<String, Set<AbstractProduit>> contenu;

    public Vrac(Map<String, Set<AbstractProduit>> contenu) {
        this.sectionId = idDefault;
        this.contenu = contenu;
    }

    @Override
    public String decrit() {
        return null;
    }

    @Override
    public Collection<AbstractProduit> retireProduits(Collection<AbstractProduit> items) {
        return null;
    }

    @Override
    public Collection<AbstractProduit> getAllProduits() {
        return null;
    }

    @Override
    public Collection<AbstractProduit> placerProduits(Boite produits) {
        return null;
    }

    @Override
    public boolean placerProduits(Collection<AbstractProduit> produits) {
        return false;
    }

    public boolean ajouterProduit(HashSet<AbstractProduit> Produit) {
        boolean ajout = false;
        double volumeTotal = 0;
        for (AbstractProduit produit : Produit) {
//            volumeTotal += produit.getVolume;
        }
        if (volumeTotal <= capaciteMax) {
            //Nom du bac au lieu de toString
//            contenu.put(Produit.toString(), Produit);
        } else {
            while (volumeTotal > capaciteMax) {
                for (AbstractProduit produits : Produit) {
//                    contenu.put(Produit.toString(), produits);
                }
            }
        }
        return ajout;
    }


    @Override
    public void viderAire() {

    }

    @Override
    public void gereSurplus(Collection<AbstractProduit> restant) {

    }
}

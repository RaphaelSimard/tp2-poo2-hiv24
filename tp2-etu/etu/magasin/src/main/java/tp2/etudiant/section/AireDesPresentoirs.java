package tp2.etudiant.section;

import tp2.application.AbstractProduit;
import tp2.etudiant.boite.Boite;

import java.util.*;

public class AireDesPresentoirs implements AireI{

    private Map<String, Set<AbstractProduit>> contenu;
    public AireDesPresentoirs() {
        this.contenu = new HashMap<>();
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
        Collection<AbstractProduit> produitsNonPlaces = new ArrayList<>();
//        List<AbstractProduit> Produits = Boite.getContenu(); // Accéder à la liste de produits dans la boîte
//
//        for (AbstractProduit produit : produit) {
//            boolean place = false;
//            for (Map.Entry<String, ????> entry : contenu.entrySet()) { // Remplacer ??? par le type approprié
//                String nomProduit = entry.getKey();
//                Collection<AbstractProduit> presentoir = entry.getValue();
//                if (/* Vérifier si le présentoir peut contenir le produit */) {
//                    presentoir.add(produit); // Ajouter le produit au présentoir
//                    place = true;
//                    break;
//                }
//            }
//            if (!place) {
//                produitsNonPlaces.add(produit); // Ajouter le produit à la liste des produits non placés
//            }
//        }

        return produitsNonPlaces;
    }

    @Override
    public boolean placerProduits(Collection<AbstractProduit> produits) {
        return false;
    }

    @Override
    public void viderAire() {

    }

    @Override
    public void gereSurplus(Collection<AbstractProduit> restant) {

    }
}

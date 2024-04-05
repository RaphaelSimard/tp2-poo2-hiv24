package tp2.etudiant.produit.CategorieRoutiers;

import tp2.etudiant.produit.AbstractVehiculeRoutiers;

public class Divertissements extends AbstractVehiculeRoutiers {


    public Divertissements(String nom) {
        super(nom);
    }

    @Override
    public int getNumeroCategorie() {
        return 0;
    }

    @Override
    public String decrit() {
        return null;
    }
}

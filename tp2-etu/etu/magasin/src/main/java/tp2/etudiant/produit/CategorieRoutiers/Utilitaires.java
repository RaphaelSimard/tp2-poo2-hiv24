package tp2.etudiant.produit.CategorieRoutiers;

import tp2.etudiant.produit.AbstractVehiculeRoutiers;

public class Utilitaires extends AbstractVehiculeRoutiers {
    public Utilitaires(String nom) {
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

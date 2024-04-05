package tp2.etudiant.produit.CategorieRoutiers;

import tp2.etudiant.produit.AbstractVehiculeRoutiers;

public class Sports extends AbstractVehiculeRoutiers {
    public Sports(String nom) {
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

package tp2.etudiant.produit;

import tp2.etudiant.produit.AbstractVehiculeRoutiers;

public class Utilitaires extends AbstractVehiculeRoutiers {


    public Utilitaires(String nom, int nbreRoues) {
        super(nom, nbreRoues);
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

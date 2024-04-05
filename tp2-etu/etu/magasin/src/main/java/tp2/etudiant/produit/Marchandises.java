package tp2.etudiant.produit;

import tp2.etudiant.produit.AbstractVehiculeFerroviers;

public class Marchandises extends AbstractVehiculeFerroviers {
    public Marchandises(String nom) {
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

package tp2.etudiant.produit.TypeFerroviers;

import tp2.etudiant.produit.AbstractVehiculeFerroviers;

public class Deplacements extends AbstractVehiculeFerroviers {
    public Deplacements(String nom) {
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

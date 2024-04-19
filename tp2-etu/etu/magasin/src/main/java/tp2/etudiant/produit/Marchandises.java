package tp2.etudiant.produit;

import tp2.etudiant.produit.AbstractVehiculeFerroviers;

public class Marchandises extends AbstractVehiculeFerroviers {
    public Marchandises(String nom, double poidsVehicule) {
        super(nom, poidsVehicule);
    }

    @Override
    public int getNumeroCategorie() {
        return 3;
    }

    @Override
    public String decrit() {
        return null;
    }
}

package tp2.etudiant.produit;

import tp2.etudiant.produit.AbstractVehiculeFerroviers;

public class Marchandises extends AbstractVehiculeFerroviers {
    public Marchandises(String nom, int volumeProduit, double poidsVehicule) {
        super(nom,volumeProduit, poidsVehicule);
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
